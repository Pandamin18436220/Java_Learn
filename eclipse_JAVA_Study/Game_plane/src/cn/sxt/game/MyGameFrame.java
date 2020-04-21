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
 * �ɻ���Ϸ��������
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
	int period;//��Ϸ������ʱ��
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Color c=g.getColor();
		g.drawImage(bg,0,0,null);
		plane.drawSelf(g);
		//�������Ե��ڵ�
		for(int i=0;i<shells.length;i++){
			shells[i].drawSelf(g);
			
			boolean peng=shells[i].getRect().intersects(plane.getRect());
			if(peng){
				//System.out.println("��ײ�ˣ���");
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
				Font f=new Font("����", Font.BOLD, 50);
				g.setFont(f);
				g.drawString("ʱ��:"+period+"��", (int)plane.x, (int)plane.y);
				
				
			}
			g.setColor(c);
		}
		

	}
	/**
	 * �����ڲ���:��������ⲿ�������
	 */
	//�����߳̿��Է������ػ�����
	class PaintThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while(true){
				//System.out.println("���ڻ�һ�Σ�");
				repaint();//�ػ�
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
	 * ������̼�����
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
	 * ��ʼ������
	 */
	public void launchFrame(){
		this.setTitle("Pandamin��Ʒ");
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
		new PaintThread().start();//�����ػ����ڵ��߳�
		addKeyListener(new KeyMonitor());//���Ӽ��̼���
		//��ʼ��50���ڵ�
		for(int i=0;i<shells.length;i++){
			shells[i]=new Shell();
		}
	}
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
	//˫����������
	private Image offScreenImage=null;
	public void update(Graphics g){
		if(offScreenImage==null)
			offScreenImage=this.createImage(Constant.GAME_WIDH, Constant.GAME_HEIGHT);
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
}
