package JAVAStudy_Page;
class Person1{
	String name;
	int age;
	public Person1(String name,int age){
		this.age=age;
		this.name=name;
	}
	public String toString(){
		return name+",年龄:"+age;
	}
}
public class Study_Object {

	/**
	 * @param args
	 */
	/**
	 * 重写toString方法
	 */
	public String toString(){
		return "pandamin";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Study_Object  to=new Study_Object();
		/**
		 * 打印对象就是调用了对象.toString方法(继承Object)
		 */
		System.out.println(to.toString());
		Person1 per=new Person1("panda",12);
		System.out.println(per);
	}

}
