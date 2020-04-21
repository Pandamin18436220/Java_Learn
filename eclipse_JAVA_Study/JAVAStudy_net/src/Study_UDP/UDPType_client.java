package Study_UDP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 
 * @author Pandamin
 * 1.ʹ��DatagramSocket ָ���˿ڣ��������ն�
 * 2.����������ת���ֽ�����
 * 3.��װ��DatagramPacket ������Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���receive(DatagramPacket p)
 * 5.�ͷ���Դ
 */
public class UDPType_client {
	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�������....");
//		1.ʹ��DatagramSocket ָ���˿ڣ��������ն�
		DatagramSocket client = new DatagramSocket(8888);
		
//		2.׼������ һ��ת���ֽ�����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeUTF("pandamin");
		dos.writeInt(20);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas =baos.toByteArray();
//		System.out.println(datas.length);
		
//		3.��װ��DatagramPacket ������Ҫָ��Ŀ�ĵ�
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
		
//		4.���Ͱ���receive(DatagramPacket p)
		client.send(packet);
//		5.�ͷ���Դ
		client.close();
	}
}
