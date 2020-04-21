package JAVAStudy_IO;

import java.io.File;

/**
 * ����Ŀ¼
 * mkdir():ȷ���ϼ�Ŀ¼����
 * mkdirs():�ϼ�Ŀ¼������Ҳ�ᴴ����
 * list():�г��¼�����
 * listFIle():�г��¼�����
 * listRoots():�г��̷�
 * @author Pandamin
 *
 */
public class Study_IO_dir {
	public static void main(String[] args) {
		File dir=new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy/src");
		boolean flag=dir.mkdirs();
		System.out.println(flag);
		String[] subNames=dir.list();
		File[] subFiles=dir.listFiles();
		for(String name:subNames){
			System.out.println(name);
		}
		for(File file:subFiles){
			System.out.println(file);
		}
		File[] roots=dir.listRoots();
		for(File root:roots){
			System.out.println(root);
		}
	}
}
