package JAVAStudy_Oop;
/**
 * 接口就是比“抽象类”还要抽象，不提供任何的实现
 * @author Pandamin
 * 接口中的属性只能是常量，总是public static final,可以不写
 * 接口中的方法只能是抽象，总是public abstract,可以不写
 */
public interface Study_Interface {
	int MAX_Age=100;
	void test01();
}
class Intertext implements Study_Interface{

	@Override
	public void test01() {
		// TODO Auto-generated method stub
		
	}
	
}
