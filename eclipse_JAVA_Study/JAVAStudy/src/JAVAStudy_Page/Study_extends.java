package JAVAStudy_Page;
class Person{
	String name;
	int height;
	public void rest(){
		System.out.println("休息一会");
	}
}
class Student extends Person{
	String major;
	public Student(String name,int height,String major){
		this.name=name;
		this.height=height;
		this.major=major;
		
	}
	public void study(){
		System.out.println("学习两小时");
	}
}
public class Study_extends {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu=new Student("panda",188,"java");
		stu.name="pandamin";
		System.out.println(stu instanceof Student);
	}

}
