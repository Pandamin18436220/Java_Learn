package JAVA_高级主题;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度：Timer和TimerTask类
 * @author Pandamin
 *
 */
public class MyTimer {
	public static void main(String[] args) {
		Timer timer=new Timer();
		//执行安排
		//timer.schedule(new MyTask(), 1000);//执行任务一次
		//timer.schedule(new MyTask(), 1000,2000);//执行多次；每隔2秒执行一次任务
		Calendar cal=new GregorianCalendar(2099,12,32,52,12,1);
		timer.schedule(new MyTask(),cal.getTime(),2000);//指定时间允许
	}
}
//任务类
class MyTask extends TimerTask{
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("hello world!");
		}
		System.out.println("ending.....");
	}
}