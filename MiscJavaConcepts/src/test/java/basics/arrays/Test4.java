package basics.arrays;

import java.util.ArrayList;

//To find largest element in a given integer array
public class Test4
{
	public static void main(String[] args)
	{
		int[] arr = new int[6];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		arr[5] = 60;

		int largest = arr[0]; //Assumption 30
		for(int i=1;i<arr.length;i++)
		{
			if(largest<arr[i])//Checking the assumption 20 < 30
			{
				largest = arr[i];
			}
		}
		System.out.println("largest element is " +largest);
		

		
	}
	

	
}
/*
Output:
largest element is 50
 */