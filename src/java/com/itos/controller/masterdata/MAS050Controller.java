/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.masterdata;

import com.itos.model.Bank;
import com.itos.model.BankAccountType;
import com.itos.model.json.JsonBankAccountType;
import com.itos.service.model.IBankAccountTypeService;
import com.itos.service.model.IBankService;
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
public class MAS050Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    IBankAccountTypeService iBankAccountTypeService;

    @Autowired
    IBankService iBankService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/MasterData/MAS050.htm")
    public String MAS040(Model model, Principal principal) {
        return "/Plugins/MasterData/MAS050";
    }

    @RequestMapping(value = "/Plugins/MasterData/getListMAS050.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<BankAccountType> getListMAS050(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search));
        return iBankAccountTypeService.getListBankAccountType(req);
    }

    @RequestMapping(value = "/Plugins/MasterData/setDeleteMAS050.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setDeleteMAS050(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setUserProfileId("");
        MessageResponse messageResponse = new MessageResponse();
        logger.info(req.getItemSelect());
        try {
            messageResponse = iBankAccountTypeService.setDeleteBankAccountType(req);
        } catch (Exception ex) {
            messageResponse.setMessage(ex.getMessage());
        }
        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/MasterData/setSaveNewMAS050.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveNewMAS050(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        BankAccountType bankAccountType = new BankAccountType();
        try {
            bankAccountType = JsonBankAccountType.JSONDeserializer(data2Json, stringDateFormat);
            Bank bank = new Bank();
            bank.setBankCode(bankAccountType.getBankCode());
            bankAccountType.setBank(bank);
            return iBankAccountTypeService.setSaveNewBankAccountType(bankAccountType);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/MasterData/setSaveEditMAS050.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveEditMAS050(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        BankAccountType bankAccountType = new BankAccountType();
        try {
            bankAccountType = JsonBankAccountType.JSONDeserializer(data2Json, stringDateFormat);
            Bank bank = new Bank();
            bank.setBankCode(bankAccountType.getBankCode());
            bankAccountType.setBank(bank);
            return iBankAccountTypeService.setSaveEditBankAccountType(bankAccountType);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/MasterData/getLoadMAS050.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    BankAccountType getLoadMAS050(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        BankAccountType bankAccountType = new BankAccountType();
        try {
            bankAccountType = JsonBankAccountType.JSONDeserializerKey(data2Json, stringDateFormat);
            return iBankAccountTypeService.getLoadBankAccountType(bankAccountType);
        } catch (IOException ex) {
            return null;
        }
    }
}
