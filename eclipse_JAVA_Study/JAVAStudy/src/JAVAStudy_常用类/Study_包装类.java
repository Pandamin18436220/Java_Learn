package JAVAStudy_������;
/**
 * ���԰�װ��
 * Interger���ʹ��
 * @author Pandamin
 *
 */
public class Study_��װ�� {
	public static void main(String[] args) {
		//������������ת����װ�����
		Integer a=new Integer(3);
		Integer b=Integer.valueOf(3);
		System.out.println("a="+a+"b="+b);
		
		//��װ�����ת���ɻ�����������
		int c=b.intValue();
		double d=b.doubleValue();
		
		//�ַ���ת��Ϊ��װ��
		Integer e=new Integer("999");
		Integer f=Integer.valueOf("888");
		System.out.println("e="+e+"f="+f);
		
		//��װ��ת���ַ���
		String str=f.toString();

		//��������
		System.out.println(Integer.MAX_VALUE);

	}

}
