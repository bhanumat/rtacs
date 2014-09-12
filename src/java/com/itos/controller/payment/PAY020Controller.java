/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.payment;

import com.itos.model.ControlReceipt;
import com.itos.model.Member;
import com.itos.model.Operation;
import com.itos.model.OperationMember;
import com.itos.model.ext.PaymentDetail;
import com.itos.model.ext.PaymentMember;
import com.itos.model.json.JsonOperationMember;
import com.itos.service.model.IControlMemberService;
import com.itos.service.model.IControlReceiptService;
import com.itos.service.model.IMemberService;
import com.itos.service.model.IOperationMemberService;
import com.itos.service.model.IOperationService;
import com.itos.util.ConstantsMessage;
import com.itos.util.DateUtil;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Principal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class PAY020Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @Autowired
    IOperationMemberService iOperationMemberService;

    @Autowired
    IMemberService iMemberService;

    @Autowired
    IControlMemberService iControlMemberService;

    @Autowired
    IControlReceiptService iControlReceiptService;

    @Autowired
    IOperationService iOperationService;

    @RequestMapping("/Plugins/Payment/PAY020.htm")
    public String PAY020(Model model, Principal principal) {
        return "/Plugins/Payment/PAY020";
    }

    @RequestMapping(value = "/Plugins/Payment/getListPAY020.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<PaymentMember> getListPAY020(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("TeTe info PAY020Controller : getListPAY020: search >>" + search + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        return iOperationMemberService.getListPaymentMember(req);
    }

    @RequestMapping("/Plugins/Payment/PAY020_1.htm")
    public String PAY020_1(Model model, Principal principal) {
        logger.info("TeTe info PAY020Controller : PAY020_1");
        return "/Plugins/Payment/PAY020_1";
    }

    @RequestMapping(value = "/Plugins/Payment/TOPAY020_1.htm", method = RequestMethod.POST)
    public String TOPAY020_1(@ModelAttribute("operationMemberId") String operationMemberId, Model model, Principal principal) {
        logger.info("TeTe info PAY020Controller : TOPAY020_1");
        if (operationMemberId != null) {
            logger.info("operationMemberId : >>" + operationMemberId + "<<");
            model.addAttribute("operationMemberId", operationMemberId);
        } else {
            logger.info("operationMemberId : >>is null<<");
        }
        return "/Plugins/Payment/PAY020_1";
    }

    @RequestMapping(value = "/Plugins/Payment/setDeletePAY020.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse setDeletePAY020(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("PAY020Controller : setDeletePAY020");
        req.setUserProfileId("");
        MessageResponse messageResponse = new MessageResponse();
        logger.info(req.getItemSelect());
        try {
            messageResponse = iOperationMemberService.setDeleteOperationMember(req);
        } catch (Exception ex) {
            messageResponse.setMessage(ex.getMessage());
        }
        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/Payment/cancelPAY020.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse cancelPAY020(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("PAY020Controller : cancelPAY020");
        req.setUserProfileId("");
        MessageResponse messageResponse = new MessageResponse();
        //logger.info(req.getItemSelect());
        try {
            messageResponse = iOperationMemberService.cancelBill(req);
        } catch (Exception ex) {
            messageResponse.setMessage(ex.getMessage());
        }
        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/Payment/getSearchPAY020_1.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse getSearchPAY020_1(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("PAY020Controller : getSearchPAY020_1");
        MessageResponse messageResponse = new MessageResponse();
        req.setUserProfileId("");
        PaymentDetail paymentDetail = new PaymentDetail();
        String citizenId = "";
        if (req.getItemSelect() != null && req.getItemSelect().size() > 0) {
            for (String item : req.getItemSelect()) {
                citizenId = item;
                break;
            }
        }
        try {
            paymentDetail = iMemberService.searchMemberFromCitisenId(citizenId);
            if (null != paymentDetail) {
                if (paymentDetail.getStatus() == 10) {
                    paymentDetail.setDocCode(iControlReceiptService.getDocumentCode());
                }
                paymentDetail.setBillAmount(iControlMemberService.getLastApplyFee());
                messageResponse.setCheckSuccess(Boolean.TRUE);
                messageResponse.setMessage(ConstantsMessage.SaveSuccessful);
                messageResponse.setObj(paymentDetail);
            } else {
                messageResponse.setCheckSuccess(Boolean.FALSE);
                messageResponse.setMessage(ConstantsMessage.SearchNotfound);
            }
        } catch (Exception ex) {
            logger.info("error : " + ex);
            messageResponse.setCheckSuccess(Boolean.FALSE);
            messageResponse.setMessage("Error : " + ex);
        }

        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/Payment/onLoadPAY020_1.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse onLoadPAY020_1(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("PAY020Controller : onLoadPAY020_1");
        MessageResponse messageResponse = new MessageResponse();
        req.setUserProfileId("");
        BigDecimal amount = new BigDecimal(BigInteger.ZERO);
        //String docCode = "";
        try {
            amount = iControlMemberService.getLastApplyFee();
            //docCode= iControlReceiptService.getDocumentCode();
        } catch (Exception ex) {
            logger.info("error : " + ex);
            messageResponse.setCheckSuccess(Boolean.FALSE);
            messageResponse.setMessage("Error : " + ex);
            return messageResponse;
        }

        messageResponse.setCheckSuccess(Boolean.TRUE);
        messageResponse.setMessage("" + (amount != null ? amount : BigDecimal.ZERO));
        // messageResponse.setId(docCode);
        return messageResponse;
    }

    @RequestMapping(value = "/Plugins/Payment/addNewPAY020_1.json", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse addNewPAY020_1(@RequestParam(value = "operation") String operation, Model model, Principal principal) {
        logger.info("PAY020Controller : addNewPAY020_1");
        Member memberResponse = new Member();
        MessageResponse operationMemberMessageResponse = new MessageResponse();
        Operation operationResponse = new Operation();
        Operation operationRequest = new Operation();
        ControlReceipt receipt = new ControlReceipt();

        OperationMember operationMemberModify = JsonOperationMember.JSONDeserializerPayment(operation, stringDateFormat);

//        operationRequest.setOperationId(operationMemberModify.getOperationId());
        operationRequest.setOperationTypeCode(11);
        operationRequest.setDocCode(operationMemberModify.getDocCode());
        operationRequest.setDocDate(operationMemberModify.getDocDate());
        operationRequest.setAmount(operationMemberModify.getAmount());
        operationRequest.setCreateDate(DateUtil.getCurrentDate());
        operationRequest.setPrintedStatus('N');

        memberResponse = iMemberService.updateMemberStatus(operationMemberModify.getCitizenId());
        operationResponse = iOperationService.saveNewOperation(operationRequest);
        receipt = iControlReceiptService.updateMemberStatus(1);
        if (null != receipt) {
            System.out.println("new runningNo : >>" + receipt.getRunningNo() + "<<");
        }
        OperationMember operationMemberRequest = new OperationMember();
        operationMemberRequest.setMember(memberResponse);
        operationMemberRequest.setOperation(operationResponse);
        operationMemberMessageResponse = iOperationMemberService.savePaymentNewOperationMember(operationMemberRequest);
        logger.info("save success");

        return operationMemberMessageResponse;
    }

    @RequestMapping(value = "/Plugins/Payment/searchByOperationMemberId.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse searchByOperationMemberId(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("PAY020Controller : searchByOperationMemberId");
        MessageResponse messageResponse = new MessageResponse();
        PaymentDetail paymentDetail = new PaymentDetail();
        String operationMemberId = "";
        if (req.getItemSelect() != null && req.getItemSelect().size() > 0) {
            for (String item : req.getItemSelect()) {
                operationMemberId = item;
                break;
            }
        }
        try {
            paymentDetail = iOperationMemberService.searchPaymentDetail(operationMemberId);
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
}
