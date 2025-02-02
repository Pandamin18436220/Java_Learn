package Study_TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	/**
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
		Socket client = new Socket("localhost",8888);
//		 * 2.操作：输入输出流
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String data = "hello";
		dos.writeUTF(data);
		dos.flush();
//		 * 3.释放资源
		dos.close();
		client.close();
	}

}
