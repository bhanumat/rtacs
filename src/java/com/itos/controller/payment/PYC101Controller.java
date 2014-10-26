package com.itos.controller.payment;

import com.itos.model.ext.DeptMemberPaymentDto;
import com.itos.model.ext.DeptPaymentDto;
import com.itos.service.model.IMemberPaymentService;
import com.itos.service.model.IMemberService;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import java.security.Principal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
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
    public String getPagePAY010_1(@RequestParam Integer deptpaymentId, 
            Model model, Principal principal) {
        String page = "/Plugins/Payment/PYC101_1";
        logger.info("get Page >>" + page + "<<");
        if (deptpaymentId != null) {
            logger.info("deptpaymentId : >>" + deptpaymentId + "<<");
            model.addAttribute("deptpaymentId", deptpaymentId);
            
            Locale localeTH = new Locale("th", "TH");
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", localeTH);
            SimpleDateFormat sdfMMyy = new SimpleDateFormat("MMM yyyy", localeTH);
            DecimalFormat df = new DecimalFormat("#,##0.00");
            
            JqGridRequest req = new JqGridRequest();
            req.setSidx("paymentDate");
            req.setSord("asc");
            req.setPage(1);
            req.setRows(1);
            req.setSearchCommand("{\"conditions\":[{\"groupOp\":\"\",\"field\":\"deptpaymentId\",\"op\":\"eq\",\"data\":" + deptpaymentId.toString() + ",\"dataType\":\"integer\"}]}");
            req.setSearchField("deptpayment_id");
            req.setSearchString(deptpaymentId.toString());
            
            DeptPaymentDto deptPayment = iMemberPaymentService.getDeptPayment(req);
            model.addAttribute("mildeptName", deptPayment.getMildeptName());
            model.addAttribute("paymentDate", sdf.format(deptPayment.getPaymentDate()));
            model.addAttribute("budgetMonth", sdfMMyy.format(deptPayment.getBudgetMonth()));
            model.addAttribute("createdDate", sdf.format(deptPayment.getCreatedDate()));
            model.addAttribute("totalAmount", df.format(deptPayment.getTotalAmount()));
            model.addAttribute("numMember", deptPayment.getNumMember());
            model.addAttribute("numMemberIn", deptPayment.getNumMemberIn());
            model.addAttribute("numMemberOut", deptPayment.getNumMemberOut());
            model.addAttribute("remark", deptPayment.getRemark());
        } else {
            logger.info("deptpaymentId : >>is null<<");
        }
        return page;
    }
    
    
    @RequestMapping(value = "/Plugins/Payment/searchDeptPayment.json", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<DeptPaymentDto> searchDeptPayment(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("search Dept Member Payment>>" + req.getSearchCommand() + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        JqGridResponse<DeptPaymentDto> gridResponse = iMemberPaymentService.searchDeptPayment(req);
        logger.info("Found "+ gridResponse.getRecords() + " records.");
        return gridResponse;
    }
    
    @RequestMapping(value = "/Plugins/Payment/getListDeptMemberPayment.json", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    JqGridResponse<DeptMemberPaymentDto> getListDeptMemberPayment(JqGridRequest req, @RequestParam(value = "_search", defaultValue = "false") String search, Model model, Principal principal) {
        logger.info("search Dept Member Payment>>" + req.getSearchCommand() + "<<");
        req.setSearch(Boolean.parseBoolean(search));
        JqGridResponse<DeptMemberPaymentDto> gridResponse = iMemberPaymentService.getListDeptMemberPayment(req);
        logger.info("Found "+ gridResponse.getRecords() + " records.");
        return gridResponse;
    }
    
}
