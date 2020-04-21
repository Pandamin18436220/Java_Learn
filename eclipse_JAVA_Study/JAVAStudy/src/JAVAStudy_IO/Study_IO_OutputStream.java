package JAVAStudy_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Study_IO_OutputStream {
public static void main(String[] args) {
	File src=new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src/JAVAStudy_IO/abc.txt");
	OutputStream os=null;
	try {
		os=new FileOutputStream(src,true);//追加标识true
		String msg="IO is so easy!";
		byte[] datas=msg.getBytes();
		os.write(datas,0,datas.length);
		os.flush();//刷新，要养成习惯
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(os!=null){
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
}
