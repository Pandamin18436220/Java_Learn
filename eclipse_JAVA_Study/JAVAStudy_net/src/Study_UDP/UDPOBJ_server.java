package Study_UDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 发送端
 * @author Pandamin
 * 1.使用DatagramSocket 指定端口，创建接收端
 * 2.准备容器封装成DatagramPacket 包裹
 * 3.阻塞式接收包裹receive(DatagramPacket p)
 * 4.分析数据 将基本类型还原为对应类型
 * 	4.1byte[] getDate()
 *  4.2byte[] getLength()
 * 5.释放资源
 */
public class UDPOBJ_server {
	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中....");
//		 * 1.使用DatagramSocket 指定端口，创建接收端
		DatagramSocket server = new DatagramSocket(9999);
//		 * 2.准备容器封装成DatagramPacket 包裹
		byte[] container = new byte[1024*60];
		DatagramPacket packet = new DatagramPacket(container,0,container.length);
//		 * 3.阻塞式接收包裹receive(DatagramPacket p)
		server.receive(packet);
//		 * 4.分析数据
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
		
//		 * 5.释放资源
		server.close();
	}
}