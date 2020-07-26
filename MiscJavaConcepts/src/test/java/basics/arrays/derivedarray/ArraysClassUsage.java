package basics.arrays.derivedarray;

import java.util.Arrays;

public class ArraysClassUsage {

	 public static void main1(String[] args) 
	    { 
	  
	        // Get the Array 
	        int intArr[] = { 10, 20, 15, 22, 35 }; 
	  
	        // To convert the elements as List 
	        System.out.println("Integer Array as List: "
	                           + Arrays.asList(intArr)); 
	    } 
	 
	  public static void main2(String[] args) 
	    { 
	  
	        // Get the Array 
	        int intArr[] = { 10, 20, 15, 22, 35 }; 
	  
	        Arrays.sort(intArr); 
	  
	        int intKey = 22; 
	  
	        System.out.println(intKey 
	                           + " found at index = "
	                           + Arrays 
	                                 .binarySearch(intArr, intKey)); 
	    } 
	  
	  public static void main3(String[] args) 
	    { 
	  
	        // Get the Array 
	        int intArr[] = { 10, 20, 15, 22, 35 }; 
	  
	        Arrays.sort(intArr); 
	  
	        int intKey = 22; 
	  
	        System.out.println( 
	            intKey 
	            + " found at index = "
	            + Arrays 
	                  .binarySearch(intArr, 1, 3, intKey)); 
	    } 
	  
	  public static void main4(String[] args) 
	    { 
	  
	        // Get the Array 
	        int intArr[] = { 10, 20, 15, 22, 35 }; 
	  
	        // Get the second Array 
	        int intArr1[] = { 10, 15, 22 }; 
	  
	        // To compare both arrays 
	        System.out.println("Integer Arrays on comparison: "
	                           + Arrays.compare(intArr, intArr1)); 
	    } 
	  
	  public static void main5(String[] args) 
	    { 
	  
	        // Get the Array 
	        int intArr[] = { 10, 20, 15, 22, 35 }; 
	  
	        // To print the elements in one line 
	        System.out.println("Integer Array: "
	                           + Arrays.toString(intArr)); 
	  
	        System.out.println("\nNew Arrays by copyOf:\n"); 
	  
	        System.out.println("Integer Array: "
	                           + Arrays.toString( 
	                                 Arrays.copyOf(intArr, 10))); 
	    } 
	  
	  public static void main6(String[] args) 
	    { 
	  
	        // Get the Array 
	        int intArr[] = { 10, 20, 15, 22, 35 }; 
	  
	        // To sort the array using normal sort- 
	        Arrays.sort(intArr); 
	  
	        System.out.println("Integer Array: "
	                           + Arrays.toString(intArr)); 
	    } 
	  
	  public static void main7(String[] args) 
	    { 
	  
	        // Get the Array 
	        int intArr[] = { 10, 20, 15, 22, 35 }; 
	  
	        // To print the elements in one line 
	        System.out.println("Integer Array: "
	                           + Arrays.toString(intArr)); 
	    } 
	 
}
