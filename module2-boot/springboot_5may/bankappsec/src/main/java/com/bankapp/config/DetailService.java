package com.bankapp.config;

import com.bankapp.entites.UserEntity;
import com.bankapp.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class DetailService implements UserDetailsService {

    //spring sec is going to call this method
    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=userService.findByUsername(username);
        if(userEntity==null){
            throw new UsernameNotFoundException("username/password is not correct");
        }
        //UserEntity is not understood by spring sec...i need to covert UserEntity to the user that spring sec understand
        return new SecUser(userEntity);
    }
}



