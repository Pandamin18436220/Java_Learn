package com.sxt.syn;
/**
 * �̲߳���ȫ���и�������ͬ�����
 * @author Pandamin
 *
 */
public class UnsafeTest02 {
	public static void main(String[] args) {
		Account account=new Account(1000,"���");
		
		Drawing you=new Drawing(account,80,"�Լ�");
		Drawing wife=new Drawing(account,90,"��");
		you.start();
		wife.start();
	}
}
class Account{
	int money;
	String name;
	public Account(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}
}
//�̰߳�ȫ+��
class Drawing extends Thread{
	Account account;
	int drawingMoney;
	int packetTotal;
	
	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	public void run() {
		test();
	}
	//����account
	public void test(){
		//�ṩ���ܵĴ���
		if(account.money<=0){
			return;
		}
		//ͬ����
		synchronized(account){
		if(account.money-drawingMoney<0){
			return;
		}//��Ҫ�����ſ���
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		super.run();
		account.money-=drawingMoney;
		packetTotal+=drawingMoney;
		System.out.println(this.getName()+"-->�˺����Ϊ��"+account.money);
		System.out.println(this.getName()+"-->�ڴ����Ϊ��"+packetTotal);
	}
	}
}