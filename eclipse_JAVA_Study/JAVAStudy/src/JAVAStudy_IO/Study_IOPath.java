package JAVAStudy_IO;

import java.io.File;

public class Study_IOPath {
	public static void main(String[] args) {
		String path="C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy/src/1.jpg";
		System.out.println(File.separatorChar);
		/**
		 * ·��д��һ��"C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy/src/1.jpg";
		 * ·��д������"C"+File.separator+"User"+File.separator+"Pandamin"+File.separator
		 * +"Desktop"+File.separator+"JAVA���ѧϰ"+File.separator+"JAVAStudy"+File.separator
		 * +"scr"+File.separator+"1.jpg";
		 */
		System.out.println(path);
	}

}
