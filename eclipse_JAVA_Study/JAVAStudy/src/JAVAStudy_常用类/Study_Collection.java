package JAVAStudy_≥£”√¿‡;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Study_Collection {
	public static void main(String[] args) {
		MyCollection<String> mc=new MyCollection<String>();
		mc.set("pandamin",0);
		//List
		List list=new ArrayList();
		Map map=new HashMap();
	}
}
class MyCollection<T>{
	Object[] objs=new Object[5];
	
	public void set(T obj,int index){
		objs[index]=obj;
	}
	public T get(int index){
		return (T)objs[index];
	}
}
