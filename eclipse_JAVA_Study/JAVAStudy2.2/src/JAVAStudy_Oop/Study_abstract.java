package JAVAStudy_Oop;
/**
 * 抽象类的意义:
 * 为子类提供统一的规范的模板，子类必须实现相关的抽象方法
 * @author Pandamin
 *
 */
public abstract class Study_abstract {
	abstract public void shout();
	public void run(){
		System.out.println("跑跑跑！");
	}
	public static void main(String[] args) {
		Study_abstract animal=new Dog();
	}
}
class Dog extends Study_abstract{

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("汪汪汪！");
	}
	
}
