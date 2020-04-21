package JAVAStudy_�ֹ�ʵ��;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Study_�洢ORM {
	/**
	 * ÿһ��ʹ��һ��javabea����
	 * �������ʹ��Map(ֻҪ�������Ϳ���)
	 * @param args
	 */
	public static void main(String[] args) {
		User user1=new User(1001,"panda",2000.0,"200-03-06");
		User user2=new User(1002,"panda1",3000.0,"200-03-06");
		User user3=new User(1003,"panda2",4000.0,"200-03-06");
		
		List<User> list=new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		for(User u:list){
			System.out.println(u);
		}
		
		Map<Integer,User> map=new HashMap<Integer, User>();
		map.put(1, user1);
		map.put(2, user2);
		map.put(3, user3);
		Set<Integer> keyset=map.keySet();
		for(Integer key:keyset){
			System.out.println(key+"-"+map.get(key));
		}
	}
}
class User{
	//������javabean������Ҫ��һ���޲ι�����+setget����
	private int id;
	private String name;
	private double salary;
	private String hiredate;
	public User(){
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id+",name:"+name+",salary:"+salary+",hiredate:"+hiredate;
	}
	public User(int id, String name, double salary, String hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hiredate = hiredate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
}
