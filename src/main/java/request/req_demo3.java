package request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
//tomcat8后解决，tomcat改为utf-8
@WebServlet(name = "req_demo3", value = "/req3")
public class req_demo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        Map<String,String[]> map = request.getParameterMap();
        for(Map.Entry<String,String[]> i : map.entrySet()){
            System.out.print(i.getKey()+" ");
            for(String decode : i.getValue()){
                //2.Get乱码(1),tomcat默认解码iso-8859-1
//                String encode = URLEncoder.encode(j,"ISO-8859-1");
//                String decode = URLDecoder.decode(encode,"utf-8");
                //(2)
                    decode = new String(decode.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                System.out.print(decode+" ");
            }
            System.out.println();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.Post乱码
//        request.setCharacterEncoding("UTF-8");//设置字符输入流的编码
        doGet(request, response);
    }
}
