package Study_TCP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 熟悉流程：
 * 创建服务器
 * 1.使用ServerSocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作：输入输出流
 * 4.释放资源
 * @author Pandamin
 *
 */
public class FileServer {
	public static void main(String[] args) throws IOException {
//		 * 创建服务器
//		 * 1.使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
//		 * 2.阻塞式等待连接accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
//		 * 3.操作：输入输出流
		InputStream is = new BufferedInputStream(client.getInputStream());
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("src/3.png"));
		byte[] flush = new byte[1024];
		int len = -1;
		while((len=is.read(flush))!=-1){
			System.out.println();
			os.write(flush,0,len);
		}
		os.flush();
//		 * 4.释放资源
		os.close();
		is.close();
	}
}
