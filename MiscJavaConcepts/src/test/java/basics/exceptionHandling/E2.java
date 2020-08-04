package basics.exceptionHandling;

class Z1
{
}
public class E2
{
	public static void main(String[] args)
	{
		Z1 z1= null;
		// Z1 z1=new Z1();
		try
		{
			System.out.println(z1.hashCode());
		}
		catch(ArithmeticException e)
		{
			System.out.println("caught!");
		} finally
		{
			System.out.println("Runnig Finally block \n");
		}
	}
}
/*
Output:
Runnig Finally block
Exception in thread "main"
java.lang.NullPointerException
 */