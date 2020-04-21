package JAVAStudy_常用类;
/**
 * 测试包装类
 * Interger类的使用
 * @author Pandamin
 *
 */
public class Study_包装类 {
	public static void main(String[] args) {
		//基本数据类型转化包装类对象
		Integer a=new Integer(3);
		Integer b=Integer.valueOf(3);
		System.out.println("a="+a+"b="+b);
		
		//包装类对象转化成基本数据类型
		int c=b.intValue();
		double d=b.doubleValue();
		
		//字符串转化为包装类
		Integer e=new Integer("999");
		Integer f=Integer.valueOf("888");
		System.out.println("e="+e+"f="+f);
		
		//包装类转化字符串
		String str=f.toString();

		//常见常量
		System.out.println(Integer.MAX_VALUE);

	}

}
