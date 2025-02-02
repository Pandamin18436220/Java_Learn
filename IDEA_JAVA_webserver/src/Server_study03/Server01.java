package Server_study03;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//目标：使用ServerSocket建立与浏览器的连接，获取请求协议

/**
 * 创建ServerSocket
 * 建立连接获取Socket
 * 通过输入流获取请求协议
 */
public class Server01 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server01 server = new Server01();
        server.start();
        server.receive();
    }
    //启动服务
    public void start() {
        try {
            serverSocket = new ServerSocket(9898);
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("服务器启动失败....");
        }
    }
    //接收连接处理
    public void receive(){
            try {
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接");
                //获取请求协议
                InputStream is = client.getInputStream();
                byte[] datas = new byte[1024*1024];
                int len =is.read(datas);
                String requestInfo = new String(datas,0,len);
                System.out.println(requestInfo);
            } catch (IOException e) {
//                e.printStackTrace();
                System.out.println("客户端错误....");
            }
        }
    //结束服务
    public void stop(){

    }
}