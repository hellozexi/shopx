package com.mikey.shopx.service;

import com.mikey.shopx.model.User;
import com.mikey.shopx.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User getCurrentUser() {
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principle instanceof UserDetails) {
            String userName = ((UserDetails) principle).getUsername();
            User user = userRepo.findByUserName(userName);
            return user;
        }
        return null;
    }

    public String getCurrentUserName() {
        if(getCurrentUser() != null) {
            return getCurrentUser().getUserName();
        } else {
            return null;
        }

    }
}
