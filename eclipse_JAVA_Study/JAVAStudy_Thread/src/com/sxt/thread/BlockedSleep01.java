package com.sxt.thread;

public class BlockedSleep01 {	
	public static void main(String[] args) {
		Thread.currentThread().getName();
		//一份资源
		Web_12306 web=new Web_12306();
		
		//多个代理
		new Thread(web,"马处").start();
		new Thread(web,"码农").start();
		new Thread(web,"蚂蟥").start();
	}
}
class Web_12306 implements Runnable{
	private int ticketNums=99;
	public void run() {
		while(true){
			if(ticketNums<0){
				break;
			}
			//模拟网络延时
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
		}
	}
}
