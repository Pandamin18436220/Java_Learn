package JAVAStudy_������;

public class Study_StringBuffer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//StringBuffer��StringBuilder������:
		//StringBuilder�̲߳���ȫ��Ч�ʸ�(һ��ʹ����);StringBuffer�̰߳�ȫ��Ч�ʵ�
		StringBuffer sb=new StringBuffer("abcdef");
		
		System.out.println(Integer.toHexString(sb.hashCode()));
		System.out.println(sb.hashCode());
		System.out.println(sb);
		
		sb.setCharAt(2, 'P');
		
		System.out.println(Integer.toHexString(sb.hashCode()));
		System.out.println(sb.hashCode());
		System.out.println(sb);
		
		StringBuffer s=new StringBuffer();
		for(int i=0;i<26;i++){
			char temp=(char)('a'+i);
			s.append(temp);
		}
		System.out.println(s);
		
		//return this����ʵ����ʽ����
		//�˴��ṩ����һ�γ���ռ���ڴ��ʱ��ķ���
		long num=Runtime.getRuntime().freeMemory();//��ȡϵͳʣ����ڴ�ռ�
		long time=System.currentTimeMillis();//��ȡϵͳ��ǰʱ��
				
		
		
	}

}
