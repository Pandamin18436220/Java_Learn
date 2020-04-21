package com.sxt.syn;
/**
 * 线程不安全：有负数和相同的情况
 * @author Pandamin
 *
 */
public class UnsafeTest01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//一份资源
		UnsafeWeb_12306 web=new UnsafeWeb_12306();
		
		//多个代理
		new Thread(web,"马处").start();
		new Thread(web,"码农").start();
		new Thread(web,"蚂蟥").start();
	}

}
class UnsafeWeb_12306 implements Runnable{
	private int ticketNums=10;
	private boolean flag=true;
	public void run() {
		while(flag){
			test5();
		}
	}
	//尽可能锁住合理的范围(不是指的代码,而是指数据的完整性)
	//双重检测****
	public void test5(){
		if(ticketNums<0){//考虑的是没有票的情况
			flag=false;
			return;
		}
		synchronized(this){//考虑最后的票只有1张的情况
		if(ticketNums<0){
			flag=false;
			return;
		}
		//模拟网络延时
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
		}
	}
	//范围太小所不住，范围太大，效率低下
	public void test4(){
		synchronized(this){
		if(ticketNums<0){
			flag=false;
			return;
		}
		}
		//模拟网络延时
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
	}
	//线程任然不安全，ticketNums对象在变动(其内存地址在变，锁不住！！！我们要锁内存地址不变的)
	public void test3(){
		synchronized((Integer)ticketNums){
		if(ticketNums<0){
			flag=false;
			return;
		}
		//模拟网络延时
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
		}
	}
	public void test2(){
		synchronized(this){
		if(ticketNums<0){
			flag=false;
			return;
		}
		//模拟网络延时
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
		}
	}
	//线程安全 同步
	public synchronized void test(){
		if(ticketNums<0){
			flag=false;
			return;
		}
		//模拟网络延时
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
	}
}
