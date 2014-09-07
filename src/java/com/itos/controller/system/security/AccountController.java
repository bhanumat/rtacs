/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.system.security;

import java.security.Principal;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ITOS
 */
@Controller
public class AccountController extends HttpServlet {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/Login.htm", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) boolean error, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            return "redirect:/";
        }
        if (error) {
            modelMap.addAttribute("error", "เกิดข้อผิดพลาด! ไม่สามารถเข้าสู่ระบบได้");
        }
        return "Login";
    }

//    @RequestMapping(value = "/logoutSuccess")
//    public String logoutSuccess(HttpSession session, HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//
//        String sessionId = "";
//        //UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        try {
//            session = request.getSession(false);
//            //sessionId = userPrincipal.getSessionId();
//
//            System.out.println("userId : " + request.getUserPrincipal().getName());
//            System.out.println("sessionId : " + sessionId);
//            if (session != null) {
//                //-------------update user LogUserAccess : LogOut
////                LogUserAccess logUserAccess = logUserAccessService.findBysessionId(sessionId);
////                logUserAccessService.saveOrUpdate(logUserAccess, userPrincipal.getName(), new Date(), request.getRemoteAddr());
//                //-------------end of Update LogUserAccess : LogOut
//                session.invalidate(); // clear session
//            }
//            System.out.println("Logout success");
//        } catch (Exception ex) {
//            System.out.println(ex.toString());
//        } finally {
//            return "redirect:/j_spring_security_logout";
//        }
//    }
    @RequestMapping(value = "/Loginfailed.htm", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "ไม่พบชื่อผู้ใช้งานหรือรหัสผ่านไม่ถูกต้อง");
        return "Login";

    }

    @RequestMapping(value = "/Logout.htm", method = RequestMethod.GET)
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response, Authentication authentication, ModelMap model) {
        try {
            if (session != null) {
                session.invalidate(); // clear session
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            return "j_spring_security_logout";
        }
    }
}
