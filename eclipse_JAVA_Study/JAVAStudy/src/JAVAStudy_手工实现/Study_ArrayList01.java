package JAVAStudy_手工实现;

public class Study_ArrayList01<T> {
	private Object[] elementDate;
	private int size;
	private static final int DEFALT_CAPACITY=10;
	public  Study_ArrayList01(){
		elementDate=new Object[DEFALT_CAPACITY];
	}
	public  Study_ArrayList01(int capacity){
		elementDate=new Object[capacity];
	}
	public void add(T obj){
		System.out.println(size);
		elementDate[size++]=obj;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i=0;i<size;i++){
			sb.append(elementDate[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Study_ArrayList01<String> s1=new Study_ArrayList01<String>(20);
		s1.add("aa");
		s1.add("bb");
		System.out.println(s1);
	}

}
