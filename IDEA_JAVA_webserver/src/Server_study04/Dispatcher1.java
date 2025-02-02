package Server_study04;

import java.io.IOException;
import java.net.Socket;

public class Dispatcher1 implements Runnable{
    private Socket client;
    private Request request;
    private Response response;
    public Dispatcher1(Socket client){
        this.client=client;
        try {
            request = new Request(client);
            response=new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
    }
    @Override
    public void run() {
        try {
            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
            if (null != servlet) {
                servlet.service(request, response);
                //关注了状态码
                response.pushToBrowser(200);
            } else {
                //错误...
                response.pushToBrowser(404);
            }
        }catch (Exception e){
            try {
                response.pushToBrowser(500);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        this.release();
    }
    private void release(){
        try {
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
