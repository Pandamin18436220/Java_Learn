package JAVAStudy_Page;
/**
 * 
 * @author Pandamin
 *java��������ڴ���Է�Ϊ��������:ջstack,��heap,������method area
 *ջ�Ƿ���ִ�е��ڴ�ģ��,ÿ�����������ö��ᴴ��һ��ջ֡���������߳�˽��
 *�����ڴ����õĶ�������飬�������̹߳����ڴ�ռ䲻����(һ��JVMֻ��һ����)
 *������ʵ�����Ƕѣ�ֻ�����ڴ洢�࣬���������Ϣ
 */
public class Study_class_UML {
	//һ��java�ļ�ֻ����һ����public���ε���
	
	/**
	 * @param args
	 */
	//����
	int id;
	String sname;
	int age;
	Computer comp;
	//���췽��
	Study_class_UML(){
		
	}
	
	//����
	void study(){
		System.out.println("������Ŭ��ѧϰ��,ʹ�õ���:"+comp.brand);
	}
	void play(){
		System.out.println("����������Ϸ��");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Study_class_UML stu=new Study_class_UML();
		stu.id=1001;
		stu.age=18;
		stu.sname="pandamin";
		Computer c1=new Computer();
		c1.brand="����";
		stu.comp=c1;
		stu.play();
		stu.study();
	}
}

class Computer{
	String brand;
	
}