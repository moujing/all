package com.mou.mapper;

import com.mou.pojo.User;
import com.mou.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test(){

        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(new User(5,"小白","123"));
        //修改表一定要提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDeleteUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUserById(5);
        //修改表一定要提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testInsertUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //使用map(工作中一般都这样用)
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userId",5);
        map.put("userName","小白");
        map.put("userPwd","abc");

        mapper.insertUser2(map);

        //修改表一定要提交事务
        sqlSession.commit();
        //一定记得要关闭啊！
        sqlSession.close();
    }
}
