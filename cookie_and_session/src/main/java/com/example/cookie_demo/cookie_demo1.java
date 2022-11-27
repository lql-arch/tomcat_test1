package com.example.cookie_demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//默认随浏览器销毁而销毁
@WebServlet(name = "cookie_demo1", value = "/cookie1")
public class cookie_demo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //发送cookie
        response.setContentType("text/html;charset=UTF-8");
        //1.创建cookie对象
        //中文URLEncode编码后存
        Cookie cookie = new Cookie("username","qwqw");
        cookie.setMaxAge(7 * 24 * 60 * 60);//存活一周
        //2.发送cookie.response
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
