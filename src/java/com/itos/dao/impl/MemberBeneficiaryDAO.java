/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IMemberBeneficiaryDAO;
import com.itos.model.Member;
import com.itos.model.MemberBeneficiary;
import com.itos.util.ConstantsMessage;
import com.itos.util.Hibernate.CommandConstant;
import com.itos.util.Hibernate.CommandQuery;
import com.itos.util.Hibernate.WhereField;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jqGrid.Paging;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITOS
 */
@Repository("iMemberBeneficiaryDAO")
public class MemberBeneficiaryDAO implements IMemberBeneficiaryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private final String objectTable = "MemberBeneficiary";

    @Override
    public JqGridResponse<MemberBeneficiary> getList(JqGridRequest req) {
        List<MemberBeneficiary> listResponse = new ArrayList<>();
        JqGridResponse<MemberBeneficiary> jqGrid = new JqGridResponse<>();
        MemberBeneficiary memberBeneficiaryObject;
        List<MemberBeneficiary> list;
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
            for (MemberBeneficiary memberBeneficiaryObjectList : list) {
                memberBeneficiaryObject = new MemberBeneficiary();
                memberBeneficiaryObject.setAddress(memberBeneficiaryObjectList.getAddress());
                memberBeneficiaryObject.setBeneficiaryId(memberBeneficiaryObjectList.getBeneficiaryId());
                memberBeneficiaryObject.setCitizenId(memberBeneficiaryObjectList.getCitizenId());
                memberBeneficiaryObject.setCreateBy(memberBeneficiaryObjectList.getCreateBy());
                memberBeneficiaryObject.setCreateDate(memberBeneficiaryObjectList.getCreateDate());
                memberBeneficiaryObject.setDistrict(memberBeneficiaryObjectList.getDistrict());
                memberBeneficiaryObject.setFax(memberBeneficiaryObjectList.getFax());
                memberBeneficiaryObject.setMobile(memberBeneficiaryObjectList.getMobile());
                memberBeneficiaryObject.setMoo(memberBeneficiaryObjectList.getMoo());
                memberBeneficiaryObject.setName(memberBeneficiaryObjectList.getName());
                memberBeneficiaryObject.setPermanentAddress(memberBeneficiaryObjectList.getPermanentAddress());
                memberBeneficiaryObject.setPermanentDistrict(memberBeneficiaryObjectList.getPermanentDistrict());
                memberBeneficiaryObject.setPermanentFax(memberBeneficiaryObjectList.getPermanentFax());
                memberBeneficiaryObject.setPermanentMobile(memberBeneficiaryObjectList.getPermanentMobile());

                if (null != memberBeneficiaryObjectList.getProvinceByPermanentProvinceCode()) {
                    memberBeneficiaryObject.setPermanentProvinceCode(memberBeneficiaryObjectList.getProvinceByPermanentProvinceCode().getProvinceCode());
                } else {
                    memberBeneficiaryObject.setPermanentProvinceCode("");
                }

                memberBeneficiaryObject.setPermanentRoad(memberBeneficiaryObjectList.getPermanentRoad());
                memberBeneficiaryObject.setPermanentSoi(memberBeneficiaryObjectList.getPermanentSoi());
                memberBeneficiaryObject.setPermanentSubdistrict(memberBeneficiaryObjectList.getPermanentSubdistrict());
                memberBeneficiaryObject.setPermanentTel(memberBeneficiaryObjectList.getPermanentTel());
                memberBeneficiaryObject.setPermanentZipcode(memberBeneficiaryObjectList.getPermanentZipcode());

                if (null != memberBeneficiaryObjectList.getProvinceByProvinceCode()) {
                    memberBeneficiaryObject.setProvinceCode(memberBeneficiaryObjectList.getProvinceByProvinceCode().getProvinceCode());
                } else {
                    memberBeneficiaryObject.setProvinceCode("");
                }

                if (null != memberBeneficiaryObjectList.getRank()) {
                    memberBeneficiaryObject.setRankId(memberBeneficiaryObjectList.getRank().getRankId());
                } else {
                    memberBeneficiaryObject.setRankId(0);
                }

                memberBeneficiaryObject.setRoad(memberBeneficiaryObjectList.getRoad());
                memberBeneficiaryObject.setSoi(memberBeneficiaryObjectList.getSoi());
                memberBeneficiaryObject.setSubdistrict(memberBeneficiaryObjectList.getSubdistrict());
                memberBeneficiaryObject.setSurname(memberBeneficiaryObjectList.getSurname());
                memberBeneficiaryObject.setTel(memberBeneficiaryObjectList.getTel());

                if (null != memberBeneficiaryObjectList.getTitle()) {
                    memberBeneficiaryObject.setTitleId(memberBeneficiaryObjectList.getTitle().getTitleId());
                } else {
                    memberBeneficiaryObject.setTitleId(0);
                }

                memberBeneficiaryObject.setUpdateBy(memberBeneficiaryObjectList.getUpdateBy());
                memberBeneficiaryObject.setUpdateDate(memberBeneficiaryObjectList.getUpdateDate());
                memberBeneficiaryObject.setZipcode(memberBeneficiaryObjectList.getZipcode());
                memberBeneficiaryObject.setMemberRelationshipCode(memberBeneficiaryObjectList.getMemberRelationshipCode());
                memberBeneficiaryObject.setPermanentMoo(memberBeneficiaryObjectList.getPermanentMoo());

                listResponse.add(memberBeneficiaryObject);
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
    public MessageResponse setDeleteMemberBeneficiary(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        MemberBeneficiary memberBeneficiaryOriginal = null;
        boolean chekSuccess = false;
        for (String id : req.getItemSelect()) {
            memberBeneficiaryOriginal = new MemberBeneficiary();
            memberBeneficiaryOriginal = (MemberBeneficiary) CommandQuery.LoadDetail(sessionFactory, MemberBeneficiary.class, id);
            if (CommandQuery.Delete(sessionFactory, memberBeneficiaryOriginal)) {
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
    public MessageResponse setSaveNewMemberBeneficiary(MemberBeneficiary memberBeneficiary) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        chekSuccess = CommandQuery.Insert(sessionFactory, memberBeneficiary);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(memberBeneficiary.getBeneficiaryId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveEditMemberBeneficiary(MemberBeneficiary memberBeneficiary) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        MemberBeneficiary memberBeneficiaryOriginal = (MemberBeneficiary) CommandQuery.LoadDetail(sessionFactory, MemberBeneficiary.class, memberBeneficiary.getBeneficiaryId());

        memberBeneficiaryOriginal = new MemberBeneficiary();
        memberBeneficiaryOriginal.setAddress(memberBeneficiary.getAddress());
        memberBeneficiaryOriginal.setBeneficiaryId(memberBeneficiary.getBeneficiaryId());
        memberBeneficiaryOriginal.setCitizenId(memberBeneficiary.getCitizenId());
        memberBeneficiaryOriginal.setCreateBy(memberBeneficiary.getCreateBy());
        memberBeneficiaryOriginal.setCreateDate(memberBeneficiary.getCreateDate());
        memberBeneficiaryOriginal.setDistrict(memberBeneficiary.getDistrict());
        memberBeneficiaryOriginal.setFax(memberBeneficiary.getFax());
        memberBeneficiaryOriginal.setMember(memberBeneficiary.getMember());
        memberBeneficiaryOriginal.setMobile(memberBeneficiary.getMobile());
        memberBeneficiaryOriginal.setMoo(memberBeneficiary.getMoo());
        memberBeneficiaryOriginal.setName(memberBeneficiary.getName());
        memberBeneficiaryOriginal.setPermanentAddress(memberBeneficiary.getPermanentAddress());
        memberBeneficiaryOriginal.setPermanentDistrict(memberBeneficiary.getPermanentDistrict());
        memberBeneficiaryOriginal.setPermanentFax(memberBeneficiary.getPermanentFax());
        memberBeneficiaryOriginal.setPermanentMobile(memberBeneficiary.getPermanentMobile());
        memberBeneficiaryOriginal.setProvinceByPermanentProvinceCode(memberBeneficiary.getProvinceByPermanentProvinceCode());
        memberBeneficiaryOriginal.setPermanentRoad(memberBeneficiary.getPermanentRoad());
        memberBeneficiaryOriginal.setPermanentSoi(memberBeneficiary.getPermanentSoi());
        memberBeneficiaryOriginal.setPermanentSubdistrict(memberBeneficiary.getPermanentSubdistrict());
        memberBeneficiaryOriginal.setPermanentTel(memberBeneficiary.getPermanentTel());
        memberBeneficiaryOriginal.setPermanentZipcode(memberBeneficiary.getPermanentZipcode());
        memberBeneficiaryOriginal.setProvinceByProvinceCode(memberBeneficiary.getProvinceByProvinceCode());
        memberBeneficiaryOriginal.setRank(memberBeneficiary.getRank());
        memberBeneficiaryOriginal.setRoad(memberBeneficiary.getRoad());
        memberBeneficiaryOriginal.setSoi(memberBeneficiary.getSoi());
        memberBeneficiaryOriginal.setSubdistrict(memberBeneficiary.getSubdistrict());
        memberBeneficiaryOriginal.setSurname(memberBeneficiary.getSurname());
        memberBeneficiaryOriginal.setTel(memberBeneficiary.getTel());
        memberBeneficiaryOriginal.setTitle(memberBeneficiary.getTitle());
        memberBeneficiaryOriginal.setUpdateBy(memberBeneficiary.getUpdateBy());
        memberBeneficiaryOriginal.setUpdateDate(memberBeneficiary.getUpdateDate());
        memberBeneficiaryOriginal.setZipcode(memberBeneficiary.getZipcode());
        memberBeneficiaryOriginal.setMemberRelationshipCode(memberBeneficiary.getMemberRelationshipCode());
        memberBeneficiaryOriginal.setPermanentMoo(memberBeneficiary.getPermanentMoo());
        chekSuccess = CommandQuery.Update(sessionFactory, memberBeneficiaryOriginal);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(memberBeneficiary.getBeneficiaryId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MemberBeneficiary getLoadMemberBeneficiary(MemberBeneficiary memberBeneficiary) {
        MemberBeneficiary groupResponse = getLoadDetailByObject(memberBeneficiary);
        return groupResponse;
    }

    private MemberBeneficiary getLoadDetailByObject(MemberBeneficiary memberBeneficiaryObject) {
        MemberBeneficiary memberBeneficiaryResponse = new MemberBeneficiary();
        List<WhereField> listWhereField = new ArrayList<>();
        List<MemberBeneficiary> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("beneficiaryId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(memberBeneficiaryObject.getBeneficiaryId());
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
                for (MemberBeneficiary memberBeneficiaryObjectList : list) {
                    memberBeneficiaryResponse = new MemberBeneficiary();
                    memberBeneficiaryResponse.setAddress(memberBeneficiaryObjectList.getAddress());
                    memberBeneficiaryResponse.setBeneficiaryId(memberBeneficiaryObjectList.getBeneficiaryId());
                    memberBeneficiaryResponse.setCitizenId(memberBeneficiaryObjectList.getCitizenId());
                    memberBeneficiaryResponse.setCreateBy(memberBeneficiaryObjectList.getCreateBy());
                    memberBeneficiaryResponse.setCreateDate(memberBeneficiaryObjectList.getCreateDate());
                    memberBeneficiaryResponse.setDistrict(memberBeneficiaryObjectList.getDistrict());
                    memberBeneficiaryResponse.setFax(memberBeneficiaryObjectList.getFax());
                    memberBeneficiaryResponse.setMember(memberBeneficiaryObjectList.getMember());
                    memberBeneficiaryResponse.setMobile(memberBeneficiaryObjectList.getMobile());
                    memberBeneficiaryResponse.setMoo(memberBeneficiaryObjectList.getMoo());
                    memberBeneficiaryResponse.setName(memberBeneficiaryObjectList.getName());
                    memberBeneficiaryResponse.setPermanentAddress(memberBeneficiaryObjectList.getPermanentAddress());
                    memberBeneficiaryResponse.setPermanentDistrict(memberBeneficiaryObjectList.getPermanentDistrict());
                    memberBeneficiaryResponse.setPermanentFax(memberBeneficiaryObjectList.getPermanentFax());
                    memberBeneficiaryResponse.setPermanentMobile(memberBeneficiaryObjectList.getPermanentMobile());
                    memberBeneficiaryResponse.setProvinceByPermanentProvinceCode(memberBeneficiaryObjectList.getProvinceByPermanentProvinceCode());
                    memberBeneficiaryResponse.setPermanentRoad(memberBeneficiaryObjectList.getPermanentRoad());
                    memberBeneficiaryResponse.setPermanentSoi(memberBeneficiaryObjectList.getPermanentSoi());
                    memberBeneficiaryResponse.setPermanentSubdistrict(memberBeneficiaryObjectList.getPermanentSubdistrict());
                    memberBeneficiaryResponse.setPermanentTel(memberBeneficiaryObjectList.getPermanentTel());
                    memberBeneficiaryResponse.setPermanentZipcode(memberBeneficiaryObjectList.getPermanentZipcode());
                    memberBeneficiaryResponse.setProvinceByProvinceCode(memberBeneficiaryObjectList.getProvinceByProvinceCode());
                    memberBeneficiaryResponse.setRank(memberBeneficiaryObjectList.getRank());
                    memberBeneficiaryResponse.setRoad(memberBeneficiaryObjectList.getRoad());
                    memberBeneficiaryResponse.setSoi(memberBeneficiaryObjectList.getSoi());
                    memberBeneficiaryResponse.setSubdistrict(memberBeneficiaryObjectList.getSubdistrict());
                    memberBeneficiaryResponse.setSurname(memberBeneficiaryObjectList.getSurname());
                    memberBeneficiaryResponse.setTel(memberBeneficiaryObjectList.getTel());
                    memberBeneficiaryResponse.setTitle(memberBeneficiaryObjectList.getTitle());
                    memberBeneficiaryResponse.setUpdateBy(memberBeneficiaryObjectList.getUpdateBy());
                    memberBeneficiaryResponse.setUpdateDate(memberBeneficiaryObjectList.getUpdateDate());
                    memberBeneficiaryResponse.setZipcode(memberBeneficiaryObjectList.getZipcode());
                    memberBeneficiaryResponse.setMemberRelationshipCode(memberBeneficiaryObjectList.getMemberRelationshipCode());
                    memberBeneficiaryResponse.setPermanentMoo(memberBeneficiaryObjectList.getPermanentMoo());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return memberBeneficiaryResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    private MemberBeneficiary getLoadDetailById(MemberBeneficiary memberBeneficiary) {
        MemberBeneficiary memberBeneficiaryResponse = null;
        List<WhereField> listWhereField = new ArrayList<>();
        List<MemberBeneficiary> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("beneficiaryId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(memberBeneficiary.getBeneficiaryId());
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
                for (MemberBeneficiary memberBeneficiaryObjectList : list) {
                    memberBeneficiaryResponse = new MemberBeneficiary();
                    memberBeneficiaryResponse.setAddress(memberBeneficiaryObjectList.getAddress());
                    memberBeneficiaryResponse.setBeneficiaryId(memberBeneficiaryObjectList.getBeneficiaryId());
                    memberBeneficiaryResponse.setCitizenId(memberBeneficiaryObjectList.getCitizenId());
                    memberBeneficiaryResponse.setCreateBy(memberBeneficiaryObjectList.getCreateBy());
                    memberBeneficiaryResponse.setCreateDate(memberBeneficiaryObjectList.getCreateDate());
                    memberBeneficiaryResponse.setDistrict(memberBeneficiaryObjectList.getDistrict());
                    memberBeneficiaryResponse.setFax(memberBeneficiaryObjectList.getFax());
                    memberBeneficiaryResponse.setMember(memberBeneficiaryObjectList.getMember());
                    memberBeneficiaryResponse.setMobile(memberBeneficiaryObjectList.getMobile());
                    memberBeneficiaryResponse.setMoo(memberBeneficiaryObjectList.getMoo());
                    memberBeneficiaryResponse.setName(memberBeneficiaryObjectList.getName());
                    memberBeneficiaryResponse.setPermanentAddress(memberBeneficiaryObjectList.getPermanentAddress());
                    memberBeneficiaryResponse.setPermanentDistrict(memberBeneficiaryObjectList.getPermanentDistrict());
                    memberBeneficiaryResponse.setPermanentFax(memberBeneficiaryObjectList.getPermanentFax());
                    memberBeneficiaryResponse.setPermanentMobile(memberBeneficiaryObjectList.getPermanentMobile());
                    memberBeneficiaryResponse.setProvinceByPermanentProvinceCode(memberBeneficiaryObjectList.getProvinceByPermanentProvinceCode());
                    memberBeneficiaryResponse.setPermanentRoad(memberBeneficiaryObjectList.getPermanentRoad());
                    memberBeneficiaryResponse.setPermanentSoi(memberBeneficiaryObjectList.getPermanentSoi());
                    memberBeneficiaryResponse.setPermanentSubdistrict(memberBeneficiaryObjectList.getPermanentSubdistrict());
                    memberBeneficiaryResponse.setPermanentTel(memberBeneficiaryObjectList.getPermanentTel());
                    memberBeneficiaryResponse.setPermanentZipcode(memberBeneficiaryObjectList.getPermanentZipcode());
                    memberBeneficiaryResponse.setProvinceByProvinceCode(memberBeneficiaryObjectList.getProvinceByProvinceCode());
                    memberBeneficiaryResponse.setRank(memberBeneficiaryObjectList.getRank());
                    memberBeneficiaryResponse.setRoad(memberBeneficiaryObjectList.getRoad());
                    memberBeneficiaryResponse.setSoi(memberBeneficiaryObjectList.getSoi());
                    memberBeneficiaryResponse.setSubdistrict(memberBeneficiaryObjectList.getSubdistrict());
                    memberBeneficiaryResponse.setSurname(memberBeneficiaryObjectList.getSurname());
                    memberBeneficiaryResponse.setTel(memberBeneficiaryObjectList.getTel());
                    memberBeneficiaryResponse.setTitle(memberBeneficiaryObjectList.getTitle());
                    memberBeneficiaryResponse.setUpdateBy(memberBeneficiaryObjectList.getUpdateBy());
                    memberBeneficiaryResponse.setUpdateDate(memberBeneficiaryObjectList.getUpdateDate());
                    memberBeneficiaryResponse.setZipcode(memberBeneficiaryObjectList.getZipcode());
                    memberBeneficiaryResponse.setMemberRelationshipCode(memberBeneficiaryObjectList.getMemberRelationshipCode());
                    memberBeneficiaryResponse.setPermanentMoo(memberBeneficiaryObjectList.getPermanentMoo());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return memberBeneficiaryResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<MemberBeneficiary> getListByMember(Member member) {
        MemberBeneficiary memberBeneficiaryResponse = null;
        List<MemberBeneficiary> listResponse = new ArrayList<>();
        List<WhereField> listWhereField = new ArrayList<>();
        List<MemberBeneficiary> list;
        WhereField whereField = null;
        int iCount = 0;
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

            Query query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);
            /*
             * Check array data if true set create object to array new.
             */
            list = query.list();
            if (!list.isEmpty()) {

                /*
                 * Start developer create object to array new.
                 */
                for (MemberBeneficiary memberBeneficiaryObjectList : list) {
                    iCount++;
                    memberBeneficiaryResponse = new MemberBeneficiary();
                    memberBeneficiaryResponse.setId(iCount);
                    memberBeneficiaryResponse.setAddress(memberBeneficiaryObjectList.getAddress());
                    memberBeneficiaryResponse.setBeneficiaryId(memberBeneficiaryObjectList.getBeneficiaryId());
                    memberBeneficiaryResponse.setCitizenId(memberBeneficiaryObjectList.getCitizenId());
                    memberBeneficiaryResponse.setCreateBy(memberBeneficiaryObjectList.getCreateBy());
                    memberBeneficiaryResponse.setCreateDate(memberBeneficiaryObjectList.getCreateDate());
                    memberBeneficiaryResponse.setDistrict(memberBeneficiaryObjectList.getDistrict());
                    memberBeneficiaryResponse.setFax(memberBeneficiaryObjectList.getFax());
                    memberBeneficiaryResponse.setMember(memberBeneficiaryObjectList.getMember());
                    memberBeneficiaryResponse.setMobile(memberBeneficiaryObjectList.getMobile());
                    memberBeneficiaryResponse.setMoo(memberBeneficiaryObjectList.getMoo());
                    memberBeneficiaryResponse.setName(memberBeneficiaryObjectList.getName());
                    memberBeneficiaryResponse.setPermanentAddress(memberBeneficiaryObjectList.getPermanentAddress());
                    memberBeneficiaryResponse.setPermanentDistrict(memberBeneficiaryObjectList.getPermanentDistrict());
                    memberBeneficiaryResponse.setPermanentFax(memberBeneficiaryObjectList.getPermanentFax());
                    memberBeneficiaryResponse.setPermanentMobile(memberBeneficiaryObjectList.getPermanentMobile());
                    memberBeneficiaryResponse.setProvinceByPermanentProvinceCode(memberBeneficiaryObjectList.getProvinceByPermanentProvinceCode());
                    memberBeneficiaryResponse.setPermanentRoad(memberBeneficiaryObjectList.getPermanentRoad());
                    memberBeneficiaryResponse.setPermanentSoi(memberBeneficiaryObjectList.getPermanentSoi());
                    memberBeneficiaryResponse.setPermanentSubdistrict(memberBeneficiaryObjectList.getPermanentSubdistrict());
                    memberBeneficiaryResponse.setPermanentTel(memberBeneficiaryObjectList.getPermanentTel());
                    memberBeneficiaryResponse.setPermanentZipcode(memberBeneficiaryObjectList.getPermanentZipcode());
                    memberBeneficiaryResponse.setProvinceByProvinceCode(memberBeneficiaryObjectList.getProvinceByProvinceCode());
                    memberBeneficiaryResponse.setRank(memberBeneficiaryObjectList.getRank());
                    memberBeneficiaryResponse.setRoad(memberBeneficiaryObjectList.getRoad());
                    memberBeneficiaryResponse.setSoi(memberBeneficiaryObjectList.getSoi());
                    memberBeneficiaryResponse.setSubdistrict(memberBeneficiaryObjectList.getSubdistrict());
                    memberBeneficiaryResponse.setSurname(memberBeneficiaryObjectList.getSurname());
                    memberBeneficiaryResponse.setTel(memberBeneficiaryObjectList.getTel());
                    memberBeneficiaryResponse.setTitle(memberBeneficiaryObjectList.getTitle());
                    memberBeneficiaryResponse.setUpdateBy(memberBeneficiaryObjectList.getUpdateBy());
                    memberBeneficiaryResponse.setUpdateDate(memberBeneficiaryObjectList.getUpdateDate());
                    memberBeneficiaryResponse.setZipcode(memberBeneficiaryObjectList.getZipcode());
                    memberBeneficiaryResponse.setMemberRelationshipCode(memberBeneficiaryObjectList.getMemberRelationshipCode());
                    memberBeneficiaryResponse.setPermanentMoo(memberBeneficiaryObjectList.getPermanentMoo());
                    memberBeneficiaryResponse.setTitleId(memberBeneficiaryObjectList.getTitleId());
                    memberBeneficiaryResponse.setTitleName(memberBeneficiaryObjectList.getTitleName());
                    memberBeneficiaryResponse.setRankId(memberBeneficiaryObjectList.getRankId());
                    memberBeneficiaryResponse.setRankName(memberBeneficiaryObjectList.getRankName());
                    memberBeneficiaryResponse.setProvinceCode(memberBeneficiaryObjectList.getProvinceCode());
                    memberBeneficiaryResponse.setProvinceName(memberBeneficiaryObjectList.getProvinceName());
                    memberBeneficiaryResponse.setPermanentProvinceCode(memberBeneficiaryObjectList.getPermanentProvinceCode());
                    memberBeneficiaryResponse.setPermanentProvinceName(memberBeneficiaryObjectList.getPermanentProvinceName());
                    memberBeneficiaryResponse.setMemberRelationship(memberBeneficiaryResponse.getMemberRelationship());

                    listResponse.add(memberBeneficiaryResponse);
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return listResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
