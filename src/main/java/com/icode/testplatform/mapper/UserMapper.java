package com.icode.testplatform.mapper;

import com.icode.testplatform.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    int insertUser(@Param("user")User user);
    User selectByUserNameAndPwd(@Param("user")User user);

    User selectById(@Param("userId")Long userID);


}
