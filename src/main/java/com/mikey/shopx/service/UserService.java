package com.mikey.shopx.service;

import com.mikey.shopx.model.User;
import com.mikey.shopx.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;


    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = auth.getName();
        //String currentUserName = userPrincipal.getUsername();
        User currentUser = userRepo.findByUserName(currentUserName);
        return currentUser;
    }

}
