package com.mou.mapper;

import com.mou.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //查询所有学生信息，以及对应老师信息
    public List<Student> getStudent();
    public List<Student> getStudent2();
}
