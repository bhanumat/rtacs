/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.registration;

import com.itos.model.Member;
import com.itos.model.Operation;
import com.itos.model.OperationMember;
import com.itos.model.ext.MemberData;
import com.itos.model.ext.OperationView;
import com.itos.model.ext.PaymentDetail;
import com.itos.model.json.JsonMember;
import com.itos.model.json.JsonOperation;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class APP031Controller {

    protected final Log logger = LogFactory.getLog(getClass());
    private static final Locale ENG_LOCALE = new Locale("en", "EN");
    private static final SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy", ENG_LOCALE);

    @Autowired
    IOperationService iOperationService;

    @Autowired
    IMemberService iMemberService;

    @Autowired
    IOperationMemberService iOperationMemberService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/Registration/APP031.htm")
    public String APP031(Model model, Principal principal) {
        return "/Plugins/Registration/APP031";
    }

    @RequestMapping(value = "/Plugins/Registration/getListAPP031.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<OperationView> getListAPP031(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        req.setSearch(Boolean.parseBoolean(search));
        return iOperationService.getListOperationAPP031(req);
    }

    @RequestMapping(value = "/Plugins/Registration/setSaveNewAPP031.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setSaveNewAPP031(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("APP031Controller : setSaveNewAPP031");
        req.setUserProfileId("");
        MessageResponse messageResponse = new MessageResponse();
        logger.info("ItemSelect : " + req.getItemSelect());
        List<Integer> itemSelect = new ArrayList<Integer>();
        Member memberResponse = new Member();
        OperationMember operationMember = null;
        Operation operation = new Operation();
        Operation operationResponse = new Operation();
        if (req.getItemSelect() != null && req.getItemSelect().size() > 0) {
            for (String item : req.getItemSelect()) {
                itemSelect.add(Integer.parseInt(item));
            }
        }
        try {
            Operation operationRequest = new Operation();
            operationRequest = JsonOperation.JSONDeserializerAPP031(req.getDataSource(), stringDateFormat);
            operationRequest.setItemSelect(itemSelect);
            logger.info("docCode : >>" + operationRequest.getDocCode() + "<<");
            logger.info("docDate : >>" + operationRequest.getDocDate() + "<<");
            logger.info("itemSelect : >>" + operationRequest.getItemSelect() + "<<");

            operation.setOperationTypeCode(13);
            operation.setDocCode(operationRequest.getDocCode());
            operation.setDocDate(operationRequest.getDocDate());
            operation.setCreateDate(DateUtil.getCurrentDate());
            operationResponse = iOperationService.saveNewOperation(operation);
            if (operationRequest.getItemSelect() != null && operationRequest.getItemSelect().size() > 0) {
                for (Integer memberId : operationRequest.getItemSelect()) {
                    memberResponse = iMemberService.updateMemberStatusAPP031(memberId);
                    logger.info("memberResponse status : >>" + memberResponse.getMemberStatusCode() + "<<");
                    operationMember = new OperationMember();
                    operationMember.setMember(memberResponse);
                    operationMember.setOperation(operationResponse);
                    messageResponse = iOperationMemberService.savePaymentNewOperationMember(operationMember);
                    if (!messageResponse.getCheckSuccess()) {
                        messageResponse.setMessage("Can not Save");
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            messageResponse.setMessage(ex.getMessage());
        }
        messageResponse.setId("" + operationResponse.getOperationId());
        return messageResponse;
    }

    //APP031_2
    @RequestMapping("/Plugins/Registration/APP031_2.htm")
    public String APP031_2(Model model, Principal principal) {
        return "/Plugins/Registration/APP031_2";
    }

    @RequestMapping(value = "/Plugins/Registration/APP031_1.htm")
    public String APP031_1(@ModelAttribute("operationId") String operationId, Model model, Principal principal) {
        logger.info("TeTe info APP031Controller : APP031_1");
        if (operationId != null) {
            logger.info("operationId : >>" + operationId + "<<");
            model.addAttribute("operationId", operationId);
        } else {
            logger.info("operationId : >>is null<<");
        }
        return "/Plugins/Registration/APP031_1";
    }

    @RequestMapping(value = "/Plugins/Registration/getListAPP031_2.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MemberData> getListAPP031_2(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("TeTe info APP031Controller : getListAPP031_2 : search >>" + search + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        int operationId = 0;
        int operationTypeCode = 13;//Set Status 0 = ALL
        return iMemberService.getListMember(req, operationTypeCode, operationId);
    }

    @RequestMapping(value = "/Plugins/Registration/getAddListAPP031_2.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MemberData> getAddListAPP031_2(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("TeTe info APP031Controller : getAddListAPP031_2 : search >>" + search + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        int memberStatusCode = 11;//Set Status 0 = ALL
        return iMemberService.getListMemberStatus(req, memberStatusCode);
    }

    @RequestMapping(value = "/Plugins/Registration/APP030_searchByOperationId.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse searchByOperationIdAPP030(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("APP031Controller : searchByOperationId");
        MessageResponse messageResponse = new MessageResponse();
        Operation operation = new Operation();
        PaymentDetail paymentDetail = new PaymentDetail();
        String operationId = "";
        if (req.getItemSelect() != null && req.getItemSelect().size() > 0) {
            for (String item : req.getItemSelect()) {
                operationId = item;
                operation.setOperationId(Integer.parseInt(operationId));
                break;
            }
        }
        try {
            operation = iOperationService.getLoadOperation(operation);
            paymentDetail.setDocCode(operation.getDocCode());
            paymentDetail.setDateString(reverseFormatDate(operation.getDocDate()));
        } catch (Exception ex) {
            logger.info("error : " + ex);
            messageResponse.setCheckSuccess(Boolean.FALSE);
            messageResponse.setMessage("Error : " + ex);
            return messageResponse;
        }

        messageResponse.setCheckSuccess(Boolean.TRUE);
        messageResponse.setMessage("SUSCESS");
        messageResponse.setObj(paymentDetail);
        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/Registration/getLoadAPP031.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Operation getLoadAPP031(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        Operation operation = new Operation();
        try {
            operation = JsonOperation.JSONDeserializerKey(data2Json, stringDateFormat);
            return iOperationService.getLoadOperation(operation);
        } catch (IOException ex) {
            return null;
        }
    }

    @RequestMapping(value = "/Plugins/Registration/getListAPP031_1.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MemberData> getListAPP031_1(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, @RequestParam(value = "id", defaultValue = "0") String id, Model model, Principal principal) {
        logger.info("TeTe info APP031Controller : getListAPP031_1 : search >>" + search + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        int operationId = Integer.parseInt(id);
        int operationTypeCode = 13;//Set Status 0 = ALL
        return iMemberService.getListMember(req, operationTypeCode, operationId);
    }

    private String reverseFormatDate(Date date) {
        if (date == null) {
            return null;
        }
        String result = sf.format(date);
        return result;
    }
}
