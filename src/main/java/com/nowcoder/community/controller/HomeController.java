package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    private String getIndexPage(Model model, Page page) {  //响应HTML页面的第二种方法,页面会传来一些条件需要用page来封装
        //方法调用之前会自动实例化model和page，并将page到model中，所以在thmeleaf里可以直接访问page对象中的数据,会自动装配到dishiparueservlet中
        page.setRows( discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
// SpringMVC会自动将请求中的参数映射到Controller方法参数上，默认按照同名规则映射，无论是基本类型与之同名，还是对象中的成员与之同名。
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getoffset(), page.getLimit());  //响应页面应该需要两个表中的数据，就可以显示两页之间的数据了
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post: list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);

                //springmvc会在后台自动匹配user和post
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "index";  //（踩坑），必须要在pom中导入引擎

    }
}
