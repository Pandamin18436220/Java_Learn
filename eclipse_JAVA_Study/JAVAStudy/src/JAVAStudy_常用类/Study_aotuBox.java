package JAVAStudy_常用类;
/**自动拆箱和装箱
 * @param args
 */
public class Study_aotuBox {
	public static void main(String[] args) {
		Integer a=234;//编译器自动Integer a=Integer.valueOf(234);
		int b=a;      //编译器自动Integer int b=a.intValue();
		
		Integer c=null;
		if(c!=null){
			int d=c;
		}
		//缓存问题:[-128,127]之间的数，已经提前生成了对象保存在了cache中
		//如果是该范围的数，就返回该对象，不是则创建新对象
		Integer in1=-128;
		Integer in2=-128;
		System.out.println(in1==in2);         //true
		System.out.println(in1.equals(in2));  //true
		
		Integer in3=1234;
		Integer in4=1234;
		System.out.println(in1==in2);         //false
		System.out.println(in1.equals(in2));  //true
		
		
		
	}

}
