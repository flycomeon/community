package com.mowcoder.Luntan.dao;

import com.mowcoder.Luntan.entity.DiscussPost;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    //offset:开始行号
    List<DiscussPost> selectDisscusPosts(int userId, int offset, int limit);//当userId为0时则不作为sql查询条件

    //查询帖子数量
    //@Param:给参数取个别名，
    //如果只有一个参数，并且在<if>里使用，则必须取别名
    int selectDisscusPostRows(@Param("userId") int userId);

    //


}
