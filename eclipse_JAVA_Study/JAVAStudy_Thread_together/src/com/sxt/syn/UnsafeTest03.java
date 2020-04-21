 package com.sxt.syn;
/**
 * 一般来说；存在对数据进行改的时候，我们就要控制它：并发控制保证线程安全
 * 
 * 并发：同一个对象多个线程同时操作
 * 三个重要点：1.同一个2.多个3.同时
 * 
 * 线程同步实现：
 * 1.(等待池形成)队列
 * 2.锁机制(synchronized)关键字
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程不安全：有负数和相同的情况
 * @author Pandamin
 *
 */
public class UnsafeTest03 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		//List提供了线程安全的一种方式:CopyOnWriteArrayList***高级并发
		CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
		//List<String> list=new ArrayList<String>();
		for(int i=0;i<100000;i++){
			new Thread(new Runnable() {
				public void run() {//操作容器：线程不安全
					//synchronized (list) {
						//list.add(Thread.currentThread().getName());
					//}
				}
			}).start();
		 }
		Thread.sleep(10000);
		System.out.println(list.size());
	}
}
