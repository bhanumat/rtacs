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
import com.itos.model.Rank;
import com.itos.model.Title;
import com.itos.model.ext.ChangeMemberData;
import com.itos.model.ext.MemberData;
import com.itos.model.ext.MemberTotalDetail;
import com.itos.model.ext.PaymentDetail;
import com.itos.model.ext.PaymentMilitary;
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
import com.itos.util.jsonObject.CHT010Request;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.math.BigDecimal;
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
import org.hibernate.SQLQuery;
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
    private static final SimpleDateFormat fullDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

    private static final String SQLString = "Select *, r.rank_id as rankId, r.rank_name as rankName, t.title_id as titleId, t.title as titleName, mi.name as militaryName"
            + ", pp.province_code as permanentProvinceCode, pp.province_name as permanentProvinceName, p.province_code as provinceCode, p.province_name as provinceName"
            + ", b.bank_code as bankCode, bb.branch_id as bankBranchId, bb.branch_code as branchCode, ba.acc_type_id as accTypeId";
    private static final String SQLStringTable = " from Member m ";
    private static final String SQLStringTableOperation = " from Member m ";
    private static final String SQLStringJoinOperation = " inner join OperationMember om on m.member_id=om.member_id inner join Operation o on o.operation_id = om.operation_id ";
    private static final String SQLStringJoin = "left join Title t on t.title_id = m.title_id left join Rank r on r.rank_id = m.rank_id left join MilitaryDepartment mi on mi.military_id = m.military_id "
            + "left join Province pp on pp.province_code = m.permanent_province_code left join Province p on p.province_code = m.province_code "
            + "left join Bank b on b.bank_code = m.bank_code left join BankBranch bb on bb.branch_id = m.bank_branch_id left join BankAccountType ba on ba.acc_type_id = m.acc_type_id ";
    private static final String SQLStringPaymentMilitaryHead = " select m.military_id, m.apply_date, md.mildept_id, md.name as mildept_name, count(m.member_id) as num_member, "
            + "(count(m.member_id)*(select top 1 apply_fee from ControlMember order by control_member_id desc)) as sum_amount "
            + "from Member m "
            + "left outer join rtacs.dbo.MilitaryDepartment md on m.military_id = md.military_id ";
    private static final String SQLStringPaymentMilitaryGroup = "group by m.military_id, m.apply_date, md.mildept_id, md.name ";
    private static final String SQLStringPaymentMilitaryOrder = "order by md.name ";
    private static final String SQLStringPaymentMilitaryWhere = "where m.member_type_code <> 10 and m.member_status_code = 10 ";

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    IMemberBeneficiaryDAO iMemberBeneficiaryDAO;

    private final String objectTable = "Member";
    private final String operationMemberTable = "OperationMember";

    @Override
    public JqGridResponse<MemberData> getList(JqGridRequest req) {
        StringBuilder hql = new StringBuilder();
        List<MemberData> listResponse = new ArrayList<>();
        JqGridResponse<MemberData> jqGrid = new JqGridResponse<>();
        MemberData memberObject;
        List<MemberData> list;
        String where = "";
        boolean control = true;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Bank");
        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;

        hql.append(SQLStringTable);
        hql.append(SQLStringJoin);

        where = CommandQuery.WhereQuery(req, control, "");
        if (!where.isEmpty()) {
            if (!control) {
                hql.append(" and ");
            }
            hql.append(where);
        }

        StringBuilder hqlCount = new StringBuilder();
        StringBuilder hqlQuery = new StringBuilder();
        hqlCount.append(CommandConstant.CountRows);
        hqlCount.append(hql.toString());
        hqlQuery.append(SQLString);
        hql.append(" ");
        hql.append(CommandConstant.OrderBy);
        hql.append(" ");
        hql.append(req.getSidx());
        hql.append(" ");
        hql.append(req.getSord());
        hqlQuery.append(hql.toString());

        Paging paging = CommandQuery.CountRows(sessionFactory, listWhereField, CommandConstant.QueryAND, req, hqlCount);
        SQLQuery query = CommandQuery.CreateQuery(sessionFactory, listWhereField, CommandConstant.QueryAND, req, paging, hqlQuery);
        query.addEntity(MemberData.class);
        /*
         * Check array data if true set create object to array new.
         */
        list = query.list();
        if (!list.isEmpty()) {

            /*
             * Start developer create object to array new.
             */
            for (MemberData memberObjectList : list) {
                memberObject = new MemberData();
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
                memberObject.setTitleName(memberObjectList.getTitleName());
                memberObject.setRankId(memberObjectList.getRankId());
                memberObject.setRankName(memberObjectList.getRankName());
                memberObject.setRankOrTitleName(null != memberObjectList.getRankName() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
                String rankAndTitleName = "";
                if (null != memberObjectList.getRankName()) {
                    rankAndTitleName = rankAndTitleName + memberObjectList.getRankName();
                }
                if (null != memberObjectList.getTitle() && null != memberObjectList.getTitle().getTitleDesc()) {
                    rankAndTitleName = rankAndTitleName + memberObjectList.getTitle().getTitleDesc();
                }
                memberObject.setRankAndTitleName(rankAndTitleName);
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
    public JqGridResponse<MemberData> getListForRegister(JqGridRequest req) {
        List<MemberData> listResponse = new ArrayList<>();
        JqGridResponse<MemberData> jqGrid = new JqGridResponse<>();
        MemberData memberObject;
        List<MemberData> list;
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
            list = query.list();
            if (!list.isEmpty()) {

                /*
                 * Start developer create object to array new.
                 */
                for (MemberData memberObjectList : list) {
                    memberObject = new MemberData();
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
                    memberObject.setRankOrTitleName(null != memberObjectList.getRankName() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
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
            memberOriginal = (Member) CommandQuery.LoadDetail(sessionFactory, MemberData.class, Integer.parseInt(id));

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
        //memberOriginal.setMilitaryId(member.getMilitaryId());
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
    public MemberData getLoadMember(Member member) {
        MemberData memberResponse = getLoadDetailByObject(member);
        return memberResponse;
    }

    private MemberData getLoadDetailByObject(Member member) {
        logger.info("MemberDAO : getLoadDetailByObject");
        MemberData memberResponse = new MemberData();
        List<WhereField> listWhereField = new ArrayList<>();
        List<MemberData> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            if (0 != member.getMemberId()) {
                whereField.setSearchField("memberId");
                whereField.setSearchLogic("");
                whereField.setSearchOper(CommandConstant.QueryEqual);
                whereField.setSearchValue(member.getMemberId());
                whereField.setSearchDataType(CommandConstant.DataTypeInteger);
                listWhereField.add(whereField);
            } else if (null != member.getCitizenId() && !member.getCitizenId().isEmpty()) {
                whereField.setSearchField("citizenId");
                whereField.setSearchLogic("");
                whereField.setSearchOper(CommandConstant.QueryEqual);
                whereField.setSearchValue(member.getCitizenId());
                whereField.setSearchDataType(CommandConstant.DataTypeVarchar);
                listWhereField.add(whereField);
            } else {
                whereField.setSearchField("memberCode");
                whereField.setSearchLogic("");
                whereField.setSearchOper(CommandConstant.QueryEqual);
                whereField.setSearchValue(member.getMemberCode());
                whereField.setSearchDataType(CommandConstant.DataTypeVarchar);
                listWhereField.add(whereField);
            }

            boolean control = true;
            /*
             * Command HQL query Data.
             */
            StringBuilder hql = new StringBuilder();
//        hql.append("From Bank");

//            hql.append(" from Member m ");
//            hql.append("left join Title t on t.title_id = m.title_id ");
//            hql.append("left join Rank r on r.rank_id = m.rank_id ");
//            hql.append("left join MilitaryDepartment mi on mi.military_id = m.military_id ");
            hql.append(SQLStringTable);
            hql.append(SQLStringJoin);
            hql.append(" where ");
            if (0 != member.getMemberId()) {
                hql.append("m.member_id = :memberId");
            } else if (null != member.getCitizenId() && !member.getCitizenId().isEmpty()) {
                hql.append("m.citizen_id like :citizenId");
            } else {
                hql.append("m.member_code like :memberCode");
            }

            StringBuilder hqlQuery = new StringBuilder();
            hqlQuery.append(SQLString);
            hqlQuery.append(hql.toString());

            SQLQuery query = CommandQuery.CreateQuery(sessionFactory, listWhereField, 0, 1, hqlQuery);
            logger.info(hqlQuery);
            query.addEntity(MemberData.class);
            /*
             * Check array data if true set create object to array new.
             */
            list = query.list();
            if (!list.isEmpty()) {

                /*
                 * Start developer create object to array new.
                 */
                for (MemberData memberObjectList : list) {
                    memberResponse = new MemberData();
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
                    if (null != memberObjectList.getMilitaryDepartment()) {
                        memberResponse.setMilitaryId(memberObjectList.getMilitaryDepartment().getMilitaryId());
                    }
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
                    memberResponse.setTitleName(memberObjectList.getTitleName());
                    memberResponse.setRankId(memberObjectList.getRankId());
                    memberResponse.setRankName(memberObjectList.getRankName());
                    memberResponse.setRankOrTitleName(null != memberObjectList.getRankName() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
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
            } else {
                memberResponse = null;
            }
            return memberResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
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
        whereField.setSearchField("citizenId");
        whereField.setSearchLogic("");
        whereField.setSearchOper(CommandConstant.QueryEqual);
        whereField.setSearchValue(citizenId);
        whereField.setSearchDataType(CommandConstant.DataTypeVarchar);
        listWhereField.add(whereField);
        query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);

        list = query.list();
        if (!list.isEmpty()) {

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

        list = query.list();
        if (!list.isEmpty()) {
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
    public Member updatedStatusPAY021_1(String memberId) {
        logger.info("MemberDAO : updatedStatusPAY021_1");
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
        whereField.setSearchValue(Integer.parseInt(memberId));
        whereField.setSearchDataType(CommandConstant.DataTypeInteger);
        listWhereField.add(whereField);
        query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);

        list = query.list();
        if (!list.isEmpty()) {
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

        list = query.list();
        if (!list.isEmpty()) {
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

        list = query.list();
        if (!list.isEmpty()) {
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
    public JqGridResponse<MemberData> getList(JqGridRequest req, int operationTypeCode) {
        StringBuilder hql = new StringBuilder();
        List<MemberData> listResponse = new ArrayList<>();
        JqGridResponse<MemberData> jqGrid = new JqGridResponse<>();
        MemberData memberObject;
        List<MemberData> list;
        String where = "";
        boolean control = true;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Bank");
        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;
        if (0 != operationTypeCode) {
            whereField = new WhereField();
            whereField.setSearchField("operationTypeCode");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(operationTypeCode);
            whereField.setSearchDataType(CommandConstant.DataTypeInteger);
            listWhereField.add(whereField);
        }

//        hql.append(" from Member m ");
//        hql.append("left join Title t on t.title_id = m.title_id ");
//        hql.append("left join Rank r on r.rank_id = m.rank_id ");
//        hql.append("left join MilitaryDepartment mi on mi.military_id = m.military_id ");
        hql.append(SQLStringTableOperation);
        hql.append(SQLStringJoinOperation);
        hql.append(SQLStringJoin);
        //แก้ไขกำหนดเลขทะเบียนสมาชิก
        if (0 != operationTypeCode) {
            hql.append(" where ");
        }
        if (0 != operationTypeCode) {
            hql.append("o.operation_type_code=:operationTypeCode");
            hql.append(" and m.member_status_code = 13 ");
            control = false;
        }
        /* นำออกกำหนดเลขทะเบียนสมาชิก
         if (0 != operationTypeCode) {
         hql.append(" where ");
         }
         if (0 != operationTypeCode) {
         hql.append("o.operation_type_code=:operationTypeCode");
         control = false;
         }
         */
        where = CommandQuery.WhereQuery(req, control, "");
        if (!where.isEmpty()) {
            if (!control) {
                hql.append(" and ");
            }
            hql.append(where);
        }

        StringBuilder hqlCount = new StringBuilder();
        StringBuilder hqlQuery = new StringBuilder();
        hqlCount.append(CommandConstant.CountRows);
        hqlCount.append(hql.toString());
        hqlQuery.append(SQLString);
        hql.append(" ");
        hql.append(CommandConstant.OrderBy);
        hql.append(" ");
        hql.append(req.getSidx());
        hql.append(" ");
        hql.append(req.getSord());
        hqlQuery.append(hql.toString());

        Paging paging = CommandQuery.CountRows(sessionFactory, listWhereField, CommandConstant.QueryAND, req, hqlCount);
        SQLQuery query = CommandQuery.CreateQuery(sessionFactory, listWhereField, CommandConstant.QueryAND, req, paging, hqlQuery);
        query
                .addEntity(MemberData.class
                );
        /*
         * Check array data if true set create object to array new.
         */
        list = query.list();

        if (!list.isEmpty()) {

            /*
             * Start developer create object to array new.
             */
            for (MemberData memberObjectList : list) {
                memberObject = new MemberData();
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
                memberObject.setTitleName(memberObjectList.getTitleName());
                memberObject.setRankId(memberObjectList.getRankId());
                memberObject.setRankName(memberObjectList.getRankName());
                memberObject.setRankOrTitleName(null != memberObjectList.getRankName() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
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
    public JqGridResponse<MemberData> getListMemberStatus(JqGridRequest req, int memberStatusCode) {
        StringBuilder hql = new StringBuilder();
        List<MemberData> listResponse = new ArrayList<>();
        JqGridResponse<MemberData> jqGrid = new JqGridResponse<>();
        MemberData memberObject;
        List<MemberData> list;
        String where = "";
        boolean control = true;
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

//        hql.append(" from Member m ");
//        hql.append("left join Title t on t.title_id = m.title_id ");
//        hql.append("left join Rank r on r.rank_id = m.rank_id ");
//        hql.append("left join MilitaryDepartment mi on mi.military_id = m.military_id ");
        hql.append(SQLStringTable);
        hql.append(SQLStringJoin);

        if (0 != memberStatusCode) {
            hql.append(" where ");
        }
        if (0 != memberStatusCode) {
            hql.append("m.member_status_code=:memberStatusCode");
            control = false;
        }

        where = CommandQuery.WhereQuery(req, control, "");
        if (!where.isEmpty()) {
            if (!control) {
                hql.append(" and ");
            }
            hql.append(where);
        }

        StringBuilder hqlCount = new StringBuilder();
        StringBuilder hqlQuery = new StringBuilder();
        hqlCount.append(CommandConstant.CountRows);
        hqlCount.append(hql.toString());
        hqlQuery.append(SQLString);
        hql.append(" ");
        hql.append(CommandConstant.OrderBy);
        hql.append(" ");
        hql.append(req.getSidx());
        hql.append(" ");
        hql.append(req.getSord());
        hqlQuery.append(hql.toString());

        Paging paging = CommandQuery.CountRows(sessionFactory, listWhereField, CommandConstant.QueryAND, req, hqlCount);
        SQLQuery query = CommandQuery.CreateQuery(sessionFactory, listWhereField, CommandConstant.QueryAND, req, paging, hqlQuery);
        query
                .addEntity(MemberData.class
                );
        /*
         * Check array data if true set create object to array new.
         */

        list = query.list();

        if (!list.isEmpty()) {

            /*
             * Start developer create object to array new.
             */
            for (MemberData memberObjectList : list) {
                memberObject = new MemberData();
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
                memberObject.setRankOrTitleName(null != memberObjectList.getRankName() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
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
    public JqGridResponse<MemberData> getList(JqGridRequest req, int operationTypeCode, int operationId) {
        StringBuilder hql = new StringBuilder();
        List<MemberData> listResponse = new ArrayList<>();
        JqGridResponse<MemberData> jqGrid = new JqGridResponse<>();
        MemberData memberObject;
        List<MemberData> list;
        String where = "";
        boolean control = true;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Bank");
        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;
        if (0 != operationTypeCode) {
            whereField = new WhereField();
            whereField.setSearchField("operationTypeCode");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(operationTypeCode);
            whereField.setSearchDataType(CommandConstant.DataTypeInteger);
            listWhereField.add(whereField);
        }
        if (0 != operationId) {
            whereField = new WhereField();
            whereField.setSearchField("operationId");
            whereField.setSearchLogic(CommandConstant.QueryAND);
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(operationId);
            whereField.setSearchDataType(CommandConstant.DataTypeInteger);
            listWhereField.add(whereField);
        }

        hql.append(SQLStringTableOperation);
        hql.append(SQLStringJoinOperation);
        hql.append(SQLStringJoin);
        if (0 != operationTypeCode || 0 != operationId) {
            hql.append(" where ");
        }
        if (0 != operationTypeCode) {
            hql.append("o.operation_type_code=:operationTypeCode");
            control = false;
        }
        if (0 != operationTypeCode && 0 != operationId) {
            hql.append(" and ");
        }
        if (0 != operationId) {
            hql.append("o.operation_id=:operationId ");
            control = false;
        }

        where = CommandQuery.WhereQuery(req, control, "");
        if (!where.isEmpty()) {
            if (!control) {
                hql.append(" and ");
            }
            hql.append(where);
        }

        StringBuilder hqlCount = new StringBuilder();
        StringBuilder hqlQuery = new StringBuilder();
        hqlCount.append(CommandConstant.CountRows);
        hqlCount.append(hql.toString());
        hqlQuery.append(SQLString);
        hql.append(" ");
        hql.append(CommandConstant.OrderBy);
        hql.append(" ");
        hql.append(req.getSidx());
        hql.append(" ");
        hql.append(req.getSord());
        hqlQuery.append(hql.toString());

        Paging paging = CommandQuery.CountRows(sessionFactory, listWhereField, CommandConstant.QueryAND, req, hqlCount);
        SQLQuery query = CommandQuery.CreateQuery(sessionFactory, listWhereField, CommandConstant.QueryAND, req, paging, hqlQuery);
        query.addEntity(MemberData.class);
        /*
         * Check array data if true set create object to array new.
         */
        list = query.list();

        if (!list.isEmpty()) {

            /*
             * Start developer create object to array new.
             */
            for (MemberData memberObjectList : list) {
                memberObject = new MemberData();
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
                memberObject.setTitleName(memberObjectList.getTitleName());
                memberObject.setRankId(memberObjectList.getRankId());
                memberObject.setRankName(memberObjectList.getRankName());
                memberObject.setRankOrTitleName(null != memberObjectList.getRankName() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
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

    private String formatDateFullDate(String date) {

        if (date.isEmpty()) {
            Date currentDate = DateUtil.getCurrentDate();
            String result = format.format(currentDate);
            return result;
        }
        try {
            Date tempDate = fullDate.parse(date);
            String result = format.format(tempDate);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public JqGridResponse<PaymentMilitary> getPaymentMilitaryList(JqGridRequest req) {
        StringBuilder hql = new StringBuilder();
        List<PaymentMilitary> listResponse = new ArrayList<>();
        JqGridResponse<PaymentMilitary> jqGrid = new JqGridResponse<>();
        PaymentMilitary paymentMilitary;
        List<WhereField> listWhereField = new ArrayList<>();
        hql.append(SQLStringPaymentMilitaryHead);
        hql.append(SQLStringPaymentMilitaryWhere);

        /**/
        if (req.isSearch()) {
            Search search = Search.JSONDeserializer(req.getSearchCommand());
            for (Condition condition : search.getConditions()) {
                if (condition.getField().equalsIgnoreCase("militaryId")) {
                    hql.append(" and ");
                    hql.append(" m.military_id = :militaryId ");
                }
                if (condition.getField().equalsIgnoreCase("docDate")) {
                    hql.append(" and ");
                    hql.append(" m.apply_date");
                    hql.append(" between ");
                    hql.append(":beginDate and :endDate ");
                }
            }
        }
        /**/

        hql.append(SQLStringPaymentMilitaryGroup);

        StringBuilder hqlCount = new StringBuilder();
        StringBuilder hqlQuery = new StringBuilder();

        hqlCount.append(CommandConstant.CountRows);
        hqlCount.append(" from ( ");
        hqlCount.append(hql.toString());
        hqlCount.append(" ) as temp ");

        hql.append(SQLStringPaymentMilitaryOrder);
        hqlQuery.append(hql.toString());

        Paging paging = CommandQuery.CountRows(sessionFactory, listWhereField, CommandConstant.QueryAND, req, hqlCount);
        SQLQuery query = CommandQuery.CreateQuery(sessionFactory, listWhereField, CommandConstant.QueryAND, req, paging, hqlQuery);
        //query.addEntity(MemberData.class);
        /*
         * Check array data if true set create object to array new.
         */
        List<?> list;
        list = query.list();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Object[] result = (Object[]) list.get(i);
                paymentMilitary = new PaymentMilitary();
                paymentMilitary.setMilitaryId((result[0] != null) ? Integer.parseInt(result[0].toString()) : -1);
                String date = (result[1] != null) ? result[1].toString() : "";
                if (date.isEmpty()) {
                    paymentMilitary.setDocDate(null);
                } else {
                    try {
                        paymentMilitary.setDocDate(fullDate.parse(date));
                    } catch (ParseException ex) {
                        paymentMilitary.setDocDate(null);
                    }
                }
                paymentMilitary.setMilitaryCode((result[2] != null) ? result[2].toString() : "");
                paymentMilitary.setMilitaryName((result[3] != null) ? result[3].toString() : "");
                paymentMilitary.setSumMember((result[4] != null) ? Integer.parseInt(result[4].toString()) : 0);
                paymentMilitary.setSumAmount(new BigDecimal((result[5] != null) ? result[5].toString() : "0"));
                listResponse.add(paymentMilitary);
            }

            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(listResponse);
        }
        return jqGrid;
    }

    @Override
    public JqGridResponse<ChangeMemberData> getChangeMemberList(JqGridRequest req) {
        StringBuilder hql = new StringBuilder();
        List<ChangeMemberData> listResponse = new ArrayList<>();
        JqGridResponse<ChangeMemberData> jqGrid = new JqGridResponse<>();
        ChangeMemberData changeMemberData;
        List<WhereField> listWhereField = new ArrayList<>();

        hql.append(" select ");
        hql.append(" m.member_id, ");//0
        hql.append(" a.created_date, ");//1
        hql.append(" md.name as mildept_name, ");//2
        hql.append(" m.member_code, ");//3
        hql.append(" isnull(r.rank_name,'') + isnull(t.title_desc,'') as title_rank, ");//4
        hql.append(" m.name, ");//5
        hql.append(" m.surname, ");//6
        hql.append(" isnull(rn.rank_name,'') + isnull(tn.title_desc,'') as title_rank_new, ");//7
        hql.append(" a.name as name_new, ");//8
        hql.append(" a.surname as surname_new, ");//9
        hql.append(" a.file_type_code, ");//10
        hql.append(" m.member_status_code, ");//11
        hql.append(" a.remark, ");//12
        hql.append(" a.approved, ");//13
        hql.append(" a.titleame_history_id, ");//14
        hql.append(" a.title_id, ");//15
        hql.append(" a.rank_id ");//16
        hql.append(" from ");
        hql.append(" rtacs.dbo.Member m ");
        hql.append(" join rtacs.dbo.MemberTitleNameHistory a on m.member_id = a.member_id ");
        hql.append(" left outer join rtacs.dbo.MilitaryDepartment md on md.military_id=m.military_id ");
        hql.append(" left outer join rtacs.dbo.Title t on m.title_id = t.title_id ");
        hql.append(" left outer join rtacs.dbo.Rank r on m.rank_id = r.rank_id ");
        hql.append(" left outer join rtacs.dbo.Title tn on a.title_id = tn.title_id ");
        hql.append(" left outer join rtacs.dbo.Rank rn on a.rank_id = rn.rank_id ");
        hql.append(" where ");
        hql.append(" a.file_type_code is not null and a.file_type_code <> 0 ");
        //hql.append(" and "); 
        //hql.append(" a.approved = 0 ");
        /**/
        if (req.isSearch()) {
            Search search = Search.JSONDeserializer(req.getSearchCommand());
            for (Condition condition : search.getConditions()) {
                if (condition.getField().equalsIgnoreCase("citizenId")) {
                    hql.append(" and ");
                    hql.append(" m.citizen_id = :citizenId ");
                }
                if (condition.getField().equalsIgnoreCase("memberCode")) {
                    hql.append(" and ");
                    hql.append(" m.member_code = :memberCode ");
                }
                if (condition.getField().equalsIgnoreCase("name")) {
                    hql.append(" and ");
                    hql.append(" m.name = :name ");
                }
                if (condition.getField().equalsIgnoreCase("surname")) {
                    hql.append(" and ");
                    hql.append(" m.surname = :surname ");
                }
                if (condition.getField().equalsIgnoreCase("militaryId")) {
                    hql.append(" and ");
                    hql.append(" m.military_id = :militaryId ");
                }
                if (condition.getField().equalsIgnoreCase("memberTypeCode")) {
                    hql.append(" and ");
                    hql.append(" m.member_type_code = :memberTypeCode ");
                }
                if (condition.getField().equalsIgnoreCase("fileTypeCode")) {
                    hql.append(" and ");
                    hql.append(" a.file_type_code = :fileTypeCode ");
                }
                if (condition.getField().equalsIgnoreCase("approved")) {
                    hql.append(" and ");
                    hql.append(" a.approved = :approved ");
                }

                if (condition.getField().equalsIgnoreCase("docDate")) {
                    hql.append(" and ");
                    hql.append(" a.created_date");
                    hql.append(" between ");
                    hql.append(":beginDate and :endDate ");
                }
            }
        }
        /**/

        StringBuilder hqlCount = new StringBuilder();
        StringBuilder hqlQuery = new StringBuilder();

        hqlCount.append(CommandConstant.CountRows);
        hqlCount.append(" from ( ");
        hqlCount.append(hql.toString());
        hqlCount.append(" ) as temp ");

        hql.append(" ");
        hql.append(CommandConstant.OrderBy);
        hql.append(" ");
        hql.append(req.getSidx());
        hql.append(" ");
        hql.append(req.getSord());

        hqlQuery.append(hql.toString());

        Paging paging = CommandQuery.CountRows(sessionFactory, listWhereField, CommandConstant.QueryAND, req, hqlCount);
        SQLQuery query = CommandQuery.CreateQuery(sessionFactory, listWhereField, CommandConstant.QueryAND, req, paging, hqlQuery);
        //query.addEntity(MemberData.class);
        /*
         * Check array data if true set create object to array new.
         */
        List<?> list;
        list = query.list();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Object[] result = (Object[]) list.get(i);
                changeMemberData = new ChangeMemberData();

                changeMemberData.setMemberId((result[0] != null) ? Integer.parseInt(result[0].toString()) : -1);
                String date = (result[1] != null) ? result[1].toString() : "";
                if (date.isEmpty()) {
                    changeMemberData.setCreatedDate(null);
                } else {
                    try {
                        changeMemberData.setCreatedDate(fullDate.parse(date));
                    } catch (ParseException ex) {
                        changeMemberData.setCreatedDate(null);
                    }
                }
                changeMemberData.setMilitaryName((result[2] != null) ? result[2].toString() : "");
                changeMemberData.setMemberCode((result[3] != null) ? result[3].toString() : "");
                String titleOld = (result[4] != null) ? result[4].toString() : "";
                String oldName = (result[5] != null) ? result[5].toString() : "";
                String oldSurname = (result[6] != null) ? result[6].toString() : "";
                String oldFullName = titleOld + " " + oldName + " " + oldSurname;
                String titleNew = (result[7] != null) ? result[7].toString() : "";
                String newName = (result[8] != null) ? result[8].toString() : "";
                String newSurname = (result[9] != null) ? result[9].toString() : "";
                String newFullName = titleNew + " " + newName + " " + newSurname;

                changeMemberData.setOldName(oldFullName);
                changeMemberData.setNewName(newFullName);
                changeMemberData.setFileTypeCode((result[10] != null) ? result[10].toString() : "");
                changeMemberData.setMemberStatusCode((result[11] != null) ? result[11].toString() : "");
                changeMemberData.setRemark((result[12] != null) ? result[12].toString() : "");
                changeMemberData.setApproved((result[13] != null) ? result[13].toString() : "");
                changeMemberData.setTitleameHistoryId((result[14] != null) ? Integer.parseInt(result[14].toString()) : -1);

                changeMemberData.setNameHidden(newName);
                changeMemberData.setSurnameHidden(newSurname);
                changeMemberData.setTitleId((result[15] != null) ? Integer.parseInt(result[15].toString()) : null);
                changeMemberData.setRankId((result[16] != null) ? Integer.parseInt(result[16].toString()) : null);
                listResponse.add(changeMemberData);
            }

            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(listResponse);
        }
        return jqGrid;
    }

    @Override
    public MessageResponse updatedCHT010(CHT010Request request) {
        logger.info("MemberDAO : updatedCHT010");
        MessageResponse messageResponse = new MessageResponse();
        int iCountSuccessful = 0;
        int size = request.getTitleameHistoryId().size();
        System.out.println("size : " + size);
        for (int i = 0; i < size; i++) {
            List<Member> list;
            Member memberOriginal;

            Integer memberId = request.getMemberId().get(i);
            Integer titleId = request.getTitleId().get(i);
            Integer rankId = request.getRankId().get(i);
            String name = request.getName().get(i);
            String surname = request.getSurname().get(i);
            System.out.println("memberId : " + memberId);
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
            System.out.println("before member search");
            query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);

            System.out.println("after member search");
            list = query.list();
            if (!list.isEmpty()) {
                System.out.println("list member search");
                memberOriginal = list.get(0);
                System.out.println("get member search");
                if (titleId != null) {
                    Title title = new Title();
                    System.out.println("title member search");
                    title.setTitleId(titleId);
                    memberOriginal.setTitle(title);
                } else {
                    System.out.println("title member null");
                    memberOriginal.setTitle(null);
                }
                if (rankId != null) {
                    System.out.println("rank member search");
                    Rank rank = new Rank();
                    rank.setRankId(rankId);
                    memberOriginal.setRank(rank);
                } else {
                    System.out.println("rank member null");
                    memberOriginal.setRank(null);
                }

                memberOriginal.setName(name);
                memberOriginal.setSurname(surname);
                System.out.println("before member update");
                if (CommandQuery.Update(sessionFactory, memberOriginal)) {
                    System.out.println("update member success");
                    StringBuilder hql = new StringBuilder();
                    Integer titleameHistoryId = request.getTitleameHistoryId().get(i);
                    System.out.println("titleameHistoryId : " + titleameHistoryId);
                    Integer approved = (!request.getApproved().get(i).isEmpty()) ? Integer.parseInt(request.getApproved().get(i)) : null;
                    Date date = stringToDate(request.getApprovedDate().get(i));
                    hql.append(" update MemberTitleNameHistory ");
                    hql.append(" set approved =:approved");
                    hql.append(" ,approved_date =:approvedDate");
                    hql.append(" ,approved_by =:approvedBy");
                    hql.append(" where titleame_history_id =:titleameHistoryId");

                    if (CommandQuery.updateQuery(sessionFactory, hql, approved, date, "admin", titleameHistoryId)) {
                        iCountSuccessful++;
                    } else {
                        break;
                    }
                } else {
                    System.out.println("update member unsuccess");
                    break;
                }
            }
        }
        if (iCountSuccessful > 0) {
            System.out.println("success");
            messageResponse.setMessage(ConstantsMessage.SaveSuccessful);
            messageResponse.setCheckSuccess(true);
            return messageResponse;
        }
        System.out.println("unsuccess");
        messageResponse.setMessage(ConstantsMessage.SaveUnsuccessful);
        messageResponse.setCheckSuccess(false);
        return messageResponse;
    }

    @Override
    public MemberTotalDetail searchCHT030(MessageRequest req) {
        StringBuilder hql = new StringBuilder();
        MemberTotalDetail memberTotalDetail;

        hql.append(" select ");
        hql.append(" m.member_code, ");//0
        hql.append(" m.approved_date, ");//1
        hql.append(" m.citizen_id, ");//2
        hql.append(" m.begin_sop, ");//3
        hql.append(" isnull(r.rank_name,'') + isnull(t.title_desc,'') as title_rank, ");//4
        hql.append(" m.gender, ");//5
        hql.append(" m.name, ");//6
        hql.append(" m.surname, ");//7
        hql.append(" m.birth_date, ");//8
        hql.append(" m.officer_type_code, ");//9
        hql.append(" m.member_type_code, ");//10
        hql.append(" m.payment_type_code, ");//11
        hql.append(" m.mildept_id, ");//12
        hql.append(" md.name as mildept_name, ");//13
        hql.append(" ref.member_code as reference_code, ");//14
        hql.append(" (ref.name+' '+ref.surname) as reference_name, ");//15
        hql.append(" m.referrer_relationship_code, ");//16
        hql.append(" m.wifehusband_fullname, ");//17
        hql.append(" m.remark, ");//18
        hql.append(" m.member_status_code, ");//19
        hql.append(" m.permanent_address, ");//20
        hql.append(" m.permanent_moo, ");//21
        hql.append(" m.permanent_road, ");//22
        hql.append(" m.permanent_soi, ");//23
        hql.append(" m.permanent_subdistrict, ");//24
        hql.append(" m.permanent_district, ");//25
        hql.append(" pm.province_name as permanent_province, ");//26
        hql.append(" m.permanent_zipcode, ");//27
        hql.append(" m.permanent_tel, ");//28
        hql.append(" m.permanent_mobile, ");//29
        hql.append(" m.permanent_fax, ");//30
        hql.append(" m.address, ");//31
        hql.append(" m.moo, ");//32
        hql.append(" m.road, ");//33
        hql.append(" m.soi, ");//34
        hql.append(" m.subdistrict, ");//35
        hql.append(" m.district, ");//36
        hql.append(" pr.province_name, ");//37
        hql.append(" m.zipcode, ");//38
        hql.append(" m.tel, ");//39
        hql.append(" m.mobile, ");//40
        hql.append(" m.fax ");//41

        hql.append(" from ");
        hql.append(" rtacs.dbo.Member m ");
        hql.append(" left outer join rtacs.dbo.MilitaryDepartment md on md.mildept_id = m.military_id ");
        hql.append(" left outer join rtacs.dbo.Title t on m.title_id = t.title_id ");
        hql.append(" left outer join rtacs.dbo.Rank r on m.rank_id = r.rank_id ");
        hql.append(" left outer join rtacs.dbo.Province pr on pr.province_code = m.province_code ");
        hql.append(" left outer join rtacs.dbo.Province pm on pm.province_code = m.permanent_province_code ");
        hql.append(" left outer join rtacs.dbo.Member ref on ref.member_id = m.member_id ");

        if (req.getDataSource().equals("1")) {
            hql.append(" where m.citizen_id = :searchCode ");
        } else {
            hql.append(" where m.member_code= :searchCode ");
        }
        System.out.println("sql : " + hql.toString());

        System.out.println("1 req.getDataSource() : >>" + req.getDataSource() + "<<");
        System.out.println("1 req.getItemSelect().get(0) : >>" + req.getItemSelect().get(0) + "<<");

        SQLQuery query;
        query = sessionFactory.getCurrentSession().createSQLQuery(hql.toString());
        System.out.println("req.getDataSource() : >>" + req.getDataSource() + "<<");
        System.out.println("req.getItemSelect().get(0) : >>" + req.getItemSelect().get(0) + "<<");
        query.setParameter("searchCode", req.getItemSelect().get(0));

        List<?> list;
        list = query.list();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Object[] result = (Object[]) list.get(i);
                memberTotalDetail = new MemberTotalDetail();

                memberTotalDetail.setMemberCode((result[0] != null) ? result[0].toString() : "");
                String date = (result[1] != null) ? result[1].toString() : "";
                if (date.isEmpty()) {
                    memberTotalDetail.setApprovedDate("");
                } else {
                    memberTotalDetail.setApprovedDate(formatDateFullDate(date));
                }
                memberTotalDetail.setCitizenId((result[2] != null) ? result[2].toString() : "");
                memberTotalDetail.setBeginSop((result[3] != null) ? result[3].toString() : "");
                memberTotalDetail.setTitleRank((result[4] != null) ? result[4].toString() : "");
                memberTotalDetail.setGender((result[5] != null) ? result[5].toString() : "");
                memberTotalDetail.setName((result[6] != null) ? result[6].toString() : "");
                memberTotalDetail.setSurname((result[7] != null) ? result[7].toString() : "");
                String birthDateStr = (result[8] != null) ? result[8].toString() : "";
                if (birthDateStr.isEmpty()) {
                    memberTotalDetail.setBirthDate("");
                    memberTotalDetail.setAge("");
                } else {
                    memberTotalDetail.setBirthDate(formatDateFullDate(birthDateStr));
                    Date currentDate = DateUtil.getCurrentDate();
                    int birthDate = Integer.parseInt(birthDateStr.substring(2, 4));
                    memberTotalDetail.setAge("" + (currentDate.getYear() - birthDate));
                }
                memberTotalDetail.setOfficerTypeCode((result[9] != null) ? result[9].toString() : "");
                memberTotalDetail.setMemberTypeCode((result[10] != null) ? result[10].toString() : "");
                memberTotalDetail.setPaymentTypeCode((result[11] != null) ? result[11].toString() : "");
                memberTotalDetail.setMildeptId((result[12] != null) ? result[12].toString() : "");
                memberTotalDetail.setMildeptName((result[13] != null) ? result[13].toString() : "");
                memberTotalDetail.setReferenceCode((result[14] != null) ? result[14].toString() : "");
                memberTotalDetail.setReferenceName((result[15] != null) ? result[15].toString() : "");
                memberTotalDetail.setReferenceRelationshipCode((result[16] != null) ? result[16].toString() : "");
                memberTotalDetail.setWifehusbandFullname((result[17] != null) ? result[17].toString() : "");
                memberTotalDetail.setRemark((result[18] != null) ? result[18].toString() : "");
                memberTotalDetail.setMemberStatusCode((result[19] != null) ? result[19].toString() : "");
                memberTotalDetail.setPermanentAddress((result[20] != null) ? result[20].toString() : "");
                memberTotalDetail.setPermanentMoo((result[21] != null) ? result[21].toString() : "");
                memberTotalDetail.setPermanentRoad((result[22] != null) ? result[22].toString() : "");
                memberTotalDetail.setPermanentSoi((result[23] != null) ? result[23].toString() : "");
                memberTotalDetail.setPermanentSubDistrict((result[24] != null) ? result[24].toString() : "");
                memberTotalDetail.setPermanentDistrict((result[25] != null) ? result[25].toString() : "");
                memberTotalDetail.setPermanentProvinceName((result[26] != null) ? result[26].toString() : "");
                memberTotalDetail.setPermanentZipcode((result[27] != null) ? result[27].toString() : "");
                memberTotalDetail.setPermanentTel((result[28] != null) ? result[28].toString() : "");
                memberTotalDetail.setPermanentMobile((result[29] != null) ? result[29].toString() : "");
                memberTotalDetail.setPermanentFax((result[30] != null) ? result[30].toString() : "");
                memberTotalDetail.setAddress((result[31] != null) ? result[31].toString() : "");
                memberTotalDetail.setMoo((result[32] != null) ? result[32].toString() : "");
                memberTotalDetail.setRoad((result[33] != null) ? result[33].toString() : "");
                memberTotalDetail.setSoi((result[34] != null) ? result[34].toString() : "");
                memberTotalDetail.setSubdistrict((result[35] != null) ? result[35].toString() : "");
                memberTotalDetail.setDistrict((result[36] != null) ? result[36].toString() : "");
                memberTotalDetail.setProvinceName((result[37] != null) ? result[37].toString() : "");
                memberTotalDetail.setZipcode((result[38] != null) ? result[38].toString() : "");
                memberTotalDetail.setTel((result[39] != null) ? result[39].toString() : "");
                memberTotalDetail.setMobile((result[40] != null) ? result[40].toString() : "");
                memberTotalDetail.setFax((result[41] != null) ? result[41].toString() : "");

                return memberTotalDetail;
            }

        }
        return null;
    }

    private Date stringToDate(String date) {
        if (date.isEmpty()) {
            Date currentDate = DateUtil.getCurrentDate();
            return currentDate;
        }
        try {
            Date tempDate = sf.parse(date);
            return tempDate;
        } catch (ParseException e) {
            return null;
        }
    }
}
