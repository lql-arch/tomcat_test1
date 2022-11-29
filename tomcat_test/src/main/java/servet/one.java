package servet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet(value = "/one_demo1",loadOnStartup = -1)
//servlet由web服务器创建调用
public class one implements Servlet {
    private ServletConfig config;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        System.out.println("init...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.println("server hello world~");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        if("GET".equals(method)){

        }else if("POST".equals(method)){

        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }
}
