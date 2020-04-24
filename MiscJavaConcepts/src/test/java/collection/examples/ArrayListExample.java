package collection.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ArrayListExample {
	
	@Test
	public void t_01_array_list_operations() {
		
		//Dec and init
		ArrayList<String> list = new ArrayList<String>();
		list.add("Akash");
		list.add("Sumit");
		list.add("Amit");
		
		//Printing the whole list
		System.out.println(list.toString());
		
		//Adding a new element , added at the bottom
		list.add("sumit1");
		
		System.out.println(list.toString());
		
		//To retieve the element from the list
		System.out.println("2nd element of the list: " + list.get(2));
		
		//Remove the element
		list.add(1, "Rahul");
		System.out.println(list.toString());
		
		
		//Merge two lists
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Akash1");
		list1.add("Sumit1");
		list1.add("Amit1");
		
		list.addAll(2, list1);
		System.out.println(list.toString());
		
		//Iteration- Method 1
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		//Iterator-Method 2
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println("Looping using Iterator:" + itr.next());
		}

		
	}

	
	@Test
	public void t_02_multidimensional_array_list() {
		//Data-1,2,3,4,5,6,7,8
		
		/* two dimensional Data
			0,1,2
			3,4,5
			6,7,8
		 */
		
		//Init a parent collection
		ArrayList<ArrayList<Integer>> parent = new ArrayList<ArrayList<Integer>>();
		
		//Creating 1st row
		ArrayList<Integer> col_list_row_1 = new ArrayList<Integer>();
		col_list_row_1.add(0);
		col_list_row_1.add(1);
		col_list_row_1.add(2);
		
		//Adding the first row
		parent.add(col_list_row_1);
		
		//Creating the  2nd Row
		ArrayList<Integer> col_list_row_2 = new ArrayList<Integer>();
		col_list_row_2.add(3);
		col_list_row_2.add(4);
		col_list_row_2.add(5);
		
		//Adding the second row
		parent.add(col_list_row_2);
		
		System.out.println(parent.toString());
		
		
		
	}
}
