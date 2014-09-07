/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.webpage;

import java.security.Principal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ITOS
 */
@Controller
public class HomeController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping("/Pages/Home.htm")
    public String Home(Model model, Principal principal) {
        String name = principal.getName();
        model.addAttribute("userName", name);
        model.addAttribute("message", "Spring Security Custom Form example");
        return "/Pages/Home";
    }
    
    @RequestMapping("/Pages/mainPage.htm")
    public String MainPage(Model model, Principal principal) {
        return "/Pages/mainPage";
    }
}
