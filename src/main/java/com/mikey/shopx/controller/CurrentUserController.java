package com.mikey.shopx.controller;


import com.mikey.shopx.Security.CurrentUser;
import com.mikey.shopx.Security.UserPrincipal;
import com.mikey.shopx.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.mysql.cj.conf.PropertyKey.logger;

@Controller
@RequestMapping("/api")
public class CurrentUserController {
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/user/me")
    public ResponseEntity<?> currentUserName(@CurrentUser UserPrincipal currentuser) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity(currentuser.getUsername(), HttpStatus.OK);
    }
}