package collection.examples;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HashMapExample {

	@Test
	public void t_01_hash_map_example() {
		
		//Data: 1,2,3,4,5
		
		//Data: a-1,b-2,c-3
		
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		hm.put("a", 1);
		hm.put("b", 2);
		hm.put("c", 3);
		
		System.out.println(hm.toString());
		
		if (hm.containsKey("b")) {
			System.out.println("Key as B is found");
		}else {
			System.out.println("Key as B is not found");
		}
		
		//Iterate a hash map
		for (Map.Entry<String, Integer> entry:hm.entrySet()) {
			System.out.println("Key is: " +  entry.getKey());
			System.out.println("Value is: " +  entry.getValue());	
		}
		
	}
	
	@Test
	public void t_01_dual_hash_map() {
		//Create dual hash Map
		/*
		 * 
		 * Akash->P->30
		 * 		  C->56
		 * 		  M->78
		   Sumit->P->90
		 * 		  c->46
		 * 		  M->28
		 * 
		 */
		
		HashMap<String,Integer> akash_marks_hm = new HashMap<String,Integer>();
		akash_marks_hm.put("P",30);
		akash_marks_hm.put("C",56);
		akash_marks_hm.put("M",78);
		
		HashMap<String,Integer> sumit_marks_hm = new HashMap<String,Integer>();
		sumit_marks_hm.put("P",90);
		sumit_marks_hm.put("C",46);
		sumit_marks_hm.put("M",28);
		
		//Parent HM
		HashMap<String,HashMap<String,Integer>> hm_parent = new HashMap<String,HashMap<String,Integer>>();
		hm_parent.put("Akash",akash_marks_hm);
		hm_parent.put("Sumit",sumit_marks_hm);
		
		System.out.println(hm_parent.toString());
		
		
		
		
	}
	
}
