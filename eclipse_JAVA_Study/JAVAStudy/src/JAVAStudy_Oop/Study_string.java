package JAVAStudy_Oop;

public class Study_string {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abc";
		String str1=new String("abc");
		String str2="abc"+"efg";
		
		System.out.println(str.charAt(2));
		System.out.println(str.equals(str2));
		System.out.println(str.indexOf("b"));
		String str3=str.replaceAll("b", "B");
		
		System.out.println(str.startsWith("a"));
		System.out.println(str.endsWith("b"));
		
		String s=str.substring(1);
		
		str=str.toLowerCase();
		System.out.println(str);
		str2=str2.toUpperCase();
		
		String str4="   I love you  ";
		str4=str4.trim();//È¥³ýÊ×Î²¿Õ¸ñ
		System.out.println(str4);
	}

}
