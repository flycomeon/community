package com.mowcoder.Luntan.controller;

import com.mowcoder.Luntan.entity.DiscussPost;
import com.mowcoder.Luntan.entity.Page;
import com.mowcoder.Luntan.entity.User;
import com.mowcoder.Luntan.service.DiscussPostService;
import com.mowcoder.Luntan.service.UserService;
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

    @RequestMapping(path="/index",method= RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        //dispatchservlet，方法调用前，springmvc会自动实例化Model和Page,并将Page注入Model中
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
       List<DiscussPost> list= discussPostService.findDiscussPosts(0,page.getoffset(),page.getLimit());
       List<Map<String,Object>> discussPosts=new ArrayList<>();
       if(list!=null){
           for(DiscussPost post:list){
               Map<String,Object> map=new HashMap<>();
               map.put("post",post);
               User user=userService.findUserById(post.getUserId());
               map.put("user",user);
               discussPosts.add(map);
           }
       }
       model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }
}
