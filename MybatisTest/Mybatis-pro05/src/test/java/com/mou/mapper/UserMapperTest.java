package com.mou.mapper;

import com.mou.pojo.User;
import com.mou.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void testGetAllUsers(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allUsers = mapper.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }

        sqlSession.close();
    }
    @Test
    public void testAddUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(6,"小明","1231"));

        sqlSession.close();
    }

    @Test
    public void selectUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserByID(3);
        System.out.println("------------------------");
        System.out.println(user);
        System.out.println("------------------------");
        sqlSession.close();
    }
}
