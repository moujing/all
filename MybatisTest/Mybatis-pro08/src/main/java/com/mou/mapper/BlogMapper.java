package com.mou.mapper;

import com.mou.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);

    //动态SQL查询if
    List<Blog> selectBlogIf(Map map);

    //动态SQL查询when otherwise 相当于switch case
    List<Blog> selectBlogWhen(Map map);

    //查询id为1,2,3号记录的博客
    List<Blog> queryBlogForeach(Map map);
}
