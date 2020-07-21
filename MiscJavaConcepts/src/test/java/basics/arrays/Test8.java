package basics.arrays;
//to find the sum of even number in a given integer array
public class Test8
{
	public static void main(String[] args)
	{
		int[] arr = new int[5];
		arr[0]=10;
		arr[0]=11;
		arr[0]=12;
		arr[0]=13;
		arr[0]=14;
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]%2==0)
			{
				sum=sum+arr[i];
			}
		}
		System.out.println("elements sum is " +sum);
	}
}
/*
Output:
elements sum is 14
 */