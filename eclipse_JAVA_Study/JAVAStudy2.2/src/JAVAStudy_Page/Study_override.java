package JAVAStudy_Page;
class Vehicle{
	public void run(){
		System.out.println("��");
	}
	public void stop(){
		 System.out.println("ֹͣ");
	 }
	public Person whoispsg(){
		return new Person();
	}
}
class Horse extends Vehicle{
	 public void run(){
		 System.out.println("����");
	 }
	 public Student whoispsg(){
		 return new Student("1",1,"");
	 }
}
public class Study_override {

	/**
	 * @param args
	 * ���෽����д
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Horse h=new Horse();
		h.run();
	}

}
