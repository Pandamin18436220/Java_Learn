package JAVAStudy_Page;
/**
 * 
 * @author Pandamin
 * ��static�������ı�����Ϊ��̬��Ա������Ҳ��Ϊ�����
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
		System.out.println("ִ����ĳ�ʼ������");
		company="Pandamin";
		printCompany();
	}
	public void login(){
		System.out.println("��¼:"+this.name);
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
