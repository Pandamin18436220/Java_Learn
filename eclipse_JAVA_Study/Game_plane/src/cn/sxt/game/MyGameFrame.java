package cn.sxt.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
//import java.awt.JFrame;
import javax.swing.JFrame;
/**
 * 飞机游戏的主窗口
 * @author Pandamin
 *
 */
public class MyGameFrame extends Frame{
	Image planeImg=GameUtil.getImage("images/plane.png");
	Image bg=GameUtil.getImage("images/bg.png");
	Plane plane =new Plane(planeImg,150,150);
	Shell[] shells=new Shell[50];
	Explode bao;
	Date startTime=new Date();
	Date endTime;
	int period;//游戏持续的时间
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Color c=g.getColor();
		g.drawImage(bg,0,0,null);
		plane.drawSelf(g);
		//画出所以的炮弹
		for(int i=0;i<shells.length;i++){
			shells[i].drawSelf(g);
			
			boolean peng=shells[i].getRect().intersects(plane.getRect());
			if(peng){
				//System.out.println("相撞了！！");
				plane.live=false;
				if(bao==null){
					bao =new Explode(plane.x, plane.y);
					endTime=new Date();
					period=(int)((endTime.getTime()-startTime.getTime())/1000);
				}
				bao.draw(g);
			}
			if(!plane.live){
				g.setColor(Color.RED);
				Font f=new Font("宋体", Font.BOLD, 50);
				g.setFont(f);
				g.drawString("时间:"+period+"秒", (int)plane.x, (int)plane.y);
				
				
			}
			g.setColor(c);
		}
		

	}
	/**
	 * 定义内部类:方便调用外部类的属性
	 */
	//调用线程可以反复的重画窗口
	class PaintThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while(true){
				//System.out.println("窗口画一次！");
				repaint();//重画
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	} 
	
	/**
	 * 定义键盘监听类
	 * @author Pandamin
	 *
	 */
	class KeyMonitor extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
			plane.addDirection(e);
			//System.out.println(e.getKeyCode());
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyReleased(e);
			plane.minuDirection(e);
			//System.out.println(e.getKeyCode());
		}
	}
	/**
	 * 初始化窗口
	 */
	public void launchFrame(){
		this.setTitle("Pandamin作品");
		this.setSize(Constant.GAME_WIDH, Constant.GAME_HEIGHT);
		this.setLocation(500, 250);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
		new PaintThread().start();//启动重画窗口的线程
		addKeyListener(new KeyMonitor());//增加键盘监听
		//初始化50个炮弹
		for(int i=0;i<shells.length;i++){
			shells[i]=new Shell();
		}
	}
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
	//双缓冲问题解决
	private Image offScreenImage=null;
	public void update(Graphics g){
		if(offScreenImage==null)
			offScreenImage=this.createImage(Constant.GAME_WIDH, Constant.GAME_HEIGHT);
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
}
