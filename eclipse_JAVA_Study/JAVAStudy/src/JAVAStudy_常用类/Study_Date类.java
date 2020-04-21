package JAVAStudy_常用类;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Study_Date类 {
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//用long类型变量表示时间
		long time=System.currentTimeMillis();
		System.out.println(time);
		Date d=new Date();
		Date d1=new Date(1000);
		System.out.println(d.getTime());//获得毫秒数
		System.out.println(d.after(d1));
		
		//DateFormat是抽象类，SimpleDateFormat是实现类
		//把时间对象按照“格式字符串的格式”转成相应的字符串
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm::ss");
		String str=df.format(new Date(4000));
		System.out.println(str);
		//把字符串按照“格式字符串指定的格式”转成相应的时间对象
		DateFormat df1=new SimpleDateFormat("yyyy-MM-dd hh:mm::ss");
		Date date=df1.parse("1970-01-01 08:00::04");
		System.out.println(date);
		//参数其他格式字符
		DateFormat df2=new SimpleDateFormat("D");
		String str3=df2.format(new Date());
		System.out.println(str3);
	}

}
