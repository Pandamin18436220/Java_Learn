package JAVA_�߼�����;
/**
 * volatile���ڱ�֤���ݵ�ͬ����Ҳ���ǿɼ���,���Ա���ָ������
 * volatile��������synchronized
 * @author Pandamin
 *
 */
public class Volatile {
	//ʹ��volatile
	private volatile static int num=0;
	//��ʱû��ʱ��ȥͬ��numֵ
	//private static int num=0;
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable(){
			public void run() {
				while(num==0){
					//�˴���д����
				}
			}	
		}).start();
		Thread.sleep(1000);
		num=1;
	}	
}
