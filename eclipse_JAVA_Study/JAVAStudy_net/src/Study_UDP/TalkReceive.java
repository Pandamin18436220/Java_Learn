package Study_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ���ܶˣ�ʹ����������װ
 * @author Pandamin
 *
 */
public class TalkReceive implements Runnable{
	DatagramSocket server;
	TalkReceive(int port){
		try {
			server = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			byte[] container = new byte[1024*60];
			DatagramPacket packet = new DatagramPacket(container,0,container.length);
//			 * 3.����ʽ���հ���receive(DatagramPacket p)
			try {
				server.receive(packet);
//				 * 4.��������
//				 * 	4.1byte[] getDate()
//				 *  4.2byte[] getLength()
				byte[] datas = packet.getData();
				int len = packet.getLength();
				String data = new String(datas,0,len);
				System.out.println(data);
				
				if(data.equals("bye")){
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		server.close();
	}

}
