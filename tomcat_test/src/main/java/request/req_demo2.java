package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

@WebServlet(name = "hello",urlPatterns = "/req2")
public class req_demo2 extends HttpServlet {
    String message ;
    public void init() {
        message = "Hello World!";
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");

        Enumeration<String> e = request.getParameterNames();
        for (Iterator<String> iter = e.asIterator(); iter.hasNext();  ) {
            String i = iter.next();
            System.out.println(i);
        }

        out.print("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet!This is one</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> hello!" + name + " !</h1>");
        out.print("</body>");
        out.println("</html>");
        out.close();
        System.out.println("toGet...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("toPost...");
        String name = req.getParameter("username");
        PrintWriter out = resp.getWriter();

//        Enumeration<String> e = req.getParameterNames();
//        for (Iterator<String> iter = e.asIterator(); iter.hasNext();  ) {
//            String i = iter.next();
//            System.out.println(i+" "+req.getParameter(i));
//        }
        Map<String,String[]> map = req.getParameterMap();
        for(Map.Entry<String,String[]> i : map.entrySet()){
            System.out.print(i.getKey()+" ");
            for(String j : i.getValue()){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        out.print("<html>");
        out.println("<body>");
        out.println("<h1> hello!" + name + " !</h1>");
        out.print("</body>");
        out.println("</html>");
        out.close();

    }
}
