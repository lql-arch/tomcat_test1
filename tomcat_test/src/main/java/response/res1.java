package response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//重定向:给浏览器使用。需要加虚拟目录
@WebServlet("/res1")
public class res1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("res1..");

//        //设置响应状态码
//        response.setStatus(302);
//        //设置响应头
//        response.setHeader("Location","/res2");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        //简化方式
        response.sendRedirect(contextPath+"/res2");
//        response.sendRedirect("https://github.com/astaxie/build-web-application-with-golang/blob/master/zh/02.5.md");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
