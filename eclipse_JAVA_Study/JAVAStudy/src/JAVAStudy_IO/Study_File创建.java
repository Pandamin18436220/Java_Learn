package JAVAStudy_IO;

import java.io.File;
import java.io.IOException;

public class Study_File���� {
	public static void main(String[] args) throws IOException {
		File src=new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy/src/1.jpg");
		/**
		 * createNewFile():�����ڲŴ��������ڲ�����
		 * delete():ɾ���Ѿ����ڵ��ļ�
		 */
		boolean flag=src.createNewFile();
		
		System.out.println(flag);
	}
}
