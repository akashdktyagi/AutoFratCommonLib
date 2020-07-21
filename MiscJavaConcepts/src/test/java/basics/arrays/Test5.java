package basics.arrays;
public class Test5
{
	public static void main(String[] args)
	{
		int[] arr = new int[5];
		arr[0] = 50;
		arr[1] = 40;
		arr[2] = 30;
		arr[3] = 20;
		arr[4] = 10;
		int index=0;
		int smallest = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(smallest>arr[i])
			{
				smallest=arr[i];
				index=i;
			}
		}
		System.out.println("smallest element "+ smallest +" is available @index "+ index);
	}
}
/*
Output:
smallest element 10 is available @index 4
 */