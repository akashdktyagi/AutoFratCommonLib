package basics.cmn;
public class SwapTwoNumbersWithOutTemp
{
	static void swap(int a, int b)
	{
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("a=" +a);
		System.out.println("b=" +b);
	}
	public static void main(String[] args)
	{
		int a=10;
		int b=20;
		System.out.println("Before Swapping");
		System.out.println("a=" +a);
		System.out.println("b=" +b);
		System.out.println("After Swapping");
		SwapTwoNumbersWithOutTemp.swap(a, b);
	}
}
