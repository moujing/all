package com.mou.mapper;

import com.mou.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    //获取老师（测试用）
    List<Teacher> getTeacher();

    //获取指定老师信息及其学生的信息
    Teacher getTeacher(@Param("tid") int tid);

    Teacher getTeacher2(@Param("tid") int tid);
}
