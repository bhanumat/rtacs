/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IOperationMemberDAO;
import com.itos.model.Member;
import com.itos.model.MilitaryDepartment;
import com.itos.model.Operation;
import com.itos.model.OperationMember;
import com.itos.model.Rank;
import com.itos.model.Title;
import com.itos.model.ext.PaymentDetail;
import com.itos.model.ext.PaymentMember;
import com.itos.util.ConstantsMessage;
import com.itos.util.DateUtil;
import com.itos.util.Hibernate.CommandConstant;
import com.itos.util.Hibernate.CommandQuery;
import com.itos.util.Hibernate.WhereField;
import com.itos.util.jqGrid.Condition;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jqGrid.Paging;
import com.itos.util.jqGrid.Search;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITOS
 */
@Repository("iOperationMemberDAO")
public class OperationMemberDAO implements IOperationMemberDAO {

    protected final Log logger = LogFactory.getLog(getClass());
    private static final Locale ENG_LOCALE = new Locale("en", "EN");
    private static final SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy", ENG_LOCALE);
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", ENG_LOCALE);

    @Autowired
    private SessionFactory sessionFactory;
    private final String objectTable = "OperationMember";
    private final String memberTable = "Member";
    private final String operationTable = "Operation";

    @Override
    public JqGridResponse<OperationMember> getList(JqGridRequest req) {
        List<OperationMember> listResponse = new ArrayList<>();
        JqGridResponse<OperationMember> jqGrid = new JqGridResponse<>();
        OperationMember operationMemberObject;
        List<OperationMember> list;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Bank");

        Paging paging = CommandQuery.CountRows(sessionFactory, req, objectTable);
        Query query = CommandQuery.CreateQuery(sessionFactory, req, objectTable, paging);
        /*
         * Check array data if true set create object to array new.
         */
        list = query.list();
        if (!list.isEmpty()) {
            /*
             Predicate condition = new Predicate() {
             boolean evaluate(Object sample) {
             return ((Sample) sample).value3.equals("three");
             }
             };*/

            /*
             * Start developer create object to array new.
             */
            for (OperationMember operationMemberObjectList : list) {
                operationMemberObject = new OperationMember();
                //operationMemberObject.setMember(operationMemberObjectList.getMember());
                //operationMemberObject.setOperation(operationMemberObjectList.getOperation());
                //operationMemberObject.setMember(null);
                operationMemberObject.setOperationId(operationMemberObjectList.getOperationId());
                operationMemberObject.setOperationTypeCode(operationMemberObjectList.getOperationTypeCode());
                operationMemberObject.setOperationMemberId(operationMemberObjectList.getOperationMemberId());
                operationMemberObject.setMemberCode(operationMemberObjectList.getMemberCode());
                operationMemberObject.setMilitaryId(operationMemberObjectList.getMilitaryId());
                operationMemberObject.setCitizenId(operationMemberObjectList.getCitizenId());
                operationMemberObject.setRankId(operationMemberObjectList.getRankId());
                operationMemberObject.setRankName(operationMemberObjectList.getRankName());
                operationMemberObject.setName(operationMemberObjectList.getName());
                operationMemberObject.setSurname(operationMemberObjectList.getSurname());
                operationMemberObject.setDocDate(operationMemberObjectList.getDocDate());
                operationMemberObject.setApplyDate(operationMemberObjectList.getApplyDate());
                operationMemberObject.setMemberTypeCode(operationMemberObjectList.getMemberTypeCode());
                operationMemberObject.setDocCode(operationMemberObjectList.getDocCode());
                listResponse.add(operationMemberObjectList);
            }
            /*
             * End developer create object to array new.
             */

            /*
             * Set Paging to jqgrid.
             */
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(listResponse);
        }
        return jqGrid;
    }

