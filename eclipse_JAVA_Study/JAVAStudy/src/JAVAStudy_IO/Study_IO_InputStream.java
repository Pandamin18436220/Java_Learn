package JAVAStudy_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * 创建源
 * 选择流
 * 操作
 * 释放
 * @author Pandamin
 *
 */
public class Study_IO_InputStream {
	public static void main(String[] args) {
		//创建源
		File src=new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src/JAVAStudy_IO/abc.txt");
		InputStream is=null;
		try {
			//选择流
			is=new FileInputStream(src);
			/*全部读取
			int temp;
			while((temp=is.read())!=-1){
				System.out.println((char)temp);
			}*/
			//一段一段读取
			//操作
			byte[] car=new byte[4];//卡车大小:缓冲容器
			int length=-1;//接受长度
			while((length=is.read(car))!=-1){
				String str=new String(car,0,length);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				//释放
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
