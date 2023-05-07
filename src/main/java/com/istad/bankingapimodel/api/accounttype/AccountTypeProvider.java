package com.istad.bankingapimodel.api.accounttype;

import org.apache.ibatis.jdbc.SQL;

public class AccountTypeProvider {
    public String buildSelectSQL(){
        return new SQL(){{
            SELECT("*");
            FROM ("Account_types");
        }}.toString();
    }
}
