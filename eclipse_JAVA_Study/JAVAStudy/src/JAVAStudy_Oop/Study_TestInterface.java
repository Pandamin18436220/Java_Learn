package JAVAStudy_Oop;

public class Study_TestInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
/**
 * 接口1
 * @author Pandamin
 *
 */
interface Volant{
	int FLY_HEIGHT=100;
	void fly();
}
/**
 * 接口2
 * @author Pandamin
 *
 */
interface Honest{
	void helpOther();
}
class Baby implements Volant,Honest{

	@Override
	public void helpOther() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
	
}