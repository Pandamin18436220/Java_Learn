package Study_net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP:定位一个节点：计算机，路由，通讯
 * 
 * InetAddress：
 * 1.getLocalHost()本机
 * 2.getByName()根据域名解析IP地址   |IP地址解析IP
 * 
 * 
 * 两个成员方法
 * 1.getHostAddress():返回主机地址
 * 2.getHostName():返回计算机名
 * 
 * 
 * 
 * *******查看所有端口******
 * netstat -ano
 * *******查看指定端口******
 * netstat -ano|findstr "808"
 * *******查看指定进程******
 * tasklist|findstr "808"
 * *******查看具体程序******
 * 使用任务管理查看PID
 * @author Pandamin
 *
 */
public class Study_loc_ip {
	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost方法创建InetAddress对象
		InetAddress addr=InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//返回：192.169.1.3
		System.out.println(addr.getHostName());//输出计算机名
		
		//根据域名得到InetAddress对象
		addr=InetAddress.getByName("www.shsxt.com");
		System.out.println(addr.getHostAddress());//返回服务器的IP:123.56.138.186
		System.out.println(addr.getHostName());//输出www.163.com
		
		//根据IP得到InetAddress对象
		addr=InetAddress.getByName("123.56.138.176");
		System.out.println(addr.getHostAddress());//返回服务器的IP
		System.out.println(addr.getHostName());//输出IP而不是域名
	}

}




