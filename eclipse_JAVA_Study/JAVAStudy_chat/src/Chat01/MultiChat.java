package Chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务端
 * 目标：实现一个客户可以正常收发多条信息
 * @author Pandamin
 *
 */
 
public class MultiChat {
	public static void main(String[] args) throws IOException {
		System.out.println("----------Server------------");
//		 * 1.使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
//		 * 2.阻塞式等待连接accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
		
//       * 3.接收消息
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());	
		boolean isRunning = true;
		while(isRunning){
			String datas = dis.readUTF();
//	       * 4.返回消息
			dos.writeUTF(datas);
			dos.flush();
		}
//       * 5释放资源
		dos.close();
		dis.close();
		client.close();
	}
}
