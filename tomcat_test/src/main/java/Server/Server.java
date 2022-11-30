package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("server is running");
        while(true){
            Socket socket = ss.accept();
            System.out.println("connected from "+ socket.getRemoteSocketAddress());
            Thread t = new Handler(socket);
            t.start();
        }
    }
}

class Handler extends Thread{
    Socket socket;

    public Handler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream input = this.socket.getInputStream()){
            try(OutputStream output = this.socket.getOutputStream()){
                handle(input,output);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("client disconnected.");
    }

    protected void handle(InputStream input,OutputStream output) throws IOException, NoSuchMethodException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output,StandardCharsets.UTF_8));

        boolean requestOk = false;
        String first = reader.readLine();
        if(first.startsWith("GET / HTTP/1.")){
            requestOk = true;
        }
        while(true){
            String header = reader.readLine();
            if(header.isEmpty()){
                break;
            }
            System.out.println(header);
        }
        System.out.println(requestOk ? "Response OK" : "Response Error");
        if(!requestOk){
            writer.write("HTTP?1.0 404 Not Found\n");
            writer.write("Content-Length:0\n");
            writer.write("\n");
            writer.flush();
        }else {
//            String path = Arrays.toString(Handler.class.getConstructors());
//            System.out.println(path);
            BufferedReader br = new BufferedReader(new FileReader("tomcat_test/html/a.html"));
            StringBuilder data = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null){
                data.append(line);
            }
            br.close();
            int length = data.toString().getBytes(StandardCharsets.UTF_8).length;

            writer.write("HTTP/1.1 200 OK\n");
            writer.write("Connection: keep-alive\n");
            writer.write("Content-Typ: text/html\n");
            writer.write("Content-Length: "+length+"\n");
            writer.write(data.toString());
            writer.flush();
        }
    }
}
