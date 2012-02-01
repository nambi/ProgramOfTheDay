package org.nava.obj2map;

import java.util.HashMap;
import java.util.Map;

public class ObjectToMapConverterTest {

	public static void main(String[] args) {
		ItemInContext item = new ItemInContext(10L, "TestItem", 12.34);
		Map<String, Object> map = new HashMap<String, Object>();
		
		ObjectToMapConverter converter = new ObjectToMapConverter(item, map);
		System.out.println("Item to be converted : "+item);
		converter.convert();
		
		for (String key : map.keySet()) {
			System.out.println("Key : " + key + " -> " + map.get(key));
		}
		
		Long id = (Long)map.get("id");
		System.out.println("The id maintains the type so I can increment by 2 :"+(id+2));
	}
	
}
