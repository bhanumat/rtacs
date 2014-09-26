/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.payment;

import com.itos.model.Member;
import com.itos.model.Operation;
import com.itos.model.OperationMember;
import com.itos.model.ext.MemberData;
import com.itos.model.ext.PaymentMilitary;
import com.itos.model.json.JsonPaymentMilitary;
import com.itos.service.model.IControlMemberService;
import com.itos.service.model.IControlReceiptService;
import com.itos.service.model.IMemberService;
import com.itos.service.model.IOperationMemberService;
import com.itos.service.model.IOperationService;
import com.itos.util.ConstantsMessage;
import com.itos.util.DateUtil;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageResponse;
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
public class PAY021Controller {

    protected final Log logger = LogFactory.getLog(getClass());
    private static final Locale ENG_LOCALE = new Locale("en", "EN");
    private static final SimpleDateFormat sf = new SimpleDateFormat("ddMMyy", ENG_LOCALE);
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

    @RequestMapping("/Plugins/Payment/PAY021.htm")
    public String PAY021(Model model, Principal principal) {
        return "/Plugins/Payment/PAY021";
    }

    @RequestMapping(value = "/Plugins/Payment/getPAY021List.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<PaymentMilitary> getPAY021List(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("PAY021Controller : getPAY021List");
        req.setSearch(Boolean.parseBoolean(search));
        return iMemberService.getPaymentMilitaryList(req);
    }
    
    @RequestMapping(value = "/Plugins/Payment/TOPAY021_1.htm", method = RequestMethod.POST)
    public String TOPAY021_1(@ModelAttribute("militaryId") String militaryId
                            ,@ModelAttribute("militaryName") String militaryName
                            ,@ModelAttribute("militaryDate") String militaryDate
                            ,@ModelAttribute("militaryMember") String militaryMember
                            ,@ModelAttribute("militarySumAmount") String militarySumAmount, Model model, Principal principal) {
        logger.info("TeTe info PAY021Controller : TOPAY021_1");
        if (militaryId != null && militaryName!=null && militaryDate!=null) {
            model.addAttribute("militaryId", militaryId);
            model.addAttribute("militaryName", militaryName);
            model.addAttribute("militaryDate", militaryDate);
            model.addAttribute("militaryMember", militaryMember);
            model.addAttribute("militarySumAmount", militarySumAmount);
        } else {
            logger.info("parameter : >>is null<<");
        }
        return "/Plugins/Payment/PAY021_1";
    }
    
    @RequestMapping(value = "/Plugins/Payment/getPAY021_1List.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MemberData> getPAY021_1List(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("PAY021Controller : getPAY021_1List");
        req.setSearch(Boolean.parseBoolean(search));
        return iMemberService.getListMember(req);
    }
    
    @RequestMapping(value = "/Plugins/Payment/savePAY021_1.json", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse savePAY021_1(@RequestParam(value = "paymentMilitary") String paymentMilitary, Model model, Principal principal) {
        logger.info("PAY021Controller : savePAY021_1");
        
        MessageResponse paymentMilitaryMessageResponse = new MessageResponse();

        PaymentMilitary paymentMilitaryModify = JsonPaymentMilitary.JSONDeserializer(paymentMilitary, stringDateFormat);
        
        String dateString = formatDate(paymentMilitaryModify.getDocDate());
        String docCode = paymentMilitaryModify.getMilitaryId() + " " + dateString;
        List<String> memberIdList = new ArrayList<String>();
        int length = paymentMilitaryModify.getMemberIdList().length();
        String tempString = paymentMilitaryModify.getMemberIdList().substring(0, length-1);
        String[] split = tempString.split(",");
        if(split!=null&&split.length>0){
            for(String t:split){
                memberIdList.add(t);
            }
        }
        int success = 0;
        Operation operationRequest = new Operation();
        Operation operationResponse = new Operation();
        operationRequest.setOperationTypeCode(11);
        operationRequest.setDocCode(docCode);
        operationRequest.setDocDate(DateUtil.getCurrentDate());
        operationRequest.setAmount(paymentMilitaryModify.getSumAmount());
        operationRequest.setCreateDate(DateUtil.getCurrentDate());
        operationRequest.setPrintedStatus('N');
        operationResponse = iOperationService.saveNewOperation(operationRequest);
        
        for(String t:memberIdList){
            Member memberResponse = new Member();
            memberResponse = iMemberService.updatedMemberPAY021_1(t);
            
            OperationMember operationMemberRequest = new OperationMember();
            operationMemberRequest.setMember(memberResponse);
            operationMemberRequest.setOperation(operationResponse);
            MessageResponse messageResponse = iOperationMemberService.savePaymentNewOperationMember(operationMemberRequest);
            if(ConstantsMessage.SaveSuccessful.equalsIgnoreCase(messageResponse.getMessage())){
                success++;
            }
        }
        if(success == memberIdList.size()){
            logger.info("save success");
            paymentMilitaryMessageResponse.setMessage(ConstantsMessage.SaveSuccessful);
            paymentMilitaryMessageResponse.setCheckSuccess(true);
        }else{
            logger.info("save unsuccess");
            paymentMilitaryMessageResponse.setMessage(ConstantsMessage.SaveUnsuccessful);
            paymentMilitaryMessageResponse.setCheckSuccess(false);
        }
        return paymentMilitaryMessageResponse;
    }
    
    private String formatDate(Date date) {
        if (date == null)
            return "";
        
        String result = sf.format(date);
        return result;
    }
}
