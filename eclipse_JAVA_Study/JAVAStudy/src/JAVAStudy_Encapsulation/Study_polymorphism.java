package JAVAStudy_Encapsulation;
/**
 * 
 * @author Pandamin
 * 多态是指方法的多态
 * 多态产生的条件:
 * 继承+方法重弄+父类引用指向子类对象
 */
class Animal{
	public void shout(){
		System.out.println("叫了一声！");
	}
}
class Dog extends Animal{
	public void shout(){
		System.out.println("旺旺旺！");
	}
	public void seeDoor(){
		System.out.println("看门中...");
	}
}
class Cat extends Animal{
	public void shout(){
		System.out.println("喵喵喵！");
	}
}
public class Study_polymorphism {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal an=new Animal();
		animalCry(an);
		/**
		 * 子类对象：狗，传给了父类Animal a
		 * 即：父类引用指向子类对象且该方法为static
		 */
		Dog d=new Dog();
		animalCry(d);
		
		
		/**
		 * 向上转型：子类变为父类类型，自动
		 */
		Animal a1=new Dog();
		/**
		 * 向下转型：父类变成子类类型，强制，(强制转换可能存在问题)
		 */
		Dog d1=(Dog) a1;
		
	}
	static void animalCry(Animal a){
		a.shout();
	}

}
