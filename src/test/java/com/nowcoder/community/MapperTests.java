package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplicationTests.class)
@EnableAutoConfiguration  //自动装配相关,踩坑

//-----------------------------------------------测试UserMapper
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(103);
        System.out.println(user);

        user = userMapper.selectByName("zhangfei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder103@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser() {
        int rows = userMapper.updateStatus(1,0);
        System.out.println(rows);

        rows = userMapper.updateHeader(165, "http://www.baidu.com");
        System.out.println(rows);

        rows = userMapper.updatePassword(1,"123");
        System.out.println(rows);
    }

    //------------------------------------------------------测试DiscussPostMapper

    @Test
    public void testSelectPosts() {
         List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, 0, 10);
         for (DiscussPost discussPost: discussPosts) {
             System.out.println(discussPost);
         }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

}
