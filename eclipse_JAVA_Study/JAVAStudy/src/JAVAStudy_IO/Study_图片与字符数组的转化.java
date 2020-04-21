package JAVAStudy_IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Study_图片与字符数组的转化 {
	/**
	 * File-->ByteArray
	 */
	public static void main(String[] args) {
		byte[] datas=File2ByteArray("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src/1.jpg");
		System.out.println(datas.length);
		ByteArray2File(datas,"1.jpg");
	}
	public static void ByteArray2File(byte[] ByteFile,String FilePath) {
		File src=new File(FilePath);
		System.out.println(src);
		InputStream bis=null;
		OutputStream os=null;
		try{
			bis=new ByteArrayInputStream(ByteFile);
			os=new FileOutputStream(src);
			System.out.println(os);
			byte[] car=new byte[1024];
			int len=-1;
			while((len=bis.read(car))!=-1){
				os.write(car, 0, len);
				System.out.println(os);
			}
			os.flush();
		}catch (Exception e) {
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
	public static byte[] File2ByteArray(String FilePath) {
		File src=new File(FilePath);
		byte[] dest=null;
		InputStream is=null;
		OutputStream bos=null;
		try {
			is=new FileInputStream(src);
			bos=new ByteArrayOutputStream();
			
			byte[] car=new byte[1024];
			int len=-1;
			while((len=is.read(car))!=-1){
				String s=new String(car,0,len);
				bos.write(car, 0, len);
			}
			bos.flush();
			return ((ByteArrayOutputStream) bos).toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
