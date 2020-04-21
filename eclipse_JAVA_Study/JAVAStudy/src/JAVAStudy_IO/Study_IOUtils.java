package JAVAStudy_IO;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Study_IOUtils {
	public static void main(String[] args) {
		try {
			InputStream is=new FileInputStream("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src/JAVAStudy_IO/abc.txt");
			OutputStream os=new FileOutputStream("abc_cp.txt");
			copy(is,os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//法二:
	//try with resoures jdk1.7
	/*
	public static void copy(InputStream is,OutputStream os) {
		try(is;os) {
			byte[] car=new byte[1024];
			int len=-1;
			while((len=is.read())!=-1){
				os.write(car, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	//法一:
	public static void copy(InputStream is,OutputStream os) {
		try {
			byte[] car=new byte[1024];
			int len=-1;
			while((len=is.read())!=-1){
				os.write(car, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//先打开的后关闭
			close(is,os);
		}
	}
	public static void close(Closeable...oss){
		for(Closeable os:oss){
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
