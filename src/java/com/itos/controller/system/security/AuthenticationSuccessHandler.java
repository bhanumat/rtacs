/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.system.security;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 *
 * @author ITOS
 */
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        saveLogUserAccess(request, response, authentication);
        super.onAuthenticationSuccess(request, response, authentication);
    }

    // Insert Log User Login to System --------------------------------------
    public void saveLogUserAccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        try {
//                UserPrincipal userPrincipal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//                LogUserAccess logUserAccess = new LogUserAccess();
//                        
//                logUserAccess.setClientIpAddress(request.getRemoteAddr());
//                logUserAccess.setClientName(request.getRemoteHost());
//                logUserAccess.setLoginStatus((String)"Y");
//                logUserAccess.setUrl(request.getRequestURI());
//                logUserAccess.setUserid(userPrincipal.getName());
//                logUserAccess.setSessionId(userPrincipal.getSessionId());
//                logUserAccessService.save(logUserAccess, userPrincipal.getName(), new Date(), request.getRemoteAddr());
        } catch (Exception ex) {
            logger.error(ex);
        }
    }
}
