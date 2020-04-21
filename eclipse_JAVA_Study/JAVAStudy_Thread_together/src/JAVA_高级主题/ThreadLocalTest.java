package JAVA_高级主题;
/**
 * ThreadLocal:每个线程自身的存储本地，局部区域[类似于银行个人账户]
 * 1.get
 * 2.set
 * 3.initialValue
 * 
 * 
 * *****重点
 * ThreadLocal:分析上下文
 * 1.构造器：哪里调用就属于哪里，找线程体
 * 2.run方法属于本线程自身
 * 
 * 
 * InheritableThreadLocal继承上下文 环境的数据 起点
 * 
 * @author Pandamin
 *
 */
public class ThreadLocalTest {
	private static ThreadLocal<Integer> threadLoaclend=new InheritableThreadLocal<Integer>();
	//private static ThreadLocal<Integer> threadLoacl=new ThreadLocal<Integer>();
	
	//更改初始值:法一：
	private static ThreadLocal<Integer> threadLoacl=new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 20;
		};
	};
	//更改初始值:法二：
	//private static ThreadLocal<Integer> threadLoacl=ThreadLocal.withInitial(()->200);
	public static void main(String[] args) {
		//主线程
		//获取值
		System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
		
		//设置值
		threadLoacl.set(99);
		System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
		
		//线程MyRun
		//new Thread(new MyRun()).start();
		
	
		for(int i=0;i<5;i++){
			new Thread(new MyRun()).start();
		}
		
		
		//private static ThreadLocal<Integer> threadLoaclend=new InheritableThreadLocal<Integer>();
		System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
		
		//设置值
		threadLoacl.set(99);
		System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
		
		
		//子线程由main线程开辟：将main的数据复制一份给子线程:实现数据共享
		new Thread(new Runnable(){

			public void run() {
				System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
			}
			
		}).start();
		
	}
	public static class MyRun implements Runnable{
		
		public MyRun(){
			//此语句属于主线程的：因为是在主线程中调用的
			System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
		}
		//此语句属于MyRun线程
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
			//设置值
			threadLoacl.set((int)Math.random()*99);
			System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
			
			
			
			Integer left=threadLoacl.get();
			System.out.println(Thread.currentThread().getName()+"-得到了--->"+left);
			threadLoacl.set(left-1);
			System.out.println(Thread.currentThread().getName()+"-还剩下--->"+threadLoacl.get());
			
		}
	}
}
