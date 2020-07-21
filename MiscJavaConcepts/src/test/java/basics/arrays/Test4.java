package basics.arrays;
//To find largest element in a given integer array
public class Test4
{
	public static void main(String[] args)
	{
		int[] arr = new int[5];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		int largest = arr[0]; //Assumption
		for(int i=1;i<arr.length;i++)
		{
			if(largest<arr[i])//Checking the assumption
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