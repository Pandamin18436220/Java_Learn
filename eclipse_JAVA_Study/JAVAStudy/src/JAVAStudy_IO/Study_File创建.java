package JAVAStudy_IO;

import java.io.File;
import java.io.IOException;

public class Study_File创建 {
	public static void main(String[] args) throws IOException {
		File src=new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src/1.jpg");
		/**
		 * createNewFile():不存在才创建，存在不创建
		 * delete():删除已经存在的文件
		 */
		boolean flag=src.createNewFile();
		
		System.out.println(flag);
	}
}
