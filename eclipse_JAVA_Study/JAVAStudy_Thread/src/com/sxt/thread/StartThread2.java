package com.sxt.thread;
/**
 * 1 ������ʵ��Runnable+��дrun
 * 2 ����������ʵ�������+Thread����+start
 * 
 * �Ƽ�ʹ�ýӿڣ����㹲����Դ�����ⵥ�̳еľ�����
 * @author Pandamin
 *
 */
public class StartThread2 implements Runnable{

	public void run() {
		for(int i=1;i<20;i++){
			System.out.println("������ѧϰ");
		}
	}
	public static void main(String[] args) {
		/*
		StartThread2 st=new StartThread2();
		Thread td=new Thread(st);
		td.start();*/
		new Thread(new StartThread2()).start();
		for(int i=1;i<20;i++){
			System.out.println("������ˢ����");
		}
	}
	
}
