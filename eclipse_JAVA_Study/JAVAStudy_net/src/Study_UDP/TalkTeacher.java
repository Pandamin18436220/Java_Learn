package Study_UDP;
/**
 * 加入多线程，实现双向交流，模拟在线咨询
 * @author Pandamin
 *
 */
public class TalkTeacher {
	public static void main(String[] args) {
		new Thread(new TalkReceive(9999)).start();
		
		new Thread(new TalkSend(6666,"localhost",8888)).start();
	}
}
