package com.sxt.thread;
/**
 * �ػ��߳�:��Ϊ�û��̷߳���ģ�jvmֹͣ���õȴ��ػ��߳�ִ�����(***�ػ��߳�ӵ���Զ������Լ��������ڵ����ԣ������ػ��̲߳��߱�����ص�***)
 * Ĭ�ϣ��û��߳�jvm�ȴ��û��߳�ִ����ϲŻ�ֹͣ
 * @author Pandamin
 * JVM �е����������߳̾��ǵ��͵��ػ��̣߳����˵���߱������ԣ��ᷢ��ʲô�أ�
 * �� JVM Ҫ�˳�ʱ���������������̻߳��������ţ����³����޷��˳�����ͺ������ˣ������ɴ˿ɼ����ػ��̵߳���Ҫ���ˡ�
 */
public class Thread_Daemon {
	public static void main(String[] args) {
		God god=new God();
		Your you=new Your();
		/*
		new Thread(god).start();
		new Thread(you).start();
		//Ҫ�������Ļ���you if ooo��but god is still blessing you
		*/
		Thread t=new Thread(god);
		t.setDaemon(true);//Ĭ��Ϊfalse,�����Ϊ��;���û��̵߳���Ϊ�ػ�
		t.start();
		new Thread(you).start();
		
	}
}
class Your extends Thread{
	@Override
	public void run() {
		for(int i=1;i<100;i++){
			System.out.println("happy life");
		}
		System.out.println("ooooo.....");
	}
}
class God extends Thread{
	@Override
	public void run() {
		for(;;){
			System.out.println("blessing you");
		}
	}
}
