/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.model.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itos.model.Member;
import com.itos.model.MemberBeneficiary;
import com.itos.util.MiscUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonMember {

    public static Member JSONDeserializer(String json, String stringDateFormat) throws IOException {
        Member member = new Member();
        MemberBeneficiary memberBeneficiary;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("memberId")) {
                member.setMemberId(MiscUtil.getInt(jsonObject.getString("memberId")));
            }
            if (jsonObject.containsKey("memberCode")) {
                member.setMemberCode(MiscUtil.getNull(jsonObject.getString("memberCode")));
            }
            if (jsonObject.containsKey("memberGroupCode")) {
                member.setMemberGroupCode(MiscUtil.getInt(jsonObject.getString("memberGroupCode")));
            }
            if (jsonObject.containsKey("applyDate")) {
                member.setApplyDate(MiscUtil.getDate(jsonObject.getString("applyDate"), stringDateFormat));
            }
            if (jsonObject.containsKey("citizenId")) {
                member.setCitizenId(MiscUtil.getNull(jsonObject.getString("citizenId")));
            }
            if (jsonObject.containsKey("militaryId")) {
                member.setMilitaryId(MiscUtil.getInt(jsonObject.getString("militaryId")));
            }
            if (jsonObject.containsKey("rankId")) {
                member.setRankId(MiscUtil.getInt(jsonObject.getString("rankId")));
            }
            if (jsonObject.containsKey("titleId")) {
                member.setTitleId(MiscUtil.getInt(jsonObject.getString("titleId")));
            }
            if (jsonObject.containsKey("name")) {
                member.setName(MiscUtil.getNull(jsonObject.getString("name")));
            }
            if (jsonObject.containsKey("surname")) {
                member.setSurname(MiscUtil.getNull(jsonObject.getString("surname")));
            }
            if (jsonObject.containsKey("gender")) {
                member.setGender(MiscUtil.getChar(jsonObject.getString("gender")));
            }
            if (jsonObject.containsKey("birthDate")) {
                member.setBirthDate(MiscUtil.getDate(jsonObject.getString("birthDate"), stringDateFormat));
            }
            if (jsonObject.containsKey("memberTypeCode")) {
                member.setMemberTypeCode(MiscUtil.getInt(jsonObject.getString("memberTypeCode")));
            }
            if (jsonObject.containsKey("paymentType")) {
                member.setPaymentType(MiscUtil.getInt(jsonObject.getString("paymentType")));
            }
            if (jsonObject.containsKey("referrerId")) {
                member.setReferrerId(MiscUtil.getInt(jsonObject.getString("referrerId")));
            }
            if (jsonObject.containsKey("referrerRelationshipCode")) {
                member.setReferrerRelationshipCode(MiscUtil.getInt(jsonObject.getString("referrerRelationshipCode")));
            }
            if (jsonObject.containsKey("marryStatusCode")) {
                member.setMarryStatusCode(MiscUtil.getInt(jsonObject.getString("marryStatusCode")));
            }
            if (jsonObject.containsKey("wifehusbandFullname")) {
                member.setWifehusbandFullname(MiscUtil.getNull(jsonObject.getString("wifehusbandFullname")));
            }
            if (jsonObject.containsKey("remark")) {
                member.setRemark(MiscUtil.getNull(jsonObject.getString("remark")));
            }
            if (jsonObject.containsKey("paymentTypeCode")) {
                member.setPaymentTypeCode(MiscUtil.getNull(jsonObject.getString("paymentTypeCode")));
            }
            if (jsonObject.containsKey("paymentRemark")) {
                member.setPaymentRemark(MiscUtil.getNull(jsonObject.getString("paymentRemark")));
            }
            if (jsonObject.containsKey("bankAccName")) {
                member.setBankAccName(MiscUtil.getNull(jsonObject.getString("bankAccName")));
            }
            if (jsonObject.containsKey("bankCode")) {
                member.setBankCode(MiscUtil.getNull(jsonObject.getString("bankCode")));
            }
            if (jsonObject.containsKey("bankBranchId")) {
                member.setBankBranchId(MiscUtil.getInt(jsonObject.getString("bankBranchId")));
            }
            if (jsonObject.containsKey("bankAccNo")) {
                member.setBankAccNo(MiscUtil.getNull(jsonObject.getString("bankAccNo")));
            }
            if (jsonObject.containsKey("accTypeId")) {
                member.setAccTypeId(MiscUtil.getInt(jsonObject.getString("accTypeId")));
            }
            if (jsonObject.containsKey("permanentAddress")) {
                member.setPermanentAddress(MiscUtil.getNull(jsonObject.getString("permanentAddress")));
            }
            if (jsonObject.containsKey("permanentMoo")) {
                member.setPermanentMoo(MiscUtil.getNull(jsonObject.getString("permanentMoo")));
            }
            if (jsonObject.containsKey("permanentRoad")) {
                member.setPermanentRoad(MiscUtil.getNull(jsonObject.getString("permanentRoad")));
            }
            if (jsonObject.containsKey("permanentSoi")) {
                member.setPermanentSoi(MiscUtil.getNull(jsonObject.getString("permanentSoi")));
            }
            if (jsonObject.containsKey("permanentSubdistrict")) {
                member.setPermanentSubdistrict(MiscUtil.getNull(jsonObject.getString("permanentSubdistrict")));
            }
            if (jsonObject.containsKey("permanentDistrict")) {
                member.setPermanentDistrict(MiscUtil.getNull(jsonObject.getString("permanentDistrict")));
            }
            if (jsonObject.containsKey("permanentProvinceCode")) {
                member.setPermanentProvinceCode(MiscUtil.getNull(jsonObject.getString("permanentProvinceCode")));
            }
            if (jsonObject.containsKey("permanentZipcode")) {
                member.setPermanentZipcode(MiscUtil.getNull(jsonObject.getString("permanentZipcode")));
            }
            if (jsonObject.containsKey("permanentTel")) {
                member.setPermanentTel(MiscUtil.getNull(jsonObject.getString("permanentTel")));
            }
            if (jsonObject.containsKey("permanentFax")) {
                member.setPermanentFax(MiscUtil.getNull(jsonObject.getString("permanentFax")));
            }
            if (jsonObject.containsKey("permanentMobile")) {
                member.setPermanentMobile(MiscUtil.getNull(jsonObject.getString("permanentMobile")));
            }
            if (jsonObject.containsKey("address")) {
                member.setAddress(MiscUtil.getNull(jsonObject.getString("address")));
            }
            if (jsonObject.containsKey("moo")) {
                member.setMoo(MiscUtil.getNull(jsonObject.getString("moo")));
            }
            if (jsonObject.containsKey("road")) {
                member.setRoad(MiscUtil.getNull(jsonObject.getString("road")));
            }
            if (jsonObject.containsKey("soi")) {
                member.setSoi(MiscUtil.getNull(jsonObject.getString("soi")));
            }
            if (jsonObject.containsKey("subdistrict")) {
                member.setSubdistrict(MiscUtil.getNull(jsonObject.getString("subdistrict")));
            }
            if (jsonObject.containsKey("district")) {
                member.setDistrict(MiscUtil.getNull(jsonObject.getString("district")));
            }
            if (jsonObject.containsKey("provinceCode")) {
                member.setProvinceCode(MiscUtil.getNull(jsonObject.getString("provinceCode")));
            }
            if (jsonObject.containsKey("zipcode")) {
                member.setZipcode(MiscUtil.getNull(jsonObject.getString("zipcode")));
            }
            if (jsonObject.containsKey("tel")) {
                member.setTel(MiscUtil.getNull(jsonObject.getString("tel")));
            }
            if (jsonObject.containsKey("fax")) {
                member.setFax(MiscUtil.getNull(jsonObject.getString("fax")));
            }
            if (jsonObject.containsKey("mobile")) {
                member.setMobile(MiscUtil.getNull(jsonObject.getString("mobile")));
            }
            if (jsonObject.containsKey("addressPrimary")) {
                member.setAddressPrimary(MiscUtil.getChar(jsonObject.getString("addressPrimary")));
            }
            if (jsonObject.containsKey("deleteBeneficiaryId")) {
                JSONArray jsonArray = jsonObject.getJSONArray("deleteBeneficiaryId");
                List<String> deleteBeneficiaryId = new ArrayList<>();
                for (Object id : jsonArray) {
                    deleteBeneficiaryId.add(String.valueOf(id));
                }
                member.setDeleteBeneficiaryId(deleteBeneficiaryId);
            }
            if (jsonObject.containsKey("listMemberBeneficiary")) {
                JSONArray jsonArray = jsonObject.getJSONArray("listMemberBeneficiary");
                List<MemberBeneficiary> listMemberBeneficiary = new ArrayList<>();
                for (Object objMemberBeneficiary : jsonArray) {
                    JSONObject jsonObjectMemberBeneficiary = (JSONObject) objMemberBeneficiary;
                    memberBeneficiary = new MemberBeneficiary();
                    if (jsonObjectMemberBeneficiary.containsKey("beneficiaryId")) {
                        memberBeneficiary.setBeneficiaryId(MiscUtil.getInt(jsonObjectMemberBeneficiary.getString("beneficiaryId")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("citizenId")) {
                        memberBeneficiary.setCitizenId(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("citizenId")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("name")) {
                        memberBeneficiary.setName(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("name")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("surname")) {
                        memberBeneficiary.setSurname(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("surname")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("memberRelationshipCode")) {
                        memberBeneficiary.setMemberRelationshipCode(MiscUtil.getInt(jsonObjectMemberBeneficiary.getString("memberRelationshipCode")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("permanentAddress")) {
                        memberBeneficiary.setPermanentAddress(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("permanentAddress")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("permanentMoo")) {
                        memberBeneficiary.setPermanentMoo(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("permanentMoo")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("permanentRoad")) {
                        memberBeneficiary.setPermanentRoad(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("permanentRoad")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("permanentSoi")) {
                        memberBeneficiary.setPermanentSoi(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("permanentSoi")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("permanentSubdistrict")) {
                        memberBeneficiary.setPermanentSubdistrict(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("permanentSubdistrict")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("permanentDistrict")) {
                        memberBeneficiary.setPermanentDistrict(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("permanentDistrict")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("permanentZipcode")) {
                        memberBeneficiary.setPermanentZipcode(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("permanentZipcode")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("permanentTel")) {
                        memberBeneficiary.setPermanentTel(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("permanentTel")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("permanentFax")) {
                        memberBeneficiary.setPermanentFax(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("permanentFax")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("permanentMobile")) {
                        memberBeneficiary.setPermanentMobile(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("permanentMobile")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("address")) {
                        memberBeneficiary.setAddress(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("address")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("moo")) {
                        memberBeneficiary.setMoo(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("moo")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("road")) {
                        memberBeneficiary.setRoad(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("road")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("soi")) {
                        memberBeneficiary.setSoi(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("soi")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("subdistrict")) {
                        memberBeneficiary.setSubdistrict(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("subdistrict")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("district")) {
                        memberBeneficiary.setDistrict(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("district")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("zipcode")) {
                        memberBeneficiary.setZipcode(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("zipcode")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("tel")) {
                        memberBeneficiary.setTel(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("tel")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("fax")) {
                        memberBeneficiary.setFax(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("fax")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("mobile")) {
                        memberBeneficiary.setMobile(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("mobile")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("rankId")) {
                        memberBeneficiary.setRankId(MiscUtil.getInt(jsonObjectMemberBeneficiary.getString("rankId")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("titleId")) {
                        memberBeneficiary.setTitleId(MiscUtil.getInt(jsonObjectMemberBeneficiary.getString("titleId")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("permanentProvinceCode")) {
                        memberBeneficiary.setPermanentProvinceCode(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("permanentProvinceCode")));
                    }
                    if (jsonObjectMemberBeneficiary.containsKey("provinceCode")) {
                        memberBeneficiary.setProvinceCode(MiscUtil.getNull(jsonObjectMemberBeneficiary.getString("provinceCode")));
                    }
                    listMemberBeneficiary.add(memberBeneficiary);
                }
                member.setListMemberBeneficiary(listMemberBeneficiary);
            }
        } catch (Exception ex) {
            throw ex;
        }
//        Member member = new Member();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            member = mapper.readValue(json, Member.class);
//        } catch (IOException ex) {
//            throw ex;
//        }
        return member;
    }

    public static Member JSONDeserializerKey(String json, String stringDateFormat) throws IOException {
        Member member = new Member();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("memberId")) {
                member.setMemberId(MiscUtil.getInt(jsonObject.getString("memberId")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return member;
    }
}
