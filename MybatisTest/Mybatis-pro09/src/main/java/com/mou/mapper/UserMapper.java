package com.mou.mapper;

import com.mou.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUsers(Map map);

    User getUserById(@Param("id") int id);
}
