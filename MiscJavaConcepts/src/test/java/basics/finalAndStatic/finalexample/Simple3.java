package basics.finalAndStatic.finalexample;
/*Example: If local and Global variables have the same name, then we should use class-name to
access the global varibale
 */
public class Simple3
{
	static int a=10;//Global varibale
	public static void main(String[] args)
	{
		int a=20;//Local Varibale
		System.out.println("local a=" +a);
		System.out.println("Global a=" +Simple3.a);
	}
}
/*
	Output:
		local a=20
		Global a=10
*/