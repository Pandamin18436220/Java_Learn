package com.sxt.thread;
/**
 * �����̷߳���һ��
 * 1.�������̳�Thread+��дrun
 * 2.�����������������+start
 * @author Pandamin
 *
 */
public class StartThread extends Thread{
	/*
	 * �̵߳���ڵ�
	 */
	public void run() {
		for(int i=0;i<20;i++){
			System.out.println("һ������");
		}
	}
	public static void main(String[] args) {
		//�����������
		StartThread st=new StartThread();
		//�����߳�
		st.start();//��cup�Լ�ȥ����run����
		for(int i=0;i<20;i++){
			System.out.println("һ��coding");
		}
	}
}
