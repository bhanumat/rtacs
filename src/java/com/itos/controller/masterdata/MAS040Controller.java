/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.masterdata;

import com.itos.model.Bank;
import com.itos.model.json.JsonBank;
import com.itos.service.model.IBankService;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MAS040Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    IBankService iBankService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/MasterData/MAS040.htm")
    public String MAS040(Model model, Principal principal) {
        return "/Plugins/MasterData/MAS040";
    }

    @RequestMapping(value = "/Plugins/MasterData/getListMAS040.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<Bank> getListMAS040(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search));
        return iBankService.getListBank(req);
    }

    @RequestMapping(value = "/Plugins/MasterData/setDeleteMAS040.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setDeleteMAS040(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setUserProfileId("");
        MessageResponse messageResponse = new MessageResponse();
        logger.info(req.getItemSelect());
        try {
            messageResponse = iBankService.setDeleteBank(req);
        } catch (Exception ex) {
            messageResponse.setMessage(ex.getMessage());
        }
        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/MasterData/setSaveNewMAS040.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveNewMAS040(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Bank bank = new Bank();
        try {
            bank = JsonBank.JSONDeserializer(data2Json, stringDateFormat);
            return iBankService.setSaveNewBank(bank);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/MasterData/setSaveEditMAS040.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveEditMAS040(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Bank bank = new Bank();
        try {
            bank = JsonBank.JSONDeserializer(data2Json, stringDateFormat);
            return iBankService.setSaveEditBank(bank);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/MasterData/getLoadMAS040.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Bank getLoadMAS040(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Bank bank = new Bank();
        try {
            bank = JsonBank.JSONDeserializerKey(data2Json, stringDateFormat);
            return iBankService.getLoadBank(bank);
        } catch (IOException ex) {
            return null;
        }
    }
}
