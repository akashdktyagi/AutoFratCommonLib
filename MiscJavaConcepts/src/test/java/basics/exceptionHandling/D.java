package basics.exceptionHandling;
public class D
{
	public static void main(String[] args)
	{
		int a=10;
		int b=0;
		try
		{
			int result=a/b;
			System.out.println("the result is " +result);
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
/*
Output:
/ by zero
 */