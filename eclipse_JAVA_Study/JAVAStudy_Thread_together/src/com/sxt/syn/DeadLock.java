package com.sxt.syn;
/**
 * �����������ͬ����������໥���ͷ���Դ
 * �Ӷ��໥�ȴ���һ�㷢����ͬ���г��ж���������
 * 
 * ����:��Ҫ�ڴ�����У�ͬʱ���ж��������
 * @author Pandamin
 *
 */
public class DeadLock {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Makeup g1=new Makeup(1,"��Y");
		Makeup g2=new Makeup(0,"СY");
		g1.start();
		g2.start();
	}
}
//�ں�
class Lipstick{
	
}
//����
class Mirror{
	
}
//��ױ
class Makeup extends Thread{
	static Lipstick lipstick=new Lipstick();
	static Mirror mirror=new Mirror();
	int choice;
	String girl;
	public Makeup(int choice,String girl) {
		super();
		this.choice = choice;
		this.girl=girl;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		makeup();
	}
	//�໥���жԷ��Ķ�����-->�����������
	private void makeup() {
		if(choice==0){
			synchronized (lipstick) {
				System.out.println(this.girl+"��ÿں����");
				//1�����ӵ�о��ӵ���
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized (mirror) {
				System.out.println(this.girl+"�վ���");
			}
		}else{
			synchronized (mirror) {
				System.out.println(this.girl+"�վ���");
				//1�����ӵ�о��ӵ���
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized (lipstick) {
				System.out.println(this.girl+"��ÿں����");
			}
		}
	}
}

