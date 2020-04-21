package com.sxt.thread;
/**
 * 该阻塞线程方法是成员方法，需要new Thread()才可以用
 * 而yield()和sleep()都是静态方法
 * 
 * jion合并线程，带此线程完成之后，再去完成其他线程，其他线程阻塞
 * @author Pandamin
 *
 */
public class BlockJion02 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("爸爸和儿子买烟的故事");
		new Thread(new Father()).start();
	}
}
class Father extends Thread{
	public void run(){
		System.out.println("烟没有了！");
		System.out.println("让儿子去买烟！");
		Thread t=new Thread(new Son());
		t.start();
		try {
			t.join();//father被阻塞
			System.out.println("老爸接过烟，把零钱给了儿子");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("孩子走丢了！");
		}
	}
}
class Son extends Thread{
	public void run(){
		System.out.println("接过老爸的钱，去买烟");
		System.out.println("路边有个游戏机玩了10s");
		for(int i=0;i<10;i++){
			System.out.println(i+"秒过去了！");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("想起来还要去买烟！");
		System.out.println("手拿一包中华回来了！");
	}
}
