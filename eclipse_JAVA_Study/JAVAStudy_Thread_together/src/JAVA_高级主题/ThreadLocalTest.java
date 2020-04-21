package JAVA_�߼�����;
/**
 * ThreadLocal:ÿ���߳�����Ĵ洢���أ��ֲ�����[���������и����˻�]
 * 1.get
 * 2.set
 * 3.initialValue
 * 
 * 
 * *****�ص�
 * ThreadLocal:����������
 * 1.��������������þ�����������߳���
 * 2.run�������ڱ��߳�����
 * 
 * 
 * InheritableThreadLocal�̳������� ���������� ���
 * 
 * @author Pandamin
 *
 */
public class ThreadLocalTest {
	private static ThreadLocal<Integer> threadLoaclend=new InheritableThreadLocal<Integer>();
	//private static ThreadLocal<Integer> threadLoacl=new ThreadLocal<Integer>();
	
	//���ĳ�ʼֵ:��һ��
	private static ThreadLocal<Integer> threadLoacl=new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 20;
		};
	};
	//���ĳ�ʼֵ:������
	//private static ThreadLocal<Integer> threadLoacl=ThreadLocal.withInitial(()->200);
	public static void main(String[] args) {
		//���߳�
		//��ȡֵ
		System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
		
		//����ֵ
		threadLoacl.set(99);
		System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
		
		//�߳�MyRun
		//new Thread(new MyRun()).start();
		
	
		for(int i=0;i<5;i++){
			new Thread(new MyRun()).start();
		}
		
		
		//private static ThreadLocal<Integer> threadLoaclend=new InheritableThreadLocal<Integer>();
		System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
		
		//����ֵ
		threadLoacl.set(99);
		System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
		
		
		//���߳���main�߳̿��٣���main�����ݸ���һ�ݸ����߳�:ʵ�����ݹ���
		new Thread(new Runnable(){

			public void run() {
				System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
			}
			
		}).start();
		
	}
	public static class MyRun implements Runnable{
		
		public MyRun(){
			//������������̵߳ģ���Ϊ�������߳��е��õ�
			System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
		}
		//���������MyRun�߳�
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
			//����ֵ
			threadLoacl.set((int)Math.random()*99);
			System.out.println(Thread.currentThread().getName()+"---->"+threadLoacl.get());
			
			
			
			Integer left=threadLoacl.get();
			System.out.println(Thread.currentThread().getName()+"-�õ���--->"+left);
			threadLoacl.set(left-1);
			System.out.println(Thread.currentThread().getName()+"-��ʣ��--->"+threadLoacl.get());
			
		}
	}
}
