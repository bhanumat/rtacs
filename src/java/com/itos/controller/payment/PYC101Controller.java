package com.itos.controller.payment;

import com.itos.service.model.IMemberPaymentService;
import com.itos.service.model.IMemberService;
import java.security.Principal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bhanumat.w
 */
@Controller
public class PYC101Controller {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private IMemberPaymentService iMemberPaymentService;

    @Autowired
    IMemberService iMemberService;

    @Value("${application.DateFormat}")
    private String stringDateFormat;
//
    @RequestMapping("/Plugins/Payment/PYC101.htm")
    public String getPagePAY010(Model model, Principal principal) {
        String page = "/Plugins/Payment/PYC101";
        logger.info("get Page >>" + page + "<<");
        return page;
    }

    @RequestMapping("/Plugins/Payment/PYC101_1.htm")
    public String getPagePAY010_1(Model model, Principal principal) {
        String page = "/Plugins/Payment/PYC101_1";
        logger.info("get Page >>" + page + "<<");
        return page;
    }
}
