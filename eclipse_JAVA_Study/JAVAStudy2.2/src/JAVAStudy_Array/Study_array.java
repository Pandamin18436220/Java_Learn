package JAVAStudy_Array;

public class Study_array {

	/** ���鿽��
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testBasicCopy2();
	}
	public static void testBasicCopy() {
		String[] s1={"aa","bb","cc","dd","ee"};
		String[] s2=new String[10];
		System.arraycopy(s1, 0, s2, 4, 5);
		for(String i:s2)
			System.out.println(i);
	}
	//ɾ��Ԫ��:�Լ��������Լ�
	public static void testBasicCopy2() {
		String[] s1={"aa","bb","cc","dd","ee"};
		String[] s2=new String[5];
		//index=3:Ϊ��Ҫɾ�����±�
		System.arraycopy(s1, 3+1, s1, 3, s1.length-3-1);
		s1[s1.length-1]=null;
		for(String i:s1)
			System.out.println(i);
	}
	//����Ԫ��:���ݣ��ȶ���һ����������飬Ȼ�󿽱���ȥ
	public static void testBasicCopy3() {
		String[] s1={"aa","bb","cc"};
		String[] s2=new String[s1.length+10];
		//index=3:Ϊ��Ҫɾ�����±�
		System.arraycopy(s1, 0, s2, 0, s1.length);
		
		s1[s1.length-1]=null;
		for(String i:s2)
			System.out.println(i);
	}

}
