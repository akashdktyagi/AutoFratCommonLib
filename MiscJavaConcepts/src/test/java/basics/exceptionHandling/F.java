package basics.exceptionHandling;

public class F
{
	public static void main(String[] args)
	{
		try
		{
			int a=10/0;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Runnig 1st catch");
		}
		catch(ArithmeticException e)
		{
			System.out.println("Running 2nd catch");
		}
	}
}
/*
Output:
Running 2nd catch
Note:
1 try block can be followed by multiple catch block but only appropriate catch block will be executed.
*/