package com.mowcoder.Luntan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        System.out.println("......");
        return "Hello Spring Boot.";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        System.out.println(request.getServletPath());
        System.out.println(request.getMethod());
        System.out.println(request.getParameter("code"));

        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try (
                PrintWriter printWriter=response.getWriter();
                ){
            printWriter.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //get请求
    // students/id=1&limit=20
    @RequestMapping(path = "/students",method = RequestMethod.GET)//只能使用get方式访问
    public String getStudents(@RequestParam(name="id",required = false,defaultValue = "2") int id,@RequestParam(name = "limit") int limit){
        return "getsutdens";
    }
    //student/123
    @RequestMapping(path = "/student/{id}")
    @ResponseBody//返回页面不需要这个注解
    public String getStudent(@PathVariable(name="id") int id){
        System.out.println(".......");
        return id+"";
    }
    //post请求 1小时06秒
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String setStudent(String name,int age){
        System.out.println(name+age);
        return "success";
    }
    //响应Html数据1
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","abc");
        modelAndView.addObject("age",30);
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }
   //响应html2
    @RequestMapping("/school")
    public String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age",80);
        return "/demo/view";
    }
    //响应json数据（处理异步请求，当前网页不动，悄悄访问服务器）
    //java对象 -> json字符串 -> js对象
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> hashmap=new HashMap<>();
        hashmap.put("name","abc");
        hashmap.put("age",20);
        return hashmap;
    }
    //多个数据
    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> hashmap=new HashMap<>();
        hashmap.put("name","abc");
        hashmap.put("age",20);
        list.add(hashmap);
        hashmap=new HashMap<>();
        hashmap.put("name","www");
        hashmap.put("age",30);
        list.add(hashmap);
        return list;
    }


}
