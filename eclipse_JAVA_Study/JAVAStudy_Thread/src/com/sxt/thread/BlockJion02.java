package com.sxt.thread;
/**
 * �������̷߳����ǳ�Ա��������Ҫnew Thread()�ſ�����
 * ��yield()��sleep()���Ǿ�̬����
 * 
 * jion�ϲ��̣߳������߳����֮����ȥ��������̣߳������߳�����
 * @author Pandamin
 *
 */
public class BlockJion02 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("�ְֺͶ������̵Ĺ���");
		new Thread(new Father()).start();
	}
}
class Father extends Thread{
	public void run(){
		System.out.println("��û���ˣ�");
		System.out.println("�ö���ȥ���̣�");
		Thread t=new Thread(new Son());
		t.start();
		try {
			t.join();//father������
			System.out.println("�ϰֽӹ��̣�����Ǯ���˶���");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�����߶��ˣ�");
		}
	}
}
class Son extends Thread{
	public void run(){
		System.out.println("�ӹ��ϰֵ�Ǯ��ȥ����");
		System.out.println("·���и���Ϸ������10s");
		for(int i=0;i<10;i++){
			System.out.println(i+"���ȥ�ˣ�");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("��������Ҫȥ���̣�");
		System.out.println("����һ���л������ˣ�");
	}
}
