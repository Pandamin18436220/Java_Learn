package com.sxt.thread;
/**
 * ÿ���̶߳����Լ��Ĺ����ռ䣬���߳̾����乤���ռ���cpu�ĵ�������
 * 
 * 
 * ����״̬:Thread t=new Thread();�̶߳���һ�������ͽ���������״̬
 * ����״̬:start();�����¼����;���е���yield();[jvm�ӱ����߳��л������߳�(�ڲ�ʵ��)]���ø÷����������״̬
 * ����״̬:sleep();wait();join();IO������read(),write()
 * ����״̬:�߳������������߳���Ĵ���
 * ����״̬:����ִ����;�뷽�跨�ô���ִ����;ʹ��stop()[�ṩboolean����ֹ������Ϊfalseʱ����ֹ�̵߳�����]ֹͣ�߳�
 * @author Pandamin
 * 
 */
public class Thread_״̬ implements Runnable{
	private boolean flag=true;
	private String name;
	
	public Thread_״̬(String name) {
		super();
		this.name = name;
	}
	
	public void run() {
		while(flag){
			System.out.println(name+"��������");
		}
	}
	public void stop() {
		this.flag=false;
	}
	public static void main(String[] args) {
		Thread_״̬  tt=new Thread_״̬("pandamin");
		new Thread(tt).start();
		for(int i=1;i<99;i++){
			if(i==88){
				tt.stop();
				System.out.println("�߳���ֹ");
			}
			System.out.println("main-->"+i);
		}
	}
}
