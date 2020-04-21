package JAVAStudy_IO;

import java.io.File;

/**
 * 创建目录
 * mkdir():确保上级目录存在
 * mkdirs():上级目录不存在也会创建好
 * list():列出下级名称
 * listFIle():列出下级对象
 * listRoots():列出盘符
 * @author Pandamin
 *
 */
public class Study_IO_dir {
	public static void main(String[] args) {
		File dir=new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src");
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
