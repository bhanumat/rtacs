/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IMemberBeneficiaryDAO;
import com.itos.dao.model.IMemberDAO;
import com.itos.model.Member;
import com.itos.model.MemberBeneficiary;
import com.itos.model.MilitaryDepartment;
import com.itos.model.OperationMember;
import com.itos.model.Rank;
import com.itos.model.Title;
import com.itos.model.ext.PaymentDetail;
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
@Repository("iMemberDAO")
public class MemberDAO implements IMemberDAO {

    protected final Log logger = LogFactory.getLog(getClass());
    private static final Locale ENG_LOCALE = new Locale("en", "EN");
    private static final SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy", ENG_LOCALE);
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", ENG_LOCALE);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    IMemberBeneficiaryDAO iMemberBeneficiaryDAO;

    private final String objectTable = "Member";
    private final String operationMemberTable = "OperationMember";

    @Override
    public JqGridResponse<Member> getList(JqGridRequest req) {
        List<Member> listResponse = new ArrayList<>();
        JqGridResponse<Member> jqGrid = new JqGridResponse<>();
        Member memberObject;
        List<Member> list;
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
        if (!query.list().isEmpty()) {
            list = query.list();

            /*
             * Start developer create object to array new.
             */
            for (Member memberObjectList : list) {
                memberObject = new Member();
                memberObject.setAccTypeId(memberObjectList.getAccTypeId());
                memberObject.setAccTypeName(memberObjectList.getAccTypeName());
                memberObject.setAddress(memberObjectList.getAddress());
                memberObject.setAddressPrimary(memberObjectList.getAddressPrimary());
                memberObject.setApplyDate(memberObjectList.getApplyDate());
                memberObject.setBankAccName(memberObjectList.getBankAccName());
                memberObject.setBankAccNo(memberObjectList.getBankAccNo());
                memberObject.setBankBranchId(memberObjectList.getBankBranchId());
                memberObject.setBankCode(memberObjectList.getBankCode());
                memberObject.setBirthDate(memberObjectList.getBirthDate());
                memberObject.setCitizenId(memberObjectList.getCitizenId());
                memberObject.setCreateBy(memberObjectList.getCreateBy());
                memberObject.setCreateDate(memberObjectList.getCreateDate());
                memberObject.setDistrict(memberObjectList.getDistrict());
                memberObject.setFax(memberObjectList.getFax());
                memberObject.setGender(memberObjectList.getGender());
                memberObject.setMarryStatusCode(memberObjectList.getMarryStatusCode());
                memberObject.setMemberCode(memberObjectList.getMemberCode());
                memberObject.setMemberGroupCode(memberObjectList.getMemberGroupCode());
                memberObject.setMemberId(memberObjectList.getMemberId());
                memberObject.setMemberStatusCode(memberObjectList.getMemberStatusCode());
                memberObject.setMemberTypeCode(memberObjectList.getMemberTypeCode());
                memberObject.setMilitaryId(memberObjectList.getMilitaryId());
                memberObject.setMilitaryName(memberObjectList.getMilitaryName());
                memberObject.setMobile(memberObjectList.getMobile());
                memberObject.setMoo(memberObjectList.getMoo());
                memberObject.setName(memberObjectList.getName());
                memberObject.setPaymentRemark(memberObjectList.getPaymentRemark());
                memberObject.setPaymentType(memberObjectList.getPaymentType());
                memberObject.setPaymentTypeCode(memberObjectList.getPaymentTypeCode());
                memberObject.setPermanentAddress(memberObjectList.getPermanentAddress());
                memberObject.setPermanentDistrict(memberObjectList.getPermanentDistrict());
                memberObject.setPermanentFax(memberObjectList.getPermanentFax());
                memberObject.setPermanentMobile(memberObjectList.getPermanentMobile());
                memberObject.setPermanentProvinceCode(memberObjectList.getPermanentProvinceCode());
                memberObject.setPermanentProvinceName(memberObjectList.getPermanentProvinceName());
                memberObject.setPermanentRoad(memberObjectList.getPermanentRoad());
                memberObject.setPermanentSoi(memberObjectList.getPermanentSoi());
                memberObject.setPermanentSubdistrict(memberObjectList.getPermanentSubdistrict());
                memberObject.setPermanentTel(memberObjectList.getPermanentTel());
                memberObject.setPermanentZipcode(memberObjectList.getPermanentZipcode());
                memberObject.setProvinceCode(memberObjectList.getProvinceCode());
                memberObject.setProvinceName(memberObjectList.getProvinceName());
                memberObject.setTitleId(memberObjectList.getTitleId());
                memberObject.setRankId(memberObjectList.getRankId());
                memberObject.setRankOrTitleName(null != memberObjectList.getRankId() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
                memberObject.setReferrerId(memberObjectList.getReferrerId());
                memberObject.setReferrerRelationshipCode(memberObjectList.getReferrerRelationshipCode());
                memberObject.setRemark(memberObjectList.getRemark());
                memberObject.setRoad(memberObjectList.getRoad());
                memberObject.setSoi(memberObjectList.getSoi());
                memberObject.setSubdistrict(memberObjectList.getSubdistrict());
                memberObject.setSurname(memberObjectList.getSurname());
                memberObject.setTel(memberObjectList.getTel());
                memberObject.setUpdateBy(memberObjectList.getUpdateBy());
                memberObject.setUpdateDate(memberObjectList.getUpdateDate());
                memberObject.setWifehusbandFullname(memberObjectList.getWifehusbandFullname());
                memberObject.setZipcode(memberObjectList.getZipcode());
                memberObject.setPermanentMoo(memberObjectList.getPermanentMoo());

                listResponse.add(memberObject);
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
    public JqGridResponse<Member> getListAPP041_2(JqGridRequest req) {
        logger.info("getListAPP041_2");
        List<Member> listResponse = new ArrayList<>();
        JqGridResponse<Member> jqGrid = new JqGridResponse<>();
        Member memberObject;
        List<OperationMember> list;

        logger.info("req : " + req.isSearch());
        logger.info("req : >>" + req.getSearchCommand() + "<<");

        Paging paging = CommandQuery.CountRows(sessionFactory, req, operationMemberTable);
        Query query = CommandQuery.CreateQuery(sessionFactory, req, operationMemberTable, paging);

        if (!query.list().isEmpty()) {
            list = query.list();
            logger.info("list size : " + list.size());
            for (OperationMember objectList : list) {
                memberObject = new Member();
                memberObject.setAccTypeId(objectList.getMember().getAccTypeId());
                memberObject.setAccTypeName(objectList.getMember().getAccTypeName());
                memberObject.setAddress(objectList.getMember().getAddress());
                memberObject.setAddressPrimary(objectList.getMember().getAddressPrimary());
                memberObject.setApplyDate(objectList.getMember().getApplyDate());
                memberObject.setBankAccName(objectList.getMember().getBankAccName());
                memberObject.setBankAccNo(objectList.getMember().getBankAccNo());
                memberObject.setBankBranchId(objectList.getMember().getBankBranchId());
                memberObject.setBankCode(objectList.getMember().getBankCode());
                memberObject.setBirthDate(objectList.getMember().getBirthDate());
                memberObject.setCitizenId(objectList.getMember().getCitizenId());
                memberObject.setCreateBy(objectList.getMember().getCreateBy());
                memberObject.setCreateDate(objectList.getMember().getCreateDate());
                memberObject.setDistrict(objectList.getMember().getDistrict());
                memberObject.setFax(objectList.getMember().getFax());
                memberObject.setGender(objectList.getMember().getGender());
                memberObject.setMarryStatusCode(objectList.getMember().getMarryStatusCode());
                memberObject.setMemberCode(objectList.getMember().getMemberCode());
                memberObject.setMemberGroupCode(objectList.getMember().getMemberGroupCode());
                memberObject.setMemberId(objectList.getMember().getMemberId());
                memberObject.setMemberStatusCode(objectList.getMember().getMemberStatusCode());
                memberObject.setMemberTypeCode(objectList.getMember().getMemberTypeCode());
                memberObject.setMilitaryId(objectList.getMember().getMilitaryId());
                memberObject.setMilitaryName(objectList.getMember().getMilitaryName());
                memberObject.setMobile(objectList.getMember().getMobile());
                memberObject.setMoo(objectList.getMember().getMoo());
                memberObject.setName(objectList.getMember().getName());
                memberObject.setPaymentRemark(objectList.getMember().getPaymentRemark());
                memberObject.setPaymentType(objectList.getMember().getPaymentType());
                memberObject.setPaymentTypeCode(objectList.getMember().getPaymentTypeCode());
                memberObject.setPermanentAddress(objectList.getMember().getPermanentAddress());
                memberObject.setPermanentDistrict(objectList.getMember().getPermanentDistrict());
                memberObject.setPermanentFax(objectList.getMember().getPermanentFax());
                memberObject.setPermanentMobile(objectList.getMember().getPermanentMobile());
                memberObject.setPermanentProvinceCode(objectList.getMember().getPermanentProvinceCode());
                memberObject.setPermanentProvinceName(objectList.getMember().getPermanentProvinceName());
                memberObject.setPermanentRoad(objectList.getMember().getPermanentRoad());
                memberObject.setPermanentSoi(objectList.getMember().getPermanentSoi());
                memberObject.setPermanentSubdistrict(objectList.getMember().getPermanentSubdistrict());
                memberObject.setPermanentTel(objectList.getMember().getPermanentTel());
                memberObject.setPermanentZipcode(objectList.getMember().getPermanentZipcode());
                memberObject.setProvinceCode(objectList.getMember().getProvinceCode());
                memberObject.setProvinceName(objectList.getMember().getProvinceName());
                memberObject.setTitleId(objectList.getMember().getTitleId());
                memberObject.setRankId(objectList.getMember().getRankId());
                memberObject.setRankOrTitleName(null != objectList.getMember().getRankId() ? objectList.getMember().getRankName() : objectList.getMember().getTitleName());
                memberObject.setReferrerId(objectList.getMember().getReferrerId());
                memberObject.setReferrerRelationshipCode(objectList.getMember().getReferrerRelationshipCode());
                memberObject.setRemark(objectList.getMember().getRemark());
                memberObject.setRoad(objectList.getMember().getRoad());
                memberObject.setSoi(objectList.getMember().getSoi());
                memberObject.setSubdistrict(objectList.getMember().getSubdistrict());
                memberObject.setSurname(objectList.getMember().getSurname());
                memberObject.setTel(objectList.getMember().getTel());
                memberObject.setUpdateBy(objectList.getMember().getUpdateBy());
                memberObject.setUpdateDate(objectList.getMember().getUpdateDate());
                memberObject.setWifehusbandFullname(objectList.getMember().getWifehusbandFullname());
                memberObject.setZipcode(objectList.getMember().getZipcode());
                memberObject.setPermanentMoo(objectList.getMember().getPermanentMoo());

                listResponse.add(memberObject);
            }
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(listResponse);
        }
        return jqGrid;
    }

    @Override
    public JqGridResponse<Member> getAddListAPP041_2(JqGridRequest req) {
        logger.info("getAddListAPP041_2");
        List<Member> listResponse = new ArrayList<>();
        JqGridResponse<Member> jqGrid = new JqGridResponse<>();
        Member memberObject;
        List<Member> list;
        StringBuilder hqlSearch = new StringBuilder();
        StringBuilder hql = new StringBuilder();

        hqlSearch.append(CommandConstant.CountRows);
        hqlSearch.append(" ");

        hql.append(CommandConstant.QueryFrom);
        hql.append(" ");
        hql.append(objectTable);
        hql.append(" ");
        hql.append(CommandConstant.QueryWhere);
        hql.append(" member_status_code = 20 ");

        if (req.isSearch()) {
            Search search = Search.JSONDeserializer(req.getSearchCommand());
            for (Condition condition : search.getConditions()) {
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
                    hql.append(" and ").append(condition.getField());
                    hql.append(" between ");
                    hql.append(" \'").append(beginDate).append("\' ");
                    hql.append(" and \'").append(endDate).append("\' ");
                }
                if (CommandConstant.DataTypeVarchar.equalsIgnoreCase(condition.getDataType())) {
                    hql.append(" and ").append(condition.getField());
                    hql.append(" = \'").append(condition.getData()).append("\' ");
                }
                if (CommandConstant.DataTypeInteger.equalsIgnoreCase(condition.getDataType())) {
                    hql.append(" and ").append(condition.getField());
                    hql.append(" = ").append(condition.getData()).append(" ");
                }
            }
        }

        hqlSearch.append(hql);
        Paging paging = CommandQuery.queryCountRows(sessionFactory, req, hqlSearch);
        Query query = CommandQuery.CreateQuery(sessionFactory, req, paging, hql);

        if (!query.list().isEmpty()) {
            list = query.list();
            for (Member objectList : list) {
                memberObject = new Member();
                memberObject.setAccTypeId(objectList.getAccTypeId());
                memberObject.setAccTypeName(objectList.getAccTypeName());
                memberObject.setAddress(objectList.getAddress());
                memberObject.setAddressPrimary(objectList.getAddressPrimary());
                memberObject.setApplyDate(objectList.getApplyDate());
                memberObject.setBankAccName(objectList.getBankAccName());
                memberObject.setBankAccNo(objectList.getBankAccNo());
                memberObject.setBankBranchId(objectList.getBankBranchId());
                memberObject.setBankCode(objectList.getBankCode());
                memberObject.setBirthDate(objectList.getBirthDate());
                memberObject.setCitizenId(objectList.getCitizenId());
                memberObject.setCreateBy(objectList.getCreateBy());
                memberObject.setCreateDate(objectList.getCreateDate());
                memberObject.setDistrict(objectList.getDistrict());
                memberObject.setFax(objectList.getFax());
                memberObject.setGender(objectList.getGender());
                memberObject.setMarryStatusCode(objectList.getMarryStatusCode());
                memberObject.setMemberCode(objectList.getMemberCode());
                memberObject.setMemberGroupCode(objectList.getMemberGroupCode());
                memberObject.setMemberId(objectList.getMemberId());
                memberObject.setMemberStatusCode(objectList.getMemberStatusCode());
                memberObject.setMemberTypeCode(objectList.getMemberTypeCode());
                memberObject.setMilitaryId(objectList.getMilitaryId());
                memberObject.setMilitaryName(objectList.getMilitaryName());
                memberObject.setMobile(objectList.getMobile());
                memberObject.setMoo(objectList.getMoo());
                memberObject.setName(objectList.getName());
                memberObject.setPaymentRemark(objectList.getPaymentRemark());
                memberObject.setPaymentType(objectList.getPaymentType());
                memberObject.setPaymentTypeCode(objectList.getPaymentTypeCode());
                memberObject.setPermanentAddress(objectList.getPermanentAddress());
                memberObject.setPermanentDistrict(objectList.getPermanentDistrict());
                memberObject.setPermanentFax(objectList.getPermanentFax());
                memberObject.setPermanentMobile(objectList.getPermanentMobile());
                memberObject.setPermanentProvinceCode(objectList.getPermanentProvinceCode());
                memberObject.setPermanentProvinceName(objectList.getPermanentProvinceName());
                memberObject.setPermanentRoad(objectList.getPermanentRoad());
                memberObject.setPermanentSoi(objectList.getPermanentSoi());
                memberObject.setPermanentSubdistrict(objectList.getPermanentSubdistrict());
                memberObject.setPermanentTel(objectList.getPermanentTel());
                memberObject.setPermanentZipcode(objectList.getPermanentZipcode());
                memberObject.setProvinceCode(objectList.getProvinceCode());
                memberObject.setProvinceName(objectList.getProvinceName());
                memberObject.setTitleId(objectList.getTitleId());
                memberObject.setRankId(objectList.getRankId());
                memberObject.setRankOrTitleName(null != objectList.getRankId() ? objectList.getRankName() : objectList.getTitleName());
                memberObject.setReferrerId(objectList.getReferrerId());
                memberObject.setReferrerRelationshipCode(objectList.getReferrerRelationshipCode());
                memberObject.setRemark(objectList.getRemark());
                memberObject.setRoad(objectList.getRoad());
                memberObject.setSoi(objectList.getSoi());
                memberObject.setSubdistrict(objectList.getSubdistrict());
                memberObject.setSurname(objectList.getSurname());
                memberObject.setTel(objectList.getTel());
                memberObject.setUpdateBy(objectList.getUpdateBy());
                memberObject.setUpdateDate(objectList.getUpdateDate());
                memberObject.setWifehusbandFullname(objectList.getWifehusbandFullname());
                memberObject.setZipcode(objectList.getZipcode());
                memberObject.setPermanentMoo(objectList.getPermanentMoo());

                listResponse.add(memberObject);
            }
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(listResponse);
        }
        return jqGrid;
    }

    @Override
    public JqGridResponse<Member> getListAPP031_2(JqGridRequest req) {
        logger.info("getListAPP031_2");
        List<Member> listResponse = new ArrayList<>();
        JqGridResponse<Member> jqGrid = new JqGridResponse<>();
        Member memberObject;
        List<OperationMember> list;

        logger.info("req : " + req.isSearch());
        logger.info("req : >>" + req.getSearchCommand() + "<<");

        Paging paging = CommandQuery.CountRows(sessionFactory, req, operationMemberTable);
        Query query = CommandQuery.CreateQuery(sessionFactory, req, operationMemberTable, paging);

        if (!query.list().isEmpty()) {
            list = query.list();
            logger.info("list size : " + list.size());
            for (OperationMember objectList : list) {
                memberObject = new Member();
                memberObject.setAccTypeId(objectList.getMember().getAccTypeId());
                memberObject.setAccTypeName(objectList.getMember().getAccTypeName());
                memberObject.setAddress(objectList.getMember().getAddress());
                memberObject.setAddressPrimary(objectList.getMember().getAddressPrimary());
                memberObject.setApplyDate(objectList.getMember().getApplyDate());
                memberObject.setBankAccName(objectList.getMember().getBankAccName());
                memberObject.setBankAccNo(objectList.getMember().getBankAccNo());
                memberObject.setBankBranchId(objectList.getMember().getBankBranchId());
                memberObject.setBankCode(objectList.getMember().getBankCode());
                memberObject.setBirthDate(objectList.getMember().getBirthDate());
                memberObject.setCitizenId(objectList.getMember().getCitizenId());
                memberObject.setCreateBy(objectList.getMember().getCreateBy());
                memberObject.setCreateDate(objectList.getMember().getCreateDate());
                memberObject.setDistrict(objectList.getMember().getDistrict());
                memberObject.setFax(objectList.getMember().getFax());
                memberObject.setGender(objectList.getMember().getGender());
                memberObject.setMarryStatusCode(objectList.getMember().getMarryStatusCode());
                memberObject.setMemberCode(objectList.getMember().getMemberCode());
                memberObject.setMemberGroupCode(objectList.getMember().getMemberGroupCode());
                memberObject.setMemberId(objectList.getMember().getMemberId());
                memberObject.setMemberStatusCode(objectList.getMember().getMemberStatusCode());
                memberObject.setMemberTypeCode(objectList.getMember().getMemberTypeCode());
                memberObject.setMilitaryId(objectList.getMember().getMilitaryId());
                memberObject.setMilitaryName(objectList.getMember().getMilitaryName());
                memberObject.setMobile(objectList.getMember().getMobile());
                memberObject.setMoo(objectList.getMember().getMoo());
                memberObject.setName(objectList.getMember().getName());
                memberObject.setPaymentRemark(objectList.getMember().getPaymentRemark());
                memberObject.setPaymentType(objectList.getMember().getPaymentType());
                memberObject.setPaymentTypeCode(objectList.getMember().getPaymentTypeCode());
                memberObject.setPermanentAddress(objectList.getMember().getPermanentAddress());
                memberObject.setPermanentDistrict(objectList.getMember().getPermanentDistrict());
                memberObject.setPermanentFax(objectList.getMember().getPermanentFax());
                memberObject.setPermanentMobile(objectList.getMember().getPermanentMobile());
                memberObject.setPermanentProvinceCode(objectList.getMember().getPermanentProvinceCode());
                memberObject.setPermanentProvinceName(objectList.getMember().getPermanentProvinceName());
                memberObject.setPermanentRoad(objectList.getMember().getPermanentRoad());
                memberObject.setPermanentSoi(objectList.getMember().getPermanentSoi());
                memberObject.setPermanentSubdistrict(objectList.getMember().getPermanentSubdistrict());
                memberObject.setPermanentTel(objectList.getMember().getPermanentTel());
                memberObject.setPermanentZipcode(objectList.getMember().getPermanentZipcode());
                memberObject.setProvinceCode(objectList.getMember().getProvinceCode());
                memberObject.setProvinceName(objectList.getMember().getProvinceName());
                memberObject.setTitleId(objectList.getMember().getTitleId());
                memberObject.setRankId(objectList.getMember().getRankId());
                memberObject.setRankOrTitleName(null != objectList.getMember().getRankId() ? objectList.getMember().getRankName() : objectList.getMember().getTitleName());
                memberObject.setReferrerId(objectList.getMember().getReferrerId());
                memberObject.setReferrerRelationshipCode(objectList.getMember().getReferrerRelationshipCode());
                memberObject.setRemark(objectList.getMember().getRemark());
                memberObject.setRoad(objectList.getMember().getRoad());
                memberObject.setSoi(objectList.getMember().getSoi());
                memberObject.setSubdistrict(objectList.getMember().getSubdistrict());
                memberObject.setSurname(objectList.getMember().getSurname());
                memberObject.setTel(objectList.getMember().getTel());
                memberObject.setUpdateBy(objectList.getMember().getUpdateBy());
                memberObject.setUpdateDate(objectList.getMember().getUpdateDate());
                memberObject.setWifehusbandFullname(objectList.getMember().getWifehusbandFullname());
                memberObject.setZipcode(objectList.getMember().getZipcode());
                memberObject.setPermanentMoo(objectList.getMember().getPermanentMoo());

                listResponse.add(memberObject);
            }
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(listResponse);
        }
        return jqGrid;
    }

    @Override
    public JqGridResponse<Member> getAddListAPP031_2(JqGridRequest req) {
        logger.info("getAddListAPP031_2");
        List<Member> listResponse = new ArrayList<>();
        JqGridResponse<Member> jqGrid = new JqGridResponse<>();
        Member memberObject;
        List<Member> list;
        StringBuilder hqlSearch = new StringBuilder();
        StringBuilder hql = new StringBuilder();

        hqlSearch.append(CommandConstant.CountRows);
        hqlSearch.append(" ");

        hql.append(CommandConstant.QueryFrom);
        hql.append(" ");
        hql.append(objectTable);
        hql.append(" ");
        hql.append(CommandConstant.QueryWhere);
        hql.append(" member_status_code = 11 ");

        if (req.isSearch()) {
            Search search = Search.JSONDeserializer(req.getSearchCommand());
            for (Condition condition : search.getConditions()) {
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
                    hql.append(" and ").append(condition.getField());
                    hql.append(" between ");
                    hql.append(" \'").append(beginDate).append("\' ");
                    hql.append(" and \'").append(endDate).append("\' ");
                }
                if (CommandConstant.DataTypeVarchar.equalsIgnoreCase(condition.getDataType())) {
                    hql.append(" and ").append(condition.getField());
                    hql.append(" = \'").append(condition.getData()).append("\' ");
                }
                if (CommandConstant.DataTypeInteger.equalsIgnoreCase(condition.getDataType())) {
                    hql.append(" and ").append(condition.getField());
                    hql.append(" = ").append(condition.getData()).append(" ");
                }
            }
        }

        hqlSearch.append(hql);
        Paging paging = CommandQuery.queryCountRows(sessionFactory, req, hqlSearch);
        Query query = CommandQuery.CreateQuery(sessionFactory, req, paging, hql);

        if (!query.list().isEmpty()) {
            list = query.list();
            for (Member objectList : list) {
                memberObject = new Member();
                memberObject.setAccTypeId(objectList.getAccTypeId());
                memberObject.setAccTypeName(objectList.getAccTypeName());
                memberObject.setAddress(objectList.getAddress());
                memberObject.setAddressPrimary(objectList.getAddressPrimary());
                memberObject.setApplyDate(objectList.getApplyDate());
                memberObject.setBankAccName(objectList.getBankAccName());
                memberObject.setBankAccNo(objectList.getBankAccNo());
                memberObject.setBankBranchId(objectList.getBankBranchId());
                memberObject.setBankCode(objectList.getBankCode());
                memberObject.setBirthDate(objectList.getBirthDate());
                memberObject.setCitizenId(objectList.getCitizenId());
                memberObject.setCreateBy(objectList.getCreateBy());
                memberObject.setCreateDate(objectList.getCreateDate());
                memberObject.setDistrict(objectList.getDistrict());
                memberObject.setFax(objectList.getFax());
                memberObject.setGender(objectList.getGender());
                memberObject.setMarryStatusCode(objectList.getMarryStatusCode());
                memberObject.setMemberCode(objectList.getMemberCode());
                memberObject.setMemberGroupCode(objectList.getMemberGroupCode());
                memberObject.setMemberId(objectList.getMemberId());
                memberObject.setMemberStatusCode(objectList.getMemberStatusCode());
                memberObject.setMemberTypeCode(objectList.getMemberTypeCode());
                memberObject.setMilitaryId(objectList.getMilitaryId());
                memberObject.setMilitaryName(objectList.getMilitaryName());
                memberObject.setMobile(objectList.getMobile());
                memberObject.setMoo(objectList.getMoo());
                memberObject.setName(objectList.getName());
                memberObject.setPaymentRemark(objectList.getPaymentRemark());
                memberObject.setPaymentType(objectList.getPaymentType());
                memberObject.setPaymentTypeCode(objectList.getPaymentTypeCode());
                memberObject.setPermanentAddress(objectList.getPermanentAddress());
                memberObject.setPermanentDistrict(objectList.getPermanentDistrict());
                memberObject.setPermanentFax(objectList.getPermanentFax());
                memberObject.setPermanentMobile(objectList.getPermanentMobile());
                memberObject.setPermanentProvinceCode(objectList.getPermanentProvinceCode());
                memberObject.setPermanentProvinceName(objectList.getPermanentProvinceName());
                memberObject.setPermanentRoad(objectList.getPermanentRoad());
                memberObject.setPermanentSoi(objectList.getPermanentSoi());
                memberObject.setPermanentSubdistrict(objectList.getPermanentSubdistrict());
                memberObject.setPermanentTel(objectList.getPermanentTel());
                memberObject.setPermanentZipcode(objectList.getPermanentZipcode());
                memberObject.setProvinceCode(objectList.getProvinceCode());
                memberObject.setProvinceName(objectList.getProvinceName());
                memberObject.setTitleId(objectList.getTitleId());
                memberObject.setRankId(objectList.getRankId());
                memberObject.setRankOrTitleName(null != objectList.getRankId() ? objectList.getRankName() : objectList.getTitleName());
                memberObject.setReferrerId(objectList.getReferrerId());
                memberObject.setReferrerRelationshipCode(objectList.getReferrerRelationshipCode());
                memberObject.setRemark(objectList.getRemark());
                memberObject.setRoad(objectList.getRoad());
                memberObject.setSoi(objectList.getSoi());
                memberObject.setSubdistrict(objectList.getSubdistrict());
                memberObject.setSurname(objectList.getSurname());
                memberObject.setTel(objectList.getTel());
                memberObject.setUpdateBy(objectList.getUpdateBy());
                memberObject.setUpdateDate(objectList.getUpdateDate());
                memberObject.setWifehusbandFullname(objectList.getWifehusbandFullname());
                memberObject.setZipcode(objectList.getZipcode());
                memberObject.setPermanentMoo(objectList.getPermanentMoo());

                listResponse.add(memberObject);
            }
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(listResponse);
        }
        return jqGrid;
    }

    @Override
    public JqGridResponse<Member> getListForRegister(JqGridRequest req) {
        List<Member> listResponse = new ArrayList<>();
        JqGridResponse<Member> jqGrid = new JqGridResponse<>();
        Member memberObject;
        List<Member> list;
        WhereField whereField = null;
        List<WhereField> listWhereField = new ArrayList<>();
        try {
            /*
             * Command HQL query Data.
             */
            //whereField = new WhereField();
            //whereField.setSearchField("memberStatusCode");
            //whereField.setSearchLogic("");
            //whereField.setSearchOper(CommandConstant.QueryEqual);
            //whereField.setSearchValue("13");
            //listWhereField.add(whereField);
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
            if (!query.list().isEmpty()) {
                list = query.list();

                /*
                 * Start developer create object to array new.
                 */
                for (Member memberObjectList : list) {
                    memberObject = new Member();
                    memberObject.setAccTypeId(memberObjectList.getAccTypeId());
                    memberObject.setAccTypeName(memberObjectList.getAccTypeName());
                    memberObject.setAddress(memberObjectList.getAddress());
                    memberObject.setAddressPrimary(memberObjectList.getAddressPrimary());
                    memberObject.setApplyDate(memberObjectList.getApplyDate());
                    memberObject.setBankAccName(memberObjectList.getBankAccName());
                    memberObject.setBankAccNo(memberObjectList.getBankAccNo());
                    memberObject.setBankBranchId(memberObjectList.getBankBranchId());
                    memberObject.setBankCode(memberObjectList.getBankCode());
                    memberObject.setBirthDate(memberObjectList.getBirthDate());
                    memberObject.setCitizenId(memberObjectList.getCitizenId());
                    memberObject.setCreateBy(memberObjectList.getCreateBy());
                    memberObject.setCreateDate(memberObjectList.getCreateDate());
                    memberObject.setDistrict(memberObjectList.getDistrict());
                    memberObject.setFax(memberObjectList.getFax());
                    memberObject.setGender(memberObjectList.getGender());
                    memberObject.setMarryStatusCode(memberObjectList.getMarryStatusCode());
                    memberObject.setMemberCode(memberObjectList.getMemberCode());
                    memberObject.setMemberGroupCode(memberObjectList.getMemberGroupCode());
                    memberObject.setMemberId(memberObjectList.getMemberId());
                    memberObject.setMemberStatusCode(memberObjectList.getMemberStatusCode());
                    memberObject.setMemberTypeCode(memberObjectList.getMemberTypeCode());
                    memberObject.setMilitaryId(memberObjectList.getMilitaryId());
                    memberObject.setMilitaryName(memberObjectList.getMilitaryName());
                    memberObject.setMobile(memberObjectList.getMobile());
                    memberObject.setMoo(memberObjectList.getMoo());
                    memberObject.setName(memberObjectList.getName());
                    memberObject.setPaymentRemark(memberObjectList.getPaymentRemark());
                    memberObject.setPaymentType(memberObjectList.getPaymentType());
                    memberObject.setPaymentTypeCode(memberObjectList.getPaymentTypeCode());
                    memberObject.setPermanentAddress(memberObjectList.getPermanentAddress());
                    memberObject.setPermanentDistrict(memberObjectList.getPermanentDistrict());
                    memberObject.setPermanentFax(memberObjectList.getPermanentFax());
                    memberObject.setPermanentMobile(memberObjectList.getPermanentMobile());
                    memberObject.setPermanentProvinceCode(memberObjectList.getPermanentProvinceCode());
                    memberObject.setPermanentProvinceName(memberObjectList.getPermanentProvinceName());
                    memberObject.setPermanentRoad(memberObjectList.getPermanentRoad());
                    memberObject.setPermanentSoi(memberObjectList.getPermanentSoi());
                    memberObject.setPermanentSubdistrict(memberObjectList.getPermanentSubdistrict());
                    memberObject.setPermanentTel(memberObjectList.getPermanentTel());
                    memberObject.setPermanentZipcode(memberObjectList.getPermanentZipcode());
                    memberObject.setProvinceCode(memberObjectList.getProvinceCode());
                    memberObject.setProvinceName(memberObjectList.getProvinceName());
                    memberObject.setTitleId(memberObjectList.getTitleId());
                    memberObject.setRankId(memberObjectList.getRankId());
                    memberObject.setRankOrTitleName(null != memberObjectList.getRankId() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
                    memberObject.setReferrerId(memberObjectList.getReferrerId());
                    memberObject.setReferrerRelationshipCode(memberObjectList.getReferrerRelationshipCode());
                    memberObject.setRemark(memberObjectList.getRemark());
                    memberObject.setRoad(memberObjectList.getRoad());
                    memberObject.setSoi(memberObjectList.getSoi());
                    memberObject.setSubdistrict(memberObjectList.getSubdistrict());
                    memberObject.setSurname(memberObjectList.getSurname());
                    memberObject.setTel(memberObjectList.getTel());
                    memberObject.setUpdateBy(memberObjectList.getUpdateBy());
                    memberObject.setUpdateDate(memberObjectList.getUpdateDate());
                    memberObject.setWifehusbandFullname(memberObjectList.getWifehusbandFullname());
                    memberObject.setZipcode(memberObjectList.getZipcode());
                    memberObject.setPermanentMoo(memberObjectList.getPermanentMoo());

                    listResponse.add(memberObject);
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
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public MessageResponse setDeleteMember(MessageRequest req) {
        int iCountSuccessful = 0;
        int iCountSubSuccessful = 0;
        MessageResponse response = new MessageResponse();
        MemberBeneficiary memberBeneficiaryOriginal;
        List<MemberBeneficiary> listMemberBeneficiary = new ArrayList<>();
        Member memberOriginal = null;
        boolean chekSuccess = false;
        for (String id : req.getItemSelect()) {
            memberOriginal = new Member();
            memberOriginal = (Member) CommandQuery.LoadDetail(sessionFactory, Member.class, Integer.parseInt(id));

            listMemberBeneficiary = iMemberBeneficiaryDAO.getListByMember(memberOriginal);

            for (MemberBeneficiary memberBeneficiary : listMemberBeneficiary) {
                memberBeneficiaryOriginal = (MemberBeneficiary) CommandQuery.LoadDetail(sessionFactory, MemberBeneficiary.class, memberBeneficiary.getBeneficiaryId());
                if (CommandQuery.Delete(sessionFactory, memberBeneficiaryOriginal)) {
                    iCountSubSuccessful++;
                }
            }
            if (iCountSubSuccessful == listMemberBeneficiary.size()) {
                if (CommandQuery.Delete(sessionFactory, memberOriginal)) {
                    iCountSuccessful++;
                }
            } else {
                throw new RuntimeException(ConstantsMessage.DeleteUnsuccessful);
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
    public MessageResponse setSaveNewMember(Member member) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        int iCountSuccessful = 0;
        chekSuccess = CommandQuery.Insert(sessionFactory, member);

        if (chekSuccess) {
            if (null != member.getListMemberBeneficiary() && !member.getListMemberBeneficiary().isEmpty() && member.getListMemberBeneficiary().size() != 0) {
                for (MemberBeneficiary memberBeneficiary : member.getListMemberBeneficiary()) {
                    memberBeneficiary.setMember(member);
                    if (CommandQuery.Insert(sessionFactory, memberBeneficiary)) {
                        iCountSuccessful++;
                    }
                }
                if (iCountSuccessful == member.getListMemberBeneficiary().size()) {
                    chekSuccess = true;
                } else {
                    chekSuccess = false;
                }
            }
        }

        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(member.getMemberId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveEditMember(Member member) {
        MessageResponse response = new MessageResponse();
        MemberBeneficiary memberBeneficiaryOriginal;
        boolean chekSuccess = false;
        int iCountSuccessful = 0;
        Member memberOriginal = (Member) CommandQuery.LoadDetail(sessionFactory, Member.class, member.getMemberId());

        memberOriginal.setBankAccountType(member.getBankAccountType());
        memberOriginal.setAddress(member.getAddress());
        memberOriginal.setAddressPrimary(member.getAddressPrimary());
        memberOriginal.setApplyDate(member.getApplyDate());
        memberOriginal.setBankAccName(member.getBankAccName());
        memberOriginal.setBankAccNo(member.getBankAccNo());
        memberOriginal.setBankBranch(member.getBankBranch());
        memberOriginal.setBank(member.getBank());
        memberOriginal.setBirthDate(member.getBirthDate());
        memberOriginal.setCitizenId(member.getCitizenId());
        memberOriginal.setCreateBy(member.getCreateBy());
        memberOriginal.setCreateDate(member.getCreateDate());
        memberOriginal.setDistrict(member.getDistrict());
        memberOriginal.setFax(member.getFax());
        memberOriginal.setGender(member.getGender());
        memberOriginal.setMarryStatusCode(member.getMarryStatusCode());
        memberOriginal.setMemberCode(member.getMemberCode());
        memberOriginal.setMemberGroupCode(member.getMemberGroupCode());
        memberOriginal.setMemberId(member.getMemberId());
        memberOriginal.setMilitaryId(member.getMilitaryId());
        //memberOriginal.setMemberStatusCode(member.getMemberStatusCode());
        memberOriginal.setMemberTypeCode(member.getMemberTypeCode());
        memberOriginal.setMilitaryDepartment(member.getMilitaryDepartment());
        memberOriginal.setMobile(member.getMobile());
        memberOriginal.setMoo(member.getMoo());
        memberOriginal.setName(member.getName());
        memberOriginal.setPaymentRemark(member.getPaymentRemark());
        memberOriginal.setPaymentType(member.getPaymentType());
        memberOriginal.setPaymentTypeCode(member.getPaymentTypeCode());
        memberOriginal.setPermanentAddress(member.getPermanentAddress());
        memberOriginal.setPermanentDistrict(member.getPermanentDistrict());
        memberOriginal.setPermanentFax(member.getPermanentFax());
        memberOriginal.setPermanentMobile(member.getPermanentMobile());
        memberOriginal.setProvinceByPermanentProvinceCode(member.getProvinceByPermanentProvinceCode());
        memberOriginal.setPermanentRoad(member.getPermanentRoad());
        memberOriginal.setPermanentSoi(member.getPermanentSoi());
        memberOriginal.setPermanentSubdistrict(member.getPermanentSubdistrict());
        memberOriginal.setPermanentTel(member.getPermanentTel());
        memberOriginal.setPermanentZipcode(member.getPermanentZipcode());
        memberOriginal.setProvinceByProvinceCode(member.getProvinceByProvinceCode());
        memberOriginal.setRank(member.getRank());
        memberOriginal.setReferrerId(member.getReferrerId());
        memberOriginal.setReferrerRelationshipCode(member.getReferrerRelationshipCode());
        memberOriginal.setRemark(member.getRemark());
        memberOriginal.setRoad(member.getRoad());
        memberOriginal.setSoi(member.getSoi());
        memberOriginal.setSubdistrict(member.getSubdistrict());
        memberOriginal.setSurname(member.getSurname());
        memberOriginal.setTel(member.getTel());
        memberOriginal.setTitle(member.getTitle());
        memberOriginal.setUpdateBy(member.getUpdateBy());
        memberOriginal.setUpdateDate(member.getUpdateDate());
        memberOriginal.setWifehusbandFullname(member.getWifehusbandFullname());
        memberOriginal.setZipcode(member.getZipcode());
        memberOriginal.setPermanentMoo(member.getPermanentMoo());
        chekSuccess = CommandQuery.Update(sessionFactory, memberOriginal);

        if (chekSuccess) {
            if (null != member.getListMemberBeneficiary() && !member.getListMemberBeneficiary().isEmpty() && member.getListMemberBeneficiary().size() != 0) {
                for (MemberBeneficiary memberBeneficiary : member.getListMemberBeneficiary()) {
                    if (memberBeneficiary.getBeneficiaryId() == 0) {
                        memberBeneficiary.setMember(member);
                        if (CommandQuery.Insert(sessionFactory, memberBeneficiary)) {
                            iCountSuccessful++;
                        }
                    } else {
                        memberBeneficiary.setMember(member);
                        if (CommandQuery.Update(sessionFactory, memberBeneficiary)) {
                            iCountSuccessful++;
                        }
                    }
                }

                if (null != member.getDeleteBeneficiaryId() && !member.getDeleteBeneficiaryId().isEmpty() && member.getDeleteBeneficiaryId().size() != 0) {
                    for (String beneficiaryId : member.getDeleteBeneficiaryId()) {
                        memberBeneficiaryOriginal = new MemberBeneficiary();
                        memberBeneficiaryOriginal = (MemberBeneficiary) CommandQuery.LoadDetail(sessionFactory, MemberBeneficiary.class, Integer.parseInt(beneficiaryId));
                        if (CommandQuery.Delete(sessionFactory, memberBeneficiaryOriginal)) {
                            iCountSuccessful++;
                        }
                    }
                }

                if (iCountSuccessful == (member.getListMemberBeneficiary().size() + member.getDeleteBeneficiaryId().size())) {
                    chekSuccess = true;
                } else {
                    chekSuccess = false;
                }
            }
        }

        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(member.getMemberId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveUpdateMemberOperation(Member memberData) {
        logger.info("call setSaveUpdateMemberOperation");
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        memberData.setMemberStatusCode(25);
        if (CommandQuery.Update(sessionFactory, memberData)) {
            iCountSuccessful++;
        }
        if (iCountSuccessful > 1) {
            chekSuccess = true;
        }
        if (chekSuccess) {
            response.setId("");
            response.setCheckSuccess(chekSuccess);
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public Member getLoadMember(Member member) {
        logger.info("MemberDAO : getLoadMember");
        Member memberObject = getLoadDetailByObject(member);
        Member memberResponse = new Member();
        memberResponse.setAccTypeId(memberObject.getAccTypeId());
        memberResponse.setAccTypeName(memberObject.getAccTypeName());
        memberResponse.setAddress(memberObject.getAddress());
        memberResponse.setAddressPrimary(memberObject.getAddressPrimary());
        memberResponse.setApplyDate(memberObject.getApplyDate());
        memberResponse.setBankAccName(memberObject.getBankAccName());
        memberResponse.setBankAccNo(memberObject.getBankAccNo());
        memberResponse.setBankBranchId(memberObject.getBankBranchId());
        memberResponse.setBankCode(memberObject.getBankCode());
        memberResponse.setBirthDate(memberObject.getBirthDate());
        memberResponse.setCitizenId(memberObject.getCitizenId());
        memberResponse.setCreateBy(memberObject.getCreateBy());
        memberResponse.setCreateDate(memberObject.getCreateDate());
        memberResponse.setDistrict(memberObject.getDistrict());
        memberResponse.setFax(memberObject.getFax());
        memberResponse.setGender(memberObject.getGender());
        memberResponse.setMarryStatusCode(memberObject.getMarryStatusCode());
        memberResponse.setMemberCode(memberObject.getMemberCode());
        memberResponse.setMemberGroupCode(memberObject.getMemberGroupCode());
        memberResponse.setMemberId(memberObject.getMemberId());
        memberResponse.setMemberStatusCode(memberObject.getMemberStatusCode());
        memberResponse.setMemberTypeCode(memberObject.getMemberTypeCode());
        memberResponse.setMilitaryId(memberObject.getMilitaryId());
        memberResponse.setMilitaryName(memberObject.getMilitaryName());
        memberResponse.setMobile(memberObject.getMobile());
        memberResponse.setMoo(memberObject.getMoo());
        memberResponse.setName(memberObject.getName());
        memberResponse.setPaymentRemark(memberObject.getPaymentRemark());
        memberResponse.setPaymentType(memberObject.getPaymentType());
        memberResponse.setPaymentTypeCode(memberObject.getPaymentTypeCode());
        memberResponse.setPermanentAddress(memberObject.getPermanentAddress());
        memberResponse.setPermanentDistrict(memberObject.getPermanentDistrict());
        memberResponse.setPermanentFax(memberObject.getPermanentFax());
        memberResponse.setPermanentMobile(memberObject.getPermanentMobile());
        memberResponse.setPermanentProvinceCode(memberObject.getPermanentProvinceCode());
        memberResponse.setPermanentProvinceName(memberObject.getPermanentProvinceName());
        memberResponse.setPermanentRoad(memberObject.getPermanentRoad());
        memberResponse.setPermanentSoi(memberObject.getPermanentSoi());
        memberResponse.setPermanentSubdistrict(memberObject.getPermanentSubdistrict());
        memberResponse.setPermanentTel(memberObject.getPermanentTel());
        memberResponse.setPermanentZipcode(memberObject.getPermanentZipcode());
        memberResponse.setProvinceCode(memberObject.getProvinceCode());
        memberResponse.setProvinceName(memberObject.getProvinceName());
        memberResponse.setTitleId(memberObject.getTitleId());
        memberResponse.setRankId(memberObject.getRankId());
        memberResponse.setRankOrTitleName(null != memberObject.getRankId() ? memberObject.getRankName() : memberObject.getTitleName());
        memberResponse.setReferrerId(memberObject.getReferrerId());
        memberResponse.setReferrerRelationshipCode(memberObject.getReferrerRelationshipCode());
        memberResponse.setRemark(memberObject.getRemark());
        memberResponse.setRoad(memberObject.getRoad());
        memberResponse.setSoi(memberObject.getSoi());
        memberResponse.setSubdistrict(memberObject.getSubdistrict());
        memberResponse.setSurname(memberObject.getSurname());
        memberResponse.setTel(memberObject.getTel());
        memberResponse.setUpdateBy(memberObject.getUpdateBy());
        memberResponse.setUpdateDate(memberObject.getUpdateDate());
        memberResponse.setWifehusbandFullname(memberObject.getWifehusbandFullname());
        memberResponse.setZipcode(memberObject.getZipcode());
        memberResponse.setPermanentMoo(memberObject.getPermanentMoo());
        return memberResponse;
    }

    private Member getLoadDetailByObject(Member member) {
        logger.info("MemberDAO : getLoadDetailByObject");
        Member memberResponse = new Member();
        List<WhereField> listWhereField = new ArrayList<>();
        List<Member> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("memberId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(member.getMemberId());
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
            if (!query.list().isEmpty()) {
                list = query.list();

                /*
                 * Start developer create object to array new.
                 */
                for (Member memberObjectList : list) {
                    memberResponse = new Member();
                    memberResponse.setAccTypeId(memberObjectList.getAccTypeId());
                    memberResponse.setAccTypeName(memberObjectList.getAccTypeName());
                    memberResponse.setAddress(memberObjectList.getAddress());
                    memberResponse.setAddressPrimary(memberObjectList.getAddressPrimary());
                    memberResponse.setApplyDate(memberObjectList.getApplyDate());
                    memberResponse.setBankAccName(memberObjectList.getBankAccName());
                    memberResponse.setBankAccNo(memberObjectList.getBankAccNo());
                    memberResponse.setBankBranchId(memberObjectList.getBankBranchId());
                    memberResponse.setBankCode(memberObjectList.getBankCode());
                    memberResponse.setBirthDate(memberObjectList.getBirthDate());
                    memberResponse.setCitizenId(memberObjectList.getCitizenId());
                    memberResponse.setCreateBy(memberObjectList.getCreateBy());
                    memberResponse.setCreateDate(memberObjectList.getCreateDate());
                    memberResponse.setDistrict(memberObjectList.getDistrict());
                    memberResponse.setFax(memberObjectList.getFax());
                    memberResponse.setGender(memberObjectList.getGender());
                    memberResponse.setMarryStatusCode(memberObjectList.getMarryStatusCode());
                    memberResponse.setMemberCode(memberObjectList.getMemberCode());
                    memberResponse.setMemberGroupCode(memberObjectList.getMemberGroupCode());
                    memberResponse.setMemberId(memberObjectList.getMemberId());
                    memberResponse.setMemberStatusCode(memberObjectList.getMemberStatusCode());
                    memberResponse.setMemberTypeCode(memberObjectList.getMemberTypeCode());
                    memberResponse.setMilitaryId(memberObjectList.getMilitaryId());
                    memberResponse.setMilitaryName(memberObjectList.getMilitaryName());
                    memberResponse.setMobile(memberObjectList.getMobile());
                    memberResponse.setMoo(memberObjectList.getMoo());
                    memberResponse.setName(memberObjectList.getName());
                    memberResponse.setPaymentRemark(memberObjectList.getPaymentRemark());
                    memberResponse.setPaymentType(memberObjectList.getPaymentType());
                    memberResponse.setPaymentTypeCode(memberObjectList.getPaymentTypeCode());
                    memberResponse.setPermanentAddress(memberObjectList.getPermanentAddress());
                    memberResponse.setPermanentDistrict(memberObjectList.getPermanentDistrict());
                    memberResponse.setPermanentFax(memberObjectList.getPermanentFax());
                    memberResponse.setPermanentMobile(memberObjectList.getPermanentMobile());
                    memberResponse.setPermanentProvinceCode(memberObjectList.getPermanentProvinceCode());
                    memberResponse.setPermanentProvinceName(memberObjectList.getPermanentProvinceName());
                    memberResponse.setPermanentRoad(memberObjectList.getPermanentRoad());
                    memberResponse.setPermanentSoi(memberObjectList.getPermanentSoi());
                    memberResponse.setPermanentSubdistrict(memberObjectList.getPermanentSubdistrict());
                    memberResponse.setPermanentTel(memberObjectList.getPermanentTel());
                    memberResponse.setPermanentZipcode(memberObjectList.getPermanentZipcode());
                    memberResponse.setProvinceCode(memberObjectList.getProvinceCode());
                    memberResponse.setProvinceName(memberObjectList.getProvinceName());
                    memberResponse.setTitleId(memberObjectList.getTitleId());
                    memberResponse.setRankId(memberObjectList.getRankId());
                    memberResponse.setRankOrTitleName(null != memberObjectList.getRankId() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
                    memberResponse.setReferrerId(memberObjectList.getReferrerId());
                    memberResponse.setReferrerRelationshipCode(memberObjectList.getReferrerRelationshipCode());
                    memberResponse.setRemark(memberObjectList.getRemark());
                    memberResponse.setRoad(memberObjectList.getRoad());
                    memberResponse.setSoi(memberObjectList.getSoi());
                    memberResponse.setSubdistrict(memberObjectList.getSubdistrict());
                    memberResponse.setSurname(memberObjectList.getSurname());
                    memberResponse.setTel(memberObjectList.getTel());
                    memberResponse.setUpdateBy(memberObjectList.getUpdateBy());
                    memberResponse.setUpdateDate(memberObjectList.getUpdateDate());
                    memberResponse.setWifehusbandFullname(memberObjectList.getWifehusbandFullname());
                    memberResponse.setZipcode(memberObjectList.getZipcode());
                    memberResponse.setPermanentMoo(memberObjectList.getPermanentMoo());
                    memberResponse.setMemberBeneficiaries(memberObjectList.getMemberBeneficiaries());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return memberResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Member getLoadDetailById(Member member) {
        Member memberResponse = null;
        List<WhereField> listWhereField = new ArrayList<>();
        List<Member> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("memberId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(member.getMemberId());
            listWhereField.add(whereField);

            Query query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField, 0, 1);
            /*
             * Check array data if true set create object to array new.
             */
            if (!query.list().isEmpty()) {
                list = query.list();

                /*
                 * Start developer create object to array new.
                 */
                for (Member memberObjectList : list) {
                    memberResponse = new Member();
                    memberResponse.setAccTypeId(memberObjectList.getAccTypeId());
                    memberResponse.setAccTypeName(memberObjectList.getAccTypeName());
                    memberResponse.setAddress(memberObjectList.getAddress());
                    memberResponse.setAddressPrimary(memberObjectList.getAddressPrimary());
                    memberResponse.setApplyDate(memberObjectList.getApplyDate());
                    memberResponse.setBankAccName(memberObjectList.getBankAccName());
                    memberResponse.setBankAccNo(memberObjectList.getBankAccNo());
                    memberResponse.setBankBranchId(memberObjectList.getBankBranchId());
                    memberResponse.setBankCode(memberObjectList.getBankCode());
                    memberResponse.setBirthDate(memberObjectList.getBirthDate());
                    memberResponse.setCitizenId(memberObjectList.getCitizenId());
                    memberResponse.setCreateBy(memberObjectList.getCreateBy());
                    memberResponse.setCreateDate(memberObjectList.getCreateDate());
                    memberResponse.setDistrict(memberObjectList.getDistrict());
                    memberResponse.setFax(memberObjectList.getFax());
                    memberResponse.setGender(memberObjectList.getGender());
                    memberResponse.setMarryStatusCode(memberObjectList.getMarryStatusCode());
                    memberResponse.setMemberCode(memberObjectList.getMemberCode());
                    memberResponse.setMemberGroupCode(memberObjectList.getMemberGroupCode());
                    memberResponse.setMemberId(memberObjectList.getMemberId());
                    memberResponse.setMemberStatusCode(memberObjectList.getMemberStatusCode());
                    memberResponse.setMemberTypeCode(memberObjectList.getMemberTypeCode());
                    memberResponse.setMilitaryId(memberObjectList.getMilitaryId());
                    memberResponse.setMilitaryName(memberObjectList.getMilitaryName());
                    memberResponse.setMobile(memberObjectList.getMobile());
                    memberResponse.setMoo(memberObjectList.getMoo());
                    memberResponse.setName(memberObjectList.getName());
                    memberResponse.setPaymentRemark(memberObjectList.getPaymentRemark());
                    memberResponse.setPaymentType(memberObjectList.getPaymentType());
                    memberResponse.setPaymentTypeCode(memberObjectList.getPaymentTypeCode());
                    memberResponse.setPermanentAddress(memberObjectList.getPermanentAddress());
                    memberResponse.setPermanentDistrict(memberObjectList.getPermanentDistrict());
                    memberResponse.setPermanentFax(memberObjectList.getPermanentFax());
                    memberResponse.setPermanentMobile(memberObjectList.getPermanentMobile());
                    memberResponse.setPermanentProvinceCode(memberObjectList.getPermanentProvinceCode());
                    memberResponse.setPermanentProvinceName(memberObjectList.getPermanentProvinceName());
                    memberResponse.setPermanentRoad(memberObjectList.getPermanentRoad());
                    memberResponse.setPermanentSoi(memberObjectList.getPermanentSoi());
                    memberResponse.setPermanentSubdistrict(memberObjectList.getPermanentSubdistrict());
                    memberResponse.setPermanentTel(memberObjectList.getPermanentTel());
                    memberResponse.setPermanentZipcode(memberObjectList.getPermanentZipcode());
                    memberResponse.setProvinceCode(memberObjectList.getProvinceCode());
                    memberResponse.setProvinceName(memberObjectList.getProvinceName());
                    memberResponse.setTitleId(memberObjectList.getTitleId());
                    memberResponse.setRankId(memberObjectList.getRankId());
                    memberResponse.setRankOrTitleName(null != memberObjectList.getRankId() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
                    memberResponse.setReferrerId(memberObjectList.getReferrerId());
                    memberResponse.setReferrerRelationshipCode(memberObjectList.getReferrerRelationshipCode());
                    memberResponse.setRemark(memberObjectList.getRemark());
                    memberResponse.setRoad(memberObjectList.getRoad());
                    memberResponse.setSoi(memberObjectList.getSoi());
                    memberResponse.setSubdistrict(memberObjectList.getSubdistrict());
                    memberResponse.setSurname(memberObjectList.getSurname());
                    memberResponse.setTel(memberObjectList.getTel());
                    memberResponse.setUpdateBy(memberObjectList.getUpdateBy());
                    memberResponse.setUpdateDate(memberObjectList.getUpdateDate());
                    memberResponse.setWifehusbandFullname(memberObjectList.getWifehusbandFullname());
                    memberResponse.setZipcode(memberObjectList.getZipcode());
                    memberResponse.setPermanentMoo(memberObjectList.getPermanentMoo());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return memberResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public PaymentDetail searchMember(String citizenId) {
        logger.info("MemberDAO : searchMember");
        List<Member> list;
        PaymentDetail paymentDetail = new PaymentDetail();
        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;

        Query query;
        whereField = new WhereField();
        whereField.setSearchField("citizen_id");
        whereField.setSearchLogic("");
        whereField.setSearchOper(CommandConstant.QueryEqual);
        whereField.setSearchValue(citizenId);
        whereField.setSearchDataType(CommandConstant.DataTypeVarchar);
        listWhereField.add(whereField);
        query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);

        if (!query.list().isEmpty()) {
            list = query.list();

            for (Member memberObjectList : list) {
                MilitaryDepartment militaryDepartment = memberObjectList.getMilitaryDepartment();
                Rank rank = memberObjectList.getRank();
                Title title = memberObjectList.getTitle();

                String name = "";
                if (rank != null && rank.getRankName() != null) {
                    name = name + rank.getRankName() + " ";
                }
                if (title != null && title.getTitleDesc() != null) {
                    name = name + title.getTitleDesc() + " ";
                }
                if (memberObjectList.getName() != null) {
                    name = name + memberObjectList.getName() + " ";
                }
                if (memberObjectList.getSurname() != null) {
                    name = name + memberObjectList.getSurname();
                }
                paymentDetail.setCitizenID(memberObjectList.getCitizenId());
                paymentDetail.setName(name);
                paymentDetail.setMilitaryName((militaryDepartment != null) ? militaryDepartment.getName() : "");
                paymentDetail.setStatus(memberObjectList.getMemberStatusCode());
                paymentDetail.setMemberId(memberObjectList.getMemberId());
                return paymentDetail;
            }
        }
        return null;
    }

    @Override
    public Member updatedStatus(String citizenId) {
        logger.info("MemberDAO : updatedStatus");
        int iCountSuccessful = 0;
        List<Member> list;
        Member memberOriginal = null;

        logger.info("citizenId : >>" + citizenId + "<<");

        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;

        Query query;
        whereField = new WhereField();
        whereField.setSearchField("citizenId");
        whereField.setSearchLogic("");
        whereField.setSearchOper(CommandConstant.QueryEqual);
        whereField.setSearchValue(citizenId);
        whereField.setSearchDataType(CommandConstant.DataTypeVarchar);
        listWhereField.add(whereField);
        query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);

        if (!query.list().isEmpty()) {
            list = query.list();
            memberOriginal = list.get(0);
            memberOriginal.setMemberStatusCode(11);
            if (CommandQuery.Update(sessionFactory, memberOriginal)) {
                iCountSuccessful++;
            }
        }
        if (iCountSuccessful > 0) {
            return memberOriginal;
        }
        return null;
    }

    @Override
    public Member updatedStatusAPP041(Integer memberId) {
        logger.info("MemberDAO : updatedStatusAPP041");
        int iCountSuccessful = 0;
        List<Member> list;
        Member memberOriginal = null;

        logger.info("memberId : >>" + memberId + "<<");

        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;

        Query query;
        whereField = new WhereField();
        whereField.setSearchField("memberId");
        whereField.setSearchLogic("");
        whereField.setSearchOper(CommandConstant.QueryEqual);
        whereField.setSearchValue(memberId);
        whereField.setSearchDataType(CommandConstant.DataTypeInteger);
        listWhereField.add(whereField);
        query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);

        if (!query.list().isEmpty()) {
            list = query.list();
            logger.info("list size : " + list.size());
            memberOriginal = list.get(0);
            logger.info("1 memberOriginal status : " + memberOriginal.getMemberStatusCode());
            memberOriginal.setMemberStatusCode(25);
            logger.info("2 memberOriginal status : " + memberOriginal.getMemberStatusCode());
            if (CommandQuery.Update(sessionFactory, memberOriginal)) {
                iCountSuccessful++;
                logger.info("update success");
            }
        }
        if (iCountSuccessful > 0) {
            return memberOriginal;
        }
        return null;
    }

    @Override
    public Member updatedStatusAPP031(Integer memberId) {
        logger.info("MemberDAO : updatedStatusAPP031");
        int iCountSuccessful = 0;
        List<Member> list;
        Member memberOriginal = null;

        logger.info("memberId : >>" + memberId + "<<");

        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;

        Query query;
        whereField = new WhereField();
        whereField.setSearchField("memberId");
        whereField.setSearchLogic("");
        whereField.setSearchOper(CommandConstant.QueryEqual);
        whereField.setSearchValue(memberId);
        whereField.setSearchDataType(CommandConstant.DataTypeInteger);
        listWhereField.add(whereField);
        query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);

        if (!query.list().isEmpty()) {
            list = query.list();
            logger.info("list size : " + list.size());
            memberOriginal = list.get(0);
            logger.info("1 memberOriginal status : " + memberOriginal.getMemberStatusCode());
            memberOriginal.setMemberStatusCode(13);
            logger.info("2 memberOriginal status : " + memberOriginal.getMemberStatusCode());
            if (CommandQuery.Update(sessionFactory, memberOriginal)) {
                iCountSuccessful++;
                logger.info("update success");
            }
        }
        if (iCountSuccessful > 0) {
            return memberOriginal;
        }
        return null;
    }

    @Override
    public JqGridResponse<Member> getList(JqGridRequest req, int memberStatusCode) {
        List<Member> listResponse = new ArrayList<>();
        JqGridResponse<Member> jqGrid = new JqGridResponse<>();
        Member memberObject;
        List<Member> list;
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
        if (!query.list().isEmpty()) {
            list = query.list();

            /*
             * Start developer create object to array new.
             */
            for (Member memberObjectList : list) {
                memberObject = new Member();
                memberObject.setAccTypeId(memberObjectList.getAccTypeId());
                memberObject.setAccTypeName(memberObjectList.getAccTypeName());
                memberObject.setAddress(memberObjectList.getAddress());
                memberObject.setAddressPrimary(memberObjectList.getAddressPrimary());
                memberObject.setApplyDate(memberObjectList.getApplyDate());
                memberObject.setBankAccName(memberObjectList.getBankAccName());
                memberObject.setBankAccNo(memberObjectList.getBankAccNo());
                memberObject.setBankBranchId(memberObjectList.getBankBranchId());
                memberObject.setBankCode(memberObjectList.getBankCode());
                memberObject.setBirthDate(memberObjectList.getBirthDate());
                memberObject.setCitizenId(memberObjectList.getCitizenId());
                memberObject.setCreateBy(memberObjectList.getCreateBy());
                memberObject.setCreateDate(memberObjectList.getCreateDate());
                memberObject.setDistrict(memberObjectList.getDistrict());
                memberObject.setFax(memberObjectList.getFax());
                memberObject.setGender(memberObjectList.getGender());
                memberObject.setMarryStatusCode(memberObjectList.getMarryStatusCode());
                memberObject.setMemberCode(memberObjectList.getMemberCode());
                memberObject.setMemberGroupCode(memberObjectList.getMemberGroupCode());
                memberObject.setMemberId(memberObjectList.getMemberId());
                memberObject.setMemberStatusCode(memberObjectList.getMemberStatusCode());
                memberObject.setMemberTypeCode(memberObjectList.getMemberTypeCode());
                memberObject.setMilitaryId(memberObjectList.getMilitaryId());
                memberObject.setMilitaryName(memberObjectList.getMilitaryName());
                memberObject.setMobile(memberObjectList.getMobile());
                memberObject.setMoo(memberObjectList.getMoo());
                memberObject.setName(memberObjectList.getName());
                memberObject.setPaymentRemark(memberObjectList.getPaymentRemark());
                memberObject.setPaymentType(memberObjectList.getPaymentType());
                memberObject.setPaymentTypeCode(memberObjectList.getPaymentTypeCode());
                memberObject.setPermanentAddress(memberObjectList.getPermanentAddress());
                memberObject.setPermanentDistrict(memberObjectList.getPermanentDistrict());
                memberObject.setPermanentFax(memberObjectList.getPermanentFax());
                memberObject.setPermanentMobile(memberObjectList.getPermanentMobile());
                memberObject.setPermanentProvinceCode(memberObjectList.getPermanentProvinceCode());
                memberObject.setPermanentProvinceName(memberObjectList.getPermanentProvinceName());
                memberObject.setPermanentRoad(memberObjectList.getPermanentRoad());
                memberObject.setPermanentSoi(memberObjectList.getPermanentSoi());
                memberObject.setPermanentSubdistrict(memberObjectList.getPermanentSubdistrict());
                memberObject.setPermanentTel(memberObjectList.getPermanentTel());
                memberObject.setPermanentZipcode(memberObjectList.getPermanentZipcode());
                memberObject.setProvinceCode(memberObjectList.getProvinceCode());
                memberObject.setProvinceName(memberObjectList.getProvinceName());
                memberObject.setTitleId(memberObjectList.getTitleId());
                memberObject.setRankId(memberObjectList.getRankId());
                memberObject.setRankOrTitleName(null != memberObjectList.getRankId() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
                memberObject.setReferrerId(memberObjectList.getReferrerId());
                memberObject.setReferrerRelationshipCode(memberObjectList.getReferrerRelationshipCode());
                memberObject.setRemark(memberObjectList.getRemark());
                memberObject.setRoad(memberObjectList.getRoad());
                memberObject.setSoi(memberObjectList.getSoi());
                memberObject.setSubdistrict(memberObjectList.getSubdistrict());
                memberObject.setSurname(memberObjectList.getSurname());
                memberObject.setTel(memberObjectList.getTel());
                memberObject.setUpdateBy(memberObjectList.getUpdateBy());
                memberObject.setUpdateDate(memberObjectList.getUpdateDate());
                memberObject.setWifehusbandFullname(memberObjectList.getWifehusbandFullname());
                memberObject.setZipcode(memberObjectList.getZipcode());
                memberObject.setPermanentMoo(memberObjectList.getPermanentMoo());

                listResponse.add(memberObject);
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
    public JqGridResponse<Member> getList(JqGridRequest req, int memberStatusCode, int operationId) {
        List<Member> listResponse = new ArrayList<>();
        JqGridResponse<Member> jqGrid = new JqGridResponse<>();
        Member memberObject;
        List<Member> list;
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
        if (0 != operationId){
            whereField = new WhereField();
            whereField.setSearchField("operationIdBy20");
            whereField.setSearchLogic(CommandConstant.QueryAND);
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(operationId);
            whereField.setSearchDataType(CommandConstant.DataTypeInteger);
            listWhereField.add(whereField);
        }
        Paging paging = CommandQuery.CountRows(sessionFactory, listWhereField, CommandConstant.QueryAND, req, objectTable);
        Query query = CommandQuery.CreateQuery(sessionFactory, listWhereField, CommandConstant.QueryAND, req, objectTable, paging);
        /*
         * Check array data if true set create object to array new.
         */
        if (!query.list().isEmpty()) {
            list = query.list();

            /*
             * Start developer create object to array new.
             */
            for (Member memberObjectList : list) {
                memberObject = new Member();
                memberObject.setAccTypeId(memberObjectList.getAccTypeId());
                memberObject.setAccTypeName(memberObjectList.getAccTypeName());
                memberObject.setAddress(memberObjectList.getAddress());
                memberObject.setAddressPrimary(memberObjectList.getAddressPrimary());
                memberObject.setApplyDate(memberObjectList.getApplyDate());
                memberObject.setBankAccName(memberObjectList.getBankAccName());
                memberObject.setBankAccNo(memberObjectList.getBankAccNo());
                memberObject.setBankBranchId(memberObjectList.getBankBranchId());
                memberObject.setBankCode(memberObjectList.getBankCode());
                memberObject.setBirthDate(memberObjectList.getBirthDate());
                memberObject.setCitizenId(memberObjectList.getCitizenId());
                memberObject.setCreateBy(memberObjectList.getCreateBy());
                memberObject.setCreateDate(memberObjectList.getCreateDate());
                memberObject.setDistrict(memberObjectList.getDistrict());
                memberObject.setFax(memberObjectList.getFax());
                memberObject.setGender(memberObjectList.getGender());
                memberObject.setMarryStatusCode(memberObjectList.getMarryStatusCode());
                memberObject.setMemberCode(memberObjectList.getMemberCode());
                memberObject.setMemberGroupCode(memberObjectList.getMemberGroupCode());
                memberObject.setMemberId(memberObjectList.getMemberId());
                memberObject.setMemberStatusCode(memberObjectList.getMemberStatusCode());
                memberObject.setMemberTypeCode(memberObjectList.getMemberTypeCode());
                memberObject.setMilitaryId(memberObjectList.getMilitaryId());
                memberObject.setMilitaryName(memberObjectList.getMilitaryName());
                memberObject.setMobile(memberObjectList.getMobile());
                memberObject.setMoo(memberObjectList.getMoo());
                memberObject.setName(memberObjectList.getName());
                memberObject.setPaymentRemark(memberObjectList.getPaymentRemark());
                memberObject.setPaymentType(memberObjectList.getPaymentType());
                memberObject.setPaymentTypeCode(memberObjectList.getPaymentTypeCode());
                memberObject.setPermanentAddress(memberObjectList.getPermanentAddress());
                memberObject.setPermanentDistrict(memberObjectList.getPermanentDistrict());
                memberObject.setPermanentFax(memberObjectList.getPermanentFax());
                memberObject.setPermanentMobile(memberObjectList.getPermanentMobile());
                memberObject.setPermanentProvinceCode(memberObjectList.getPermanentProvinceCode());
                memberObject.setPermanentProvinceName(memberObjectList.getPermanentProvinceName());
                memberObject.setPermanentRoad(memberObjectList.getPermanentRoad());
                memberObject.setPermanentSoi(memberObjectList.getPermanentSoi());
                memberObject.setPermanentSubdistrict(memberObjectList.getPermanentSubdistrict());
                memberObject.setPermanentTel(memberObjectList.getPermanentTel());
                memberObject.setPermanentZipcode(memberObjectList.getPermanentZipcode());
                memberObject.setProvinceCode(memberObjectList.getProvinceCode());
                memberObject.setProvinceName(memberObjectList.getProvinceName());
                memberObject.setTitleId(memberObjectList.getTitleId());
                memberObject.setRankId(memberObjectList.getRankId());
                memberObject.setRankOrTitleName(null != memberObjectList.getRankId() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
                memberObject.setReferrerId(memberObjectList.getReferrerId());
                memberObject.setReferrerRelationshipCode(memberObjectList.getReferrerRelationshipCode());
                memberObject.setRemark(memberObjectList.getRemark());
                memberObject.setRoad(memberObjectList.getRoad());
                memberObject.setSoi(memberObjectList.getSoi());
                memberObject.setSubdistrict(memberObjectList.getSubdistrict());
                memberObject.setSurname(memberObjectList.getSurname());
                memberObject.setTel(memberObjectList.getTel());
                memberObject.setUpdateBy(memberObjectList.getUpdateBy());
                memberObject.setUpdateDate(memberObjectList.getUpdateDate());
                memberObject.setWifehusbandFullname(memberObjectList.getWifehusbandFullname());
                memberObject.setZipcode(memberObjectList.getZipcode());
                memberObject.setPermanentMoo(memberObjectList.getPermanentMoo());

                listResponse.add(memberObject);
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
}
