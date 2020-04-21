package JAVAStudy_Encapsulation;
/**
 * 
 * @author Pandamin
 * ��̬��ָ�����Ķ�̬
 * ��̬����������:
 * �̳�+������Ū+��������ָ���������
 */
class Animal{
	public void shout(){
		System.out.println("����һ����");
	}
}
class Dog extends Animal{
	public void shout(){
		System.out.println("��������");
	}
	public void seeDoor(){
		System.out.println("������...");
	}
}
class Cat extends Animal{
	public void shout(){
		System.out.println("��������");
	}
}
public class Study_polymorphism {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal an=new Animal();
		animalCry(an);
		/**
		 * ������󣺹��������˸���Animal a
		 * ������������ָ����������Ҹ÷���Ϊstatic
		 */
		Dog d=new Dog();
		animalCry(d);
		
		
		/**
		 * ����ת�ͣ������Ϊ�������ͣ��Զ�
		 */
		Animal a1=new Dog();
		/**
		 * ����ת�ͣ��������������ͣ�ǿ�ƣ�(ǿ��ת�����ܴ�������)
		 */
		Dog d1=(Dog) a1;
		
	}
	static void animalCry(Animal a){
		a.shout();
	}

}
