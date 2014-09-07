package com.itos.controller.payment;

import java.security.Principal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bhanumat.w
 */
@Controller
public class PAY010Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping("/Plugins/Payment/PAY010.htm")
    public String getPagePAY020(Model model, Principal principal) {
        return "/Plugins/Payment/PAY010";
    }
    
     @RequestMapping("/Plugins/Payment/PAY010_1.htm")
    public String getPagePAY020_1(Model model, Principal principal) {
        return "/Plugins/Payment/PAY010_1";
    }
}
