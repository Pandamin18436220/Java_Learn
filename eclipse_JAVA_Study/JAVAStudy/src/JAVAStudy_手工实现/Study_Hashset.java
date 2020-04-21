package JAVAStudy_手工实现;
/**
 * 手动实现HashSet
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Study_Hashset {
	HashMap map;
	private static final Object PRRSENT=new Object();
	public Study_Hashset(){
		map=new HashMap();
	}
	public int siie() {
		return map.size();
	}
	public void add(Object o){
		map.put(o, PRRSENT);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder("[");
		for(Object key:map.keySet()){
			sb.append(key+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	public static void main(String[] args) {
		Set<String> set1=new HashSet<String>();
		set1.add("aa");
		set1.add("aa");
		System.out.println(set1);
		Study_Hashset set=new Study_Hashset();
		set.add("aa");
		set.add("aa");
		System.out.println(set);
		
	}

}
