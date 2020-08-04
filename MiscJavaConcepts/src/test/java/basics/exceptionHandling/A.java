package basics.exceptionHandling;
public class A
{
	public static void main(String[] args)
	{
		int a1=Integer.parseInt("wow");
		try
		{
			int a=Integer.parseInt("hey");
		}
		catch (NumberFormatException e)
		{
			System.out.println("caught");
		}
	}
}
/*
Output:
caught
 */