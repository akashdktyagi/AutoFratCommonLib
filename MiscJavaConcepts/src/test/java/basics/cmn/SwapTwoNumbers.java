package basics.cmn;
public class SwapTwoNumbers
{
	static void swap(int num1,int num2)
	{
		int temp=num1;
		num1=num2;
		num2=temp;
		System.out.println("number1: " +num1);
		System.out.println("number2: " +num2);
	}
	public static void main(String[] args)
	{
		int num1=10;
		int num2=20;
		System.out.println("number1:" +num1);
		System.out.println("number2:" +num2);
		SwapTwoNumbers.swap(num1, num2);
	}
}