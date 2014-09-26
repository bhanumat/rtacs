/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.ChangeData;

import com.itos.model.ext.ChangeMemberData;
import com.itos.service.model.IMemberService;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.CHT010Request;
import com.itos.util.jsonObject.MessageResponse;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class CHT010Controller {

    protected final Log logger = LogFactory.getLog(getClass());
    
    private static final Locale ENG_LOCALE = new Locale("en", "EN");
    private static final SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy", ENG_LOCALE);
    
    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @Autowired
    IMemberService iMemberService;
    
    @RequestMapping("/Plugins/ChangeData/CHT010.htm")
    public String CHT010(Model model, Principal principal) {
        //logger.info("CHT010Controller : CHT010");
        return "/Plugins/ChangeData/CHT010";
    }

    @RequestMapping(value = "/Plugins/ChangeData/loadCHT010.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<ChangeMemberData> loadCHT010(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        //logger.info("CHT010Controller : loadCHT010");
        req.setSearch(Boolean.parseBoolean(search));
        return iMemberService.getChangeMemberList(req);
    }
    
    @RequestMapping(value = "/Plugins/ChangeData/confirmCHT010.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse confirmCHT010(CHT010Request req, Model model, Principal principal) {
        //logger.info("CHT010Controller : confirmCHT010");
        MessageResponse messageResponse = new MessageResponse();
        //logger.info(req.getItemSelect());
        try {
            messageResponse = iMemberService.updatedCHT010(req);
        } catch (Exception ex) {
            messageResponse.setMessage(ex.getMessage());
        }
        return messageResponse;
    }
    
}
