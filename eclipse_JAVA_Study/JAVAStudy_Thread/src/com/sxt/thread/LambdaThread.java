package com.sxt.thread;
/**
 * Lambda ���ʽ���̵߳�ʹ��
 * @author Pandamin
 *
 */
public class LambdaThread {
	/*�Ƶ�һ
	//��̬�ڲ���
	static class Test implements Runnable{
		public void run() {
			for(int i=1;i<20;i++){
				System.out.println("������ѧϰ");
			}
		}
	}
	public static void main(String[] args) {
		new Thread(new Test()).start();
	}*/
	public static void main(String[] args) {
		//new Thread(new Test()).start();
		//�ֲ��ڲ���
		class Test implements Runnable{
			public void run() {
				for(int i=1;i<20;i++){
					System.out.println("������ѧϰ");
				}	
			}
		}
		new Thread(new Test()).start();
		//�����ڲ��ࣺ�����ӿڻ��߸���
		new Thread(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<20;i++){
					System.out.println("������ѧϰ");
				}	
			}
		}).start();
		//jdk8��lambda
		/*
		new Thread(()-> {
			for(int i=1;i<20;i++){
				System.out.println("������ѧϰ");
			}	
		}
		).start();
		*/
	}
}
/**
�����ڲ�����ܣ�
�����ڲ���Ҳ����û�����ֵ��ڲ���
����Ϊû�����֣����������ڲ���ֻ��ʹ��һ�Σ���ͨ�������򻯴����д
��ʹ�������ڲ��໹�и�ǰ������������̳�һ�������ʵ��һ���ӿ�
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
�����ڲ��ࣺ
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