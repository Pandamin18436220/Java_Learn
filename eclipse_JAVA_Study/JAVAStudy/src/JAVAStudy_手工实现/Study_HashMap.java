package JAVAStudy_手工实现;
/**
 * hashMap线程不安全：允许KV为空
 * hashtable线程安全，做同步检查，不允许KV为空
 * @author Pandamin
 *
 * @param <K>
 * @param <V>
 */
public class Study_HashMap<K,V> {
	Node[] table;//数组
	int size;//存放的键值对个数
	
	public Study_HashMap() {
		super();
		this.table = new Node[16];
	}
	public V get(K key){
		int hash=myHash(key.hashCode(), table.length);
		V value=null;
		
		if(table[hash]!=null){
			Node temp=table[hash];
			while(temp!=null){
				if(temp.key.equals(key)){
					value=(V)temp.value;
					break;
				}else
					temp=temp.next;
			}
		}
		return value;
	}
	public void put(K key,V value){

		Node newNode=new Node();
		newNode.hash=myHash(key.hashCode(),table.length);
		newNode.key=key;
		newNode.value=value;
		newNode.next=null;
		Node temp=table[newNode.hash];
		Node iterlast=null;
		boolean keyRepeat=false;
		if(temp==null){
			//若此处的新节点为空，则将节点直接放进去
			table[newNode.hash]=newNode;
			System.out.println(newNode);
			System.out.println(newNode.hash);
			size++;
		}else{
			//遍历数组
			while(temp!=null){
				//如果key重复则覆盖
				if(temp.key.equals(key)){
					keyRepeat=true;
					temp.value=value;
					size++;
					break;
				}else{
					//如果不重复则放进去
					iterlast=temp;
					temp=temp.next;
				}
			}
			if(!keyRepeat)
				size++;
				iterlast.next=newNode;
		}
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("{");
		for(int i=0;i<table.length;i++){
			Node temp=table[i];
			while(temp!=null){
				sb.append(temp.key+":"+temp.value+",");
				temp=temp.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}
	public int myHash(int h,int length){
		
		return h&(length-1);
	}
	public static void main(String[] args) {
		Study_HashMap<Integer,String> m=new Study_HashMap<Integer,String>();
		m.put(10, "pandamin");
		m.put(20,"pck");
		System.out.println(m);
		
		System.out.println(m.get(10));
		System.out.println(m.get(12));
	}

}
