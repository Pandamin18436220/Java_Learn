package JAVAStudy_Page;

import java.util.Scanner;

/**
 * 键盘输入
 * @author 潘晟凯
 */
public class Study_Scanner {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入名字：");
		
		//可以通过scanner.nextLine()获取输入的字符串信息
		String name=scanner.nextLine();
		
		System.out.println("请输入你的爱好：");
		String favor=scanner.nextLine();
		
		//通过scanner.nextInt()获取输入整型数据的信息
		System.out.println("请输入你的年龄：");
		int age=scanner.nextInt();
		
		System.out.println("##############################");
		System.out.println("name:"+name);
		System.out.println("favor:"+favor);
		System.out.println("age:"+age);
		
	}
	
}
