package JAVAStudy_常用类;

public class Study_StringBuffer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//StringBuffer与StringBuilder的区别:
		//StringBuilder线程不安全，效率高(一般使用它);StringBuffer线程安全，效率低
		StringBuffer sb=new StringBuffer("abcdef");
		
		System.out.println(Integer.toHexString(sb.hashCode()));
		System.out.println(sb.hashCode());
		System.out.println(sb);
		
		sb.setCharAt(2, 'P');
		
		System.out.println(Integer.toHexString(sb.hashCode()));
		System.out.println(sb.hashCode());
		System.out.println(sb);
		
		StringBuffer s=new StringBuffer();
		for(int i=0;i<26;i++){
			char temp=(char)('a'+i);
			s.append(temp);
		}
		System.out.println(s);
		
		//return this可以实现链式调用
		//此处提供计算一段程序占用内存和时间的方法
		long num=Runtime.getRuntime().freeMemory();//获取系统剩余的内存空间
		long time=System.currentTimeMillis();//获取系统当前时间
				
		
		
	}

}
