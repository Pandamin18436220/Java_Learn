package com.sxt.syn;
/**
 * �̲߳���ȫ���и�������ͬ�����
 * @author Pandamin
 *
 */
public class UnsafeTest01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//һ����Դ
		UnsafeWeb_12306 web=new UnsafeWeb_12306();
		
		//�������
		new Thread(web,"��").start();
		new Thread(web,"��ũ").start();
		new Thread(web,"���").start();
	}

}
class UnsafeWeb_12306 implements Runnable{
	private int ticketNums=10;
	private boolean flag=true;
	public void run() {
		while(flag){
			test5();
		}
	}
	//��������ס����ķ�Χ(����ָ�Ĵ���,����ָ���ݵ�������)
	//˫�ؼ��****
	public void test5(){
		if(ticketNums<0){//���ǵ���û��Ʊ�����
			flag=false;
			return;
		}
		synchronized(this){//��������Ʊֻ��1�ŵ����
		if(ticketNums<0){
			flag=false;
			return;
		}
		//ģ��������ʱ
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
		}
	}
	//��Χ̫С����ס����Χ̫��Ч�ʵ���
	public void test4(){
		synchronized(this){
		if(ticketNums<0){
			flag=false;
			return;
		}
		}
		//ģ��������ʱ
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
	}
	//�߳���Ȼ����ȫ��ticketNums�����ڱ䶯(���ڴ��ַ�ڱ䣬����ס����������Ҫ���ڴ��ַ�����)
	public void test3(){
		synchronized((Integer)ticketNums){
		if(ticketNums<0){
			flag=false;
			return;
		}
		//ģ��������ʱ
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
		}
	}
	public void test2(){
		synchronized(this){
		if(ticketNums<0){
			flag=false;
			return;
		}
		//ģ��������ʱ
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
		}
	}
	//�̰߳�ȫ ͬ��
	public synchronized void test(){
		if(ticketNums<0){
			flag=false;
			return;
		}
		//ģ��������ʱ
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
	}
}
