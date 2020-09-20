import com.mou.mapper.StudentMapper;
import com.mou.mapper.TeacherMapper;
import com.mou.pojo.Student;
import com.mou.pojo.Teacher;
import com.mou.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void testGetTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        mapper.getTeacher(1);
        sqlSession.close();
    }

    @Test
    public void testGetTeacher2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        mapper.getTeacher2(1);
        sqlSession.close();
    }
}
