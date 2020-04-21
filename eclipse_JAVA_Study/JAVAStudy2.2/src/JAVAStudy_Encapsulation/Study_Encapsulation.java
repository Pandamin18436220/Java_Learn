package JAVAStudy_Encapsulation;
/**
 * 
 * @author Pandamin
 * private 只能在本类
 * default 默认只有在本包使用
 * protected default+不同包的子类
 * public 都可以使用
 * 
 * 一般规则
 * javaBean规则:是指该类只有属性+setter+getter方法
 * 类的属性使用private 利用setter getter方法去访问私有属性(可以通过补写代码加强其方法)
 * 
 * 类的方法使用public
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
