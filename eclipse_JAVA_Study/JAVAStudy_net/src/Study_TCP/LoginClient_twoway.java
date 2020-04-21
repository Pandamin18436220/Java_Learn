package Study_TCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginClient_twoway {

	/**
	 * 模拟登录+双向
	 * 
	 * 
	 *  * 熟悉流程：
 * 创建客户端器
 * 1.建立连接：使用Socket创建客户端+服务器地址和端口
 * 2.操作：输入输出流
 * 3.释放资源
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
//		 * 1.建立连接：使用Socket创建客户端+服务器地址和端口
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名：");
		String uname = reader.readLine();
		System.out.println("请输入密码：");
		String upwd = reader.readLine();
		Socket client = new Socket("localhost",8888);
//		 * 2.操作：输入输出流
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String data = "hello";
		
		dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
		dos.flush();
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String result = dis.readUTF();
		System.out.println(result);
//		 * 3.释放资源
		dos.close();
		client.close();
	}

}
