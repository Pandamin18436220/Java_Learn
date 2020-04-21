package Study_TCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginClient_twoway {

	/**
	 * ģ���¼+˫��
	 * 
	 * 
	 *  * ��Ϥ���̣�
 * �����ͻ�����
 * 1.�������ӣ�ʹ��Socket�����ͻ���+��������ַ�Ͷ˿�
 * 2.���������������
 * 3.�ͷ���Դ
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
//		 * 1.�������ӣ�ʹ��Socket�����ͻ���+��������ַ�Ͷ˿�
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û�����");
		String uname = reader.readLine();
		System.out.println("���������룺");
		String upwd = reader.readLine();
		Socket client = new Socket("localhost",8888);
//		 * 2.���������������
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String data = "hello";
		
		dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
		dos.flush();
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String result = dis.readUTF();
		System.out.println(result);
//		 * 3.�ͷ���Դ
		dos.close();
		client.close();
	}

}
