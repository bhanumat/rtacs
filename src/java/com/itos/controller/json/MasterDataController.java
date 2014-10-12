/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.json;

import com.itos.enums.MemberStatusEnum;
import com.itos.model.Bank;
import com.itos.model.BankAccountType;
import com.itos.model.BankBranch;
import com.itos.model.ControlPayment;
import com.itos.model.MilitaryDepartment;
import com.itos.model.Province;
import com.itos.model.Rank;
import com.itos.model.Title;
import com.itos.model.ext.MemberStatusCode;
import com.itos.model.ext.PaymentMonthCode;
import com.itos.service.model.IBankAccountTypeService;
import com.itos.service.model.IBankBranchService;
import com.itos.service.model.IBankService;
import com.itos.service.model.IControlPaymentService;
import com.itos.service.model.IMilitaryDepartmentService;
import com.itos.service.model.IProvinceService;
import com.itos.service.model.IRankService;
import com.itos.service.model.ITitleService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author SPIDERMANX
 */
@Controller
public class MasterDataController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    IBankService iBankService;

    @Autowired
    IBankBranchService iBankBranchService;

    @Autowired
    IBankAccountTypeService iBankAccountTypeService;

    @Autowired
    IProvinceService iProvinceService;

    @Autowired
    IRankService iRankService;

    @Autowired
    ITitleService iTitleService;

    @Autowired
    IControlPaymentService iControlPaymentService;

    @Autowired
    IMilitaryDepartmentService iMilitaryDepartmentService;

    @RequestMapping(value = "/Plugins/MasterData/getListInJSONBankAccountType.json", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<BankAccountType> getListInJSONBankAccountType(Model model, Principal principal) {
        List<BankAccountType> listBankAccountType = new ArrayList<>();
        listBankAccountType = iBankAccountTypeService.getListInJSONBankAccountType('E');
        return listBankAccountType;
    }

    @RequestMapping(value = "/Plugins/MasterData/getListInJSONBank.json", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Bank> getListInJSONBank(Model model, Principal principal) {
        List<Bank> listBank = new ArrayList<>();
        listBank = iBankService.getListInJSONBank('E');
        return listBank;
    }

    @RequestMapping(value = "/Plugins/MasterData/getListInJSONBankBranch.json", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<BankBranch> getListInJSONBankBranch(Model model, Principal principal) {
        List<BankBranch> listBankBranch = new ArrayList<>();
        listBankBranch = iBankBranchService.getListInJSONBankBranch('E');
        return listBankBranch;
    }

    @RequestMapping(value = "/Plugins/MasterData/getListInJSONProvince.json", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Province> getListInJSONProvince(Model model, Principal principal) {
        List<Province> listProvince = new ArrayList<>();
        listProvince = iProvinceService.getListInJSONProvince('E');
        return listProvince;
    }

    @RequestMapping(value = "/Plugins/MasterData/getListInJSONRank.json", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Rank> getListInJSONRank(Model model, Principal principal) {
        List<Rank> listRank = new ArrayList<>();
        listRank = iRankService.getListInJSONRank('E');
        return listRank;
    }

    @RequestMapping(value = "/Plugins/MasterData/getListInJSONTitle.json", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Title> getListInJSONTitle(Model model, Principal principal) {
        List<Title> listTitle = new ArrayList<>();
        listTitle = iTitleService.getListInJSONTitle('E');
        return listTitle;
    }

    @RequestMapping(value = "/Plugins/MasterData/getListInJSONMilitaryDepartment.json", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<MilitaryDepartment> getListInJSONMilitaryDepartment(Model model, Principal principal) {
        List<MilitaryDepartment> listMilitaryDepartment = new ArrayList<>();
        listMilitaryDepartment = iMilitaryDepartmentService.getListInJSONMilitaryDepartment('E');
        return listMilitaryDepartment;
    }

    @RequestMapping(value = "/Plugins/MasterData/getMilitaryDepartments.json", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<MilitaryDepartment> getMilitaryDepartments(Model model, Principal principal) {
        return iMilitaryDepartmentService.getMilitaryDepartments('E');
    }

    @RequestMapping(value = "/Plugins/MasterData/getMemberStatusCodes.json", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<MemberStatusCode> getMemberStatusCodes(Model model, Principal principal) {
        List<MemberStatusCode> list = new ArrayList<>();
        for (MemberStatusEnum col : MemberStatusEnum.values()) {
            list.add(new MemberStatusCode(col.getCode(), col.getName()));
        }
        return list;
    }

    @RequestMapping(value = "/Plugins/MasterData/getControlPaymentMonthCodes.json", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<ControlPayment> getControlPaymentMonthCodes(Model model, Principal principal) {
        return iControlPaymentService.getMonthCodes();
    }

}
