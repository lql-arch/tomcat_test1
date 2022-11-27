package jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/jsp_demo1")
public class jsp_demo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> branch = new ArrayList<>();
        branch.add("aaa");
        branch.add("bbb");

        request.setAttribute("status",1);
        request.setAttribute("branches",branch);

        request.getRequestDispatcher("/jspDemo1.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
