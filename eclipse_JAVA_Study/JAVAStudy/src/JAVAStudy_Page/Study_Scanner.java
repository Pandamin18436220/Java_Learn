package JAVAStudy_Page;

import java.util.Scanner;

/**
 * ��������
 * @author ���ɿ�
 */
public class Study_Scanner {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("���������֣�");
		
		//����ͨ��scanner.nextLine()��ȡ������ַ�����Ϣ
		String name=scanner.nextLine();
		
		System.out.println("��������İ��ã�");
		String favor=scanner.nextLine();
		
		//ͨ��scanner.nextInt()��ȡ�����������ݵ���Ϣ
		System.out.println("������������䣺");
		int age=scanner.nextInt();
		
		System.out.println("##############################");
		System.out.println("name:"+name);
		System.out.println("favor:"+favor);
		System.out.println("age:"+age);
		
	}
	
}
