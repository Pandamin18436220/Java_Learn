package JAVAStudy_Oop;
/**
 * �����������:
 * Ϊ�����ṩͳһ�Ĺ淶��ģ�壬�������ʵ����صĳ��󷽷�
 * @author Pandamin
 *
 */
public abstract class Study_abstract {
	abstract public void shout();
	public void run(){
		System.out.println("�����ܣ�");
	}
	public static void main(String[] args) {
		Study_abstract animal=new Dog();
	}
}
class Dog extends Study_abstract{

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("��������");
	}
	
}
