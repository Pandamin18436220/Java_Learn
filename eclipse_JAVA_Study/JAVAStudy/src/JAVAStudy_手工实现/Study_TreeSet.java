package JAVAStudy_手工实现;

import java.util.Set;
import java.util.TreeSet;

public class Study_TreeSet {
	public static void main(String[] args) {
		Set<Integer> set=new TreeSet<Integer>();
		Set<Stu> set1=new TreeSet<Stu>();
		set1.add(new Stu(1,1));
		set1.add(new Stu(4,4));
		set1.add(new Stu(2,2));
		for(Stu s:set1){
			System.out.println(s);
		}
	}

}
class Stu implements Comparable<Stu>{
	int id;
	double scord;
	public Stu(int id, double scord) {
		super();
		this.id = id;
		this.scord = scord;
	}
	@Override
	public String toString() {
		return "id:"+id+",scord:"+scord;
	}
	@Override
	public int compareTo(Stu o) {
		if(this.scord>o.scord)
			return 1;
		else if(this.scord<o.scord){
			return -1;
		}else
			return 0;
	}	
}
