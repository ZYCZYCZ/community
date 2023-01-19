package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    /*
    查看帖子多少个
     这个是考虑到将来的我的帖子查询，有时候要userid，有时候不要（当为0时），
     所以要写动态sql,offset是起始行，limit是一次显示多少条数据
    * */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /*
     查看帖子数量，如果加了userId就是看用户帖子
     @Param 是对后面的参数取别名，用来简化写sql 的名称，多个参数可以不屑，但是只有一个参数和这个参数是一个动态的就必须写
     动态代表这个参数会在<if>中使用
    * */
    int selectDiscussPostRows(@Param("userId") int userId);
//-----------------------------------------------------------------------------------------前面为首页查询功能




}
