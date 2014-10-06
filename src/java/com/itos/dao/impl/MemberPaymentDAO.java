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
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
        ConvertUtils.register(new org.apache.commons.beanutils.converters.BigDecimalConverter(null), BigDecimal.class);
    }

    protected final Log logger = LogFactory.getLog(getClass());
    private static final Locale ENG_LOCALE = new Locale("en", "EN");
    private static final SimpleDateFormat SF = new SimpleDateFormat("dd/MM/yyyy", ENG_LOCALE);
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd", ENG_LOCALE);
    private static final String TB_NAME = "MemberPayment";
    private static final String ATT_PAYMENT_ID = "paymentId";
    private static final String MONTHLY_FEE = "ค่าบำรุงศพประจำเดือน ";
    private static final String START_SOP = "ตั้งแต่ศพที่ ";
    private static final String END_SOP = "ถึงศพที่ ";
    private static final String SQL_TB_NAME = "from MemberPayment mp ";
    private static final String SQL_JOIN_MEMBER = "left outer join Member m on mp.member_id = m.member_id left outer join MilitaryDepartment md on m.military_id = md.military_id left outer join Title t on t.title_id = m.title_id left outer join Rank r on r.rank_id = m.rank_id ";
    private static final String SQL_JOIN_OPERATION = "left outer join OperationMember om on m.member_id = om.member_id left outer join Operation o on o.operation_id = om.operation_id ";
    private static final String SQL_JOIN_CONTROL_PAYMENT = "left outer join ControlPayment cp on mp.month_code = cp.month_code ";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public MessageResponse add(MemberPayment memberPayment) {
        MessageResponse response = new MessageResponse();
        memberPayment.setUpdatedDate(new Date());
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
        for (String id : req.getItemSelect()) {
            memberPayment = (MemberPayment) CommandQuery.LoadDetail(sessionFactory, MemberPayment.class, Integer.parseInt(id));
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
        memberPaymentOrigin.setUpdatedDate(new Date());

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
        /*
         * Command HQL query Data.
         */
        Search tempSearch = new Search();
        tempSearch.setConditions(new ArrayList<>());

        StringBuilder hql = new StringBuilder();
        StringBuilder hqlConditions = new StringBuilder();
        StringBuilder hqlMemberConditions = new StringBuilder();
        StringBuilder hqlOperConditions = new StringBuilder();

        Map<String, Comparable> props = new HashMap<String, Comparable>();
        if (req.isSearch()) {
            Search search = Search.JSONDeserializer(req.getSearchCommand());
            for (Condition condition : search.getConditions()) {
                if (condition.getField().equalsIgnoreCase("paymentDate")) {
                    logger.info("1 setSearchValue : >>" + condition.getData() + "<<");
                    if (CommandConstant.DataTypeDate.equalsIgnoreCase(condition.getDataType())) {
                        String[] tempDate = condition.getData().split(",");
                        String beginDate = null;
                        String endDate = null;
                        if (tempDate.length < 2 && CommandConstant.QueryBetween.equalsIgnoreCase(condition.getOp())) {
                            try {
                                beginDate = formatDate(tempDate[0]);
                                endDate = formatDate("");
                            } catch (ParseException ex) {
                                Logger.getLogger(MemberPaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            try {
                                beginDate = formatDate(tempDate[0]);
                                endDate = formatDate(tempDate[1]);
                            } catch (ParseException ex) {
                                Logger.getLogger(MemberPaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        hqlConditions.append(" and");
                        hqlConditions.append(" mp.payment_date");
                        hqlConditions.append(" between");
                        hqlConditions.append(" :beginDate");
                        props.put("beginDate", beginDate);
                        hqlConditions.append(" and");
                        hqlConditions.append(" :endDate");
                        props.put("endDate", endDate);
                    }
                }//search
                if(condition.getField().equalsIgnoreCase("memberId")){
                    hqlMemberConditions.append(" and");
                    hqlMemberConditions.append(" m.member_id=:memberId");
                    props.put("memberId", condition.getData());
                }
                if(condition.getField().equalsIgnoreCase("citizenId")){
                    hqlMemberConditions.append(" and");
                    hqlMemberConditions.append(" m.citizen_id=:citizenId");
                    props.put("citizenId", condition.getData());
                }
                if(condition.getField().equalsIgnoreCase("name")){
                    hqlMemberConditions.append(" and");
                    hqlMemberConditions.append(" m.name=:name");
                    props.put("name", condition.getData());
                }
                if(condition.getField().equalsIgnoreCase("surname")){
                    hqlMemberConditions.append(" and");
                    hqlMemberConditions.append(" m.surname=:surname");
                    props.put("surname", condition.getData());
                }
                if(condition.getField().equalsIgnoreCase("memberCode")){
                    hqlMemberConditions.append(" and");
                    hqlMemberConditions.append(" m.member_code=:memberCode");
                    props.put("memberCode", condition.getData());
                }
                if(condition.getField().equalsIgnoreCase("memberGroupCode")){
                    hqlMemberConditions.append(" and");
                    hqlMemberConditions.append(" m.member_group_code=:memberGroupCode");
                    props.put("memberGroupCode", condition.getData());
                }
                if(condition.getField().equalsIgnoreCase("memberTypeCode")){
                    hqlMemberConditions.append(" and");
                    hqlMemberConditions.append(" m.member_type_code=:memberTypeCode");
                    props.put("memberTypeCode", condition.getData());
                }
                if(condition.getField().equalsIgnoreCase("militaryId")){
                    hqlMemberConditions.append(" and");
                    hqlMemberConditions.append(" m.military_id=:militaryId");
                    props.put("militaryId", condition.getData());
                }
                if (condition.getField().equalsIgnoreCase("printedStatus")) {
                    hqlOperConditions.append(" and");
                    hqlOperConditions.append(" o.printed_status=:printedStatus");
                    props.put("printedStatus", condition.getData());
                }
            }
        }
        /*
         * Command HQL query Data.
         */
        List<WhereField> listWhereField = new ArrayList<>();
        StringBuilder hqlDefaultCondition = new StringBuilder();
        
        hqlDefaultCondition.append(CommandConstant.QueryWhere);
        hqlDefaultCondition.append(" mp.payment_date is not null");
        
        StringBuilder hqlCount = new StringBuilder();
        StringBuilder hqlQuery = new StringBuilder();
        
        hqlCount.append("select count(mp.payment_id) ");
        hqlQuery.append("select mp.* ");
        
        hql.append(SQL_TB_NAME);
        hql.append(SQL_JOIN_MEMBER);
        hql.append(SQL_JOIN_OPERATION);
        hql.append(hqlDefaultCondition);
        hql.append(hqlConditions);
        hql.append(hqlMemberConditions);
        hql.append(hqlOperConditions);
        hqlCount.append(hql);
        hqlQuery.append(hql);
        
        if(req.getSidx() != null && req.getSord()!= null && SortingMapping.fromParameter(req.getSidx()) != null){
            hqlQuery.append(StringPool.SPACE).append(CommandConstant.OrderBy);
            hqlQuery.append(StringPool.SPACE).append(SortingMapping.fromParameter(req.getSidx()).getField());
            hqlQuery.append(StringPool.SPACE).append(req.getSord());
        }

        Paging paging = CommandQuery.CountRows(sessionFactory, listWhereField, CommandConstant.QueryAND, req, hqlCount);
        SQLQuery query = CommandQuery.CreateQuery(sessionFactory, listWhereField, CommandConstant.QueryAND, req, paging, hqlQuery);
        query.setProperties(props);
        query.addEntity(MemberPayment.class);
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
                if (mp.getMember() != null) {
                    memberPaymentDto.setMemberCode(mp.getMember().getMemberCode());
                    memberPaymentDto.setMilitaryName(mp.getMember().getMilitaryDepartment() != null ? mp.getMember().getMilitaryDepartment().getName() : null);
                    memberPaymentDto.setCitizenId(mp.getMember().getCitizenId());
                    memberPaymentDto.setTitle(buildTitleOrRank(mp.getMember()));
                    memberPaymentDto.setName(mp.getMember().getName());
                    memberPaymentDto.setSurname(mp.getMember().getSurname());
                }
                memberPaymentDto.setAmount(mp.getAmount() != null ? mp.getAmount() : BigDecimal.ZERO);
                memberPaymentDto.setPaymentStatus("N");
                listResponse.add(memberPaymentDto);
            }
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(listResponse);
        } else {
            jqGrid.setPage(0);
            jqGrid.setRecords(0);
            jqGrid.setTotalPages(0);
            jqGrid.setRows(listResponse);
            return jqGrid;
        }
        return jqGrid;
    }

    @Override
    public JqGridResponse<MemberPaymentHeadDto> getMemberPaymentByCode(JqGridRequest req) {
        JqGridResponse<MemberPaymentHeadDto> jqGrid = new JqGridResponse<>();
        List<MemberPaymentHeadDto> listResponse = new ArrayList<>();
        List<MemberPayment> memberPaymentList = new ArrayList<>();
        /*
         * Command HQL query Data.
         */
        Search tempSearch = new Search();
        tempSearch.setConditions(new ArrayList<>());

        StringBuilder hql = new StringBuilder();
        StringBuilder hqlMemberConditions = new StringBuilder();

        Map<String, Comparable> props = new HashMap<String, Comparable>();
        if (req.isSearch()) {
            Search search = Search.JSONDeserializer(req.getSearchCommand());
            for (Condition condition : search.getConditions()) {
                if(condition.getField().equalsIgnoreCase("memberId")){
                    hqlMemberConditions.append(" and");
                    hqlMemberConditions.append(" m.member_id=:memberId");
                    props.put("memberId", condition.getData());
                }
                else if(condition.getField().equalsIgnoreCase("citizenId")){
                    hqlMemberConditions.append(" and");
                    hqlMemberConditions.append(" m.citizen_id=:citizenId");
                    props.put("citizenId", condition.getData());
                }
                else if(condition.getField().equalsIgnoreCase("memberCode")){
                    hqlMemberConditions.append(" and");
                    hqlMemberConditions.append(" m.member_code=:memberCode");
                    props.put("memberCode", condition.getData());
                }
            }
        }
        /*
         * Command HQL query Data.
         */
        List<WhereField> listWhereField = new ArrayList<>();
        StringBuilder hqlDefaultCondition = new StringBuilder();
        
        hqlDefaultCondition.append(CommandConstant.QueryWhere);
        hqlDefaultCondition.append(" mp.payment_date is null");
        
        StringBuilder hqlCount = new StringBuilder();
        StringBuilder hqlQuery = new StringBuilder();
        
        hqlCount.append("select count(mp.payment_id) ");
        hqlQuery.append("select mp.*, (cp.end_sop_no - cp.start_sop_no) as sop_amount ");
        
        hql.append(SQL_TB_NAME);
        hql.append(SQL_JOIN_MEMBER);
        hql.append(SQL_JOIN_CONTROL_PAYMENT);
        hql.append(hqlDefaultCondition);
        hql.append(hqlMemberConditions);
        hqlCount.append(hql);
        hqlQuery.append(hql);
        
        if(req.getSidx() != null && req.getSord()!= null && SortingMapping.fromParameter(req.getSidx()) != null){
            hqlQuery.append(StringPool.SPACE).append(CommandConstant.OrderBy);
            hqlQuery.append(StringPool.SPACE).append(SortingMapping.fromParameter(req.getSidx()).getField());
            hqlQuery.append(StringPool.SPACE).append(req.getSord());
        }

        Paging paging = CommandQuery.CountRows(sessionFactory, listWhereField, CommandConstant.QueryAND, req, hqlCount);
        SQLQuery query = CommandQuery.CreateQuery(sessionFactory, listWhereField, CommandConstant.QueryAND, req, paging, hqlQuery);
        query.setProperties(props);
        query.addEntity(MemberPayment.class);

        if (!query.list()
                .isEmpty()) {
            memberPaymentList = query.list();
            MemberPaymentHeadDto mph;
            for (MemberPayment mp : memberPaymentList) {
                mph = new MemberPaymentHeadDto();
                mph.setPaymentId(mp.getPaymentId());
                mph.setMemberId(mp.getMember().getMemberId());
                mph.setMonthCode(mp.getMonthCode());
                mph.setStartSopNo(mp.getControlPayment().getStartSopNo());
                mph.setEndSopNo(mp.getControlPayment().getEndSopNo());
                mph.setPaymentDetail(buildMemberPaymentDetail(mp.getMonthCode(), mp.getControlPayment().getStartSopNo(), mp.getControlPayment().getEndSopNo()));
                mph.setSopAmount(mp.getControlPayment().getEndSopNo() - mp.getControlPayment().getStartSopNo());
                mph.setAmount(mp.getControlPayment().getAmount());
                mph.setPaymentFlag(false);
                mph.setRemark(StringPool.BLANK);
                listResponse.add(mph);
            }
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(listResponse);
        } else {
            jqGrid.setPage(0);
            jqGrid.setRecords(0);
            jqGrid.setTotalPages(0);
            jqGrid.setRows(listResponse);
            return jqGrid;
        }
        return jqGrid;
    }

    private String formatDate(String date) throws ParseException {

        if (date.isEmpty()) {
            Date currentDate = DateUtil.getCurrentDate();
            String result = FORMAT.format(currentDate);
            return result;
        }
        Date tempDate = SF.parse(date);
        String result = FORMAT.format(tempDate);
        return result;

    }

    private String buildTitleOrRank(Member member) {
        String titleOrRank = "";
        if (member != null) {
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

    private String buildMemberPaymentDetail(String monthCode, Integer start, Integer end) {
        String strMm = StringUtils.substring(monthCode, 3, 5);  //  MM.
        String StrYyy = StringUtils.substring(monthCode, 0, 3); //  yyy.
        String StrYy = StringUtils.substring(monthCode, 1, 3);  //  yy.
        String strBbuddhistYear = StringUtils.rightPad("2", 4, StrYyy); //  '2' + yyy.
        String shortMonth = formatMonth(NumberUtils.toInt(strMm), new Locale("th", "TH"));  //  ม.ค. etc.
        StringBuilder sb = new StringBuilder();
        sb.append(MONTHLY_FEE);
        sb.append(shortMonth);
        sb.append(StringPool.SPACE);
        sb.append(strBbuddhistYear);
        sb.append(StringPool.SPACE);
        sb.append(START_SOP).append(start).append(StringPool.SLASH).append(StrYy);
        sb.append(StringPool.SPACE);
        sb.append(END_SOP).append(end).append(StringPool.SLASH).append(StrYy);
        return sb.toString();
    }

    private String formatMonth(int month, Locale locale) {
        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        String[] monthNames = symbols.getShortMonths();
        return monthNames[month - 1];
    }
    
    private enum SortingMapping {
        PAYMENT_ID("paymentId", "mp.payment_id"),
	MEMBER_ID("memberId", "m.member_id"),
        PAYMENT_DATE("paymentDate", "mp.payment_date"),
        RECIVE_NO("receiptNo", "mp.reference_id"),
        MEMBER_CODE("memberCode", "m.member_code"),
        MILDEPT_ID("militaryName", "md.name"),
        CITIZEN_ID("citizenId", "m.citizen_id"),
        NAME("name", "m.name"),
        SURNAME("surname", "m.surname"),
        TITLE("title", "coalesce (t.title, r.rank_name)"),
        AMOUNT("amount", "mp.amount"),
        PAYMENT_STATUS("paymentStatus", "o.printed_status"),
        PRINTED_STATUS("printedStatus", "o.printed_status"),
        //  Support sorting PAY010-1
        PAYMENT_DETAIL("paymentDetail", "mp.month_code"),
        SOP_AMOUNT("sopAmount", "sop_amount");
 
	private String parameter;
        private String field;
        
        private static Map<String, SortingMapping> maps = new HashMap<String, SortingMapping>();
	static {
            for (SortingMapping sm : values()) {
                    maps.put(sm.parameter, sm);
            }
	}

	SortingMapping(String p, String f) {
		this.parameter = p;
		this.field = f;
	}

	public static SortingMapping fromParameter(String p) {
		return maps.get(p);
	}
        
        public String getField() {
		return this.field;
	}
    }
}