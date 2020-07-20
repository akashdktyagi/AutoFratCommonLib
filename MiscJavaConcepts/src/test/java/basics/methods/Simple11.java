package basics.methods;

/*
 * Given 2 integers 
 * return 
 *  a. twice their sum if both are same
 *  b. otherwise return their sum
 *  
 */
public class Simple11
{
	static int twiceSum(int a,int b)
	{
		if(a==b){
			return 2*(a+b);
		}else {
			return (a+b);
		}
	}
	
	public static void main(String[] args)
	{
		int a = Simple11.twiceSum(10,20);
		int b = Simple11.twiceSum(20,40);
		int c = Simple11.twiceSum(10,30);
		
		System.out.println("Result is :" + a);
		System.out.println("Result is :" + b); 
		System.out.println("Result is :" + c);
	}
}