package com.springapp.mvc;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/12/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class RegAppAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        AuthorityUtils AuthorityUtils;
        Set<String> roles = org.springframework.security.core.authority.AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if(roles.contains("ROLE_REGISTRATOR")){
               httpServletResponse.sendRedirect("Registrator/");
        }
        if(roles.contains("ROLE_PATIENT")){
               httpServletResponse.sendRedirect("Patient/");
        }
    }
}
