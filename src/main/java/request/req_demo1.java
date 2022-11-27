package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class req_demo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求行
        String method = req.getMethod();
        System.out.println(method);
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        String url = req.getRequestURL().toString();
        System.out.println(url);
        String uri = req.getRequestURI();
        System.out.println(uri);

        String que = req.getQueryString();
        System.out.println(que);

        //请求头
        String head = req.getHeader("User-Agent");
        System.out.println(head);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求体
        BufferedReader br = req.getReader();
        String line = br.readLine();
        System.out.println(line);

//        ServletInputStream stream = req.getInputStream();
//        System.out.println(stream);
    }
}
