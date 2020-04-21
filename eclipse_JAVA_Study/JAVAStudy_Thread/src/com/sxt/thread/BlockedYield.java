package com.sxt.thread;
/**
 * yield�����̣߳���ʱ�̣߳�ֱ�ӽ������״̬��������״̬
 * @author Pandamin
 *
 */
public class BlockedYield {
	public static void main(String[] args) {
		/*
		MyYield my=new MyYield();
		new Thread(my,"a").start();
		new Thread(my,"b").start();
		*/
		new Thread(new Runnable(){
			public void run() {
				for(int i=1;i<100;i++){
					System.out.println("lambda...."+i);
				}		
			}
		}).start();
		
		for(int i=0;i<100;i++){
			if(i%20==0){
				Thread.yield();
			}
			System.out.println("main..."+i);
		}
	}
	
}
class MyYield implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->Start");
		Thread.yield();//����
		System.out.println(Thread.currentThread().getName()+"--->End");
	}	
}
