package JAVAStudy_手工实现;

public class Study_ArrayList02<T> {
	private Object[] elementDate;
	private int size;
	private static final int DEFALT_CAPACITY=10;
	public  Study_ArrayList02(){
		elementDate=new Object[DEFALT_CAPACITY];
	}
	public  Study_ArrayList02(int capacity){
		elementDate=new Object[capacity];
	}
	public void add(T obj){
		if(size==elementDate.length){
			Object[] newArray=new Object[elementDate.length+(elementDate.length>>1)];
			System.arraycopy(elementDate, 0, newArray, 0, elementDate.length);
			elementDate=newArray;
		}
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
		Study_ArrayList02<Character> s1=new Study_ArrayList02<Character>();
		for(int i=0;i<26;i++){
			s1.add((char) ('a'+i));
		}
		System.out.println(s1);
	}

}
