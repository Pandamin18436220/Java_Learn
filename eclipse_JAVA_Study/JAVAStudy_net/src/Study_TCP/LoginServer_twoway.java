package Study_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录+双向
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
public class LoginServer_twoway {
	public static void main(String[] args) throws IOException {
//		 * 创建服务器
//		 * 1.使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
//		 * 2.阻塞式等待连接accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
//		 * 3.操作：输入输出流
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String datas = dis.readUTF();
		
		String uname="";
		String upwd="";
		
		//分析
		String[] dataArray = datas.split("&");
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
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		if(uname.equals("pandamin")&&upwd.equals("123")){
			System.out.println("登录成功");
			dos.writeUTF("登录成功");
		}else{
			System.out.println("登录失败");
			dos.writeUTF("登录失败");
		}
		dos.flush();
//		System.out.println(datas);
//		 * 4.释放资源
		dis.close();
	}
}
