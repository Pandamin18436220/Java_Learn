package JAVAStudy_IO;

import java.io.File;

public class Study_递归打印子目录 {
	private static long len=0;
	public static void main(String[] args) {
		File src=new File("C:/Users/Pandamin/Desktop/JAVA后端学习");
		printName(src,0);
		count(src);
		System.out.println(len);
	}
	public static void printName(File src,int deep) {
		System.out.println(src.getPath());
		for(int i=1;i<deep;i++){
			System.out.print("-");
		}
		if(!src.exists()||null==src){
			return;
		}else if(src.isDirectory()){
			for(File s:src.listFiles()){
				printName(s,deep+1);
			}
		}	
	}
	public static void count(File src){
		if(src.exists()&&src!=null){
			len+=src.length();
		}else{
			for(File f:src.listFiles()){
				count(f);
			}
		}
	}
	
}
