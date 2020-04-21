package com.sxt.thread;
/**
 * 每个线程都有自己的工作空间，多线程就是其工作空间与cpu的调度问题
 * 
 * 
 * 新生状态:Thread t=new Thread();线程对象一旦创建就进入了新生状态
 * 就绪状态:start();阻塞事件解除;运行调用yield();[jvm从本地线程切换其他线程(内部实现)]调用该方法进入就绪状态
 * 阻塞状态:sleep();wait();join();IO操作：read(),write()
 * 运行状态:线程真正的运行线程体的代码
 * 死亡状态:代码执行完;想方设法让代码执行完;使用stop()[提供boolean型终止变量，为false时，终止线程的运行]停止线程
 * @author Pandamin
 * 
 */
public class Thread_状态 implements Runnable{
	private boolean flag=true;
	private String name;
	
	public Thread_状态(String name) {
		super();
		this.name = name;
	}
	
	public void run() {
		while(flag){
			System.out.println(name+"正在跳舞");
		}
	}
	public void stop() {
		this.flag=false;
	}
	public static void main(String[] args) {
		Thread_状态  tt=new Thread_状态("pandamin");
		new Thread(tt).start();
		for(int i=1;i<99;i++){
			if(i==88){
				tt.stop();
				System.out.println("线程终止");
			}
			System.out.println("main-->"+i);
		}
	}
}
