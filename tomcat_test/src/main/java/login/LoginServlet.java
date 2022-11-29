package login;

import login.mapper.UserMapper;
import login.util.getSqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        //2/调用mybatis完成查询
        //2.1获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new getSqlSessionFactory().getFactory();
        //2.2获取sqlSession对象
        SqlSession session = sqlSessionFactory .openSession();
        //2.3获取Mapper
        UserMapper map = session.getMapper(UserMapper.class);
        //2.4调用方法
        User user = map.select(name,password);
        //2.5释放资源
        session.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        //3.判user是否为null
         if (user != null){
             writer.println("登陆成功");
         }else {
             writer.println("登陆失败");
         }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
