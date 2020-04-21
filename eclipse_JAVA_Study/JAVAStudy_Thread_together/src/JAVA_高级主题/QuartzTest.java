package JAVA_�߼�����;
/**
 * Quartzѧϰ����
 */
import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
public class QuartzTest {

  public void run() throws Exception {
    //1.����Scheduler�Ĺ���
    SchedulerFactory sf = new StdSchedulerFactory();
    //2.�ӹ����л�ȡ������
    Scheduler sched = sf.getScheduler();
    //3. ����JobDetail
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
    //ʱ��
    Date runTime = evenMinuteDate(new Date());
    
    //4.������
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

    //5.ע������ʹ�������
    sched.scheduleJob(job, trigger);

    //6.����
    sched.start();
    try {
      // 5���ֹͣ
      Thread.sleep(500L * 1000L);
    } catch (Exception e) {
    }
  }
  public static void main(String[] args) throws Exception {
    QuartzTest example = new QuartzTest();
    example.run();
  }
}