package Study_TCP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.omg.CORBA_2_3.portable.OutputStream;

public class FileClient {

	/**
	 *  * 熟悉流程：
 * 创建客户端器
 * 1.建立连接：使用Socket创建客户端+服务器地址和端口
 * 2.操作：输入输出流
 * 3.释放资源
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
//		 * 1.建立连接：使用Socket创建客户端+服务器地址和端口
		Socket client = new Socket("localhost",8888);
//		 * 2.操作：输入输出流
		InputStream is = new BufferedInputStream(new FileInputStream("src/2.jpg"));
		BufferedOutputStream os = new BufferedOutputStream(client.getOutputStream());
		byte[] flush = new byte[1024];
		int len = -1;
		while((len=is.read(flush))!=-1){
			System.out.println();
			os.write(flush,0,len);
		}
		os.flush();
//		 * 3.释放资源
		os.close();
		is.close();
		client.close();
	}

}
