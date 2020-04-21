package JAVAStudy_Page;
/**
 * 
 * @author Pandamin
 * Java�����������ջ��ƣ���C++û�иû��ƣ����Ի�Ҫ�����ȥ��ע�ڴ������ͷ�����
 * 
 */
class Point{
	double x_,y_,z_;
	public Point(double x,double y){
		/**
		 * ���췽���ĵ�һ������super();
		 */
		x_=x;
		y_=y;
	}
	public Point(double x,double y,double z){
		this(x,y);//����ͨ��this(a,b)ֻ�����������Ĺ������ұ���λ�ڵ�һ��
		/**
		 * this���ܳ�����static������
		 * static���ڷ����������ݣ�ֻ������Ϣ��û�ж�����Ϣ����thisֻ��ָ�������������
		 */
		z_=z;
	}
	public double getDistance(Point p){
		return Math.sqrt((x_-p.x_)*(x_-p.x_) +(y_-p.y_)*(y_-p.y_));
	}
}

public class Study_Constructor {
	public static void main(String[] args){
		Point p1=new Point(3,4);
		Point p2=new Point(5,6);
		System.out.println(p1.getDistance(p2));
	}
}
