package JAVAStudy_Page;
/**
 * 
 * @author Pandamin
 * 用static声明过的变量成为静态成员变量，也成为类变量
 */
class User{
	int id;
	String name;
	String pwd;
	static String company;
	public User(int id,String name){
		this.id=id;
		this.name=name;
	}
	static{
		System.out.println("执行类的初始化工作");
		company="Pandamin";
		printCompany();
	}
	public void login(){
		System.out.println("登录:"+this.name);
	}
	public static void printCompany(){
		System.out.println(company);
	}
}
public class Study_static {
	public static void main(String[] args){
		User u1=new User(18436220,"pandamin");
		u1.login();
		User.printCompany();
		User.company="Panchengkai";
		User.printCompany();
	}
}
