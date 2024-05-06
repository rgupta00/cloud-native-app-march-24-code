package com.bankapp.controller;

import com.bankapp.config.SecUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class HelloController {

    @PreAuthorize("hasAuthority('ROLE_ADMIN')") //aROUND advice
    @GetMapping(path = "admin")
    public String admin(@AuthenticationPrincipal SecUser secUser){
        System.out.println(secUser.getUsername());
        return "admin";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MGR')")
    @GetMapping(path = "mgr")
    public String mgr(){
        return "mgr";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
    @GetMapping(path = "clerk")
    public String clerk(){
        return "clerk";
    }

    @GetMapping(path = "home")
    public String home(){
        return "home";
    }
}
