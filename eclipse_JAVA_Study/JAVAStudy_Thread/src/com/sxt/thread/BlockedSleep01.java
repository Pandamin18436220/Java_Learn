package com.sxt.thread;

public class BlockedSleep01 {	
	public static void main(String[] args) {
		Thread.currentThread().getName();
		//һ����Դ
		Web_12306 web=new Web_12306();
		
		//�������
		new Thread(web,"��").start();
		new Thread(web,"��ũ").start();
		new Thread(web,"���").start();
	}
}
class Web_12306 implements Runnable{
	private int ticketNums=99;
	public void run() {
		while(true){
			if(ticketNums<0){
				break;
			}
			//ģ��������ʱ
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
