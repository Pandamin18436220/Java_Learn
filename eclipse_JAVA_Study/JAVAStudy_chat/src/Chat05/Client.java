package Chat05;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ����ʵ��������������������
 * 
 * 
 * ���������ң��ͻ���
 * Ŀ�꣺˽��
 * @author Pandamin
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----------Client------------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���������֣�");
		String name = br.readLine();
//		 * 1.�������ӣ�ʹ��Socket�����ͻ���+��������ַ�Ͷ˿�
		Socket client = new Socket("localhost",8888);
		
//		 * 2.���������������(������Ϣ)
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
		
	}
}
