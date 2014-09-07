/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.registration;

import com.itos.model.OperationMember;
import com.itos.model.json.JsonOperationMember;
import com.itos.service.model.IOperationMemberService;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageResponse;
import java.io.IOException;
import com.itos.util.DateUtil;
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
public class APP043Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    IOperationMemberService iOperationMemberService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/Registration/APP043.htm")
    public String APP041(Model model, Principal principal) {
        return "/Plugins/Registration/APP043";
    }

    @RequestMapping(value = "/Plugins/Registration/getListAPP043.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<OperationMember> getListAPP043(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search));
//        StringBuilder command = new StringBuilder();
//        String field = "operationTypeCode";
//        String value = "25";
//        command.append("{\"conditions\":[{\"groupOp\":\"");
//        if (null == req.getSearchCommand() || req.getSearchCommand().isEmpty()) {
//            command.append("");
//        } else {
//            command.append("AND");
//        }
//        command.append("\",\"field\":\"");
//        command.append(field);
//        command.append("\",\"op\":\"eq\",\"data\":");
//        command.append(value);
//        command.append(",\"dataType\":\"integer\"}]}");
//        if (null != req.getSearchCommand() || !req.getSearchCommand().isEmpty()) {
//            String replaceAll;
//            replaceAll = command.toString().replaceAll("{\"conditions\":[", "");
//            //req.getSearchCommand().substring(0, req.getSearchCommand().length());
//        }
//        req.setSearchCommand(command.toString());
        return iOperationMemberService.getListOperationMember(req);
    }
    
    @RequestMapping(value = "/Plugins/Registration/setSaveApproveAPP043.json", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveApproveAPP043(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        MessageResponse messageResponse = new MessageResponse();
        logger.info(data2Json);
        try {
            OperationMember operationmember = new OperationMember();
            OperationMember opermemberDeserializer = JsonOperationMember.JSONDeserializer(data2Json, stringDateFormat);
            
            operationmember.setOperationTypeCode(opermemberDeserializer.getOperationTypeCode());
            operationmember.setDocDate(opermemberDeserializer.getDocDate());
            operationmember.setApplyDate(DateUtil.getCurrentDate());
            operationmember.setItemSelect(opermemberDeserializer.getItemSelect());
            operationmember.setItemSelect2(opermemberDeserializer.getItemSelect2());
            messageResponse = iOperationMemberService.setSaveApproveOperationMember(operationmember);
        } catch (Exception ex) {
            logger.error(ex);
            return new MessageResponse(false, ex.getMessage());
        }
        return messageResponse;
    }
}
