package JAVAStudy_Page;
/**
 * 
 * @author Pandamin
 *java虚拟机的内存可以分为三个区域:栈stack,堆heap,方法区method area
 *栈是方法执行的内存模型,每个方法被调用都会创建一个栈帧，且属于线程私有
 *堆用于创建好的对象和数组，被所有线程共享，内存空间不连续(一个JVM只有一个堆)
 *方法区实际上是堆，只是用于存储类，常量相关消息
 */
public class Study_class_UML {
	//一个java文件只能有一个由public修饰的类
	
	/**
	 * @param args
	 */
	//属性
	int id;
	String sname;
	int age;
	Computer comp;
	//构造方法
	Study_class_UML(){
		
	}
	
	//方法
	void study(){
		System.out.println("我正在努力学习！,使用电脑:"+comp.brand);
	}
	void play(){
		System.out.println("我正在玩游戏！");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Study_class_UML stu=new Study_class_UML();
		stu.id=1001;
		stu.age=18;
		stu.sname="pandamin";
		Computer c1=new Computer();
		c1.brand="联想";
		stu.comp=c1;
		stu.play();
		stu.study();
	}
}

class Computer{
	String brand;
	
}