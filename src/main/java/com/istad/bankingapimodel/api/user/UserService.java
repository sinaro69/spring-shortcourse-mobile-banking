package com.istad.bankingapimodel.api.user;

import com.github.pagehelper.PageInfo;
import com.istad.bankingapimodel.api.user.web.SaveUserDto;
import com.istad.bankingapimodel.api.user.web.UserDto;

public interface UserService {

     PageInfo<UserDto> findWithPaging(int pageNum, int pageSize);
     UserDto create(SaveUserDto saveUserDto);
     UserDto findById(Integer id);

     UserDto updateById(Integer id, SaveUserDto saveUserDto);
}
