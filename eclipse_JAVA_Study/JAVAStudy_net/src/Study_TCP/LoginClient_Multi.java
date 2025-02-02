package Study_TCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginClient_Multi {

	/**
	 * 模拟登录+多个客户端请求
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
		System.out.println("------Client-------");
		// TODO Auto-generated method stub
//		 * 1.建立连接：使用Socket创建客户端+服务器地址和端口
		
		Socket client = new Socket("localhost",8888);
//		 * 2.操作：输入输出流
		new Send(client).send();
		new Receive(client).receive();
		client.close();
	}
	static class Send{
		private DataOutputStream dos;
		private BufferedReader reader ;
		private Socket client;
		private String msg;
		public Send(Socket client) {
			reader = new BufferedReader(new InputStreamReader(System.in));
			this.msg = init();
			// TODO Auto-generated constructor stub
			this.client=client;
			try {
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private String init(){
			try {
				System.out.println("请输入用户名：");
				String uname = reader.readLine();
				System.out.println("请输入密码：");
				String upwd = reader.readLine();
				return "uname="+uname+"&"+"upwd="+upwd;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
		public void send(){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	static class Receive{
		private DataInputStream dis;
		private Socket client;
		public Receive(Socket client){
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void receive(){
			String result;
			try {
				result = dis.readUTF();
				System.out.println(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
