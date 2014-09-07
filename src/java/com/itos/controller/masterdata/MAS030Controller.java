/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.masterdata;

import com.itos.model.Rank;
import com.itos.model.json.JsonRank;
import com.itos.service.model.IRankService;
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
public class MAS030Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    IRankService IRankService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/MasterData/MAS030.htm")
    public String MAS030(Model model, Principal principal) {
        return "/Plugins/MasterData/MAS030";
    }

    @RequestMapping(value = "/Plugins/MasterData/getListMAS030.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<Rank> getListMAS030(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search));
        return IRankService.getListRank(req);
    }

    @RequestMapping(value = "/Plugins/MasterData/setDeleteMAS030.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setDeleteMAS030(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setUserProfileId("");
        MessageResponse messageResponse = new MessageResponse();
        logger.info(req.getItemSelect());
        try {
            messageResponse = IRankService.setDeleteRank(req);
        } catch (Exception ex) {
            messageResponse.setMessage(ex.getMessage());
        }
        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/MasterData/setSaveNewMAS030.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveNewMAS030(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Rank rank = new Rank();
        try {
            rank = JsonRank.JSONDeserializer(data2Json, stringDateFormat);
            return IRankService.setSaveNewRank(rank);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/MasterData/setSaveEditMAS030.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveEditMAS030(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Rank rank = new Rank();
        try {
            rank = JsonRank.JSONDeserializer(data2Json, stringDateFormat);
            return IRankService.setSaveEditRank(rank);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }

    @RequestMapping(value = "/Plugins/MasterData/getLoadMAS030.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Rank getLoadMAS030(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Rank rank = new Rank();
        try {
            rank = JsonRank.JSONDeserializerKey(data2Json, stringDateFormat);
            return IRankService.getLoadRank(rank);
        } catch (IOException ex) {
            return null;
        }
    }
}
