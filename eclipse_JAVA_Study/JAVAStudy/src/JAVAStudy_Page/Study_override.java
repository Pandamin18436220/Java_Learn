package JAVAStudy_Page;
class Vehicle{
	public void run(){
		System.out.println("跑");
	}
	public void stop(){
		 System.out.println("停止");
	 }
	public Person whoispsg(){
		return new Person();
	}
}
class Horse extends Vehicle{
	 public void run(){
		 System.out.println("四蹄");
	 }
	 public Student whoispsg(){
		 return new Student("1",1,"");
	 }
}
public class Study_override {

	/**
	 * @param args
	 * 子类方法重写
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Horse h=new Horse();
		h.run();
	}

}
