package com.sxt.thread;
/**
 * 共享资源，并发(一份资源有多个代理),需要保证线程安全
 * @author Pandamin
 *
 */
public class Web12306 implements Runnable{
	private int ticketNums=99;
	public void run() {
		while(true){
			if(ticketNums<0){
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
		}
	}
	public static void main(String[] args) {
		Thread.currentThread().getName();
		//一份资源
		Web12306 web=new Web12306();
		//多个代理
		new Thread(web,"马处").start();
		new Thread(web,"码农").start();
		new Thread(web,"蚂蟥").start();
	}
	
}
