package Chat04;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 使用多线程封装了+接收端
 * 
 * 
 * 1.接受消息
 * 2.从控制台获取消息
 * 3.释放资源
 * 4.重写的run
 * @author Pandamin
 *
 */
public class Receive implements Runnable{
	private DataInputStream dis;
	private Socket client;
	private boolean inRunning =true;
	public Receive(Socket client) {
		// TODO Auto-generated constructor stub
		this.client=client;
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("==========2======");
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
//			e.printStackTrace();
			System.out.println("====4======");
			release();
		}
		return msg;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(inRunning){
			String msg = receive();
			if(!msg.equals("")){
				System.out.println(msg);
			}
		}
	}
	private void release() {
		this.inRunning=false;
		Utils.close(dis, null,client);
	}

}
