package com.itos.dao.impl;

import com.itos.dao.model.IMemberPaymentDAO;
import com.itos.model.Member;
import com.itos.model.MemberPayment;
import com.itos.model.Rank;
import com.itos.model.Title;
import com.itos.model.ext.MemberPaymentDto;
import com.itos.model.ext.MemberPaymentHeadDto;
import com.itos.util.ConstantsMessage;
import com.itos.util.DateUtil;
import com.itos.util.Hibernate.CommandConstant;
import com.itos.util.Hibernate.CommandQuery;
import com.itos.util.Hibernate.WhereField;
import com.itos.util.StringPool;
import com.itos.util.jqGrid.Condition;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jqGrid.Paging;
import com.itos.util.jqGrid.Search;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhanumat.w
 */
@Repository("iMemberPaymentDAO")
public class MemberPaymentDAO implements IMemberPaymentDAO {

    static {
        //Ignore null converting 
        ConvertUtils.register(new DateConverter(null), Date.class);
    }

    protected final Log logger = LogFactory.getLog(getClass());
    private static final Locale ENG_LOCALE = new Locale("en", "EN");
    private static final SimpleDateFormat SF = new SimpleDateFormat("dd/MM/yyyy", ENG_LOCALE);
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd", ENG_LOCALE);
    private static final String TB_NAME = "MemberPayment";
    private static final String ATT_PAYMENT_ID = "paymentId";
    private static final String TB_MEMBER = "Member";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public MessageResponse add(MemberPayment memberPayment) {
        MessageResponse response = new MessageResponse();
        boolean success = CommandQuery.Insert(sessionFactory, memberPayment);
        response.setCheckSuccess(success);
        if (success) {
            response.setId(String.valueOf(memberPayment.getPaymentId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
            response.setObj(memberPayment);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MemberPayment getMemberPaymentById(int paymentId) {
        MemberPayment memberPayment = null;
        List<WhereField> listWhereField = new ArrayList<>();

        try {
            /*
             * Command HQL query Data.
             */
            WhereField whereField = new WhereField();
            whereField.setSearchField(ATT_PAYMENT_ID);
            whereField.setSearchLogic(StringPool.BLANK);
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(paymentId);
            listWhereField.add(whereField);

            Query query = CommandQuery.CreateQuery(sessionFactory, TB_NAME, listWhereField, 0, 1);

            if (!query.list().isEmpty() && query.list().size() == 1) {
                memberPayment = (MemberPayment) query.list().get(0);
            } else if (query.list().size() > 1) {
                throw new RuntimeException("Multiple record returned");
            } //else no data found
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return memberPayment;
    }

    @Override
    public MessageResponse remove(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        MemberPayment memberPayment;
        boolean success;
        memberPayment = new MemberPayment();
        for (String id : req.getItemSelect()) {
            memberPayment.setPaymentId(Integer.valueOf(id));
            if (CommandQuery.Delete(sessionFactory, memberPayment)) {
                iCountSuccessful++;
            }
        }

        response.setCheckSuccess(iCountSuccessful == req.getItemSelect().size());
        success = response.getCheckSuccess();
        if (success) {
            response.setId(StringPool.BLANK);
            response.setMessage(ConstantsMessage.DeleteSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.DeleteUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse update(MemberPayment memberPayment) {
        MessageResponse response = new MessageResponse();
        MemberPayment memberPaymentOrigin = (MemberPayment) CommandQuery.LoadDetail(sessionFactory, MemberPayment.class, memberPayment.getPaymentId());
        try {
            BeanUtils.copyProperties(memberPaymentOrigin, memberPayment);
        } catch (IllegalAccessException | InvocationTargetException e) {
            Logger.getLogger(MemberPaymentHeadDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(ConstantsMessage.UpdateUnsuccessful);
        }

        memberPaymentOrigin.setUpdatedBy(memberPayment.getUpdatedBy());
        memberPaymentOrigin.setUpdatedDate(memberPayment.getUpdatedDate());

        if (CommandQuery.Update(sessionFactory, memberPaymentOrigin)) {
            response.setCheckSuccess(true);
            response.setId(String.valueOf(memberPaymentOrigin.getPaymentId()));
            response.setObj(memberPaymentOrigin);
            response.setMessage(ConstantsMessage.UpdateSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.UpdateUnsuccessful);
        }
        return response;
    }

    @Override
    public JqGridResponse<MemberPaymentDto> searchMemberPayment(JqGridRequest req) {
        List<MemberPaymentDto> listResponse = new ArrayList<>();
        JqGridResponse<MemberPaymentDto> jqGrid = new JqGridResponse<>();
        List<MemberPayment> memberPaymentList = new ArrayList<>();
        List rowList = new ArrayList();
        List<Member> listMember = null;

        /*
         * Command HQL query Data.
         */
        Search tempSearch = new Search();
        tempSearch.setConditions(new ArrayList<Condition>());

        StringBuilder hqlSearch = new StringBuilder();
        StringBuilder hql = new StringBuilder();
        hqlSearch.append(CommandConstant.CountRows);
        hqlSearch.append(StringPool.SPACE);

        hql.append(CommandConstant.QueryFrom);
        hql.append(StringPool.SPACE);
        hql.append(TB_NAME);
        hql.append(StringPool.SPACE);
        hql.append(CommandConstant.QueryWhere);
        hql.append(StringPool.SPACE);
        hql.append("paymentDate is not null");

        if (req.isSearch()) {
            Search search = new Search();
            search = Search.JSONDeserializer(req.getSearchCommand());
            List<WhereField> memberWhereFieldList = new ArrayList<>();
            boolean memberFlag = false;
            for (Condition condition : search.getConditions()) {
                if (condition.getField().equalsIgnoreCase("citizenId")
                        || condition.getField().equalsIgnoreCase("name")
                        || condition.getField().equalsIgnoreCase("surname")
                        || condition.getField().equalsIgnoreCase("memberCode")
                        || condition.getField().equalsIgnoreCase("memberGroupCode")
                        || condition.getField().equalsIgnoreCase("memberTypeCode")
                        || condition.getField().equalsIgnoreCase("militaryId")) {
                    WhereField whereField = new WhereField();
                    whereField.setSearchField(condition.getField());
                    whereField.setSearchValue(condition.getData());
                    whereField.setSearchOper(condition.getOp());
                    if (memberFlag) {
                        whereField.setSearchLogic("and");
                    }
                    whereField.setSearchDataType(condition.getDataType());
                    memberWhereFieldList.add(whereField);
                    memberFlag = true;
                }//search member
                if (condition.getField().equalsIgnoreCase("paymentDate")
                        || condition.getField().equalsIgnoreCase("printedStatus")) {
                    logger.info("1 setSearchValue : >>" + condition.getData() + "<<");
                    if (CommandConstant.DataTypeDate.equalsIgnoreCase(condition.getDataType())) {
                        String[] tempDate = condition.getData().split(",");
                        String beginDate = "";
                        String endDate = "";
                        if (tempDate.length < 2 && CommandConstant.QueryBetween.equalsIgnoreCase(condition.getOp())) {
                            beginDate = formatDate(tempDate[0]);
                            endDate = formatDate("");
                        } else {
                            beginDate = formatDate(tempDate[0]);
                            endDate = formatDate(tempDate[1]);
                        }
                        
                        if(!hql.toString().isEmpty()){
                            hql.append(StringPool.SPACE);
                            hql.append(CommandConstant.QueryAND);
                            hql.append(StringPool.SPACE);
                            hql.append("paymentDate");
                            hql.append(StringPool.SPACE);
                            hql.append("Between");
                            hql.append(StringPool.SPACE);
                            hql.append(StringPool.APOSTROPHE + beginDate + StringPool.APOSTROPHE);  // 'yyyy-MM-dd'
                            hql.append(StringPool.SPACE);
                            hql.append(CommandConstant.QueryAND);
                            hql.append(StringPool.SPACE);
                            hql.append(StringPool.APOSTROPHE + endDate + StringPool.APOSTROPHE); // 'yyyy-MM-dd'
                        } 
                    } 
                    if (condition.getField().equalsIgnoreCase("printedStatus")){
                        /*
                        hql.append(StringPool.SPACE);
                        hql.append(CommandConstant.QueryAND);
                        hql.append(StringPool.SPACE);
                        hql.append(condition.getField());
                        hql.append(StringPool.EQUAL);
                        hql.append(condition.getData());
                        */
                    }
                }//search operation
            }

            if (memberFlag) {
                Query queryMember = CommandQuery.CreateQuery(sessionFactory, TB_MEMBER, memberWhereFieldList);
                listMember = queryMember.list();
                logger.info("listMember size : >>" + listMember.size() + "<<");
                if (listMember.size() > 0) {
                    hql.append(" and ");
                    hql.append(" member_id in (");
                    String tempMemberId = "";
                    for (Member member : listMember) {
                        tempMemberId = tempMemberId + member.getMemberId() + ",";
                    }
                    tempMemberId = tempMemberId.substring(0, tempMemberId.length() - 1);
                    hql.append(tempMemberId);
                    hql.append(" ) ");
                } else {
                    jqGrid.setPage(0);
                    jqGrid.setRecords(0);
                    jqGrid.setTotalPages(0);
                    jqGrid.setRows(listResponse);
                    return jqGrid;
                }
            }
        }
        
        hqlSearch.append(hql);
        Paging paging = CommandQuery.queryCountRows(sessionFactory, req, hqlSearch);
        Query query = CommandQuery.CreateQuery(sessionFactory, req, paging, hql);
        /*
         * Check array data if true set create object to array new.
         */
        if (!query.list().isEmpty()) {
            memberPaymentList = query.list();
            MemberPaymentDto memberPaymentDto;
            for (MemberPayment mp : memberPaymentList) {
                memberPaymentDto = new MemberPaymentDto();
                memberPaymentDto.setPaymentId(mp.getPaymentId());
                memberPaymentDto.setPaymentDate(mp.getPaymentDate());
                memberPaymentDto.setReceiptNo(mp.getReferenceId() != null ? String.valueOf(mp.getReferenceId()) : StringPool.BLANK);
                memberPaymentDto.setMemberCode(mp.getMember().getMemberCode());
                memberPaymentDto.setMilitaryName(mp.getMember().getMilitaryName());
                memberPaymentDto.setCitizenId(mp.getMember().getCitizenId());
                memberPaymentDto.setTitle(buildTitleOrRank(mp.getMember()));
                memberPaymentDto.setName(mp.getMember().getName());
                memberPaymentDto.setSurname(mp.getMember().getSurname());
                memberPaymentDto.setAmount(mp.getAmount() != null ? mp.getAmount() : BigDecimal.ZERO);
                memberPaymentDto.setPaymentStatus("N");
                rowList.add(memberPaymentDto);
            }
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(rowList);
        }
        return jqGrid;
    }

    @Override
    public List<MemberPayment> getMemberPaymentByCode(String citizenId, String memberCode) {
        List<MemberPayment> memberPaymentList = new ArrayList<>();
        StringBuilder hqlCondition = new StringBuilder();
        StringBuilder hql = new StringBuilder();

        if (citizenId != null) {
            hqlCondition.append(" and mp.member.citizenId=");
            hqlCondition.append(citizenId);
        } else if (memberCode != null) {
            hqlCondition.append(" and mp.member.memberCode=");
            hqlCondition.append(memberCode);
        } else {
            logger.error("citizenId and memberCode is null");
            throw new NullPointerException("citizenId and memberCode parameter is null");
        }

        hql.append("select mp");
        hql.append(" from " + TB_NAME + " mp");
        hql.append(" where");
        hql.append(" mp.paymentDate is null");
        hql.append(hqlCondition);

        Query queryMemberPayment = CommandQuery.CreateQuery(sessionFactory, hql);

        if (!queryMemberPayment.list().isEmpty()) {
            memberPaymentList = queryMemberPayment.list();
        }
        return memberPaymentList;
    }

    @Override
    public JqGridResponse<MemberPaymentHeadDto> getMemberPaymentByCode(JqGridRequest req) {
        JqGridResponse<MemberPaymentHeadDto> jqGrid = new JqGridResponse<>();
        List<MemberPayment> memberPaymentList = new ArrayList<>();
        StringBuilder hqlCount = new StringBuilder();
        StringBuilder hqlCondition = new StringBuilder();
        StringBuilder hql = new StringBuilder();

        if (req.isSearch()) {
            Search search = new Search();
            search = Search.JSONDeserializer(req.getSearchCommand());
            String memberCode = null;
            String citizenId = null;
            for (Condition condition : search.getConditions()) {
                if (condition.getField().equalsIgnoreCase("citizenId")) {
                    citizenId = condition.getData();
                } else if (condition.getField().equalsIgnoreCase("memberCode")) {
                    memberCode = condition.getData();
                }//search member
            }

            if (citizenId != null) {
                hqlCondition.append(" and mp.member.citizenId=");
                hqlCondition.append(citizenId);
            } else if (memberCode != null) {
                hqlCondition.append(" and mp.member.memberCode=");
                hqlCondition.append(memberCode);
            } else {
                logger.error("citizenId and memberCode is null");
                throw new NullPointerException("citizenId and memberCode parameter is null");
            }
        }
        if (hqlCount.toString().isEmpty()) {
            hqlCount.append("select count(mp)");
            hql.append("  from " + TB_NAME + " mp");
            hql.append(" where");
            hql.append(" paymentDate is null");
            hql.append(hqlCondition);
            hqlCount.append(hql);
        }
        Paging paging = CommandQuery.queryCountRows(sessionFactory, req, hqlCount);

        if (!hqlCount.toString().isEmpty()) {
            hql.replace(0, 1, "select mp");
            hql.append(hqlCondition);
        }

        Query queryMemberPayment = CommandQuery.CreateQuery(sessionFactory, req, paging, hql);
        if (!queryMemberPayment.list().isEmpty()) {
            memberPaymentList = queryMemberPayment.list();
            MemberPaymentHeadDto mph;
            List<MemberPaymentHeadDto> mphDtoList = new ArrayList<>();
            for (MemberPayment mp : memberPaymentList) {
                mph = new MemberPaymentHeadDto();
                mph.setPaymentId(mp.getPaymentId());
                mph.setMemberId(mp.getMember().getMemberId());
                mph.setMonthCode(mp.getControlPayment().getMonthCode());
                mph.setStartSopNo(mp.getControlPayment().getStartSopNo());
                mph.setEndSopNo(mp.getControlPayment().getEndSopNo());
                mph.setPaymentDetail(StringPool.BLANK);
                mph.setSopAmount(mp.getControlPayment().getEndSopNo() - mp.getControlPayment().getStartSopNo());
                mph.setAmount(mp.getControlPayment().getAmount());
                mph.setPaymentFlag(false);
                mph.setRemark(StringPool.BLANK);
                mphDtoList.add(mph);
            }
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(mphDtoList);
        }
        return jqGrid;
    }

    private String formatDate(String date) {

        if (date.isEmpty()) {
            Date currentDate = DateUtil.getCurrentDate();
            String result = FORMAT.format(currentDate);
            return result;
        }
        try {
            Date tempDate = SF.parse(date);
            String result = FORMAT.format(tempDate);
            return result;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String buildTitleOrRank(Member member) {
        String titleOrRank = "";
        if(member != null){
            Rank rank = member.getRank();
            Title title = member.getTitle();

            if (rank != null && rank.getRankName() != null) {
                titleOrRank = titleOrRank + rank.getRankName() + " ";
            }
            if (title != null && title.getTitleDesc() != null) {
                titleOrRank = titleOrRank + title.getTitleDesc() + " ";
            }
        }
        return titleOrRank;
    }
}
