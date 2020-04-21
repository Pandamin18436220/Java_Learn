package Study_net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP:��λһ���ڵ㣺�������·�ɣ�ͨѶ
 * 
 * InetAddress��
 * 1.getLocalHost()����
 * 2.getByName()������������IP��ַ   |IP��ַ����IP
 * 
 * 
 * ������Ա����
 * 1.getHostAddress():����������ַ
 * 2.getHostName():���ؼ������
 * 
 * 
 * 
 * *******�鿴���ж˿�******
 * netstat -ano
 * *******�鿴ָ���˿�******
 * netstat -ano|findstr "808"
 * *******�鿴ָ������******
 * tasklist|findstr "808"
 * *******�鿴�������******
 * ʹ���������鿴PID
 * @author Pandamin
 *
 */
public class Study_loc_ip {
	public static void main(String[] args) throws UnknownHostException {
		//ʹ��getLocalHost��������InetAddress����
		InetAddress addr=InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//���أ�192.169.1.3
		System.out.println(addr.getHostName());//����������
		
		//���������õ�InetAddress����
		addr=InetAddress.getByName("www.shsxt.com");
		System.out.println(addr.getHostAddress());//���ط�������IP:123.56.138.186
		System.out.println(addr.getHostName());//���www.163.com
		
		//����IP�õ�InetAddress����
		addr=InetAddress.getByName("123.56.138.176");
		System.out.println(addr.getHostAddress());//���ط�������IP
		System.out.println(addr.getHostName());//���IP����������
	}

}




