package Study_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���¼+����ͻ�������
 * 
 * ��Ϥ���̣�
 * ����������
 * 1.ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����accept
 * 3.���������������
 * 4.�ͷ���Դ
 * @author Pandamin
 *
 */
public class LoginServer_Multi {
	public static void main(String[] args) throws IOException {
//		 * ����������
//		 * 1.ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(8888);
//		 * 2.����ʽ�ȴ�����accept
		boolean isRunning = true;
		while(isRunning){
			Socket client = server.accept();
			System.out.println("һ���ͻ��˽���������");
			new Thread(new Channel(client)).start();
		}
		
	}
	static class Channel implements Runnable{
		private Socket client;
		//��������װ
		private DataInputStream dis;
		private DataOutputStream dos; 
		public Channel(Socket client){
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				release();
			}
		}
		//��������
				private String receive() {
					String datas = "";
					try {
						datas = dis.readUTF();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return datas;
				}
				
		//�ͷ���Դ
		private void release(){
			try {
				if(null!=dos)
					dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(datas);
//			 * 4.�ͷ���Դ
			try {
				if(null!=dis)
					dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(null!=client)
					client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//д������
				//��������
				private void send(String msg) {
					try {
						dos.writeUTF(msg);
						dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		public void run() {
			// TODO Auto-generated method stub
//			 * 3.���������������
//			String datas = dis.readUTF();
			String uname="";
			String upwd="";
			
			//����
			String[] dataArray = receive().split("&");
			for(String info:dataArray){
				String[] useInfo = info.split("=");
				if(useInfo[0].equals("uname")){
					System.out.println("�û���Ϊ��"+useInfo[1]);
					uname=useInfo[1];
				}else if(useInfo[0].equals("upwd")){
					System.out.println("����Ϊ��"+useInfo[1]);
					upwd=useInfo[1];
				}
			}
			
			if(uname.equals("pandamin")&&upwd.equals("123")){
				System.out.println("��¼�ɹ�");
				send("��¼�ɹ�");
			}else{
				System.out.println("��¼ʧ��");
				send("��¼ʧ��");
			}
			release();
		}	
	}
}
