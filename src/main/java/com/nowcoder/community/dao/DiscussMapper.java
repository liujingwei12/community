package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussMapper {
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);
    //@Param是给参数取别名
    //如果只有一个参数，并且在<if>中使用时，必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);
}
