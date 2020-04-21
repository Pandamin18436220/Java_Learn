package com.sxt.thread;
/**
 * 1 创建：实现Runnable+重写run
 * 2 启动：创建实现类对象+Thread对象+start
 * 
 * 推荐使用接口，方便共享资源，避免单继承的局限性
 * @author Pandamin
 *
 */
public class StartThread2 implements Runnable{

	public void run() {
		for(int i=1;i<20;i++){
			System.out.println("我正在学习");
		}
	}
	public static void main(String[] args) {
		/*
		StartThread2 st=new StartThread2();
		Thread td=new Thread(st);
		td.start();*/
		new Thread(new StartThread2()).start();
		for(int i=1;i<20;i++){
			System.out.println("我正在刷抖音");
		}
	}
	
}
