package basics.finalAndStatic.finalexample;
public class Simple1
{
	final static double PI=3.14;
	public static void main(String[] args)
	{
		System.out.println("PI value" +Simple1.PI);
		Simple1.PI=9.36;//cannot assign a value to final varibale
		{
			System.out.println("PI vlaue" +Simple1.PI);
		}
	}
}