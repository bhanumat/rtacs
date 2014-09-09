/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.registration;

import com.itos.model.Member;
import com.itos.model.Operation;
import com.itos.model.OperationMember;
import com.itos.model.json.JsonOperation;
import com.itos.model.json.JsonOperationMember;
import com.itos.model.json.JsonRegisterNo;
import com.itos.service.model.IOperationMemberService;
import com.itos.util.DateUtil;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.mapping.Array;
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
public class APP043Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    IOperationMemberService iOperationMemberService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/Registration/APP043.htm")
    public String APP043(Model model, Principal principal) {
        return "/Plugins/Registration/APP043";
    }

    @RequestMapping(value = "/Plugins/Registration/getListAPP043.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<OperationMember> getListAPP043(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search));
        int memberStatusCode = 25;//Set Status 0 = ALL
        return iOperationMemberService.getListOperationMember(req, memberStatusCode);
    }

    @RequestMapping(value = "/Plugins/Registration/setSaveApproveAPP043.json", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveApproveAPP043(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Member member;
        List<OperationMember> listOperationMember = new ArrayList<>();
        List<Member> listMember = new ArrayList<>();
        Operation operation = new Operation();
        try {
            listOperationMember = JsonOperationMember.JSONDeserializerArray(data2Json, stringDateFormat);
            Operation operationDeserializer = JsonOperation.JSONDeserializer(data2Json, stringDateFormat);
            operation.setOperationTypeCode(operationDeserializer.getOperationTypeCode());
            operation.setDocCode(operationDeserializer.getDocCode());
            operation.setDocDate(operationDeserializer.getDocDate());
            operation.setCreateDate(DateUtil.getCurrentDate());

            for (OperationMember operationMember : listOperationMember) {
                member = new Member();
                member.setMemberStatusCode(operationDeserializer.getOperationTypeCode());
                member.setMemberId(operationMember.getMemberId());
                member.setUpdateDate(DateUtil.getCurrentDate());
                listMember.add(member);
            }
            return iOperationMemberService.setSaveApproveOperationMemberList(listMember, operation);
        } catch (Exception ex) {
            return new MessageResponse(false, ex.getMessage());
        }
    }
}
