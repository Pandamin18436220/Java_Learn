package JAVAStudy_������;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Study_Date�� {
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//��long���ͱ�����ʾʱ��
		long time=System.currentTimeMillis();
		System.out.println(time);
		Date d=new Date();
		Date d1=new Date(1000);
		System.out.println(d.getTime());//��ú�����
		System.out.println(d.after(d1));
		
		//DateFormat�ǳ����࣬SimpleDateFormat��ʵ����
		//��ʱ������ա���ʽ�ַ����ĸ�ʽ��ת����Ӧ���ַ���
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm::ss");
		String str=df.format(new Date(4000));
		System.out.println(str);
		//���ַ������ա���ʽ�ַ���ָ���ĸ�ʽ��ת����Ӧ��ʱ�����
		DateFormat df1=new SimpleDateFormat("yyyy-MM-dd hh:mm::ss");
		Date date=df1.parse("1970-01-01 08:00::04");
		System.out.println(date);
		//����������ʽ�ַ�
		DateFormat df2=new SimpleDateFormat("D");
		String str3=df2.format(new Date());
		System.out.println(str3);
	}

}
