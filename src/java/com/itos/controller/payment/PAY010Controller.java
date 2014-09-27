package com.itos.controller.payment;

import com.itos.model.Member;
import com.itos.model.MemberPayment;
import com.itos.model.ext.MemberData;
import com.itos.model.ext.MemberPaymentDto;
import com.itos.model.ext.MemberPaymentHeadDto;
import com.itos.util.jsonObject.MemberPaymentRequest;
import com.itos.model.json.JsonMember;
import com.itos.service.model.IMemberPaymentService;
import com.itos.service.model.IMemberService;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author bhanumat.w
 */
@Controller
public class PAY010Controller {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private IMemberPaymentService iMemberPaymentService;

    @Autowired
    IMemberService iMemberService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;

    @RequestMapping("/Plugins/Payment/PAY010.htm")
    public String getPagePAY010(Model model, Principal principal) {
        String page = "/Plugins/Payment/PAY010";
        logger.info("get Page >>" + page + "<<");
        return page;
    }

    @RequestMapping("/Plugins/Payment/PAY010_1.htm")
    public String getPagePAY010_1(Model model, Principal principal) {
        String page = "/Plugins/Payment/PAY010_1";
        logger.info("get Page >>" + page + "<<");
        return page;
    }

    @RequestMapping(value = "/Plugins/Payment/getListMemberPayment.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MemberPaymentDto> getListMemberPayment(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("search Member Payment>>" + req.getSearchCommand() + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        JqGridResponse<MemberPaymentDto> resMemberPayments = iMemberPaymentService.searchMemberPayment(req);
        return resMemberPayments;
    }

    @RequestMapping(value = "/Plugins/Payment/getMembers.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MemberData> getMembers(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("search member >>" + req.getSearchCommand() + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        return iMemberService.getListMember(req);
    }

    @RequestMapping(value = "/Plugins/Payment/getListMemberPAY010_1.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MemberPaymentHeadDto> getListMemberPayment010_1(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("search Member Payment 010_1>>" + req.getSearchCommand() + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        JqGridResponse<MemberPaymentHeadDto> resMemberPayments = iMemberPaymentService.getMemberPaymentByCode(req);
        return resMemberPayments;
    }

    @RequestMapping(value = "/Plugins/Payment/getMemberPAY010_1.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MemberData getMember(@RequestParam(value = "data2Json") String data2Json, Model model, Principal principal) {
        try {
            Member member = JsonMember.JSONDeserializerKey(data2Json, stringDateFormat);
            return iMemberService.getLoadMember(member);
        } catch (IOException ex) {
            logger.equals(ex);
        }
        return null;
    }

    @RequestMapping(value = "/Plugins/Payment/getMemberPayment.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MemberPayment getMemberPayment(@RequestParam(value = "paymentId") int paymentId) {
        logger.info("get MemberPayment ID >>" + paymentId + "<<");
        return iMemberPaymentService.getMemberPayment(paymentId);
    }

    @RequestMapping(value = "/Plugins/Payment/deleteMemberPayment.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse removeMemberPayment(MessageRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("Ids selected >>" + req.getItemSelect() + "<<");
        req.setUserProfileId("");
        return iMemberPaymentService.removeMemberPayment(req);
    }

    @RequestMapping(value = "/Plugins/Payment/updateMemberPayment.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MessageResponse updateMemberPayment( @RequestBody MemberPaymentRequest req, Model model, Principal principal) {
        logger.info("updateMemberPayment req >>" + req + "<<");
//        logger.info("Data to save Member Payment >>" + data2Json + "<<");
//        MemberPaymentDto memberDeserializer = JsonUtil.parse(data2Json, MemberPaymentHeadDto.class);
//        return iMemberPaymentService.updateMemberPayment(req);
        return null;
    }
}
