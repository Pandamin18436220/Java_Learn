package Study_UDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 
 * @author Pandamin
 * 1.使用DatagramSocket 指定端口，创建接收端
 * 2.将基本类型转成字节数组
 * 3.封装成DatagramPacket 包裹需要指定目的地
 * 4.发送包裹receive(DatagramPacket p)
 * 5.释放资源
 */
public class UDPFile_client {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中....");
//		1.使用DatagramSocket 指定端口，创建接收端
		DatagramSocket client = new DatagramSocket(8888);
		
//		2.准备数据 一定转成字节数组
		byte[] datas = IOUtils.fileToByteArray("src/2.jpg");
		
//		3.封装成DatagramPacket 包裹需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
		
//		4.发送包裹receive(DatagramPacket p)
		client.send(packet);
//		5.释放资源
		client.close();
	}
}
