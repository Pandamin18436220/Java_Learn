 package com.sxt.syn;
/**
 * һ����˵�����ڶ����ݽ��иĵ�ʱ�����Ǿ�Ҫ���������������Ʊ�֤�̰߳�ȫ
 * 
 * ������ͬһ���������߳�ͬʱ����
 * ������Ҫ�㣺1.ͬһ��2.���3.ͬʱ
 * 
 * �߳�ͬ��ʵ�֣�
 * 1.(�ȴ����γ�)����
 * 2.������(synchronized)�ؼ���
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * �̲߳���ȫ���и�������ͬ�����
 * @author Pandamin
 *
 */
public class UnsafeTest03 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		//List�ṩ���̰߳�ȫ��һ�ַ�ʽ:CopyOnWriteArrayList***�߼�����
		CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
		//List<String> list=new ArrayList<String>();
		for(int i=0;i<100000;i++){
			new Thread(new Runnable() {
				public void run() {//�����������̲߳���ȫ
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
