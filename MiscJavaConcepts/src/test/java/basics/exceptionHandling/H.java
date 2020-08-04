package basics.exceptionHandling;

public class H
{
	public static void main(String[] args)
	{
		try
		{
			int[] arr=new int[-10];
		}
		catch(Throwable e)
		{
			System.out.println(e.getMessage());
			System.out.println("Caught");
		}
	}
}
/*
Output:
null
Caught

Note: Though throw-able catch block can handle any type of exception we should not use throw-able
catch block alone i.e., while handling exceptions we should follow an order while writing catch block.
We should write the catch block from most specific exception class to most Generic Exception class.
 */