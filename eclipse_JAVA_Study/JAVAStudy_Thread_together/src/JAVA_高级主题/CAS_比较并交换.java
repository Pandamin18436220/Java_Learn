package JAVA_�߼�����;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ������:synchronized�Ƕ�ռ������������������Ҫ�����̹߳��𣬵ȴ��������ͷ���
 * �ֹ���:ÿ�β��������Ǽ���û�г�ͻȥ���ĳ���������ʧ�ܾ����¿�ʼ��ֱ���ɹ�Ϊֹ
 * A              V             B
 *ԭ����ֵ             ��ǰ��ֵ         ��Ҫ���µ�ֵ
 *�����ǰ��ֵ��ԭ����ֵһ��,�ͽ���Ҫ���µ�ֵȡ��ԭ����ֵ
 *
 *
 *Atomicԭ���Եģ��õ���CAS˼��(Ӳ������Ĳ���)��Ҳ����ʵ�����ݹ���
 * @author Pandamin
 *
 */
public class CAS_�Ƚϲ����� {
	//���
	private static AtomicInteger stock=new AtomicInteger(5);
	public static void main(String args){
		for(int i=0;i<5;i++){
			new Thread(new Runnable(){
				public void run() {
					//ģ����ʱ
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// TODO Auto-generated method stub
					Integer left=stock.decrementAndGet();
					if(left<1){
						System.out.println("������...");
						return;
					}
					System.out.println(Thread.currentThread().getName()+"������һ����Ʒ");
					System.out.println("--->��ʣ"+left);
				}
			}).start();
		}
	}
}
