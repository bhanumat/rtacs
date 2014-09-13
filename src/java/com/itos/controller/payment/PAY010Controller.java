package com.itos.controller.payment;

import com.itos.service.model.IMemberPaymentService;
import java.security.Principal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bhanumat.w
 */
@Controller
public class PAY010Controller {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private IMemberPaymentService iMemberPaymentService;

    @RequestMapping("/Plugins/Payment/PAY010.htm")
    public String getPagePAY020(Model model, Principal principal) {
        return "/Plugins/Payment/PAY010";
    }

    @RequestMapping("/Plugins/Payment/PAY010_1.htm")
    public String getPagePAY020_1(Model model, Principal principal) {
        return "/Plugins/Payment/PAY010_1";
    }
}
