package JAVAStudy_常用类;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Study_File {
	public static void main(String[] args) throws IOException {
		File f1=new File("a.txt");
		f1.createNewFile();
		f1.renameTo(new File("d:/bb.txt"));
		System.out.println(f1.exists());
		System.out.println(f1.isAbsolute());
		System.out.println(f1.getAbsolutePath());
		System.out.println(new Date(f1.lastModified()));
		File f=new File("C:/Users/Pandamin/Desktop/golf/老代码研究/研究材料/Nao代码/代码整理 红");
		printFile(f,0);
	}
	static void printFile(File file,int level){
		for(int i=0;i<level;i++){
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()){
			File[] files=file.listFiles();
			for(File temp:files){
				printFile(temp,level+1);
			}
		}
	}

}
