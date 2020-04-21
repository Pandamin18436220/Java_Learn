package JAVAStudy_手工实现;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Study_Interator {
	
	public static void test(){
		//迭代器遍历List
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		for(Iterator<String> iter=list.iterator();iter.hasNext();){
			String temp=iter.next();
			System.out.println(temp);
		}
		//set
		Set<String> set=new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		for(Iterator<String> iter=set.iterator();iter.hasNext();){
			String temp=iter.next();
			System.out.println(temp);
		}
		//Map
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(100, "a");
		map.put(200, "b");
		//先将Map转化从Set---繁琐
		Set<Entry<Integer,String>> ss=map.entrySet();
		for(Iterator<Entry<Integer, String>> iter=ss.iterator();iter.hasNext();){
			Entry<Integer, String> temp=iter.next();
			System.out.println(temp.getKey()+"-"+temp.getValue());
		}
		//先将Map转化从Set---简单
		Set<Integer> set1=map.keySet();
		for(Iterator<Integer> iter=set1.iterator();iter.hasNext();){
			Integer temp=iter.next();
			System.out.println(temp);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

}
