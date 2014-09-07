/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.masterdata;

import com.itos.model.Title;
import com.itos.model.json.JsonTitle;
import com.itos.service.model.ITitleService;
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
public class MAS020Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    ITitleService iTitleService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/MasterData/MAS020.htm")
    public String MAS020(Model model, Principal principal) {
        return "/Plugins/MasterData/MAS020";
    }

    @RequestMapping(value = "/Plugins/MasterData/getListMAS020.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<Title> getListMAS020(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search));
        return iTitleService.getListTitle(req);
    }

    @RequestMapping(value = "/Plugins/MasterData/setDeleteMAS020.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setDeleteMAS020(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setUserProfileId("");
        MessageResponse messageResponse = new MessageResponse();
        logger.info(req.getItemSelect());
        try {
            messageResponse = iTitleService.setDeleteTitle(req);
        } catch (Exception ex) {
            messageResponse.setMessage(ex.getMessage());
        }
        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/MasterData/setSaveNewMAS020.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveNewMAS020(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Title title = new Title();
        try {
            title = JsonTitle.JSONDeserializer(data2Json, stringDateFormat);
            return iTitleService.setSaveNewTitle(title);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/MasterData/setSaveEditMAS020.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveEditMAS020(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Title title = new Title();
        try {
            title = JsonTitle.JSONDeserializer(data2Json, stringDateFormat);
            return iTitleService.setSaveEditTitle(title);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/MasterData/getLoadMAS020.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Title getLoadMAS020(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Title title = new Title();
        try {
            title = JsonTitle.JSONDeserializerKey(data2Json, stringDateFormat);
            return iTitleService.getLoadTitle(title);
        } catch (IOException ex) {
            return null;
        }
    }
}
