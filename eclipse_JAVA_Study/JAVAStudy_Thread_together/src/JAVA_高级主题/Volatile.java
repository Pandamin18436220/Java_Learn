package JAVA_高级主题;
/**
 * volatile用于保证数据的同步，也就是可见性,可以避免指令重排
 * volatile是轻量的synchronized
 * @author Pandamin
 *
 */
public class Volatile {
	//使用volatile
	private volatile static int num=0;
	//此时没有时间去同步num值
	//private static int num=0;
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable(){
			public void run() {
				while(num==0){
					//此处不写代码
				}
			}	
		}).start();
		Thread.sleep(1000);
		num=1;
	}	
}
