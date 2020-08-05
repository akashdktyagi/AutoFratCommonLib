package basics.exceptionHandling;
public class B
{
	public static void main(String[] args)
	{
		//int a1=10/0;
		
		try
		{
			int a=10/0;
		}
		catch(ArithmeticException e)
		{
			System.out.println("caught");
		}
	}
}
/*
Output:
caught
 */