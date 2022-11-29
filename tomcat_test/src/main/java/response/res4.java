package response;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "res4", value = "/res4.doc")
public class res4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.读取文件
        FileInputStream fis = new FileInputStream("/home/bronya/Downloads/实验8.doc");

        //2.读取字节输出流
        ServletOutputStream so  = response.getOutputStream();

        //3.完成流的copy
//        byte[] buff = new byte[2024];
//        int len = 0;
//        while((len = fis.read(buff)) != -1){
//            so.write(buff,0,len);
//        }
        IOUtils.copy(fis,so);

        fis.close();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
