package com.istad.bankingapimodel.api.accounttype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class AccountTypeServiceIMPL implements AccountTypeService{

    private final AccountTypeMapper accountTypeMapper;
    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        List<AccountTypes> accountTypes = accountTypeMapper.findAllAccountTypes();
        return accountTypes.stream().map(new Function<AccountTypes, AccountTypeDto>() {

            @Override
            public AccountTypeDto apply(AccountTypes accountTypes1) {
                return new AccountTypeDto((accountTypes1.getName()));
            }
        }).toList();
    }
}
