package com.sxt.thread;
/**
 * ��̬����
 * �ӿڣ���������ɫ����Ҫʵ����ͬ�Ľӿ�
 * 1.��ʵ��ɫ
 * 2.�����ɫ
 * @author Pandamin
 *
 */
public class Study_StaticProxy {
	public static void main(String[] args) {
		new WeiddingCompany(new You()).happyMarry();
		//new Thread(�̶߳���).start();
	}
}
interface Marry{
	void happyMarry();
}
//��ʵ��ɫ
class You implements Marry{

	public void happyMarry() {
		// TODO Auto-generated method stub
		System.out.println("you and �϶����ڱ�����!");
	}
}
//�����ɫ
class WeiddingCompany implements Marry{
	//��ʵ��ɫ
	private Marry target;
	
	public WeiddingCompany(Marry target) {
		super();
		this.target = target;
	}

	public void happyMarry() {
		// TODO Auto-generated method stub
		ready();
		this.target.happyMarry();
		after();
	}
	private void ready(){
		System.out.println("��������");
	}
	private void after(){
		System.out.println("������");
	}
	
}
