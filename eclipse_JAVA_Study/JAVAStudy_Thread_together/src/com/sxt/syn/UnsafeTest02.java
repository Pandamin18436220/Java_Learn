package com.sxt.syn;
/**
 * 线程不安全：有负数和相同的情况
 * @author Pandamin
 *
 */
public class UnsafeTest02 {
	public static void main(String[] args) {
		Account account=new Account(1000,"结婚");
		
		Drawing you=new Drawing(account,80,"自己");
		Drawing wife=new Drawing(account,90,"她");
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
//线程安全+锁
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
	//锁定account
	public void test(){
		//提供性能的代码
		if(account.money<=0){
			return;
		}
		//同步块
		synchronized(account){
		if(account.money-drawingMoney<0){
			return;
		}//需要加锁才可以
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
		System.out.println(this.getName()+"-->账号余额为："+account.money);
		System.out.println(this.getName()+"-->口袋余额为："+packetTotal);
	}
	}
}