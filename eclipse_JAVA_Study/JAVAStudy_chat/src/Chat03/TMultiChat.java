package Chat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 可以实现自言自语啦啦啦啦！
 * 
 * 
 * 
 * 在线聊天室：服务端
 * 目标：封装+使用多线程实现多个客户可以正常收发多条信息
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
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			new Thread(new Channel(client)).start(); 
//	       * 3.接收消息
		}
//       * 5释放资源
	}
	
	//一个客户代表一个Channel
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean inRunning;
		public Channel(Socket client) {
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				inRunning=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("1");
				release();
			}
		}
		//1.接受消息
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("接受消息出错2");
				release();
			}
			return msg;
		}
		//2.发生消息
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
//				System.out.println("刷新");
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("3");
				release();
			}
		}
		//3.释放资源
		private void release() {
			this.inRunning=false;
			Utils.close(dis,dos,client);
		}
		public void run() {
			// TODO Auto-generated method stub
			while(inRunning){
				String msg = receive();
				if(!msg.equals("")){
					send(msg);
				}
			}
		}
	}
}
