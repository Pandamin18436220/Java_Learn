package Chat02;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 在线聊天室：客户端
 * 目标：实现多个客户可以正常收发多条信息
 * @author Pandamin
 *
 */
public class MultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----------Client------------");
//		 * 1.建立连接：使用Socket创建客户端+服务器地址和端口
		Socket client = new Socket("localhost",8888);
		
//		 * 2.操作：输入输出流(发生消息)
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		boolean isRunning = true;
		while(isRunning){
			String msg= reader.readLine();
			dos.writeUTF(msg);
			dos.flush();
//	       * 3.获取消息
			msg = dis.readUTF();
			System.out.println(msg);
		}
//      * 5释放资源	
		dos.close();
		dis.close();
		client.close();
	}
}
