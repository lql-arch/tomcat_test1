package request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//转发：给服务器使用，不需要加虚拟目录
@WebServlet(name = "req4", value = "/req4")
public class req_demo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo4...");

        request.setAttribute("name","yeyr2");//存储数据
        //请求转发
        request.getRequestDispatcher("/req5").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
