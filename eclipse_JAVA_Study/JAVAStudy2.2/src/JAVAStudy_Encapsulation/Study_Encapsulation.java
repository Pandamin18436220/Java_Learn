package JAVAStudy_Encapsulation;
/**
 * 
 * @author Pandamin
 * private ֻ���ڱ���
 * default Ĭ��ֻ���ڱ���ʹ��
 * protected default+��ͬ��������
 * public ������ʹ��
 * 
 * һ�����
 * javaBean����:��ָ����ֻ������+setter+getter����
 * �������ʹ��private ����setter getter����ȥ����˽������(����ͨ����д�����ǿ�䷽��)
 * 
 * ��ķ���ʹ��public
 */
class Human{
	private int age;
	void sayAge(){
		System.out.println("age:"+age);
	}
}
class boy extends Human{
	
}
public class Study_Encapsulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human h=new Human();

	}

}
