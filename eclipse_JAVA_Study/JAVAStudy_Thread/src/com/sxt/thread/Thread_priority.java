package com.sxt.thread;
/**
 * �̵߳����ȼ� 1-10(�������)
 * 1.NORM_PRIORITY 5 Ĭ��
 * 2.MIN_PRIORITY  1
 * 3.MAX_PRIORITY  10
 * ���ʣ���������Ե��Ⱥ�˳��
 * @author Pandamin
 *
 */
public class Thread_priority {
	public static void main(String[] args) {
		MyPriority mp=new MyPriority();
		
		Thread td1=new Thread(mp,"����");
		Thread td2=new Thread(mp,"�ش�");
		Thread td3=new Thread(mp,"����");
		
		//�������ȼ���Ҫ������ǰ
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
		System.out.println(Thread.currentThread().getName()+"����>"+Thread.currentThread().getPriority());
		Thread.yield();
	}
	
}
