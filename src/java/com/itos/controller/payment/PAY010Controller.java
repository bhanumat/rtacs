package com.itos.controller.payment;

import com.itos.dao.model.IMemberDAO;
import com.itos.model.Member;
import com.itos.model.MemberPayment;
import com.itos.model.ext.MemberPaymentDto;
import com.itos.model.ext.PaymentMember;
import com.itos.service.model.IMemberPaymentService;
import com.itos.service.model.IMemberService;
import com.itos.service.model.IOperationMemberService;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import java.security.Principal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author bhanumat.w
 */
@Controller
public class PAY010Controller {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private IMemberPaymentService iMemberPaymentService;
    
    @Autowired
    IMemberService iMemberService;

    @RequestMapping("/Plugins/Payment/PAY010.htm")
    public String getPagePAY010(Model model, Principal principal) {
        return "/Plugins/Payment/PAY010";
    }

    @RequestMapping("/Plugins/Payment/PAY010_1.htm")
    public String getPagePAY010_1(Model model, Principal principal) {
        return "/Plugins/Payment/PAY010_1";
    }
    
    @RequestMapping(value = "/Plugins/Payment/getListPAY010.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<MemberPaymentDto> getListPAY010(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("info PAY010Controller : getListPAY010: search >>" + search + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        JqGridResponse<MemberPaymentDto> resMemberPayments = iMemberPaymentService.searchMemberPayment(req);
        return resMemberPayments;
    }
    
    @RequestMapping(value = "/Plugins/Payment/getListMemberPAY010_1.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<Member> searchMember(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("PAY010Controller : searchMember");
        req.setSearch(Boolean.parseBoolean(search));
        return iMemberService.getListMember(req);
    }
    
    @RequestMapping(value = "/Plugins/Payment/getMemberPayment.json", method = {RequestMethod.POST},
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MemberPayment getMemberPayment(@RequestParam(value = "paymentId") int paymentId) {
        logger.info("PAY010Controller : searchMember");
//        req.setSearch(Boolean.parseBoolean(search));
        return iMemberPaymentService.getMemberPayment(paymentId);
    }
}
