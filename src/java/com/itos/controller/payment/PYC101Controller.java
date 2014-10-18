package com.itos.controller.payment;

import com.itos.model.ext.DeptPaymentDto;
import com.itos.service.model.IMemberPaymentService;
import com.itos.service.model.IMemberService;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import java.security.Principal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    
    
     @RequestMapping(value = "/Plugins/Payment/getListDeptMemberPayment.json", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<DeptPaymentDto> getListDeptMemberPayment(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("search Dept Member Payment>>" + req.getSearchCommand() + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        JqGridResponse<DeptPaymentDto> gridResponse = iMemberPaymentService.searchDeptPayment(req);
        logger.info("Found "+ gridResponse.getRecords() + " records.");
        return gridResponse;
    }
    
}
