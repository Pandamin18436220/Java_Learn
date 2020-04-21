package JAVAStudy_IO;
/**
 * �����������Ҫװ�εĳ������(�ӿڻ��߳�����)
 * �����������Ҫװ�εĶ���
 * ����װ���ࣺ�����Գ�������������Լ�װ�η���
 * ����װ���ࣺ
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
//�������
interface Drink{
	double cost();
	String info();
}
//�������
class Coffee implements Drink{
	private String name="ԭζ����";
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
//����װ����
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
//����װ����
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
		return super.info()+"������ţ��";
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
		return super.info()+"����������";
	}
}
