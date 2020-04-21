package JAVAStudy_�ֹ�ʵ��;
/**
 * hashMap�̲߳���ȫ������KVΪ��
 * hashtable�̰߳�ȫ����ͬ����飬������KVΪ��
 * @author Pandamin
 *
 * @param <K>
 * @param <V>
 */
public class Study_HashMap<K,V> {
	Node[] table;//����
	int size;//��ŵļ�ֵ�Ը���
	
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
			//���˴����½ڵ�Ϊ�գ��򽫽ڵ�ֱ�ӷŽ�ȥ
			table[newNode.hash]=newNode;
			System.out.println(newNode);
			System.out.println(newNode.hash);
			size++;
		}else{
			//��������
			while(temp!=null){
				//���key�ظ��򸲸�
				if(temp.key.equals(key)){
					keyRepeat=true;
					temp.value=value;
					size++;
					break;
				}else{
					//������ظ���Ž�ȥ
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
