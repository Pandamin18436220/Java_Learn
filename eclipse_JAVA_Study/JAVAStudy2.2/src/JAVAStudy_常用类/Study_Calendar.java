package JAVAStudy_������;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Study_Calendar {
	public static void main(String[] args) {
		//Calendar�ǳ�����,GregorianCalendar��ʵ����
		//��ȡ����
		Calendar calender=new GregorianCalendar(2999,10,9,22,10,50);
		int year =calender.get(Calendar.YEAR);
		int week=calender.get(Calendar.DAY_OF_WEEK);
		//��������
		Calendar c2=new GregorianCalendar();
		c2.set(Calendar.YEAR, 2019);
		//���ڼ���
		Calendar c3=new GregorianCalendar();
		c3.add(Calendar.DATE, 100);
		//��������ת����ʱ�����
		Date d4=c3.getTime();
		
		Calendar c4=new GregorianCalendar();
		c4.setTime(new Date());
		//��ӡ(����)
		String dayweek2=week==0?"��":week+"";
		
	}

}
