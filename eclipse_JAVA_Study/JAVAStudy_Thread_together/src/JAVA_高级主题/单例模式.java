package JAVA_�߼�����;
/**
 * ����ģʽ���ڶ��̻߳����£��������һ������
 * 1.������˽�л�-->�����ⲿnew������
 * 2.�ṩ��̬����-->�洢����ĵ�ַ(ָ������)
 * 3.�ṩ�����ľ�̬����-->��ȡ����
 * @author Pandamin
 *
 */
public class ����ģʽ {
	//2.�ṩ��̬����-->�洢����ĵ�ַ(ָ������)
	private static volatile ����ģʽ instance;
	//û��volatile�����߳̿��ܻ����һ��û�г�ʼ���Ķ���
	
	//1.������˽�л�-->�����ⲿnew������
	private ����ģʽ(){
		
	}
	//3.�ṩ�����ľ�̬����-->��ȡ����
	public static ����ģʽ getInstance(){
		//�ٴμ��:���instance�Ѿ��������ˣ���������������ʱ��ABC..�̻߳��ڵȴ�
		if(null!=instance){
			return instance;
		}
		synchronized (����ģʽ.class) {
			if(instance==null){
				instance =new ����ģʽ();
				//��ʼ�������ʱ��
				/**
				 * 1.���ٿռ�
				 * 2.��ʼ��������Ϣ  ##����������ڳ�ʼ���Ĺ����бȽϺ�ʱ�����ܻ����ָ�����ţ�*****Ϊ�˱���,�ڸö���+volatile*****
				 * 3.���ض���ĵ�ַ������
				 */
			}
		}
		return instance;
	}
	
	
	//�Ա�
	public static ����ģʽ getInstance1(long time){
		//�ٴμ��:���instance�Ѿ��������ˣ���������������ʱ��ABC..�̻߳��ڵȴ�
		if(instance==null){
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance =new ����ģʽ();
				//��ʼ�������ʱ��
				/**
				 * 1.���ٿռ�
				 * 2.��ʼ��������Ϣ  ##����������ڳ�ʼ���Ĺ����бȽϺ�ʱ�����ܻ����ָ�����ţ�*****Ϊ�˱���,�ڸö���+volatile*****
				 * 3.���ض���ĵ�ַ������
				 */
		}
		return instance;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t=new Thread(new Runnable(){
			public void run() {
				System.out.println(����ģʽ.getInstance());
			}
		});
		t.start();
		System.out.println(����ģʽ.getInstance());
		
		Thread t1=new Thread(new Runnable(){
			public void run() {
				System.out.println(����ģʽ.getInstance1(500));
			}
		});
		t1.start();
		System.out.println(����ģʽ.getInstance1(1000));
	}

}
