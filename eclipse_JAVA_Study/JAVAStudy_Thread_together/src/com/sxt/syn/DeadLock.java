package com.sxt.syn;
/**
 * 死锁：过多的同步可能造成相互不释放资源
 * 从而相互等待，一般发生于同步中持有多个对象的锁
 * 
 * 避免:不要在代码块中，同时持有多个对象锁
 * @author Pandamin
 *
 */
public class DeadLock {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Makeup g1=new Makeup(1,"大Y");
		Makeup g2=new Makeup(0,"小Y");
		g1.start();
		g2.start();
	}
}
//口红
class Lipstick{
	
}
//镜子
class Mirror{
	
}
//化妆
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
	//相互持有对方的对象锁-->可能造成死锁
	private void makeup() {
		if(choice==0){
			synchronized (lipstick) {
				System.out.println(this.girl+"获得口红的锁");
				//1秒后想拥有镜子的锁
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized (mirror) {
				System.out.println(this.girl+"照镜子");
			}
		}else{
			synchronized (mirror) {
				System.out.println(this.girl+"照镜子");
				//1秒后想拥有镜子的锁
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized (lipstick) {
				System.out.println(this.girl+"获得口红的锁");
			}
		}
	}
}

