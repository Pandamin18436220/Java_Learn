package JAVAStudy_������;

public class Study_String {
	public static void main(String[] args) {
	//�ַ����Ƚϵ�ʱ����equals(),��Ҫʹ�á�==��
	//ԭ������:
		
	//�����������Ż�ֱ���ڱ����ʱ���ַ�������ƴ��
		String str1="hello "+"java";
		String str2="hello java";
		System.out.println(str1==str2);//ture
		
		String str3="hello ";
		String str4="java";
	//�����ʱ��֪�������洢��ʲô������û�а취�ڱ����ʱ���Ż�
		
		String str5=str3+str4;
		System.out.println(str2==str5);//false

	}

}
