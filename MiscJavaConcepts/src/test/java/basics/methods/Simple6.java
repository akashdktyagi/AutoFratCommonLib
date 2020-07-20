package basics.methods;
public class Simple6
{
	static int square(int num)
	{
		int sq=num*num;
		return sq;
	} 
	public static void main(String[] args)
	{
		int res=Simple6.square(9);
		System.out.println("Result is :" +res); 
	}
}