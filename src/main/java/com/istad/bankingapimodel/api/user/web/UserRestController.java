package com.istad.bankingapimodel.api.user.web;

import com.github.pagehelper.PageInfo;
import com.istad.bankingapimodel.api.user.User;
import com.istad.bankingapimodel.api.user.UserService;
import com.istad.bankingapimodel.api.user.web.SaveUserDto;
import com.istad.bankingapimodel.base.BaseApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
@RestController

public class UserRestController {
    final private UserService userService;

    @GetMapping
    public BaseApi<?> findWithPaging(@RequestParam(required = false, defaultValue = "1") int pageNum,
                                     @RequestParam(required = false, defaultValue = "25") int pageSize) {

        PageInfo<UserDto> userDtoPageInfo = userService.findWithPaging(pageNum, pageSize);

        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Users have been found")
                .timeStamp(LocalDateTime.now())
                .data(userDtoPageInfo)
                .build();
    }

    @GetMapping("/{id}")
    public BaseApi<?> findById(@PathVariable Integer id) {
        UserDto userDto = userService.findById(id);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been found")
                .timeStamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

    @PutMapping("/{id}")
    public BaseApi<?> updateById(@PathVariable Integer id,
                                 @Valid @RequestBody SaveUserDto saveUserDto) {

        UserDto userDto = userService.updateById(id, saveUserDto);

        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been saved")
                .timeStamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }


    @PostMapping
    public BaseApi<?> create(@Valid @RequestBody SaveUserDto saveUserDto){
        UserDto userDto = userService.create(saveUserDto);
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been saved")
                .timeStamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

}
