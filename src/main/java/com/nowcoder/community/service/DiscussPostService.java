package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    /*
    * 查询到的实体类中的userId在页面中肯定不会显示，必须要显示用户名称
    * 第一种办法：改变sql，关联另一个表
    * 第二种办法：在for循环中单独对每一个对象进行查询user实体，把用户名和discussPost一          起返回给页面||这种方式比较好，后面使用redis性能够更高
    * */
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
