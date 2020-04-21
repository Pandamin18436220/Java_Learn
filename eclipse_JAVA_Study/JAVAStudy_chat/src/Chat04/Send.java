package Chat04;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ʹ�ö��̷߳�װ��+���Ͷ�
 * 
 * 1.������Ϣ
 * 2.�ӿ���̨��ȡ��Ϣ
 * 3.�ͷ���Դ
 * 4.��д��run
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
			//��������
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
	//2.������Ϣ
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
//			System.out.println("ˢ��");
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("===3====");
			release();
		}
	}
	/**
	 * �ӿ���̨��ȡ��Ϣ
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

