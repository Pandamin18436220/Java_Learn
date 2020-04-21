package JAVAStudy_Page;
/**
 * 
 * @author Pandamin
 * Java引入垃圾回收机制，令C++没有该机制，所以还要格外的去关注内存管理的释放问题
 * 
 */
class Point{
	double x_,y_,z_;
	public Point(double x,double y){
		/**
		 * 构造方法的第一句总是super();
		 */
		x_=x;
		y_=y;
	}
	public Point(double x,double y,double z){
		this(x,y);//可以通过this(a,b)只代两个参数的构造器且必须位于第一句
		/**
		 * this不能出现在static方法中
		 * static属于方法区的内容，只有类信息，没有对象信息，而this只能指代堆里面的内容
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
