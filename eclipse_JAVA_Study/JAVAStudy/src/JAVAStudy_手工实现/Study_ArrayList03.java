package JAVAStudy_手工实现;

public class Study_ArrayList03<T> {
	private Object[] elementDate;
	private int size;
	private static final int DEFALT_CAPACITY=10;
	public  Study_ArrayList03(){
		elementDate=new Object[DEFALT_CAPACITY];
	}
	public  Study_ArrayList03(int capacity){
		if(capacity<0){
			throw new RuntimeException("容器的大小不能为负数！");
		}else if(capacity==0){
			elementDate=new Object[DEFALT_CAPACITY];
		}else{
			elementDate=new Object[capacity];
		}
	}
	public void remove(T element){
		for(int i=0;i<size;i++){
			if(element.equals(get(i))){
				remove(i);
				System.out.println("需要移除的是:"+i+elementDate[i]);
			}
		}
	}
	public void remove(int index){
		int move=elementDate.length-index-1;
		if(move>0){
			System.arraycopy(elementDate, index+1,elementDate, index, move);
		}
		elementDate[--size]=null;
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
	public T get(int index){
		Check(index);
		return (T)elementDate[index];
	}
	public void set(T element,int index){
		Check(index);
		elementDate[index]=element;
	}
	public void Check(int index){
		if(index<0||index>size-1){
			throw new RuntimeException("索引不合法:"+index);
		}
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
		Study_ArrayList03<Character> s1=new Study_ArrayList03<Character>();
		for(int i=0;i<26;i++){
			s1.add((char) ('a'+i));
		}
		//s1.get(5);
		//s1.set('A', 5);
		s1.remove('a');
		//s1.remove(1);
		s1.remove('b');
		System.out.println(s1);
	}

}
