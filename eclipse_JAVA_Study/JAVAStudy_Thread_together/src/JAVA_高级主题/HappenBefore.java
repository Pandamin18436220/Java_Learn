package JAVA_�߼�����;
/**
 * 1.���ڴ�ȡָ��
 * 2.ָ����뷭��
 * 3.�ӼĴ�������ȡ����
 * 4.����
 * 5.�����д�ص��Ĵ�����
 * 
 * HappenBefore:ָ������
 * ִ�д����˳������������벻һ�£���������Ż�����˳����ָ������Happenbefore
 * ��:������������ʱ����Ϊ���Ż��������ܶ���ȡ�Ķ�ָ����������ִ�е�һ���ֶ�
 * 
 * 1.Ӳ�����棬cpu�Ὣ���յ���һ��ָ��������������ͬ���ǻ���cpu�ٶȱȻ����ٶȿ��ԭ��
 * 2.��������棬Ϊ�˼����ڴ�����ٶ�����cpu�����ٶ���������cpu���õ�Ӱ�졣
 * @author Pandamin
 *
 */
public class HappenBefore {
	
	//����1
	private static int a=0;
	//����2
	private static boolean flag=false;

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			a=0;
			flag=false;
			//�߳�һ:��������
			Thread t1=new Thread(new Runnable(){
				public void run() {
					a=1;
					flag=true;
				}		
			});
			//�̶߳�:��ȡ����
			Thread t2=new Thread(new Runnable(){
				public void run() {
					if(flag){
						a*=1;
					}
					//ָ������:��Ϊ������ָ������������֮��û�����������ܻ����ָ������
					if(a==0){
						System.out.println("happenbefore a->"+a);
					}
				}		
			});
			t1.start();
			t2.start();
			
			//�̵߳Ĳ��
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
