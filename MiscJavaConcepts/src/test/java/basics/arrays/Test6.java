package basics.arrays;
//search given element in a array is existing or not, if its existing print the index of that element
//otherwise print -1
public class Test6
{
	public static void main(String[] args)
	{
		int[] arr = new int[5];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		int search = 50;
		boolean b=true;
		for(int i=0;i<arr.length;i++)
		{
			if(search == arr[i])
			{
				b=false;
				System.out.println("element is available @ index " +i);
				break;
			}
		}
		if(b==true)
		{
			System.out.println("Element is not available " +(-1));
		}
	}
}
/*
Output:
element is available @ index 4
 */