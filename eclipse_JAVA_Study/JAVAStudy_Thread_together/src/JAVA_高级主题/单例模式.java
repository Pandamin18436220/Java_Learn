package JAVA_高级主题;
/**
 * 单例模式：在多线程环境下，对外存在一个对象
 * 1.构造器私有化-->避免外部new构造器
 * 2.提供静态属性-->存储对象的地址(指向自身)
 * 3.提供公共的静态方法-->获取属性
 * @author Pandamin
 *
 */
public class 单例模式 {
	//2.提供静态属性-->存储对象的地址(指向自身)
	private static volatile 单例模式 instance;
	//没有volatile其他线程可能会访问一个没有初始化的对象
	
	//1.构造器私有化-->避免外部new构造器
	private 单例模式(){
		
	}
	//3.提供公共的静态方法-->获取属性
	public static 单例模式 getInstance(){
		//再次检测:如果instance已经创建好了，但是由于网络延时，ABC..线程还在等待
		if(null!=instance){
			return instance;
		}
		synchronized (单例模式.class) {
			if(instance==null){
				instance =new 单例模式();
				//初始化对象的时候
				/**
				 * 1.开辟空间
				 * 2.初始化对象信息  ##如果构造器在初始化的过程中比较耗时，可能会存在指令重排，*****为了避免,在该对象+volatile*****
				 * 3.返回对象的地址给引用
				 */
			}
		}
		return instance;
	}
	
	
	//对比
	public static 单例模式 getInstance1(long time){
		//再次检测:如果instance已经创建好了，但是由于网络延时，ABC..线程还在等待
		if(instance==null){
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance =new 单例模式();
				//初始化对象的时候
				/**
				 * 1.开辟空间
				 * 2.初始化对象信息  ##如果构造器在初始化的过程中比较耗时，可能会存在指令重排，*****为了避免,在该对象+volatile*****
				 * 3.返回对象的地址给引用
				 */
		}
		return instance;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t=new Thread(new Runnable(){
			public void run() {
				System.out.println(单例模式.getInstance());
			}
		});
		t.start();
		System.out.println(单例模式.getInstance());
		
		Thread t1=new Thread(new Runnable(){
			public void run() {
				System.out.println(单例模式.getInstance1(500));
			}
		});
		t1.start();
		System.out.println(单例模式.getInstance1(1000));
	}

}
