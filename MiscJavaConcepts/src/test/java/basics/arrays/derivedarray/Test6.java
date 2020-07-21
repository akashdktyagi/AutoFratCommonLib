package basics.arrays.derivedarray;
import java.util.Arrays;
public class Test6
{
	public static void main(String[] args)
	{
		int[] arr = new int[5];
		arr[0] = 50;
		arr[1] = 40;
		arr[2] = 30;
		arr[3] = 20;
		arr[4] = 10;
		Arrays.sort(arr);
		System.out.println(Arrays.binarySearch(arr,40));
		System.out.println(Arrays.binarySearch(arr,6));
		System.out.println(Arrays.binarySearch(arr,15));
		System.out.println(Arrays.binarySearch(arr,45));
	}
}
/*
Output:
3
-1
-2
-5
 */