    @Override
    public MessageResponse setDeleteOperationMember(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        OperationMember operationMemberOriginal = null;
        boolean chekSuccess = false;
        for (String id : req.getItemSelect()) {
            operationMemberOriginal = new OperationMember();
            operationMemberOriginal = (OperationMember) CommandQuery.LoadDetail(sessionFactory, OperationMember.class, Integer.parseInt(id));
            if (CommandQuery.Delete(sessionFactory, operationMemberOriginal)) {
                iCountSuccessful++;
            }
        }
        if (iCountSuccessful == req.getItemSelect().size()) {
            response.setCheckSuccess(true);
        } else {
            response.setCheckSuccess(false);
        }
        chekSuccess = response.getCheckSuccess();
        if (chekSuccess) {
            response.setId("");
            response.setMessage(ConstantsMessage.DeleteSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.DeleteUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveNewOperationMember(OperationMember operationMember) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        chekSuccess = CommandQuery.Insert(sessionFactory, operationMember);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(operationMember.getOperationMemberId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveApproveOperationMember(OperationMember operationMember) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        Integer OperTypeCode = operationMember.getOperationTypeCode();
        Date docDate = operationMember.getDocDate();
        Date applyDate = operationMember.getApplyDate();
        List<Integer> item = operationMember.getItemSelect();
        List<Integer> item2 = operationMember.getItemSelect2();

        for (int i = 0; i < item.size(); i++) {
            //logger.info("operation_member_id : " + item.get(i));
            chekSuccess = CommandQuery.ApproveOperation(sessionFactory, item.get(i), OperTypeCode, docDate, applyDate);
            logger.info("Approve status : " + chekSuccess);
        }

        for (int i = 0; i < item2.size(); i++) {
            //logger.info("operation_member_id : " + item.get(i));
            chekSuccess = CommandQuery.ApproveMember(sessionFactory, item2.get(i), OperTypeCode, applyDate);
            logger.info("Approve status : " + chekSuccess);
        }
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(operationMember.getOperationMemberId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveEditOperationMember(OperationMember operationMember) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        OperationMember operationMemberOriginal = (OperationMember) CommandQuery.LoadDetail(sessionFactory, OperationMember.class, operationMember.getOperationMemberId());
        operationMemberOriginal.setMember(operationMember.getMember());
        operationMemberOriginal.setOperation(operationMember.getOperation());
        operationMemberOriginal.setOperationMemberId(operationMember.getOperationMemberId());
        chekSuccess = CommandQuery.Update(sessionFactory, operationMemberOriginal);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(operationMember.getOperation()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public OperationMember getLoadOperationMember(OperationMember operationMember) {
        OperationMember operationMemberResponse = getLoadDetailByObject(operationMember);
        return operationMemberResponse;
    }

    private OperationMember getLoadDetailByObject(OperationMember operationMember) {
        OperationMember operationMemberResponse = new OperationMember();
        List<WhereField> listWhereField = new ArrayList<>();
        List<OperationMember> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("operationMemberId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(operationMember.getOperationMemberId());
            listWhereField.add(whereField);

//            whereField = new WhereField();
//            whereField.setSearchField("flag");
//            whereField.setSearchLogic(CommandConstant.QueryAND);
//            whereField.setSearchOper(CommandConstant.QueryEqual);
//            whereField.setSearchValue("Y");
//            listWhereField.add(whereField);
            Query query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField, 0, 1);
            /*
             * Check array data if true set create object to array new.
             */
            list = query.list();
            if (!list.isEmpty()) {

                /*
                 * Start developer create object to array new.
                 */
                for (OperationMember operationMemberObjectList : list) {
                    operationMemberResponse.setMember(operationMemberObjectList.getMember());
                    operationMemberResponse.setOperation(operationMemberObjectList.getOperation());
                    operationMemberResponse.setOperationMemberId(operationMemberObjectList.getOperationMemberId());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return operationMemberResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    private OperationMember getLoadDetailById(OperationMember operationMember) {
        OperationMember operationMemberResponse = null;
        List<WhereField> listWhereField = new ArrayList<>();
        List<OperationMember> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("operationMemberId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(operationMember.getOperationMemberId());
            listWhereField.add(whereField);

            Query query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField, 0, 1);
            /*
             * Check array data if true set create object to array new.
             */
            list = query.list();
            if (!list.isEmpty()) {

                /*
                 * Start developer create object to array new.
                 */
                for (OperationMember operationMemberObjectList : list) {
                    operationMemberResponse.setMember(operationMemberObjectList.getMember());
                    operationMemberResponse.setOperation(operationMemberObjectList.getOperation());
                    operationMemberResponse.setOperationMemberId(operationMemberObjectList.getOperationMemberId());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return operationMemberResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<OperationMember> getListInJSONOperationMember(char status) {
        List<OperationMember> listResponse = new ArrayList<>();
        List<OperationMember> list;
        OperationMember operationMemberObject;
        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Bank");
        whereField = new WhereField();
        whereField.setSearchField("status");
        whereField.setSearchLogic("");
        if ('%' != status) {
            whereField.setSearchOper(CommandConstant.QueryEqual);
        } else {
            whereField.setSearchOper(CommandConstant.QueryContains);
        }
        whereField.setSearchValue(status);
        whereField.setSearchDataType(CommandConstant.DataTypeChar);
        listWhereField.add(whereField);

        Query query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);
        /*
         * Check array data if true set create object to array new.
         */
        list = query.list();
        if (!list.isEmpty()) {

            /*
             * Start developer create object to array new.
             */
            for (OperationMember operationMemberObjectList : list) {
                operationMemberObject = new OperationMember();
                operationMemberObject.setMember(operationMemberObjectList.getMember());
                operationMemberObject.setOperation(operationMemberObjectList.getOperation());
                operationMemberObject.setOperationMemberId(operationMemberObjectList.getOperationMemberId());
                listResponse.add(operationMemberObject);
            }
            /*
             * End developer create object to array new.
             */

        }
        return listResponse;
    }

    @Override
    public JqGridResponse<PaymentMember> getPaymentMemberList(JqGridRequest req) {
        List<PaymentMember> listResponse = new ArrayList<>();
        JqGridResponse<PaymentMember> jqGrid = new JqGridResponse<>();
        PaymentMember paymentMemberObject;
        List<OperationMember> list;
        List<Member> listMember = null;
        List<Operation> listOperation = null;
        List<Operation> listSearch = null;
        logger.info("OperationMemberDAO : getOperationMemberList");
        /*
         * Command HQL query Data.
         */
        Search tempSearch = new Search();
        tempSearch.setConditions(new ArrayList<Condition>());
        boolean firstFlag = false;
        List<WhereField> operationSearchTypeList = new ArrayList<>();
        WhereField searchField = new WhereField();
        searchField.setSearchField("operation_type_code");
        searchField.setSearchValue("11");
        searchField.setSearchOper(CommandConstant.QueryEqual);
        searchField.setSearchLogic("");
        searchField.setSearchDataType(CommandConstant.DataTypeInteger);
        operationSearchTypeList.add(searchField);
        Query searchQuery = CommandQuery.CreateQuery(sessionFactory, operationTable, operationSearchTypeList);
        listSearch = searchQuery.list();
        logger.info("searchQuery size : >>" + listSearch.size() + "<<");
        StringBuilder hqlSearch = new StringBuilder();
        StringBuilder hql = new StringBuilder();

        hqlSearch.append(CommandConstant.CountRows);
        hqlSearch.append(" ");

        hql.append(CommandConstant.QueryFrom);
        hql.append(" ");
        hql.append(objectTable);
        hql.append(" ");
        hql.append(CommandConstant.QueryWhere);
        hql.append(" operation_id in (");
        if (listSearch.size() > 0) {
            String tempOperationId = "";
            for (Operation operation : listSearch) {
                tempOperationId = tempOperationId + operation.getOperationId() + ",";
            }
            tempOperationId = tempOperationId.substring(0, tempOperationId.length() - 1);
            hql.append(tempOperationId);
            hql.append(" ) ");
        } else {
            jqGrid.setPage(0);
            jqGrid.setRecords(0);
            jqGrid.setTotalPages(0);
            jqGrid.setRows(listResponse);
            return jqGrid;
        }

        if (req.isSearch()) {
            Search search = new Search();
            search = Search.JSONDeserializer(req.getSearchCommand());
            List<WhereField> memberWhereFieldList = new ArrayList<>();
            List<WhereField> operationWhereFieldList = new ArrayList<>();
            boolean memberFlag = false;
            boolean operationFlag = false;
            for (Condition condition : search.getConditions()) {
                if (condition.getField().equalsIgnoreCase("citizenId")
                        || condition.getField().equalsIgnoreCase("name")
                        || condition.getField().equalsIgnoreCase("surname")
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
                if (condition.getField().equalsIgnoreCase("printedStatus")
                        || condition.getField().equalsIgnoreCase("docDate")) {
                    WhereField searchWhereField = new WhereField();
                    searchWhereField.setSearchField("operation_type_code");
                    searchWhereField.setSearchValue("11");
                    searchWhereField.setSearchOper(CommandConstant.QueryEqual);
                    if (operationFlag) {
                        searchWhereField.setSearchLogic("and");
                    }
                    searchWhereField.setSearchDataType(CommandConstant.DataTypeInteger);
                    operationWhereFieldList.add(searchWhereField);
                    operationFlag = true;

                    WhereField whereField = new WhereField();
                    whereField.setSearchField(condition.getField());
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
                        condition.setData(beginDate + "," + endDate);
                    }
                    logger.info("2 setSearchValue : >>" + condition.getData() + "<<");

                    whereField.setSearchValue(condition.getData());
                    whereField.setSearchOper(condition.getOp());
                    if (operationFlag) {
                        whereField.setSearchLogic("and");
                    }

                    whereField.setSearchDataType(condition.getDataType());
                    operationWhereFieldList.add(whereField);
                    operationFlag = true;
                }//search operation
            }

            if (memberFlag) {
                Query queryMember = CommandQuery.CreateQuery(sessionFactory, memberTable, memberWhereFieldList);
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
            if (operationFlag) {
                Query queryOperation = CommandQuery.CreateQuery(sessionFactory, operationTable, operationWhereFieldList);
                listOperation = queryOperation.list();
                logger.info("listOperation size : >>" + listOperation.size() + "<<");
                if (listOperation.size() > 0) {
                    hql.append(" and ");
                    hql.append(" operation_id in (");
                    String tempOperationId2 = "";
                    for (Operation operation : listOperation) {
                        tempOperationId2 = tempOperationId2 + operation.getOperationId() + ",";
                    }
                    tempOperationId2 = tempOperationId2.substring(0, tempOperationId2.length() - 1);
                    hql.append(tempOperationId2);
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
        list = query.list();
        if (!list.isEmpty()) {

            for (OperationMember operationMemberObjectList : list) {
                boolean dataFlag = true;
                paymentMemberObject = new PaymentMember();
                paymentMemberObject.setOperationMemberId(operationMemberObjectList.getOperationMemberId());
                String title = "";

                //------------------
                Member member = operationMemberObjectList.getMember();
                paymentMemberObject.setCitizenID(member.getCitizenId());
                paymentMemberObject.setName(member.getName());
                paymentMemberObject.setSurname(member.getSurname());
                Title titleId = member.getTitle();
                Rank rank = member.getRank();
                if (rank != null && rank.getRankName() != null) {
                    title = title + rank.getRankName();
                }
                if (titleId != null && titleId.getTitleDesc() != null) {
                    if (!title.isEmpty()) {
                        title = title + " ";
                    }
                    title = title + titleId.getTitleDesc();
                }
                paymentMemberObject.setTitle(title);
                Operation operation = operationMemberObjectList.getOperation();
                paymentMemberObject.setDocDate(operation.getDocDate());
                paymentMemberObject.setDocCode(operation.getDocCode());
                paymentMemberObject.setAmount(operation.getAmount());
                paymentMemberObject.setTypeCode(operation.getOperationTypeCode());
                paymentMemberObject.setPrintedStatus((operation.getPrintedStatus() != null) ? "" + operation.getPrintedStatus() : "");
                MilitaryDepartment militaryDepartment = member.getMilitaryDepartment();
                paymentMemberObject.setMilitaryName((militaryDepartment != null) ? militaryDepartment.getName() : "");
                //------------------

                if (dataFlag) {
                    listResponse.add(paymentMemberObject);
                }
            }
            /*
             * End developer create object to array new.
             */

            /*
             * Set Paging to jqgrid.
             */
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(listResponse);
        }
        return jqGrid;
    }

    @Override
    public MessageResponse cancelBill(MessageRequest req) {
        logger.info("OperationMemberDAO : cancelBill");
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        OperationMember operationMemberDtoOriginal = null;
        boolean chekSuccess = false;

        for (String id : req.getItemSelect()) {
            int temp = Integer.parseInt(id);
            logger.info("id : >>" + temp + "<<");
            operationMemberDtoOriginal = new OperationMember();
            operationMemberDtoOriginal = (OperationMember) CommandQuery.LoadDetail(sessionFactory, OperationMember.class, Integer.parseInt(id));
            logger.info("getOperationId : >>" + operationMemberDtoOriginal.getOperation().getOperationId() + "<<");
            logger.info("getOperationMemberId : >>" + operationMemberDtoOriginal.getOperationMemberId() + "<<");
            logger.info("getMemberId : >>" + operationMemberDtoOriginal.getMember().getMemberId() + "<<");

            Operation operationOriginal = new Operation();
            operationOriginal = (Operation) CommandQuery.LoadDetail(sessionFactory, Operation.class, operationMemberDtoOriginal.getOperation().getOperationId());
            operationOriginal.setPrintedStatus('C');
            operationOriginal.setCancelDate(DateUtil.getCurrentDate());
            operationOriginal.setRemark(req.getDataSource());
            if (CommandQuery.Update(sessionFactory, operationOriginal)) {
                iCountSuccessful++;
            }
        }
        if (iCountSuccessful == req.getItemSelect().size()) {
            response.setCheckSuccess(true);
        } else {
            response.setCheckSuccess(false);
        }
        chekSuccess = response.getCheckSuccess();
        if (chekSuccess) {
            response.setId("");
            response.setMessage(ConstantsMessage.CancelSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.CancelUnsuccessful);
        }
        return response;
    }

    private String formatDate(String date) {

        if (date.isEmpty()) {
            Date currentDate = DateUtil.getCurrentDate();
            String result = format.format(currentDate);
            return result;
        }
        try {
            Date tempDate = sf.parse(date);
            String result = format.format(tempDate);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String reverseFormatDate(Date date) {
        if (date == null) {
            return null;
        }
        String result = sf.format(date);
        return result;
    }

    @Override
    public PaymentDetail searchPaymentDetail(String operationMemberId) {
        PaymentDetail paymentDetailResponse = new PaymentDetail();
        List<WhereField> listWhereField = new ArrayList<>();
        List<OperationMember> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("operationMemberId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(Integer.parseInt(operationMemberId));
            listWhereField.add(whereField);

            Query query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField, 0, 1);

            list = query.list();
            if (!list.isEmpty()) {

                for (OperationMember operationMemberObjectList : list) {
                    paymentDetailResponse.setCitizenID(operationMemberObjectList.getCitizenId());
                    paymentDetailResponse.setStatus(operationMemberObjectList.getMember().getMemberStatusCode());
                    paymentDetailResponse.setName(operationMemberObjectList.getName() + " " + operationMemberObjectList.getSurname());
                    paymentDetailResponse.setMilitaryName(operationMemberObjectList.getMilitaryName());
                    paymentDetailResponse.setMemberId(operationMemberObjectList.getMember().getMemberId());
                    paymentDetailResponse.setDocCode(operationMemberObjectList.getDocCode());
                    paymentDetailResponse.setDocDate(operationMemberObjectList.getDocDate());
                    paymentDetailResponse.setDateString(reverseFormatDate(operationMemberObjectList.getDocDate()));
                    paymentDetailResponse.setBillAmount(operationMemberObjectList.getAmount());
                    break;
                }
            }
            return paymentDetailResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    public MessageResponse setSaveNewOperationMemberForRegisterNo(List<Member> listMember, Operation operation) {
        MessageResponse response = new MessageResponse();
        OperationMember operationMember;
        boolean chekSuccess = false;
        int iCountSuccessful = 0;
        if (CommandQuery.Insert(sessionFactory, operation)) {
            for (Member member : listMember) {
                Member memberOriginal = (Member) CommandQuery.LoadDetail(sessionFactory, Member.class, member.getMemberId());
                memberOriginal.setMemberCode(member.getMemberCode());
                memberOriginal.setMemberStatusCode(member.getMemberStatusCode());
                memberOriginal.setUpdateBy(member.getUpdateBy());
                memberOriginal.setUpdateDate(member.getUpdateDate());
                if (CommandQuery.Update(sessionFactory, memberOriginal)) {
                    operationMember = new OperationMember();
                    operationMember.setOperation(operation);
                    operationMember.setMember(memberOriginal);
                    if (CommandQuery.Insert(sessionFactory, operationMember)) {
                        iCountSuccessful++;
                    }
                }
            }

            if (iCountSuccessful == listMember.size()) {
                chekSuccess = true;
            } else {
                chekSuccess = false;
            }
        } else {
            chekSuccess = false;
        }

        response.setCheckSuccess(chekSuccess);

        if (chekSuccess) {
            response.setId(String.valueOf(operation.getOperationId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public JqGridResponse<OperationMember> getList(JqGridRequest req, int memberStatusCode) {
        List<OperationMember> listResponse = new ArrayList<>();
        JqGridResponse<OperationMember> jqGrid = new JqGridResponse<>();
        OperationMember operationMemberObject;
        List<OperationMember> list;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Bank");

        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;

        if (0 != memberStatusCode) {
            whereField = new WhereField();
            whereField.setSearchField("memberStatusCode");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(memberStatusCode);
            whereField.setSearchDataType(CommandConstant.DataTypeInteger);
            listWhereField.add(whereField);
        }

        Paging paging = CommandQuery.CountRows(sessionFactory, listWhereField, CommandConstant.QueryAND, req, objectTable);
        Query query = CommandQuery.CreateQuery(sessionFactory, listWhereField, CommandConstant.QueryAND, req, objectTable, paging);
        /*
         * Check array data if true set create object to array new.
         */
        list = query.list();
        if (!list.isEmpty()) {
            /*
             Predicate condition = new Predicate() {
             boolean evaluate(Object sample) {
             return ((Sample) sample).value3.equals("three");
             }
             };*/

            /*
             * Start developer create object to array new.
             */
            for (OperationMember operationMemberObjectList : list) {
                operationMemberObject = new OperationMember();
                //operationMemberObject.setMember(operationMemberObjectList.getMember());
                //operationMemberObject.setOperation(operationMemberObjectList.getOperation());
                //operationMemberObject.setMember(null);
                operationMemberObject.setOperationId(operationMemberObjectList.getOperationId());
                operationMemberObject.setOperationTypeCode(operationMemberObjectList.getOperationTypeCode());
                operationMemberObject.setOperationMemberId(operationMemberObjectList.getOperationMemberId());
                operationMemberObject.setMemberCode(operationMemberObjectList.getMemberCode());
                operationMemberObject.setMilitaryId(operationMemberObjectList.getMilitaryId());
                operationMemberObject.setCitizenId(operationMemberObjectList.getCitizenId());
                operationMemberObject.setRankId(operationMemberObjectList.getRankId());
                operationMemberObject.setRankName(operationMemberObjectList.getRankName());
                operationMemberObject.setName(operationMemberObjectList.getName());
                operationMemberObject.setSurname(operationMemberObjectList.getSurname());
                operationMemberObject.setDocDate(operationMemberObjectList.getDocDate());
                operationMemberObject.setApplyDate(operationMemberObjectList.getApplyDate());
                operationMemberObject.setMemberTypeCode(operationMemberObjectList.getMemberTypeCode());
                operationMemberObject.setDocCode(operationMemberObjectList.getDocCode());
                listResponse.add(operationMemberObjectList);
            }
            /*
             * End developer create object to array new.
             */

            /*
             * Set Paging to jqgrid.
             */
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(listResponse);
        }
        return jqGrid;
    }

    @Override
    public MessageResponse setSaveApproveOperationMemberList(List<Member> listMember, Operation operation) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        int iCountSuccessful = 0;
        OperationMember operationMember;

        if (CommandQuery.Insert(sessionFactory, operation)) {
            for (Member member : listMember) {
                Member memberOriginal = (Member) CommandQuery.LoadDetail(sessionFactory, Member.class, member.getMemberId());
                memberOriginal.setMemberStatusCode(member.getMemberStatusCode());
                memberOriginal.setUpdateBy(member.getUpdateBy());
                memberOriginal.setUpdateDate(member.getUpdateDate());
                if (CommandQuery.Update(sessionFactory, memberOriginal)) {
                    operationMember = new OperationMember();
                    operationMember.setOperation(operation);
                    operationMember.setMember(memberOriginal);
                    if (CommandQuery.Insert(sessionFactory, operationMember)) {
                        iCountSuccessful++;
                    }
                }
            }

            if (iCountSuccessful == listMember.size()) {
                chekSuccess = true;
            } else {
                chekSuccess = false;
            }
        } else {
            chekSuccess = false;
        }

        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(operation.getOperationId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }
}
