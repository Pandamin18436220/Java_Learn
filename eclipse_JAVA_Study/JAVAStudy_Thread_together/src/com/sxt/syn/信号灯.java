package com.sxt.syn;

public class 信号灯 {
	public static void main(String[] args) {
		Tv tv=new Tv();
		new Palyer(tv).start();
		new Watcher(tv).start();
	}
}
//生产者 演员
class Palyer extends Thread{
	Tv tv;
	
	public Palyer(Tv tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<20;i++){
			if(i%2==0){
				this.tv.play("pandamin");
			}else{
				this.tv.play("panchengkai");
			}
		}
	}
}
//消费者 观众
class Watcher extends Thread{
	Tv tv;
	
	public Watcher(Tv tv) {
		super();
		this.tv = tv;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;i<20;i++){
			tv.watch();
		}
	}
}
//同一个资源，电视
class Tv{
	String voice;
	//信号灯
	//如果为真，表示演员表演，观众等待
	//如果为假，表示观众观看，演员等待
	boolean flag=true;
	
	//表演
	public synchronized void play(String voice){
		//演员等待
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//表演
		System.out.println("表演了:"+voice);
		this.voice=voice;
		//唤醒
		this.notifyAll();
		//切换信号灯
		this.flag=!this.flag;
	}
	//观看
	public synchronized void watch(){
		//观众等待
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("听到了:"+voice);
		//唤醒
		this.notifyAll();
		//切换信号灯
		this.flag=!this.flag;
	}
}
