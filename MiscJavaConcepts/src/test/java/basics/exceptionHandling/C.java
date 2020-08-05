package basics.exceptionHandling;
public class C
{
	public static void main(String[] args)
	{
		int[] arr={10,20};//arr[0]
		
		try
		{
			System.out.println(arr[900]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}
}
/*
Output:
900
 */