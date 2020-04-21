package com.sxt.thread;
/**
 * 线程的优先级 1-10(代表概率)
 * 1.NORM_PRIORITY 5 默认
 * 2.MIN_PRIORITY  1
 * 3.MAX_PRIORITY  10
 * 概率，不代表绝对的先后顺序
 * @author Pandamin
 *
 */
public class Thread_priority {
	public static void main(String[] args) {
		MyPriority mp=new MyPriority();
		
		Thread td1=new Thread(mp,"回来");
		Thread td2=new Thread(mp,"回答");
		Thread td3=new Thread(mp,"回力");
		
		//设置优先级需要在启动前
		td1.setPriority(Thread.MAX_PRIORITY);
		td2.setPriority(4);
		td3.setPriority(Thread.MIN_PRIORITY);
		td1.start();
		td2.start();
		td3.start();
	}
}
class MyPriority implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName()+"——>"+Thread.currentThread().getPriority());
		Thread.yield();
	}
	
}
