package com.mikey.shopx.Security;

import com.mikey.shopx.model.User;
import com.mikey.shopx.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service()
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEamil) throws UsernameNotFoundException {
        User user = userRepo.findByUserNameOrEmail(usernameOrEamil, usernameOrEamil)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email:" + usernameOrEamil));
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("user not found with id : " + id)
        );
        return UserPrincipal.create(user);
    }

}
