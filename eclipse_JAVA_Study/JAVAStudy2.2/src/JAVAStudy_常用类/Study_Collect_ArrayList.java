package JAVAStudy_≥£”√¿‡;

import java.util.ArrayList;
import java.util.Collection;

public class Study_Collect_ArrayList {
	public static void main(String[] args) {
		Collection<String> c=new ArrayList<>();
		c.add("1");
		c.add("2");
		Object[] objs=c.toArray();
		for(Object m:objs){
			System.out.println(m);
		}
		System.out.println(c.contains("1"));
	}

}
