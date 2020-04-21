package JAVAStudy_IO;

import java.io.File;

public class Study_IO构造器 {
	public static void main(String[] args) {
		String path="C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src/1.jpg";
		//构造函数一
		File src=new File(path);
		System.out.println(src.length());
		//构造函数二
		src=new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src","1.jpg");//路径拼接(父名称+子名称)
		System.out.println(src.length());
		//构造函数三
		src=new File(new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src"),"1.jpg");//父对象+子名称
		System.out.println(src.length());
		/**
		 * 相对路径：不存在盘符
		 * 绝对路径: 盘符
		 */
		System.out.println(System.getProperty("user.dir"));
		File src1=new File(path);
		System.out.println(src1.getAbsolutePath());
		File src2=new File("1.jpg");
		System.out.println(src2.getAbsolutePath());
		/**
		 * 文件的状态
		 */
		System.out.println(src.exists());
		System.out.println(src.isFile());
		System.out.println(src.isDirectory());
		/**
		 * 读取文件的相关操作
		 */
		File sr=new File("xxx");
		if(!sr.exists()||null==sr){
			System.out.println("文件不存在");
		}else{
			if(sr.isFile()){
				System.out.println("文件操作");
			}else{
				System.out.println("目录操作");
			}
		}
	}
}
