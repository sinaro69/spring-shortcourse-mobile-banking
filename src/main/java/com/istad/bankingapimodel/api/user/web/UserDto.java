package com.istad.bankingapimodel.api.user.web;

public record UserDto(Integer id,
                      String name,
                      String gender,
                      Boolean isStudent,
                      String studentCardId
                      ) {
}
