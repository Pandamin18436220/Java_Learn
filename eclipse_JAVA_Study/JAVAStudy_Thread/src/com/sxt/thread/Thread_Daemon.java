package com.sxt.thread;
/**
 * 守护线程:是为用户线程服务的，jvm停止不用等待守护线程执行完毕(***守护线程拥有自动结束自己生命周期的特性，而非守护线程不具备这个特点***)
 * 默认：用户线程jvm等待用户线程执行完毕才会停止
 * @author Pandamin
 * JVM 中的垃圾回收线程就是典型的守护线程，如果说不具备该特性，会发生什么呢？
 * 当 JVM 要退出时，由于垃圾回收线程还在运行着，导致程序无法退出，这就很尴尬了！！！由此可见，守护线程的重要性了。
 */
public class Thread_Daemon {
	public static void main(String[] args) {
		God god=new God();
		Your you=new Your();
		/*
		new Thread(god).start();
		new Thread(you).start();
		//要是这样的话，you if ooo，but god is still blessing you
		*/
		Thread t=new Thread(god);
		t.setDaemon(true);//默认为false,将其改为真;将用户线程调整为守护
		t.start();
		new Thread(you).start();
		
	}
}
class Your extends Thread{
	@Override
	public void run() {
		for(int i=1;i<100;i++){
			System.out.println("happy life");
		}
		System.out.println("ooooo.....");
	}
}
class God extends Thread{
	@Override
	public void run() {
		for(;;){
			System.out.println("blessing you");
		}
	}
}
