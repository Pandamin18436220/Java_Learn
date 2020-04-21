package Study_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录+多个客户端请求
 * 
 * 熟悉流程：
 * 创建服务器
 * 1.使用ServerSocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作：输入输出流
 * 4.释放资源
 * @author Pandamin
 *
 */
public class LoginServer_Multi {
	public static void main(String[] args) throws IOException {
//		 * 创建服务器
//		 * 1.使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
//		 * 2.阻塞式等待连接accept
		boolean isRunning = true;
		while(isRunning){
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			new Thread(new Channel(client)).start();
		}
		
	}
	static class Channel implements Runnable{
		private Socket client;
		//输入流封装
		private DataInputStream dis;
		private DataOutputStream dos; 
		public Channel(Socket client){
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				release();
			}
		}
		//接受数据
				private String receive() {
					String datas = "";
					try {
						datas = dis.readUTF();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return datas;
				}
				
		//释放资源
		private void release(){
			try {
				if(null!=dos)
					dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(datas);
//			 * 4.释放资源
			try {
				if(null!=dis)
					dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(null!=client)
					client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//写出数据
				//接受数据
				private void send(String msg) {
					try {
						dos.writeUTF(msg);
						dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		public void run() {
			// TODO Auto-generated method stub
//			 * 3.操作：输入输出流
//			String datas = dis.readUTF();
			String uname="";
			String upwd="";
			
			//分析
			String[] dataArray = receive().split("&");
			for(String info:dataArray){
				String[] useInfo = info.split("=");
				if(useInfo[0].equals("uname")){
					System.out.println("用户名为："+useInfo[1]);
					uname=useInfo[1];
				}else if(useInfo[0].equals("upwd")){
					System.out.println("密码为："+useInfo[1]);
					upwd=useInfo[1];
				}
			}
			
			if(uname.equals("pandamin")&&upwd.equals("123")){
				System.out.println("登录成功");
				send("登录成功");
			}else{
				System.out.println("登录失败");
				send("登录失败");
			}
			release();
		}	
	}
}
