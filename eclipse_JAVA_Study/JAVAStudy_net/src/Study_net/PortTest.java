package Study_net;

import java.net.InetSocketAddress;
/**
 * �˿ں�
 * 1.�������
 * 2.2���ֽ�0-65535  UDP  TCP
 * 3.ͬһ��Э��˿ڲ��ܳ�ͻ
 * 4.����˿�Խ��Խ��
 * 
 * 
 * InetSocketAddress 
 * 1.������
 * new InetSocketAddress(��ַ|����,�˿�);
 * 2.����
 * getAddress()
 * getPort()
 * getHostName()
 * @author Pandamin
 *
 */
public class PortTest {
	public static void main(String[] args) {
		//�����˿�
		InetSocketAddress socketAddress=new InetSocketAddress("127.0.0.1",8080);
		InetSocketAddress socketAddress2=new InetSocketAddress("localhost",9000);
		System.out.println(socketAddress.getHostName());
		System.out.println(socketAddress2.getAddress());
		System.out.println(socketAddress2.getPort());
		
	}

}
