package com.example.cookie_demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cookie_demo2", value = "/cookie2")
public class cookie_demo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 cookie

        //1.获取cookie数组
        Cookie[] cookies = request.getCookies();

        //2.遍历数组
        for (Cookie cookie : cookies) {
            //3.获取cookie
            String name = cookie.getName();
            //(1)
//            String value = cookie.getValue();
//            System.out.println(name+" "+value);
            //(2)
            if("username".equals(name)){
                String value = cookie.getValue();
                System.out.println(name+":"+value);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
