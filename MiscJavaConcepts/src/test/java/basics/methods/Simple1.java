package basics.methods;
public class Simple1
{
	static int result;
	
	static void square(int num)
	{
		
		result =  num*num;
	}
	
	public static void main(String[] args)
	{
		square(2);//Method invocation
		System.out.println("Result is" +result); 
	} 

}