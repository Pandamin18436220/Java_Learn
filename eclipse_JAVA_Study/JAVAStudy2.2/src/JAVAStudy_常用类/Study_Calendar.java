package JAVAStudy_常用类;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Study_Calendar {
	public static void main(String[] args) {
		//Calendar是抽象类,GregorianCalendar是实现类
		//获取日期
		Calendar calender=new GregorianCalendar(2999,10,9,22,10,50);
		int year =calender.get(Calendar.YEAR);
		int week=calender.get(Calendar.DAY_OF_WEEK);
		//设置日期
		Calendar c2=new GregorianCalendar();
		c2.set(Calendar.YEAR, 2019);
		//日期计算
		Calendar c3=new GregorianCalendar();
		c3.add(Calendar.DATE, 100);
		//日历对象转化成时间对象
		Date d4=c3.getTime();
		
		Calendar c4=new GregorianCalendar();
		c4.setTime(new Date());
		//打印(技巧)
		String dayweek2=week==0?"日":week+"";
		
	}

}
