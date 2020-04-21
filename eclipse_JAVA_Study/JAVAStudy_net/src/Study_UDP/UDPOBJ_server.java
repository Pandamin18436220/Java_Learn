package Study_UDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ���Ͷ�
 * @author Pandamin
 * 1.ʹ��DatagramSocket ָ���˿ڣ��������ն�
 * 2.׼��������װ��DatagramPacket ����
 * 3.����ʽ���հ���receive(DatagramPacket p)
 * 4.�������� ���������ͻ�ԭΪ��Ӧ����
 * 	4.1byte[] getDate()
 *  4.2byte[] getLength()
 * 5.�ͷ���Դ
 */
public class UDPOBJ_server {
	public static void main(String[] args) throws Exception {
		System.out.println("���շ�������....");
//		 * 1.ʹ��DatagramSocket ָ���˿ڣ��������ն�
		DatagramSocket server = new DatagramSocket(9999);
//		 * 2.׼��������װ��DatagramPacket ����
		byte[] container = new byte[1024*60];
		DatagramPacket packet = new DatagramPacket(container,0,container.length);
//		 * 3.����ʽ���հ���receive(DatagramPacket p)
		server.receive(packet);
//		 * 4.��������
//		 * 	4.1byte[] getDate()
//		 *  4.2byte[] getLength()
		byte[] datas = packet.getData();
		int len = packet.getLength();
		
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		
		String msg = dis.readUTF();
		int age = dis.readInt();
		boolean flag =dis.readBoolean();
		char ch =dis.readChar();
		
		System.out.println(msg+"---->"+flag);
		
//		 * 5.�ͷ���Դ
		server.close();
	}
}