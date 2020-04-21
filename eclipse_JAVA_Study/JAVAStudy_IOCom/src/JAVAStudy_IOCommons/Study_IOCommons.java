package JAVAStudy_IOCommons;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;


public class Study_IOCommons {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//文件大小
		long len=FileUtils.sizeOf(new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy_IOCom/src/JAVAStudy_IOCommons/Study_IOCommons.java"));
		System.out.println(len);
		//目录大小
		len=FileUtils.sizeOf(new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy_IOCom/src/JAVAStudy_IOCommons"));
		System.out.println(len);
		//查看子孙级目录
		Collection<File> files=FileUtils.listFiles(new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy_IOCom"), 
				EmptyFileFilter.NOT_EMPTY, null);
		/**
		 * 参数一：路径:
		 * 参数二：过滤器:EmptyFileFilter.NOT_EMPTY;FileFilterUtils.or;FileFilterUtils.and
		 * 参数三：默认只操作一层:null;DirectoryFileFilter.INSTANCE
		 */
		for(File file:files){
			System.out.println(file.getAbsolutePath());
		}
		files=FileUtils.listFiles(new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy_IOCom"), 
				FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class"),EmptyFileFilter.EMPTY), DirectoryFileFilter.INSTANCE);
		//DirectoryFileFilter.INSTANCE可以实现查看子孙级
		for(File file:files){
			System.out.println(file.getAbsolutePath());
		}
		//读取内容
		String msg=FileUtils.readFileToString(new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy_IOCom/src/JAVAStudy_IOCommons/emp.txt"),"GBK");
		System.out.println(msg);
		byte[] datas=FileUtils.readFileToByteArray(new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy_IOCom/src/JAVAStudy_IOCommons/emp.txt"));
		System.out.println(datas.length);
			//逐行读取
		List<String> msgs=FileUtils.readLines(new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy_IOCom/src/JAVAStudy_IOCommons/emp.txt"),"gbk");
		for(String s:msgs){
			System.out.println(s);
		}
		LineIterator it=FileUtils.lineIterator(new File("C:/Users/Pandamin/Desktop/JAVA后端学习/JAVAStudy_IOCom/src/JAVAStudy_IOCommons/emp.txt"),"gbk");
		while(it.hasNext()){
			System.out.println(it.nextLine());
		}
		//写出内容
		//FileUtils.write(new File("emp.txt"), "加油", "gbk", true);
		FileUtils.writeStringToFile(new File("emp.txt"), "学习加油，出国加油", "gbk", true);
		FileUtils.writeByteArrayToFile(new File("happy.txt"), "学习加油".getBytes("gbk"),true);
			//逐行写出
		//错误写法：List<String> msgs=FileUtils.writeLines(new File("happy.txt"), "我爱学习", "gbk", true);
		List<String> datas1=new ArrayList<String>();
		datas1.add("学习你好呀！");
		datas1.add("我要出国留学！");
		datas1.add("英语加油！");
		FileUtils.writeLines(new File("happy.txt"), datas1,"--",true);
	}
}
