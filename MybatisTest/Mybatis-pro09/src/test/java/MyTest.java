import com.mou.mapper.UserMapper;
import com.mou.pojo.User;
import com.mou.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap map = new HashMap();
        map.put("id",1);
        List<User> users = mapper.getUsers(map);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //一级缓存，如果查询语句相同在sqlsession关闭前都只走了一次SQL查询
        //查询语句不同，走两次
        //增删改会刷新缓存
        User user = mapper.getUserById(1);
        System.out.println(user);
        System.out.println("===================================");
        //================================================
        //手动刷新缓存
        sqlSession.clearCache();

        User user2 = mapper.getUserById(1);
        System.out.println(user);
        System.out.println("===================================");


        System.out.println(user==user2);

        sqlSession.close();
    }

    @Test
    public void test3(){
        //二级缓存测试
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();

        User user2 = mapper2.getUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);

        sqlSession2.close();

    }
}
