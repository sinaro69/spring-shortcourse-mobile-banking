package com.istad.bankingapimodel.api.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String gender;
    private String oneSignalId;
    private Boolean isDeleted;
    private Boolean isStudent;
    private String studentCardId;

}

