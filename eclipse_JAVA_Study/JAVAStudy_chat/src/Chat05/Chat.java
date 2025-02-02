package Chat05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 可以实现自言自语啦啦啦啦！
 * 
 * 
 * 
 * 在线聊天室：服务端
 * 目标：私聊
 * @author Pandamin
 *

 * 
 */
 
public class Chat {
	private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		System.out.println("----------Server------------");
//		 * 1.使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
//		 * 2.阻塞式等待连接accept
		
		while(true){
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			Channel c = new Channel(client);
			all.add(c);
			new Thread(c).start(); 
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
		private String name;
		public Channel(Socket client) {
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				inRunning=true;
				//获取名称
				this.name = receive();
				//欢迎你的到来
				this.send("欢迎你的到来！");
				sendOthers(this.name+"来的了聊天室",true);
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
				System.out.println("2");
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
		//+群聊:获取自己的消息，发给其他人
		//+私聊:约定数据格式：@xxx:msg
		private void sendOthers(String msg,boolean isSys) {
			boolean isPrivate = msg.startsWith("@");
			if(isPrivate){//私聊
				//获取目标和数据；
				int idx = msg.indexOf(":");
				String targetname = msg.substring(1,idx);
				msg = msg.substring(idx+1);
				for(Channel other:all){
					if(other.name.equals(targetname)){//目标
						other.send(this.name+"悄悄的对您说:"+msg);//私聊
						break;
					}
				}
			}else{
				for(Channel other:all){
					if(other==this){
						continue;
					}
					if(!isSys){
						other.send(this.name+"对所有人说:"+msg);//群聊
					}else{
						other.send(msg);//系统消息
					}
				}
			}
		}
		//3.释放资源
		private void release() {
			this.inRunning=false;
			Utils.close(dis,dos,client);
			//退出
			all.remove(this);
			sendOthers(this.name+"离开了大家庭", true);
		}
		public void run() {
			// TODO Auto-generated method stub
			while(inRunning){
				String msg = receive();
				if(!msg.equals("")){
//					send(msg);
					sendOthers(msg,false);
				}
			}
		}
	}
}
