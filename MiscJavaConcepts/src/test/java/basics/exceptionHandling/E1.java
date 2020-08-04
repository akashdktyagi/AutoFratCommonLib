package basics.exceptionHandling;
class Z
{
}
public class E1
{
	public static void main(String[] args)
	{
		// Z z1= null;
		Z z1=new Z();
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
366712642
Runnig Finally block
 */