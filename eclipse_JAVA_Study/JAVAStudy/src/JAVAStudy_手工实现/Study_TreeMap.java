package JAVAStudy_手工实现;

import java.util.Map;
import java.util.TreeMap;

public class Study_TreeMap {
	public static void main(String[] args) {
		Map<Integer,String> treemap1=new TreeMap<Integer,String>();
		treemap1.put(20, "aa");
		for(Integer key:treemap1.keySet()){
			System.out.println(key+"---"+treemap1.get(key));
		}
		Map<Student,String> tp=new TreeMap<Student,String>();
		tp.put(new Student(1,99), "好");
		tp.put(new Student(1,80), "好");
		tp.put(new Student(1,100), "好");
		
		for(Student key:tp.keySet()){
			System.out.println(key+"---"+tp.get(key));
		}
	}
}
class Student implements Comparable<Student>{
	int id;
	double scord;
	public Student(int id, double scord) {
		super();
		this.id = id;
		this.scord = scord;
	}
	@Override
	public String toString() {
		return "id:"+id+",scord:"+scord;
	}
	@Override
	public int compareTo(Student o) {
		if(this.scord>o.scord)
			return 1;
		else if(this.scord<o.scord){
			return -1;
		}else
			return 0;
	}
	
	
}