package Chat05;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 工具类
 * @author Pandamin
 *
 */
public class Utils {
	/**
	 * 释放资源
	 */
	public static void close(Closeable...targets){
		for(Closeable target:targets){
			try {
				if(null!=target)
					target.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(DataInputStream dis, DataOutputStream dos,
			Socket client) {
		// TODO Auto-generated method stub
		try {
			if(null!=dis)
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(null!=dos)
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(null!=client)
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
