package com.example.session_demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//session存储到服务器.session基于cookie,浏览器关闭后,对象就会变化,session得不到对于的cookie,无法获取session
@WebServlet(name = "session_demo1", value = "/session1")
public class session_demo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //存储到session
        //1.获取session对象
        HttpSession session = request.getSession();
//        System.out.println(session);
        //2.存储数据
        session.setAttribute("username","yeyr");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
