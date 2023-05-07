package com.istad.bankingapimodel.api.user;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface UserMapper {
    @UpdateProvider(type = UserProvider.class, method = "buildUpdateSql")
    void update(@Param("u") User user);

    @Select("SELECT EXISTS(SELECT * FROM users WHERE id = #{id} AND is_deleted = FALSE)")
    boolean existsById(@Param("id") Integer id);

    @InsertProvider(type = UserProvider.class,
            method = "buildInsertSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("u") User user);

    @SelectProvider(type = UserProvider.class,
            method = "buildSelectByIdSql")
    @Results(id = "userResultMap", value = {
            @Result(column = "is_student", property = "isStudent"),
            @Result(column = "student_card_id", property = "studentCardId")
    })
    Optional<User> selectById(@Param("id") Integer id);

    @SelectProvider(type = UserProvider.class,method = "buildSelectWithPagingSql")
    @ResultMap("userResultMap")
    List<User> selectWithPaging();




}
