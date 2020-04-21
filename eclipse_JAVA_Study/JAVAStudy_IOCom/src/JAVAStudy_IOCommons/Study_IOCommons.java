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
		//�ļ���С
		long len=FileUtils.sizeOf(new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy_IOCom/src/JAVAStudy_IOCommons/Study_IOCommons.java"));
		System.out.println(len);
		//Ŀ¼��С
		len=FileUtils.sizeOf(new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy_IOCom/src/JAVAStudy_IOCommons"));
		System.out.println(len);
		//�鿴���ＶĿ¼
		Collection<File> files=FileUtils.listFiles(new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy_IOCom"), 
				EmptyFileFilter.NOT_EMPTY, null);
		/**
		 * ����һ��·��:
		 * ��������������:EmptyFileFilter.NOT_EMPTY;FileFilterUtils.or;FileFilterUtils.and
		 * ��������Ĭ��ֻ����һ��:null;DirectoryFileFilter.INSTANCE
		 */
		for(File file:files){
			System.out.println(file.getAbsolutePath());
		}
		files=FileUtils.listFiles(new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy_IOCom"), 
				FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class"),EmptyFileFilter.EMPTY), DirectoryFileFilter.INSTANCE);
		//DirectoryFileFilter.INSTANCE����ʵ�ֲ鿴���Ｖ
		for(File file:files){
			System.out.println(file.getAbsolutePath());
		}
		//��ȡ����
		String msg=FileUtils.readFileToString(new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy_IOCom/src/JAVAStudy_IOCommons/emp.txt"),"GBK");
		System.out.println(msg);
		byte[] datas=FileUtils.readFileToByteArray(new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy_IOCom/src/JAVAStudy_IOCommons/emp.txt"));
		System.out.println(datas.length);
			//���ж�ȡ
		List<String> msgs=FileUtils.readLines(new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy_IOCom/src/JAVAStudy_IOCommons/emp.txt"),"gbk");
		for(String s:msgs){
			System.out.println(s);
		}
		LineIterator it=FileUtils.lineIterator(new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy_IOCom/src/JAVAStudy_IOCommons/emp.txt"),"gbk");
		while(it.hasNext()){
			System.out.println(it.nextLine());
		}
		//д������
		//FileUtils.write(new File("emp.txt"), "����", "gbk", true);
		FileUtils.writeStringToFile(new File("emp.txt"), "ѧϰ���ͣ���������", "gbk", true);
		FileUtils.writeByteArrayToFile(new File("happy.txt"), "ѧϰ����".getBytes("gbk"),true);
			//����д��
		//����д����List<String> msgs=FileUtils.writeLines(new File("happy.txt"), "�Ұ�ѧϰ", "gbk", true);
		List<String> datas1=new ArrayList<String>();
		datas1.add("ѧϰ���ѽ��");
		datas1.add("��Ҫ������ѧ��");
		datas1.add("Ӣ����ͣ�");
		FileUtils.writeLines(new File("happy.txt"), datas1,"--",true);
	}
}
