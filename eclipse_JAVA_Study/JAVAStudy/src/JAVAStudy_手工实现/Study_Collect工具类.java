package JAVAStudy_�ֹ�ʵ��;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Study_Collect������ {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		for(int i=0;i<10;i++){
			list.add("a"+i);
		}
		System.out.println(list);
		Collections.shuffle(list);//�������listԪ��
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.sort(list);//�Զ�����ʹ��Comparable�ӿ�
		System.out.println(list);
		System.out.println(Collections.binarySearch(list, "a9"));
	}

}
