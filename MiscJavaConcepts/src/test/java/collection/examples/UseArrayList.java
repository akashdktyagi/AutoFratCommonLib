package collection.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class UseArrayList {
	
	@Test
	public void array_list() {
		
		List<String> list = new ArrayList<String>();
		
		list.add("akash");
		list.add("amit");
		list.add("sumit");
		list.add("sarang");
		list.add("rajat");
		
		System.out.println(list.toString());
		
		//Add one list to another List
		List<String> list1 = new ArrayList<String>();
		list1.add("wow");
		list1.add("foo");
		list.addAll(2,list1);
		System.out.println(list.toString());
		
		//Search for element in List
		System.out.println(list.contains("sumit"));
		System.out.println(list.containsAll(list1));
		
		//How to iterate-Method 1
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		//How to iterate-Method 2
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}

	@Test
	public void array_list_with_out_generics() {
		List list = new ArrayList();
		list.add("akash");
		list.add(1);
		list.add(true);
		
		System.out.println(list.toString());
		
	}
}
