package com.sxt.thread;
/**
 * ������Դ������(һ����Դ�ж������),��Ҫ��֤�̰߳�ȫ
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
		//һ����Դ
		Web12306 web=new Web12306();
		//�������
		new Thread(web,"��").start();
		new Thread(web,"��ũ").start();
		new Thread(web,"���").start();
	}
	
}
