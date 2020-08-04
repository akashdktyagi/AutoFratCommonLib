package basics.exceptionHandling;

class M
{
	public static void test() throws Exception
	{
		int i=10/0;
	}
}
public class L
{
	public static void main(String[] args)
	{
		M m1=new M();
		try
		{
			m1.test();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
/*
Output:
java.lang.ArithmeticException: / by zero
Note: When a method of 1 class is used in another class without inheritance then we need to
surround the method with try catch block.
Throws helps us to take up the memory address of the object and gives it to catch.
 */