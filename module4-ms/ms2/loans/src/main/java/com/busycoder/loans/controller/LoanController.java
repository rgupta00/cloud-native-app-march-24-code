package com.busycoder.loans.controller;

import com.busycoder.loans.dto.InfoDto;
import com.busycoder.loans.dto.LoanDto;
import com.busycoder.loans.services.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RefreshScope //?
public class LoanController {
    private final LoanService loanService;
    private final InfoDto infoDto;

    @GetMapping("loans")
    public LoanDto getByMobile( @RequestParam(name="mobile") String mobile){
        return loanService.findByMobile(mobile);
    }
    @GetMapping("contact-info")
    public InfoDto getInfoDto(){
        return infoDto;
    }


}
