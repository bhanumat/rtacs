/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.registration;

import com.itos.model.Member;
import com.itos.model.Operation;
import com.itos.model.ext.RegisterNo;
import com.itos.model.json.JsonOperation;
import com.itos.model.json.JsonRegisterNo;
import com.itos.service.model.IMemberService;
import com.itos.service.model.IOperationMemberService;
import com.itos.service.model.IOperationService;
import com.itos.util.DateUtil;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class APP040Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    IOperationService iOperationService;

    @Autowired
    IOperationMemberService iOperationMemberService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/Registration/APP040.htm")
    public String APP040(Model model, Principal principal) {
        return "/Plugins/Registration/APP040";
    }

    @RequestMapping("/Plugins/Registration/APP040_2.htm")
    public String APP040_2(Model model, Principal principal) {
        return "/Plugins/Registration/APP040_2";
    }

    @RequestMapping("/Plugins/Registration/APP040_3.htm")
    public String APP040_3(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        //data2Json;
        Operation operation = new Operation();
        try {
            operation = JsonOperation.JSONDeserializerKey(data2Json, stringDateFormat);
            model.addAttribute("operationId", operation.getOperationId());
        } catch (IOException ex) {
            logger.error(ex);
        }
        return "/Plugins/Registration/APP040_3";
    }

    @RequestMapping(value = "/Plugins/Registration/getListAPP040.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<Operation> getListAPP040(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search));
        int operationTypeCode = 20;
        return iOperationService.getListOperation(req, operationTypeCode);
    }

    @RequestMapping(value = "/Plugins/Registration/getLoadAPP040.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Operation getLoadAPP040(Operation operation, Model model, Principal principal) {
        return iOperationService.getLoadOperation(operation);
    }

    @RequestMapping(value = "/Plugins/Registration/setSaveNewAPP040_2.json", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveNewAPP040_2(MessageRequest req, Model model, Principal principal) {
        Member member;
        List<RegisterNo> listRegisterNo = new ArrayList<>();
        List<Member> listMember = new ArrayList<>();
        Operation operation = new Operation();
        int operationTypeCode = 20;
        try {
            listRegisterNo = JsonRegisterNo.JSONDeserializer(req.getDataSource(), stringDateFormat);
            operation.setOperationTypeCode(operationTypeCode);
            operation.setDocCode("");
            operation.setDocDate(DateUtil.getCurrentDate());
            operation.setCreateDate(DateUtil.getCurrentDate());

            for (RegisterNo registerNo : listRegisterNo) {
                member = new Member();
                member.setMemberStatusCode(operationTypeCode);
                member.setMemberId(registerNo.getMemberId());
                member.setMemberCode(registerNo.getMemberCode());
                member.setUpdateDate(DateUtil.getCurrentDate());
                listMember.add(member);
            }
            return iOperationMemberService.setSaveNewOperationMemberForRegisterNo(listMember, operation);
        } catch (IOException ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }
    /*
     @RequestMapping(value = "/Plugins/Registration/setSaveNewAPP040MemberOperation.json", method = {RequestMethod.POST, RequestMethod.GET},
     produces = "application/json; charset=utf-8")
     @ResponseStatus(HttpStatus.OK)
     public @ResponseBody
     MessageResponse setSaveUpdateAPP040MemberOperation(@RequestParam(value = "member") String operation, Model model, Principal principal) {
     Member memberRequest = new Member();
     return iMemberService.setSaveUpdateMemberOperation(memberRequest);
     }
     */
}
