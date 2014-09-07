/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.masterdata;

import com.itos.model.Bank;
import com.itos.model.BankAccountType;
import com.itos.model.BankBranch;
import com.itos.model.MilitaryDepartment;
import com.itos.model.json.JsonMilitaryDepartment;
import com.itos.service.model.IMilitaryDepartmentService;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.io.IOException;
import java.security.Principal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class MAS010Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    IMilitaryDepartmentService IMilitaryDepartmentService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/MasterData/MAS010.htm")
    public String MAS010(Model model, Principal principal) {
        return "/Plugins/MasterData/MAS010";
    }

    @RequestMapping(value = "/Plugins/MasterData/getListMAS010.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MilitaryDepartment> getListMAS010(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search));
        return IMilitaryDepartmentService.getListMilitaryDepartment(req);
    }

    @RequestMapping(value = "/Plugins/MasterData/setDeleteMAS010.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setDeleteMAS010(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setUserProfileId("");
        MessageResponse messageResponse = new MessageResponse();
        logger.info(req.getItemSelect());
        try {
            messageResponse = IMilitaryDepartmentService.setDeleteMilitaryDepartment(req);
        } catch (Exception ex) {
            messageResponse.setMessage(ex.getMessage());
        }
        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/MasterData/setSaveNewMAS010.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveNewMAS010(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        MilitaryDepartment militaryDepartment = new MilitaryDepartment();
        try {
            militaryDepartment = JsonMilitaryDepartment.JSONDeserializer(data2Json, stringDateFormat);
            Bank bank = new Bank();
            bank.setBankCode(militaryDepartment.getBankCode());
            militaryDepartment.setBank(bank);
            BankBranch bankBranch = new BankBranch();
            bankBranch.setBranchId(militaryDepartment.getBranchId());
            militaryDepartment.setBankBranch(bankBranch);
            BankAccountType bankAccountType = new BankAccountType();
            bankAccountType.setAccTypeId(militaryDepartment.getBankAccTypeId());
            militaryDepartment.setBankAccountType(bankAccountType);
            return IMilitaryDepartmentService.setSaveNewMilitaryDepartment(militaryDepartment);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/MasterData/setSaveEditMAS010.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveEditMAS010(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        MilitaryDepartment militaryDepartment = new MilitaryDepartment();
        try {
            militaryDepartment = JsonMilitaryDepartment.JSONDeserializer(data2Json, stringDateFormat);
            Bank bank = new Bank();
            bank.setBankCode(militaryDepartment.getBankCode());
            militaryDepartment.setBank(bank);
            BankBranch bankBranch = new BankBranch();
            bankBranch.setBranchId(militaryDepartment.getBranchId());
            militaryDepartment.setBankBranch(bankBranch);
            BankAccountType bankAccountType = new BankAccountType();
            bankAccountType.setAccTypeId(militaryDepartment.getBankAccTypeId());
            militaryDepartment.setBankAccountType(bankAccountType);
            return IMilitaryDepartmentService.setSaveEditMilitaryDepartment(militaryDepartment);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/MasterData/getLoadMAS010.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MilitaryDepartment getLoadMAS010(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        MilitaryDepartment militaryDepartment = new MilitaryDepartment();
        try {
            militaryDepartment = JsonMilitaryDepartment.JSONDeserializerKey(data2Json, stringDateFormat);
            return IMilitaryDepartmentService.getLoadMilitaryDepartment(militaryDepartment);
        } catch (IOException ex) {
            return null;
        }
    }
}
