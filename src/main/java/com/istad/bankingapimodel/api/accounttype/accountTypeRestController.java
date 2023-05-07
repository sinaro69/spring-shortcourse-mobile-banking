package com.istad.bankingapimodel.api.accounttype;

import com.istad.bankingapimodel.base.BaseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/account-types")
@RequiredArgsConstructor
public class accountTypeRestController {

    private final AccountTypeService accountTypeService;

    @GetMapping
    public BaseApi<?> getAllAccountTypes(){
        List<AccountTypeDto> accountTypeDtos = accountTypeService.getAllAccountTypes();
        return BaseApi.builder().status(true).code(HttpStatus.OK.value()).message("AccountType have been found!").timeStamp(LocalDateTime.now()).build();
    }
}
