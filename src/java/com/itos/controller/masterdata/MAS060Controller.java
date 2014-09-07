/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.masterdata;

import com.itos.model.Bank;
import com.itos.model.BankBranch;
import com.itos.model.json.JsonBankBranch;
import com.itos.service.model.IBankBranchService;
import com.itos.service.model.IBankService;
import com.itos.service.model.IProvinceService;
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
public class MAS060Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    IBankBranchService iBankBranchService;

    @Autowired
    IBankService iBankService;

    @Autowired
    IProvinceService iProvinceService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/MasterData/MAS060.htm")
    public String MAS040(Model model, Principal principal) {
        return "/Plugins/MasterData/MAS060";
    }

    @RequestMapping(value = "/Plugins/MasterData/getListMAS060.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<BankBranch> getListMAS060(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search));
        return iBankBranchService.getListBankBranch(req);
    }

    @RequestMapping(value = "/Plugins/MasterData/setDeleteMAS060.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setDeleteMAS060(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setUserProfileId("");
        MessageResponse messageResponse = new MessageResponse();
        logger.info(req.getItemSelect());
        try {
            messageResponse = iBankBranchService.setDeleteBankBranch(req);
        } catch (Exception ex) {
            messageResponse.setMessage(ex.getMessage());
        }
        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/MasterData/setSaveNewMAS060.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveNewMAS060(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        BankBranch bankBranch = new BankBranch();
        try {
            bankBranch = JsonBankBranch.JSONDeserializer(data2Json, stringDateFormat);
            Bank bank = new Bank();
            bank.setBankCode(bankBranch.getBankCode());
            bankBranch.setBank(bank);
            return iBankBranchService.setSaveNewBankBranch(bankBranch);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/MasterData/setSaveEditMAS060.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveEditMAS060(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        BankBranch bankBranch = new BankBranch();
        try {
            bankBranch = JsonBankBranch.JSONDeserializer(data2Json, stringDateFormat);
            Bank bank = new Bank();
            bank.setBankCode(bankBranch.getBankCode());
            bankBranch.setBank(bank);
            return iBankBranchService.setSaveEditBankBranch(bankBranch);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/MasterData/getLoadMAS060.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    BankBranch getLoadMAS060(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        BankBranch bankBranch = new BankBranch();
        try {
            bankBranch = JsonBankBranch.JSONDeserializerKey(data2Json, stringDateFormat);
            return iBankBranchService.getLoadBankBranch(bankBranch);
        } catch (IOException ex) {
            return null;
        }
    }
}
