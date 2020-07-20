package basics.methods;
/*
 * Given 2 integers return true(boolean) 
 * if sum of them is 30 or one of them is 30.
 */
public class Simple10
{
	static boolean test(int n1,int n2)
	{
		if(n1+n2==30 && n1==30 && n2==30){ //t,f,f = t
			return true; 
		}else{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("Result is " +Simple10.test(10, 20));
		System.out.println("Result is " +Simple10.test(20, 20)); 
	}
}
/*

 t , t ,t = t
 f,f,f=f
 t,f,f = t
 f,t,f = t
 f,f,t = t
 
 */
