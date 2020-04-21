package JAVA_高级主题;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 悲观锁:synchronized是独占锁，导致其他所有需要锁的线程挂起，等待持有锁释放锁
 * 乐观锁:每次不加锁而是假设没有冲突去完成某项任务，如果失败就重新开始，直到成功为止
 * A              V             B
 *原来的值             当前的值         带要更新的值
 *如果当前的值与原来的值一致,就将带要更新的值取代原来的值
 *
 *
 *Atomic原子性的，用到了CAS思想(硬件级别的操作)，也可以实现数据共享
 * @author Pandamin
 *
 */
public class CAS_比较并交换 {
	//库存
	private static AtomicInteger stock=new AtomicInteger(5);
	public static void main(String args){
		for(int i=0;i<5;i++){
			new Thread(new Runnable(){
				public void run() {
					//模拟延时
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// TODO Auto-generated method stub
					Integer left=stock.decrementAndGet();
					if(left<1){
						System.out.println("抢完了...");
						return;
					}
					System.out.println(Thread.currentThread().getName()+"抢到了一件商品");
					System.out.println("--->还剩"+left);
				}
			}).start();
		}
	}
}
