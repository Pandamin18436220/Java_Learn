package JAVAStudy_IOCommons;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Study_IOcopy {
	public static void main(String[] args) throws IOException {
		/*
		//�����ļ�
		FileUtils.copyFile(new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy_IOCom/src/1.jpg"), new File("copy.png"));
		//�����ļ���Ŀ¼
		FileUtils.copyFileToDirectory(new File("copy.png"), new File("lib"));
		//����Ŀ¼��Ŀ¼(����lib���Ƶ�lib2,��Ϊlib2����Ŀ¼)
		FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
		//����Ŀ¼
		FileUtils.copyDirectory(new File("lib"), new File("lib2"));
		//��������
		String url=null;
		FileUtils.copyURLToFile(new URL(url), new File("marvel.jpg"));
		*/
		String datas=IOUtils.toString(new URL("http://www.baidu.com"), "UTF-8");
		System.out.println(datas);
	}
}
