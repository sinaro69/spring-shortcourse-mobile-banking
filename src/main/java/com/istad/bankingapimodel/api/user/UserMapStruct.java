package com.istad.bankingapimodel.api.user;

import com.github.pagehelper.PageInfo;
import com.istad.bankingapimodel.api.user.web.SaveUserDto;
import com.istad.bankingapimodel.api.user.web.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User saveUserDtoToUser(SaveUserDto dto);

    UserDto userToUserDto(User user);
    PageInfo<UserDto> userPageInfoToUserDtoPageInfo(PageInfo<User> model);
}
