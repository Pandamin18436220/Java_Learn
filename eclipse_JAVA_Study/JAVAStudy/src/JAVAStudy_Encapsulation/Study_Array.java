package JAVAStudy_Encapsulation;

class Users{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
public class Study_Array {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1=new int[10];
		String[] arr2;
		Users[] u;
		//����
		Users u1[];
		
		//��̬��ʼ��
		int[] a={1,2,3};
		//Ĭ�ϳ�ʼ��:Ĭ��0 null  false
		int[] b=new int[10];
		//��̬��ʼ��
		int[] c=new int[5];
		c[0]=0;
		c[1]=1;
		
		for(int i=0;i<b.length;i++){
			b[i]=i+5;
			System.out.println("b["+i+"]="+b[i]);
		}
		//foreachѭ����������ȡ����Ԫ�ص�ֵ,�����޸�
		for(int m:a){
			System.out.println(m);
		}
	}

}
