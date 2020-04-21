package JAVAStudy_IO;

import java.io.File;

public class Study_IOPath {
	public static void main(String[] args) {
		String path="C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src/1.jpg";
		System.out.println(File.separatorChar);
		/**
		 * 路径写法一："C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy/src/1.jpg";
		 * 路径写法二："C"+File.separator+"User"+File.separator+"Pandamin"+File.separator
		 * +"Desktop"+File.separator+"JAVA后端学习"+File.separator+"JAVAStudy"+File.separator
		 * +"scr"+File.separator+"1.jpg";
		 */
		System.out.println(path);
	}

}
