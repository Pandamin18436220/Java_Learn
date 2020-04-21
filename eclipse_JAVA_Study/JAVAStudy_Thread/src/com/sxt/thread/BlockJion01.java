package com.sxt.thread;
/**
 * �������̷߳����ǳ�Ա��������Ҫnew Thread()�ſ�����
 * ��yield()��sleep()���Ǿ�̬����
 * @author Pandamin
 *
 */
public class BlockJion01 {
	public static void main(String[] args) throws InterruptedException {
		
	Thread t=new Thread(new Runnable() {
		public void run() {
			for(int i=1;i<100;i++){
				System.out.println("lambda...."+i);
			}
		}
	});
	t.start();
	for(int i=0;i<100;i++){
		if(i==20){
			t.join();//��ӣ�main()���̱߳�����
		}
		System.out.println("main..."+i);
	}
	}
}
class MyJion implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->Start");
		Thread.yield();//����
		System.out.println(Thread.currentThread().getName()+"--->End");
	}	
}
