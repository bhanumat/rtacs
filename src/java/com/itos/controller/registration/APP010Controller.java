/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.registration;

import com.itos.model.Bank;
import com.itos.model.BankAccountType;
import com.itos.model.BankBranch;
import com.itos.model.Member;
import com.itos.model.MemberBeneficiary;
import com.itos.model.MilitaryDepartment;
import com.itos.model.Province;
import com.itos.model.Rank;
import com.itos.model.Title;
import com.itos.model.json.JsonMember;
import com.itos.service.model.IMemberBeneficiaryService;
import com.itos.service.model.IMemberService;
import com.itos.util.DateUtil;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author ITOS
 */
@Controller
@Configuration
@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
public class APP010Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    IMemberService iMemberService;

    @Autowired
    IMemberBeneficiaryService iMemberBeneficiaryService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/Registration/APP010.htm")
    public String APP010(Model model, Principal principal) {
        return "/Plugins/Registration/APP010";
    }

    @RequestMapping("/Plugins/Registration/APP010_2_New.htm")
    public String APP010_2_New(Model model, Principal principal) {
        return "/Plugins/Registration/APP010_2_New";
    }

    @RequestMapping("/Plugins/Registration/APP010_2_Edit.htm")
    public String APP010_2_Edit(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Member member = new Member();
        try {
            member = JsonMember.JSONDeserializerKey(data2Json, stringDateFormat);
        } catch (IOException ex) {
            return null;
        }
        model.addAttribute("memberId", member.getMemberId());
        return "/Plugins/Registration/APP010_2_Edit";
    }

    @RequestMapping(value = "/Plugins/Registration/getListAPP010.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<Member> getListAPP010(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("APP010Controller : getListAPP010");
        req.setSearch(Boolean.parseBoolean(search));
        return iMemberService.getListMember(req);
    }

    @RequestMapping(value = "/Plugins/Registration/getListAPP010ForRegister.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<Member> getListAPP010ForRegister(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search));
        return iMemberService.getListMemberForRegister(req);
    }

    @RequestMapping(value = "/Plugins/Registration/getLoadAPP010.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Member getLoadAPP010(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Member member = new Member();
        try {
            member = JsonMember.JSONDeserializerKey(data2Json, stringDateFormat);
            return iMemberService.getLoadMember(member);
        } catch (IOException ex) {
            return null;
        }
    }

    @RequestMapping(value = "/Plugins/Registration/setSaveNewAPP010.json", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveNewAPP010(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Member memberRequest = new Member();
        List<MemberBeneficiary> listMemberBeneficiaryInsert = new ArrayList<>();
        logger.info(data2Json);
        try {
            Member memberDeserializer = JsonMember.JSONDeserializer(data2Json, stringDateFormat);

            BankAccountType bankAccountType = new BankAccountType();
            if (null != memberDeserializer.getAccTypeId() && memberDeserializer.getAccTypeId() != 0) {
                bankAccountType.setAccTypeId(memberDeserializer.getAccTypeId());
            } else {
                bankAccountType = null;
            }
            memberRequest.setBankAccountType(bankAccountType);

            memberRequest.setAddress(memberDeserializer.getAddress());
            memberRequest.setAddressPrimary(memberDeserializer.getAddressPrimary());
            memberRequest.setApplyDate(memberDeserializer.getApplyDate());
            memberRequest.setBankAccName(memberDeserializer.getBankAccName());
            memberRequest.setBankAccNo(memberDeserializer.getBankAccNo());

            BankBranch bankBranch = new BankBranch();
            if (null != memberDeserializer.getBankBranchId() && memberDeserializer.getBankBranchId() != 0) {
                bankBranch.setBranchId(memberDeserializer.getBankBranchId());
            } else {
                bankBranch = null;
            }
            memberRequest.setBankBranch(bankBranch);

            Bank bank = new Bank();
            bank.setBankCode(memberDeserializer.getBankCode());
            if (null != memberDeserializer.getBankCode() && !memberDeserializer.getBankCode().isEmpty()) {
                bank.setBankCode(memberDeserializer.getBankCode());
            } else {
                bank = null;
            }
            memberRequest.setBank(bank);

            memberRequest.setBirthDate(memberDeserializer.getBirthDate());
            memberRequest.setCitizenId(memberDeserializer.getCitizenId());
            memberRequest.setCreateBy(memberDeserializer.getCreateBy());
            memberRequest.setCreateDate(memberDeserializer.getCreateDate());
            memberRequest.setDistrict(memberDeserializer.getDistrict());
            memberRequest.setFax(memberDeserializer.getFax());
            memberRequest.setGender(memberDeserializer.getGender());
            memberRequest.setMarryStatusCode(memberDeserializer.getMarryStatusCode());
            memberRequest.setMemberCode(memberDeserializer.getMemberCode());
            memberRequest.setMemberGroupCode(memberDeserializer.getMemberGroupCode());
            memberRequest.setMemberId(memberDeserializer.getMemberId());
            memberRequest.setMemberStatusCode(10);
            memberRequest.setMemberTypeCode(memberDeserializer.getMemberTypeCode());

            MilitaryDepartment militaryDepartment = new MilitaryDepartment();
            if (null != memberDeserializer.getMilitaryId() && memberDeserializer.getMilitaryId() != 0) {
                militaryDepartment.setMilitaryId(memberDeserializer.getMilitaryId());
            } else {
                militaryDepartment = null;
            }
            memberRequest.setMilitaryDepartment(militaryDepartment);

            memberRequest.setMobile(memberDeserializer.getMobile());
            memberRequest.setMoo(memberDeserializer.getMoo());
            memberRequest.setName(memberDeserializer.getName());
            memberRequest.setPaymentRemark(memberDeserializer.getPaymentRemark());
            memberRequest.setPaymentType(memberDeserializer.getPaymentType());
            memberRequest.setPaymentTypeCode(memberDeserializer.getPaymentTypeCode());
            memberRequest.setPermanentAddress(memberDeserializer.getPermanentAddress());
            memberRequest.setPermanentDistrict(memberDeserializer.getPermanentDistrict());
            memberRequest.setPermanentFax(memberDeserializer.getPermanentFax());
            memberRequest.setPermanentMobile(memberDeserializer.getPermanentMobile());

            Province province = new Province();
            if (null != memberDeserializer.getPermanentProvinceCode() && !memberDeserializer.getPermanentProvinceCode().isEmpty()) {
                province.setProvinceCode(memberDeserializer.getPermanentProvinceCode());
            } else {
                province = null;
            }
            memberRequest.setProvinceByPermanentProvinceCode(province);

            memberRequest.setPermanentRoad(memberDeserializer.getPermanentRoad());
            memberRequest.setPermanentSoi(memberDeserializer.getPermanentSoi());
            memberRequest.setPermanentSubdistrict(memberDeserializer.getPermanentSubdistrict());
            memberRequest.setPermanentTel(memberDeserializer.getPermanentTel());
            memberRequest.setPermanentZipcode(memberDeserializer.getPermanentZipcode());

            province = null;
            province = new Province();
            if (null != memberDeserializer.getProvinceCode() && !memberDeserializer.getProvinceCode().isEmpty()) {
                province.setProvinceCode(memberDeserializer.getProvinceCode());
            } else {
                province = null;
            }
            memberRequest.setProvinceByProvinceCode(province);

            Rank rank = new Rank();
            if (null != memberDeserializer.getRankId() && memberDeserializer.getRankId() != 0) {
                rank.setRankId(memberDeserializer.getRankId());
            } else {
                rank = null;
            }
            memberRequest.setRank(rank);

            memberRequest.setReferrerId(memberDeserializer.getReferrerId());
            memberRequest.setReferrerRelationshipCode(memberDeserializer.getReferrerRelationshipCode());
            memberRequest.setRemark(memberDeserializer.getRemark());
            memberRequest.setRoad(memberDeserializer.getRoad());
            memberRequest.setSoi(memberDeserializer.getSoi());
            memberRequest.setSubdistrict(memberDeserializer.getSubdistrict());
            memberRequest.setSurname(memberDeserializer.getSurname());
            memberRequest.setTel(memberDeserializer.getTel());

            Title title = new Title();
            if (null != memberDeserializer.getTitleId() && memberDeserializer.getTitleId() != 0) {
                title.setTitleId(memberDeserializer.getTitleId());
            } else {
                title = null;
            }
            memberRequest.setTitle(title);

            memberRequest.setUpdateBy(memberDeserializer.getUpdateBy());
            memberRequest.setUpdateDate(memberDeserializer.getUpdateDate());
            memberRequest.setWifehusbandFullname(memberDeserializer.getWifehusbandFullname());
            memberRequest.setZipcode(memberDeserializer.getZipcode());
            memberRequest.setPermanentMoo(memberDeserializer.getPermanentMoo());
            memberRequest.setCreateBy("");
            memberRequest.setCreateDate(DateUtil.getCurrentDate());

            List<MemberBeneficiary> listMemberBeneficiary = memberDeserializer.getListMemberBeneficiary();
            if (null != listMemberBeneficiary && !listMemberBeneficiary.isEmpty() && listMemberBeneficiary.size() != 0) {
                for (MemberBeneficiary memberBeneficiary : listMemberBeneficiary) {
                    rank = new Rank();
                    if (null != memberBeneficiary.getRankId() && memberBeneficiary.getRankId() != 0) {
                        rank.setRankId(memberBeneficiary.getRankId());
                    } else {
                        rank = null;
                    }
                    memberBeneficiary.setRank(rank);

                    title = new Title();
                    if (null != memberBeneficiary.getTitleId() && memberBeneficiary.getTitleId() != 0) {
                        title.setTitleId(memberBeneficiary.getTitleId());
                    } else {
                        title = null;
                    }
                    memberBeneficiary.setTitle(title);

                    province = new Province();
                    if (null != memberBeneficiary.getPermanentProvinceCode() && !memberBeneficiary.getPermanentProvinceCode().isEmpty()) {
                        province.setProvinceCode(memberBeneficiary.getPermanentProvinceCode());
                    } else {
                        province = null;
                    }
                    memberBeneficiary.setProvinceByPermanentProvinceCode(province);

                    province = new Province();
                    if (null != memberBeneficiary.getProvinceCode() && !memberBeneficiary.getProvinceCode().isEmpty()) {
                        province.setProvinceCode(memberBeneficiary.getProvinceCode());
                    } else {
                        province = null;
                    }
                    memberBeneficiary.setProvinceByProvinceCode(province);

                    listMemberBeneficiaryInsert.add(memberBeneficiary);
                }
                memberRequest.setListMemberBeneficiary(listMemberBeneficiaryInsert);
            }

            return iMemberService.setSaveNewMember(memberRequest);
        } catch (IOException ex) {
            logger.error(ex);
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/Registration/getListMemberBeneficiaryAPP010.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<MemberBeneficiary> getListMemberBeneficiaryAPP010(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Member member = new Member();
        try {
            member = JsonMember.JSONDeserializerKey(data2Json, stringDateFormat);
            return iMemberBeneficiaryService.getListMemberBeneficiaryByMember(member);
        } catch (IOException ex) {
            return null;
        }
    }

    @RequestMapping(value = "/Plugins/Registration/setSaveEditAPP010.json", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveEditAPP010(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Member memberRequest = new Member();
        List<MemberBeneficiary> listMemberBeneficiaryInsert = new ArrayList<>();
        logger.info(data2Json);
        try {
            Member memberDeserializer = JsonMember.JSONDeserializer(data2Json, stringDateFormat);

            BankAccountType bankAccountType = new BankAccountType();
            if (null != memberDeserializer.getAccTypeId() && memberDeserializer.getAccTypeId() != 0) {
                bankAccountType.setAccTypeId(memberDeserializer.getAccTypeId());
            } else {
                bankAccountType = null;
            }
            memberRequest.setBankAccountType(bankAccountType);

            memberRequest.setAddress(memberDeserializer.getAddress());
            memberRequest.setAddressPrimary(memberDeserializer.getAddressPrimary());
            memberRequest.setApplyDate(memberDeserializer.getApplyDate());
            memberRequest.setBankAccName(memberDeserializer.getBankAccName());
            memberRequest.setBankAccNo(memberDeserializer.getBankAccNo());

            BankBranch bankBranch = new BankBranch();
            if (null != memberDeserializer.getBankBranchId() && memberDeserializer.getBankBranchId() != 0) {
                bankBranch.setBranchId(memberDeserializer.getBankBranchId());
            } else {
                bankBranch = null;
            }
            memberRequest.setBankBranch(bankBranch);

            Bank bank = new Bank();
            bank.setBankCode(memberDeserializer.getBankCode());
            if (null != memberDeserializer.getBankCode() && !memberDeserializer.getBankCode().isEmpty()) {
                bank.setBankCode(memberDeserializer.getBankCode());
            } else {
                bank = null;
            }
            memberRequest.setBank(bank);

            memberRequest.setBirthDate(memberDeserializer.getBirthDate());
            memberRequest.setCitizenId(memberDeserializer.getCitizenId());
            memberRequest.setCreateBy(memberDeserializer.getCreateBy());
            memberRequest.setCreateDate(memberDeserializer.getCreateDate());
            memberRequest.setDistrict(memberDeserializer.getDistrict());
            memberRequest.setFax(memberDeserializer.getFax());
            memberRequest.setGender(memberDeserializer.getGender());
            memberRequest.setMarryStatusCode(memberDeserializer.getMarryStatusCode());
            memberRequest.setMemberCode(memberDeserializer.getMemberCode());
            memberRequest.setMemberGroupCode(memberDeserializer.getMemberGroupCode());
            memberRequest.setMemberId(memberDeserializer.getMemberId());
            //memberRequest.setMemberStatusCode(10);
            memberRequest.setMemberTypeCode(memberDeserializer.getMemberTypeCode());

            MilitaryDepartment militaryDepartment = new MilitaryDepartment();
            if (null != memberDeserializer.getMilitaryId() && memberDeserializer.getMilitaryId() != 0) {
                militaryDepartment.setMilitaryId(memberDeserializer.getMilitaryId());
            } else {
                militaryDepartment = null;
            }
            memberRequest.setMilitaryDepartment(militaryDepartment);

            memberRequest.setMobile(memberDeserializer.getMobile());
            memberRequest.setMoo(memberDeserializer.getMoo());
            memberRequest.setName(memberDeserializer.getName());
            memberRequest.setPaymentRemark(memberDeserializer.getPaymentRemark());
            memberRequest.setPaymentType(memberDeserializer.getPaymentType());
            memberRequest.setPaymentTypeCode(memberDeserializer.getPaymentTypeCode());
            memberRequest.setPermanentAddress(memberDeserializer.getPermanentAddress());
            memberRequest.setPermanentDistrict(memberDeserializer.getPermanentDistrict());
            memberRequest.setPermanentFax(memberDeserializer.getPermanentFax());
            memberRequest.setPermanentMobile(memberDeserializer.getPermanentMobile());

            Province province = new Province();
            if (null != memberDeserializer.getPermanentProvinceCode() && !memberDeserializer.getPermanentProvinceCode().isEmpty()) {
                province.setProvinceCode(memberDeserializer.getPermanentProvinceCode());
            } else {
                province = null;
            }
            memberRequest.setProvinceByPermanentProvinceCode(province);

            memberRequest.setPermanentRoad(memberDeserializer.getPermanentRoad());
            memberRequest.setPermanentSoi(memberDeserializer.getPermanentSoi());
            memberRequest.setPermanentSubdistrict(memberDeserializer.getPermanentSubdistrict());
            memberRequest.setPermanentTel(memberDeserializer.getPermanentTel());
            memberRequest.setPermanentZipcode(memberDeserializer.getPermanentZipcode());

            province = null;
            province = new Province();
            if (null != memberDeserializer.getProvinceCode() && !memberDeserializer.getProvinceCode().isEmpty()) {
                province.setProvinceCode(memberDeserializer.getProvinceCode());
            } else {
                province = null;
            }
            memberRequest.setProvinceByProvinceCode(province);

            Rank rank = new Rank();
            if (null != memberDeserializer.getRankId() && memberDeserializer.getRankId() != 0) {
                rank.setRankId(memberDeserializer.getRankId());
            } else {
                rank = null;
            }
            memberRequest.setRank(rank);

            memberRequest.setReferrerId(memberDeserializer.getReferrerId());
            memberRequest.setReferrerRelationshipCode(memberDeserializer.getReferrerRelationshipCode());
            memberRequest.setRemark(memberDeserializer.getRemark());
            memberRequest.setRoad(memberDeserializer.getRoad());
            memberRequest.setSoi(memberDeserializer.getSoi());
            memberRequest.setSubdistrict(memberDeserializer.getSubdistrict());
            memberRequest.setSurname(memberDeserializer.getSurname());
            memberRequest.setTel(memberDeserializer.getTel());

            Title title = new Title();
            if (null != memberDeserializer.getTitleId() && memberDeserializer.getTitleId() != 0) {
                title.setTitleId(memberDeserializer.getTitleId());
            } else {
                title = null;
            }
            memberRequest.setTitle(title);

            memberRequest.setUpdateBy(memberDeserializer.getUpdateBy());
            memberRequest.setUpdateDate(memberDeserializer.getUpdateDate());
            memberRequest.setWifehusbandFullname(memberDeserializer.getWifehusbandFullname());
            memberRequest.setZipcode(memberDeserializer.getZipcode());
            memberRequest.setPermanentMoo(memberDeserializer.getPermanentMoo());
            memberRequest.setCreateBy("");
            memberRequest.setCreateDate(DateUtil.getCurrentDate());
            memberRequest.setDeleteBeneficiaryId(memberDeserializer.getDeleteBeneficiaryId());

            List<MemberBeneficiary> listMemberBeneficiary = memberDeserializer.getListMemberBeneficiary();
            if (null != listMemberBeneficiary && !listMemberBeneficiary.isEmpty() && listMemberBeneficiary.size() != 0) {
                for (MemberBeneficiary memberBeneficiary : listMemberBeneficiary) {
                    rank = new Rank();
                    if (null != memberBeneficiary.getRankId() && memberBeneficiary.getRankId() != 0) {
                        rank.setRankId(memberBeneficiary.getRankId());
                    } else {
                        rank = null;
                    }
                    memberBeneficiary.setRank(rank);

                    title = new Title();
                    if (null != memberBeneficiary.getTitleId() && memberBeneficiary.getTitleId() != 0) {
                        title.setTitleId(memberBeneficiary.getTitleId());
                    } else {
                        title = null;
                    }
                    memberBeneficiary.setTitle(title);

                    province = new Province();
                    if (null != memberBeneficiary.getPermanentProvinceCode() && !memberBeneficiary.getPermanentProvinceCode().isEmpty()) {
                        province.setProvinceCode(memberBeneficiary.getPermanentProvinceCode());
                    } else {
                        province = null;
                    }
                    memberBeneficiary.setProvinceByPermanentProvinceCode(province);

                    province = new Province();
                    if (null != memberBeneficiary.getProvinceCode() && !memberBeneficiary.getProvinceCode().isEmpty()) {
                        province.setProvinceCode(memberBeneficiary.getProvinceCode());
                    } else {
                        province = null;
                    }
                    memberBeneficiary.setProvinceByProvinceCode(province);

                    listMemberBeneficiaryInsert.add(memberBeneficiary);
                }
                memberRequest.setListMemberBeneficiary(listMemberBeneficiaryInsert);
            }

            return iMemberService.setSaveEditMember(memberRequest);
        } catch (IOException ex) {
            logger.error(ex);
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/Registration/setDeleteAPP010.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setDeleteAPP010(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setUserProfileId("");
        MessageResponse messageResponse = new MessageResponse();
        logger.info(req.getItemSelect());
        try {
            messageResponse = iMemberService.setDeleteMember(req);
        } catch (Exception ex) {
            messageResponse.setMessage(ex.getMessage());
        }
        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/Registration/getListAPP010_FOR_APP040_2.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<Member> getListAPP010_FOR_APP040_2(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search));
        int memberStatusCode = 13;//Set Status 0 = ALL
        return iMemberService.getListMember(req, memberStatusCode);
    }
    
    @RequestMapping(value = "/Plugins/Registration/getListAPP010_FOR_APP040_3.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<Member> getListAPP010_FOR_APP040_3(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, @RequestParam(value = "id", defaultValue = "0") String id, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search)); 
        int operationId = Integer.parseInt(id);
        int memberStatusCode = 0;//Set Status 0 = ALL
        return iMemberService.getListMember(req, memberStatusCode, operationId);
    }
    
    @RequestMapping(value = "/Plugins/Registration/getListAPP010_FOR_REFERRER.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<Member> getListAPP010_FOR_REFERRER(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, @RequestParam(value = "id", defaultValue = "0") String id, Model model, Principal principal) {
        logger.info("APP010Controller : getListAPP010_FOR_REFERRER : id >>" + id + "<<");
        req.setSearch(Boolean.parseBoolean(search)); 
        int operationId = Integer.parseInt(id);
        int memberStatusCode = 105;//Set Status 0 = ALL
        return iMemberService.getListMember(req, memberStatusCode, operationId);
    }
}
