package JAVAStudy_IO;
/**
 * 抽象组件：需要装饰的抽象对象(接口或者抽象父类)
 * 具体组件：需要装饰的对象
 * 抽象装饰类：包含对抽象组件的引用以及装饰方法
 * 具体装饰类：
 * @author Pandamin
 *
 */
public class Study_IOderaction {
public static void main(String[] args) {
	Drink coffee=new Coffee();
	Drink sugor=new sugor(coffee);
	System.out.println(sugor.info()+"----->"+sugor.cost());
}
}
//抽象组件
interface Drink{
	double cost();
	String info();
}
//具体组件
class Coffee implements Drink{
	private String name="原味咖啡";
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return name;
	}
}
//抽象装饰类
abstract class Decoration implements Drink{
	private Drink drink;
	public Decoration(Drink drink) {
		super();
		this.drink = drink;
	}
	@Override
	public double cost() {
		return this.drink.cost();
	}

	@Override
	public String info() {
		return this.drink.info();
	}
}
//具体装饰类
class Milk extends Decoration{
	public Milk(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double cost() {
		return super.cost()*4;
	}

	@Override
	public String info() {
		return super.info()+"加入了牛奶";
	}
}
class sugor extends Decoration{
	public sugor(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double cost() {
		return super.cost()*2;
	}

	@Override
	public String info() {
		return super.info()+"加入了蔗糖";
	}
}
