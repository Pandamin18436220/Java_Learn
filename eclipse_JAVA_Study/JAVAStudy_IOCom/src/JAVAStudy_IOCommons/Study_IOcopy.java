package JAVAStudy_IOCommons;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Study_IOcopy {
	public static void main(String[] args) throws IOException {
		/*
		//复制文件
		FileUtils.copyFile(new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy_IOCom/src/1.jpg"), new File("copy.png"));
		//复制文件到目录
		FileUtils.copyFileToDirectory(new File("copy.png"), new File("lib"));
		//复制目录到目录(即将lib复制到lib2,成为lib2的子目录)
		FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
		//复制目录
		FileUtils.copyDirectory(new File("lib"), new File("lib2"));
		//复制内容
		String url=null;
		FileUtils.copyURLToFile(new URL(url), new File("marvel.jpg"));
		*/
		String datas=IOUtils.toString(new URL("http://www.baidu.com"), "UTF-8");
		System.out.println(datas);
	}
}
