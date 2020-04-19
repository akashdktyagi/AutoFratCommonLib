package collection.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class UseArrayList {
	
	@Test
	public void add_value_to_array_list() {
		
		List<String> list = new ArrayList<String>();
		
		list.add("akash");
		list.add("amit");
		list.add("sumit");
		list.add("sarang");
		list.add("rajat");
		
		System.out.println(list.toString());
		
		List<String> list1 = new ArrayList<String>();
		list1.add("wow");
		list1.add("foo");
		
		list.addAll(2,list1);
		System.out.println(list.toString());
		
		System.out.println(list.contains("sumit"));
		System.out.println(list.containsAll(list1));
		
		
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		TreeSet<String> ts = new TreeSet<String>();
		
		ts.add("rajat");
		ts.add("amit");
		ts.add("sumit");
		ts.add("sarang");
		ts.add("akash");
		System.out.println(ts.toString());
		
	}

}
