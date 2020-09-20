package com.mou.mapper;

import com.mou.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    int insertUser(User user);

    int deleteUserById(int id);

    int insertUser2(Map<String, Object> map);
}
