package com.sxt.thread;
/**
 * 创建线程方法一：
 * 1.创建：继承Thread+重写run
 * 2.启动：创建子类对象+start
 * @author Pandamin
 *
 */
public class StartThread extends Thread{
	/*
	 * 线程的入口点
	 */
	public void run() {
		for(int i=0;i<20;i++){
			System.out.println("一边听歌");
		}
	}
	public static void main(String[] args) {
		//创建子类对象
		StartThread st=new StartThread();
		//启动线程
		st.start();//由cup自己去调用run方法
		for(int i=0;i<20;i++){
			System.out.println("一边coding");
		}
	}
}
