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
		//或者
		Users u1[];
		
		//静态初始化
		int[] a={1,2,3};
		//默认初始化:默认0 null  false
		int[] b=new int[10];
		//动态初始化
		int[] c=new int[5];
		c[0]=0;
		c[1]=1;
		
		for(int i=0;i<b.length;i++){
			b[i]=i+5;
			System.out.println("b["+i+"]="+b[i]);
		}
		//foreach循环是用来读取数组元素的值,不能修改
		for(int m:a){
			System.out.println(m);
		}
	}

}
