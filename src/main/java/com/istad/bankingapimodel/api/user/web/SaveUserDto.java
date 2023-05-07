package com.istad.bankingapimodel.api.user.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record SaveUserDto(@NotBlank(message = "Name is required !!")
                          @Size(min = 5,max = 10)
                          String name,
                          @NotBlank(message = "Gender is required!!")
                          String gender,
                          @NotNull(message = "Are you Student or not?")
                          Boolean isStudent,
                          String studentCardId) {
}
