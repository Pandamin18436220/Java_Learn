package JAVAStudy_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Study_IO_Copy {
	public static void main(String[] args) {
		copy("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src/1.jpg","C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src/3.jpg");
	}
	public static void copy(String srcpath,String destpath) {
	File src=new File(srcpath);
	File dest=new File(destpath);
	InputStream is=null;
	OutputStream os=null;
	try {
		is=new FileInputStream(src);
		os=new FileOutputStream(dest);
		
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
		if(os!=null){
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(is!=null){
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
}
