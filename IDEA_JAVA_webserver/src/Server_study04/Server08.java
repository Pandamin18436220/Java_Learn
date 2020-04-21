package Server_study04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//目标：加入多线程

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
 * 通过Map封装请求参数两个方法 考虑一个参数多个值和中文
 *
 * Dispatcher
 * 加入多线程，可以同时处理多个请求
 * 使用的是短连接
 */
public class Server08 {
    private ServerSocket serverSocket ;
    private boolean isRunning;
    public static void main(String[] args) {
        Server08 server = new Server08();
        server.start();
    }
    //启动服务
    public void start() {
        try {
            serverSocket =  new ServerSocket(7899);
            isRunning = true;
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败....");
        }
    }
    //接受连接处理
    public void receive() {
        while(isRunning) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接....");
                //多线程处理
                new Thread(new Dispatcher(client)).start();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("客户端错误");
            }
        }
    }
    //停止服务
    public void stop() {
        isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("服务器停止");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}