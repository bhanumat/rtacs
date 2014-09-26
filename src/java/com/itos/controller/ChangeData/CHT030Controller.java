/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.ChangeData;

import com.itos.model.ext.ChangeMemberData;
import com.itos.model.ext.MemberTotalDetail;
import com.itos.service.model.IMemberService;
import com.itos.util.ConstantsMessage;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
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
public class CHT030Controller {

    protected final Log logger = LogFactory.getLog(getClass());
    
    private static final Locale ENG_LOCALE = new Locale("en", "EN");
    private static final SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy", ENG_LOCALE);
    
    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @Autowired
    IMemberService iMemberService;
    
    @RequestMapping("/Plugins/ChangeData/CHT030.htm")
    public String CHT030(Model model, Principal principal) {
        //logger.info("CHT030Controller : CHT030");
        return "/Plugins/ChangeData/CHT030";
    }
    
    @RequestMapping(value = "/Plugins/ChangeData/searchCHT030.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse searchCHT030(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        //logger.info("CHT030Controller : searchCHT030");
        MessageResponse messageResponse = new MessageResponse();
        MemberTotalDetail memberTotalDetail = iMemberService.searchCHT030(req);
        if (null != memberTotalDetail) {
                messageResponse.setCheckSuccess(Boolean.TRUE);
                messageResponse.setMessage(ConstantsMessage.SaveSuccessful);
                messageResponse.setObj(memberTotalDetail);
            } else {
                messageResponse.setCheckSuccess(Boolean.FALSE);
                messageResponse.setMessage(ConstantsMessage.SearchNotfound);
            }
        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/ChangeData/gridTab4CHT030.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<ChangeMemberData> gridTab4CHT030(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        //logger.info("CHT010Controller : loadCHT010");
        req.setSearch(Boolean.parseBoolean(search));
        return iMemberService.getChangeMemberList(req);
    }
}
