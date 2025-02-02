package Test;
/**
 *两个对象，一个顾客，一个老板， 顾客来点包子吃，每次顾客来了，
 *老板要先问你想吃什么，顾客回答吃包子，老板就开始做包子，顾客进入睡眠，
 *老板要10秒做一个包子，做好后顾客开吃，吃30秒吃完，
 *吃完回答一声好吃，在20秒内随机有顾客加入，如果没有包子要做了 老板要停下来不运行进入睡眠
 * @author Pandamin
 */
public class Stro {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		store container=new store();
		new Boss(container,12).start();
		new Consumer(container,2).start();
	}
}
//老板
class Boss extends Thread{
	private boolean making = true;
	private int bcount = 0;//老板做了的包子数
	static int allbcount;//总包子数
	store container;
	public Boss(store container,int allbcount) {
		super();
		this.container = container;
		this.allbcount = allbcount;
	}
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(making){
			try {
				bcount++;
				container.push(new bun(bcount));
				Thread.sleep(1*1000);
				System.out.println("1s钟过去了......做了"+bcount+"个包子");
				if(allbcount==bcount){
					System.out.println("今天的包子销售完了！");
					making = false;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		making = true;
	}
}
//顾客
class Consumer extends Thread{
	private int ebcount;//顾客点包子的数量
	private boolean eating = true;
	store container;	
	public Consumer(store container,int ebcount) {
		super();
		this.container = container;
		this.ebcount = ebcount;
	}
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(eating){
			try {
				Thread.sleep(3*1000);
				container.pop();
				ebcount--;
				if(ebcount==0){
					System.out.println("顾客说包子好吃");
					eating = false;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		eating = true;
	}
}
//门店
class store{
	bun[] buns=new bun[10];
	int count=0;
	//制作包子
	public synchronized void push(bun bun) {
		if(count==buns.length){
			try {
				System.out.println("老板休息一会！");
				this.wait();//线程阻塞
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buns[count++]=bun;
		this.notifyAll();//唤醒
		System.out.println("顾客来了.....");
	}
	//销售包子
	public synchronized bun pop() {
		if(count==0){
			try {
				System.out.println("顾客休息一会");
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//线程阻塞
		}
		count--;
		this.notifyAll();//唤醒;
		System.out.println("老板开工了");
		return null;
	}
}
//包子
class bun{
	int id;
	public bun(int id) {
		super();
		this.id = id;
	}
}