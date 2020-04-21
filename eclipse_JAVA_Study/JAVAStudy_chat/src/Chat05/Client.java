package Chat05;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 可以实现自言自语啦啦啦啦！
 * 
 * 
 * 在线聊天室：客户端
 * 目标：私聊
 * @author Pandamin
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----------Client------------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入名字：");
		String name = br.readLine();
//		 * 1.建立连接：使用Socket创建客户端+服务器地址和端口
		Socket client = new Socket("localhost",8888);
		
//		 * 2.操作：输入输出流(发生消息)
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
		
	}
}
