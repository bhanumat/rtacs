/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.querydata;

import com.itos.model.Member;
import com.itos.model.MemberBeneficiary;
import com.itos.model.ext.MemberData;
import com.itos.model.ext.MemberDeptHistoryView;
import com.itos.model.ext.MemberPaymentTypeHistoryView;
import com.itos.model.ext.MemberStatusView;
import com.itos.model.ext.PaymentView;
import com.itos.model.json.JsonMember;
import com.itos.service.model.IMemberBeneficiaryService;
import com.itos.service.model.IMemberDeptHistoryViewService;
import com.itos.service.model.IMemberPaymentTypeHistoryViewService;
import com.itos.service.model.IMemberService;
import com.itos.service.model.IMemberStatusViewService;
import com.itos.service.model.IPaymentViewService;
import com.itos.util.ConstantsMessage;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
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
public class QRY010Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    IMemberService iMemberService;

    @Autowired
    IMemberBeneficiaryService iMemberBeneficiaryService;

    @Autowired
    IPaymentViewService iPaymentViewService;

    @Autowired
    IMemberStatusViewService iMemberStatusViewService;

    @Autowired
    IMemberDeptHistoryViewService iMemberDeptHistoryViewService;

    @Autowired
    IMemberPaymentTypeHistoryViewService iMemberPaymentTypeHistoryViewService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/QueryData/QRY010.htm")
    public String QRY010(Model model, Principal principal) {
        return "/Plugins/QueryData/QRY010";
    }

    @RequestMapping(value = "/Plugins/QueryData/getLoadQRY010.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse getLoadQRY010(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Member member = new Member();
        MessageResponse messageResponse = new MessageResponse();
        try {
            member = JsonMember.JSONDeserializerKey(data2Json, stringDateFormat);
            messageResponse.setObj(iMemberService.getLoadMember(member));
            if (null != messageResponse.getObj()) {
                messageResponse.setCheckSuccess(true);
            } else {
                messageResponse.setCheckSuccess(false);
                messageResponse.setMessage(ConstantsMessage.SearchNotfound);
            }

        } catch (Exception ex) {
            messageResponse.setMessage(ex.getMessage());
        }
        return messageResponse;
    }
    
    @RequestMapping(value = "/Plugins/QueryData/getListQRY010_Search.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MemberData> getListQRY010_Search(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, @RequestParam(value = "id", defaultValue = "0") String id, Model model, Principal principal) {
        logger.info("QRY010Controller : getListQRY010_Search : id >>" + id + "<<");
        req.setSearch(Boolean.parseBoolean(search)); 
        int operationId = Integer.parseInt(id);
        int operationTypeCode = 0;//Set Status 0 = ALL
        return iMemberService.getListMember(req, operationTypeCode, operationId);
    }

    @RequestMapping(value = "/Plugins/QueryData/getListMemberBeneficiaryQRY010.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<MemberBeneficiary> getListMemberBeneficiaryQRY010(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Member member = new Member();
        try {
            member = JsonMember.JSONDeserializerKey(data2Json, stringDateFormat);
            return iMemberBeneficiaryService.getListMemberBeneficiaryByMember(member);
        } catch (IOException ex) {
            return null;
        }
    }

    @RequestMapping(value = "/Plugins/QueryData/getListPaymentViewQRY010.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<PaymentView> getListPaymentViewQRY010(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, @RequestParam(value = "id", defaultValue = "0") String id, Model model, Principal principal) {
        logger.info("QRY010Controller : getListPaymentViewQRY010 : id >>" + id + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        int memberId = Integer.parseInt(null == id ? "0" : !id.isEmpty() ? id : "0");
        logger.info("QRY010Controller : getListPaymentViewQRY010 : memberId >>" + memberId + "<<");
        return iPaymentViewService.getList(req, memberId);
    }

    @RequestMapping(value = "/Plugins/QueryData/getListMemberStatusViewQRY010.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MemberStatusView> getListMemberStatusViewQRY010(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, @RequestParam(value = "id", defaultValue = "0") String id, Model model, Principal principal) {
        logger.info("QRY010Controller : getListMemberStatusViewQRY010 : id >>" + id + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        int memberId = Integer.parseInt(null == id ? "0" : !id.isEmpty() ? id : "0");
        logger.info("QRY010Controller : getListMemberStatusViewQRY010 : memberId >>" + memberId + "<<");
        return iMemberStatusViewService.getList(req, memberId);
    }

    @RequestMapping(value = "/Plugins/QueryData/getListMemberDeptHistoryViewQRY010.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MemberDeptHistoryView> getListMemberDeptHistoryViewQRY010(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, @RequestParam(value = "id", defaultValue = "0") String id, Model model, Principal principal) {
        logger.info("QRY010Controller : getListMemberDeptHistoryViewQRY010 : id >>" + id + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        int memberId = Integer.parseInt(null == id ? "0" : !id.isEmpty() ? id : "0");
        logger.info("QRY010Controller : getListMemberDeptHistoryViewQRY010 : memberId >>" + memberId + "<<");
        return iMemberDeptHistoryViewService.getList(req, memberId);
    }

    @RequestMapping(value = "/Plugins/QueryData/getListMemberPaymentTypeHistoryViewQRY010.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MemberPaymentTypeHistoryView> getListMemberPaymentTypeHistoryViewQRY010(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, @RequestParam(value = "id", defaultValue = "0") String id, Model model, Principal principal) {
        logger.info("QRY010Controller : getListMemberPaymentTypeHistoryViewQRY010 : id >>" + id + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        int memberId = Integer.parseInt(null == id ? "0" : !id.isEmpty() ? id : "0");
        logger.info("QRY010Controller : getListMemberPaymentTypeHistoryViewQRY010 : memberId >>" + memberId + "<<");
        return iMemberPaymentTypeHistoryViewService.getList(req, memberId);
    }
}
