package JAVAStudy_手工实现;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Study_Collect工具类 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		for(int i=0;i<10;i++){
			list.add("a"+i);
		}
		System.out.println(list);
		Collections.shuffle(list);//随机排列list元素
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.sort(list);//自定义类使用Comparable接口
		System.out.println(list);
		System.out.println(Collections.binarySearch(list, "a9"));
	}

}
