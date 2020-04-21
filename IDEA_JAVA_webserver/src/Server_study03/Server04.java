package Server_study03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//目标：封装请求信息   1.内容可以动态添加   2.关注状态码，拼接响应协议

/**
 * 创建ServerSocket
 * 建立连接获取Socket
 * 通过输入流获取请求协议
 *
 * 准备内容
 * 获取字节数的长度
 * 拼接响应协议   注意：空格与换行
 * 使用输入输出
 *
 * Response
 * 1.动态添加内容print
 * 2.累加字节数的长度
 * 3.根据状态码拼接
 * 4.根据状态码统一推送出去
 * 调用处：动态调用print+传入状态码推送
 *
 * Request
 * 通过分解字符串获取method URL和请求参数POST请求参数可能请求体中还存在
 *
 */
public class Server04 {
    private ServerSocket serverSocket ;
    public static void main(String[] args) {
        Server04 server = new Server04();
        server.start();
    }
    //启动服务
    public void start() {
        try {
            serverSocket =  new ServerSocket(8899);
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败....");
        }
    }
    //接受连接处理
    public void receive() {
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接....");
            //获取请求协议
            Request request = new Request(client);

            Response response=new Response(client); //创建好了输出流
            //关注了内容
            response.print("<html>");    //通过输出流输出
            response.print("<head>");
            response.print("<title>");
            response.print("服务器响应成功");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.print("shsxt server终于回来了。。。。");
            response.print("</body>");
            response.print("</html>");
            //关注了状态码
            response.pushToBrowser(200);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误");
        }
    }
    //停止服务
    public void stop() {

    }
}