package com.sxt.syn;
/**
 * 生产者----缓冲区----消费者
 * 多线程     容器(并发) 多线程
 *          存与取
 * @author Pandamin
 * wait()与sleep()都是阻塞，但是wait()会释放锁
 */
public class 线程管程法 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynContainer container=new SynContainer();
		new Productor(container).start();
		new Consumer(container).start();
	}
}
//生产者
class Productor extends Thread{
	SynContainer container;
	
	public Productor(SynContainer container) {
		super();
		this.container = container;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<100;i++){
			System.out.println("生产第"+i+"个商品");
			container.push(new Steamedbun(i));
		}
	}
}
//消费者
class Consumer extends Thread{
	SynContainer container;
	
	public Consumer(SynContainer container) {
		super();
		this.container = container;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<1000;i++){
			System.out.println("消费第"+container.pop().id+"个商品");
			container.push(new Steamedbun(i));
		}
	}
}
//缓冲区
class SynContainer{
	Steamedbun[] buns=new Steamedbun[10];
	int count=0;
	//存
	public synchronized void push(Steamedbun bun) {
		//何时生产 容器存在空间
		//存在空间可以生产
		//不能生产
		if(count==buns.length){
			try {
				this.wait();//线程阻塞，消费者通知生产解除
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//存在空间，可以生产
		buns[count++]=bun;
		this.notifyAll();//唤醒
	}
	//取
	public synchronized Steamedbun pop() {
		//何时消费 容器中是否存在数据
		//没有数据 只有等待
		if(count==0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//线程阻塞，生产者通知消费解除
		}
		//存在数据可以消费
		count--;
		//Steamedbun buns=buns[count];
		this.notifyAll();//唤醒
		//return buns;
		return null;
	}
}
//数据(商品)
class Steamedbun{
	int id;
	public Steamedbun(int id) {
		super();
		this.id = id;
	}
}