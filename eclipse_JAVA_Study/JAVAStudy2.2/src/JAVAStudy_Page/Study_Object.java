package JAVAStudy_Page;
class Person1{
	String name;
	int age;
	public Person1(String name,int age){
		this.age=age;
		this.name=name;
	}
	public String toString(){
		return name+",����:"+age;
	}
}
public class Study_Object {

	/**
	 * @param args
	 */
	/**
	 * ��дtoString����
	 */
	public String toString(){
		return "pandamin";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Study_Object  to=new Study_Object();
		/**
		 * ��ӡ������ǵ����˶���.toString����(�̳�Object)
		 */
		System.out.println(to.toString());
		Person1 per=new Person1("panda",12);
		System.out.println(per);
	}

}
