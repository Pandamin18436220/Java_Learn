package JAVAStudy_IO;

import java.io.File;

public class Study_IO������ {
	public static void main(String[] args) {
		String path="C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy/src/1.jpg";
		//���캯��һ
		File src=new File(path);
		System.out.println(src.length());
		//���캯����
		src=new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy/src","1.jpg");//·��ƴ��(������+������)
		System.out.println(src.length());
		//���캯����
		src=new File(new File("C:/Users/Pandamin/Desktop/JAVA���ѧϰ/JAVAStudy/src"),"1.jpg");//������+������
		System.out.println(src.length());
		/**
		 * ���·�����������̷�
		 * ����·��: �̷�
		 */
		System.out.println(System.getProperty("user.dir"));
		File src1=new File(path);
		System.out.println(src1.getAbsolutePath());
		File src2=new File("1.jpg");
		System.out.println(src2.getAbsolutePath());
		/**
		 * �ļ���״̬
		 */
		System.out.println(src.exists());
		System.out.println(src.isFile());
		System.out.println(src.isDirectory());
		/**
		 * ��ȡ�ļ�����ز���
		 */
		File sr=new File("xxx");
		if(!sr.exists()||null==sr){
			System.out.println("�ļ�������");
		}else{
			if(sr.isFile()){
				System.out.println("�ļ�����");
			}else{
				System.out.println("Ŀ¼����");
			}
		}
	}
}
