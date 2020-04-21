package JAVAStudy_常用类;

public class Study_String {
	public static void main(String[] args) {
	//字符串比较的时候用equals(),不要使用“==”
	//原因有下:
		
	//编译器做了优化直接在编译的时候将字符串进行拼接
		String str1="hello "+"java";
		String str2="hello java";
		System.out.println(str1==str2);//ture
		
		String str3="hello ";
		String str4="java";
	//编译的时候不知道变量存储是什么，所以没有办法在编译的时候优化
		
		String str5=str3+str4;
		System.out.println(str2==str5);//false

	}

}
