package JAVAStudy_手工实现;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Study_存储表格 {
	/**
	 * 每一行使用一个Map或者数组
	 * 整个表格使用List或者Map(只要是容器就可以)
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,Object> row1=new HashMap<String,Object>();
		row1.put("id", 1001);
		row1.put("name", "pandamin");
		row1.put("salary", 2000);
		row1.put("时间", 2000-03-06);
		
		Map<String,Object> row2=new HashMap<String,Object>();
		row2.put("id", 1002);
		row2.put("name", "pand");
		row2.put("salary", 3000);
		row2.put("时间", 1999-03-06);
		
		List<Map<String,Object>> table1=new ArrayList<Map<String,Object>>();
		table1.add(row1);
		table1.add(row2);
		for(Map<String,Object> row:table1){
			Set<String> keyset=row.keySet();
			for(String key:keyset){
				System.out.print(key+":"+row.get(key)+"\t");
			}
			System.out.println();
		}
	}

}
