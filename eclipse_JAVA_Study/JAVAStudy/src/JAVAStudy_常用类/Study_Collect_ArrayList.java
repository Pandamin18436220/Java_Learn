package JAVAStudy_≥£”√¿‡;

import java.util.ArrayList;
import java.util.Collection;

public class Study_Collect_ArrayList {
	public static void main(String[] args) {
		Collection<String> c=new ArrayList<String>();
		Collection<String> c1=new ArrayList<String>();
		c.add("1");
		c.add("2");
		c.add("3");
		c1.add("1");
		c1.add("2");
		c1.add("3");
		Object[] objs=c.toArray();
		for(Object m:objs){
			System.out.println(m);
		}
		System.out.println(c.contains("1"));
		
		System.out.println("c"+c);
		c.removeAll(c1);
		System.out.println("c"+c);
		c.retainAll(c1);
		System.out.println("c"+c);
		System.out.println(c.containsAll(c1));
	}

}
