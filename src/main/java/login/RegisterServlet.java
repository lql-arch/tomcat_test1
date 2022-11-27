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

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2/调用mybatis完成查询
        //2.1获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new getSqlSessionFactory().getFactory();
        //2.2获取sqlSession对象
        SqlSession session = sqlSessionFactory .openSession();
        //2.3获取Mapper
        UserMapper map = session.getMapper(UserMapper.class);
        //2.4判断是否已存在用户,调用方法
        User user;
        if((user = map.find(username)) == null) {
            writer.println("用户已存在<br>");
            writer.println("注册失败");
            return;
        }
        user = map.create(username, password);
        session.commit();
        //2.5释放资源
        session.close();

        if(user != null){
            writer.println("注册成功");
            request.getRequestDispatcher("/login.html").forward(request,response);
        }else{
            writer.println("注册失败");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
