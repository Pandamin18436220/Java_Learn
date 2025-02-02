package Chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务端
 * 目标：使用多线程实现多个客户可以正常收发多条信息
 * @author Pandamin
 *
 * 问题：
 * 1.代码不好维护
 * 2.客户端读写没有分开，必须先写后读
 * 
 */
 
public class TMultiChat {
	public static void main(String[] args) throws IOException {
		System.out.println("----------Server------------");
//		 * 1.使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
//		 * 2.阻塞式等待连接accept
		
		while(true){
			final Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			
			new Thread(new Runnable(){
				public void run() {
					// TODO Auto-generated method stub
					DataInputStream dis = null;
					DataOutputStream dos = null;
					try {
						dis = new DataInputStream(client.getInputStream());
						dos = new DataOutputStream(client.getOutputStream());	
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					boolean isRunning = true;
					while(isRunning){
						String datas;
						try {
							datas = dis.readUTF();
//						       * 4.返回消息
							dos.writeUTF(datas);
							dos.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						if(null==dos)
							dos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						if(null==dis)
							dis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						if(null==client)
							client.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						isRunning = false;
					}
				}
			}).start();
//	       * 3.接收消息
		}
//       * 5释放资源
	}
}
