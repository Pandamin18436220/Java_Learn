package JAVAStudy_������;
/**�Զ������װ��
 * @param args
 */
public class Study_aotuBox {
	public static void main(String[] args) {
		Integer a=234;//�������Զ�Integer a=Integer.valueOf(234);
		int b=a;      //�������Զ�Integer int b=a.intValue();
		
		Integer c=null;
		if(c!=null){
			int d=c;
		}
		//��������:[-128,127]֮��������Ѿ���ǰ�����˶��󱣴�����cache��
		//����Ǹ÷�Χ�������ͷ��ظö��󣬲����򴴽��¶���
		Integer in1=-128;
		Integer in2=-128;
		System.out.println(in1==in2);         //true
		System.out.println(in1.equals(in2));  //true
		
		Integer in3=1234;
		Integer in4=1234;
		System.out.println(in1==in2);         //false
		System.out.println(in1.equals(in2));  //true
		
		
		
	}

}
