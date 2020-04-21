package com.sxt.thread;
/**
 * 该阻塞线程方法是成员方法，需要new Thread()才可以用
 * 而yield()和sleep()都是静态方法
 * @author Pandamin
 *
 */
public class BlockJion01 {
	public static void main(String[] args) throws InterruptedException {
		
	Thread t=new Thread(new Runnable() {
		public void run() {
			for(int i=1;i<100;i++){
				System.out.println("lambda...."+i);
			}
		}
	});
	t.start();
	for(int i=0;i<100;i++){
		if(i==20){
			t.join();//插队，main()主线程被阻塞
		}
		System.out.println("main..."+i);
	}
	}
}
class MyJion implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--->Start");
		Thread.yield();//礼让
		System.out.println(Thread.currentThread().getName()+"--->End");
	}	
}
