package com.sxt.thread;
/**
 * Lambda 表达式简化线程的使用
 * @author Pandamin
 *
 */
public class LambdaThread {
	/*推导一
	//静态内部类
	static class Test implements Runnable{
		public void run() {
			for(int i=1;i<20;i++){
				System.out.println("我正在学习");
			}
		}
	}
	public static void main(String[] args) {
		new Thread(new Test()).start();
	}*/
	public static void main(String[] args) {
		//new Thread(new Test()).start();
		//局部内部类
		class Test implements Runnable{
			public void run() {
				for(int i=1;i<20;i++){
					System.out.println("我正在学习");
				}	
			}
		}
		new Thread(new Test()).start();
		//匿名内部类：借助接口或者父类
		new Thread(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<20;i++){
					System.out.println("我正在学习");
				}	
			}
		}).start();
		//jdk8简化lambda
		/*
		new Thread(()-> {
			for(int i=1;i<20;i++){
				System.out.println("我正在学习");
			}	
		}
		).start();
		*/
	}
}
/**
匿名内部类介绍：
匿名内部类也就是没有名字的内部类
正因为没有名字，所以匿名内部类只能使用一次，它通常用来简化代码编写
但使用匿名内部类还有个前提条件：必须继承一个父类或实现一个接口
abstract class Person {
    public abstract void eat();
} 
class Child extends Person {
    public void eat() {
        System.out.println("eat something");
    }
}
public class Demo {
    public static void main(String[] args) {
        Person p = new Child();
        p.eat();
    }
}
匿名内部类：
abstract class Person {
    public abstract void eat();
}
public class Demo {
    public static void main(String[] args) {
        Person p = new Person() {
            public void eat() {
                System.out.println("eat something");
            }
        };
        p.eat();
    }
}
*/