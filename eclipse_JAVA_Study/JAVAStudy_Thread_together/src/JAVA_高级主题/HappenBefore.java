package JAVA_高级主题;
/**
 * 1.从内存取指令
 * 2.指令解码翻译
 * 3.从寄存器里面取数据
 * 4.操作
 * 5.将结果写回到寄存器中
 * 
 * HappenBefore:指令重排
 * 执行代码的顺序可能与编译代码不一致，即虚拟机优化代码顺序，则指令重排Happenbefore
 * 即:编译器或运行时环境为了优化程序性能而采取的对指令重新排序执行的一种手段
 * 
 * 1.硬件层面，cpu会将接收到的一批指令按照其规则重排序，同样是基于cpu速度比缓存速度快的原因
 * 2.虚拟机层面，为了减少内存操作速度慢于cpu运行速度锁带来的cpu空置的影响。
 * @author Pandamin
 *
 */
public class HappenBefore {
	
	//变量1
	private static int a=0;
	//变量2
	private static boolean flag=false;

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			a=0;
			flag=false;
			//线程一:更改数据
			Thread t1=new Thread(new Runnable(){
				public void run() {
					a=1;
					flag=true;
				}		
			});
			//线程二:读取数据
			Thread t2=new Thread(new Runnable(){
				public void run() {
					if(flag){
						a*=1;
					}
					//指令重排:因为操作的指令数据与数据之间没有依赖，可能会产生指令重排
					if(a==0){
						System.out.println("happenbefore a->"+a);
					}
				}		
			});
			t1.start();
			t2.start();
			
			//线程的插队
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
