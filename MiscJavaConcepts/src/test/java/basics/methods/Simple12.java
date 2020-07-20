package basics.methods;
/*
 * There are 2 monkeys, if both the monkeys are smiling then we are in trouble, 
 * if both the monkeys are not smiling then also we are in trouble, 
 * Return true if we are in trouble
 */
public class Simple12
{
	static boolean trouble(boolean a, boolean b)
	{
		if(a==true && b==true){ 
			return true;
		}else if(a==false && b==false){
			return true; 
		}else{ 
			return false; 
		}
	}
	public static void main(String[] args)
	{
		System.out.println("Result is:" +Simple12.trouble(true, true)); 
		System.out.println("Result is:" +Simple12.trouble(false, false)); 
		System.out.println("Result is:" +Simple12.trouble(true, false)); 
		System.out.println("Result is:" +Simple12.trouble(false, true));
	} 
}
