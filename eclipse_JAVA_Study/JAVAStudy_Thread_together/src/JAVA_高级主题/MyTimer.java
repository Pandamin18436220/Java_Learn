package JAVA_�߼�����;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ������ȣ�Timer��TimerTask��
 * @author Pandamin
 *
 */
public class MyTimer {
	public static void main(String[] args) {
		Timer timer=new Timer();
		//ִ�а���
		//timer.schedule(new MyTask(), 1000);//ִ������һ��
		//timer.schedule(new MyTask(), 1000,2000);//ִ�ж�Σ�ÿ��2��ִ��һ������
		Calendar cal=new GregorianCalendar(2099,12,32,52,12,1);
		timer.schedule(new MyTask(),cal.getTime(),2000);//ָ��ʱ������
	}
}
//������
class MyTask extends TimerTask{
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("hello world!");
		}
		System.out.println("ending.....");
	}
}