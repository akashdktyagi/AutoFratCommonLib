package basics.exceptionHandling;
public class C
{
	public static void main(String[] args)
	{
		int[] arr={10,20};
		try
		{
			System.out.println(arr[900]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
/*
Output:
900
 */