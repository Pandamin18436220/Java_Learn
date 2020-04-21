package Study_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ���Ͷ�
 * @author Pandamin
 * 1.ʹ��DatagramSocket ָ���˿ڣ��������ն�
 * 2.׼��������װ��DatagramPacket ����
 * 3.����ʽ���հ���receive(DatagramPacket p)
 * 4.��������
 * 	4.1byte[] getDate()
 *  4.2byte[] getLength()
 * 5.�ͷ���Դ
 */
public class UDP_server {
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
		System.out.println(new String(datas,0,len));
//		 * 5.�ͷ���Դ
		server.close();
	}
}
