package com.sxt.thread;
/**
 * 静态代理
 * 接口：这两个角色都需要实现相同的接口
 * 1.真实角色
 * 2.代理角色
 * @author Pandamin
 *
 */
public class Study_StaticProxy {
	public static void main(String[] args) {
		new WeiddingCompany(new You()).happyMarry();
		//new Thread(线程对象).start();
	}
}
interface Marry{
	void happyMarry();
}
//真实角色
class You implements Marry{

	public void happyMarry() {
		// TODO Auto-generated method stub
		System.out.println("you and 嫦娥终于奔月了!");
	}
}
//代理角色
class WeiddingCompany implements Marry{
	//真实角色
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
		System.out.println("布置猪窝");
	}
	private void after(){
		System.out.println("闹玉兔");
	}
	
}
