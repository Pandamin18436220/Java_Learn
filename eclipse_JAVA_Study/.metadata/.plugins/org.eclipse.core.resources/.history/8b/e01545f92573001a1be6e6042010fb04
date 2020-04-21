package Chat04;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 使用多线程封装了+发送端
 * 
 * 1.发生消息
 * 2.从控制台获取消息
 * 3.释放资源
 * 4.重写的run
 * @author Pandamin
 *
 */
public class Send implements Runnable{
	private BufferedReader reader;
	private DataOutputStream dos;
	private Socket client;
	private boolean inRunning = true;
	private String name;
	public Send(Socket client,String name){
		this.client = client;
		reader= new BufferedReader(new InputStreamReader(System.in));
		this.name=name;
		try {
			dos= new DataOutputStream(client.getOutputStream());
			//发送名称
			send(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("======2=====");
			this.release();
		}	
	}
	public void run() {
		// TODO Auto-generated method stub
		while(inRunning){
			String msg = getStrFromConsole();
			if(!msg.equals("")){
				send(msg);
			}
		}
	}
	//2.发生消息
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
//			System.out.println("刷新");
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("===3====");
			release();
		}
	}
	/**
	 * 从控制台获取消息
	 * @return
	 */
	private String getStrFromConsole(){
		try {
			return reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	private void release() {
		this.inRunning=false;
		Utils.close(null, dos,client);
	}
}

