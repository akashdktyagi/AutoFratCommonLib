package basics.exceptionHandling;

public class G
{
	public static void main(String[] args)
	{
		int[] arr1={10,20,30,40,50,60,70,80};
		int[] arr2={10,0,30,0,50};
		for(int i=0;i<arr1.length;i++)
		{
			try
			{
				System.out.println(arr1[i]/arr2[i]);
			}
			catch(ArithmeticException e)
			{
				System.out.println(e.getMessage());
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("No such index");
			}
		}
	}
}
/*
Output:
1/
by zero
1/
by zero
1
No such index
No such index
No such index
 */