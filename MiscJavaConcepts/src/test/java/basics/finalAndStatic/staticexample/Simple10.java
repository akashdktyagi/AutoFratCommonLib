package basics.finalAndStatic.staticexample;
public class Simple10
{
	static int count=0;
	static void click()
	{
		System.out.println("Button clicked");
		Simple10.count++;
	}
	public static void main(String[] args)
	{
		System.out.println("Total clicks: " +Simple10.count);
		Simple10.click();
		Simple10.click();
		System.out.println("Total clicks: " +Simple10.count);
		Simple10.click();
		Simple10.click();
		System.out.println("Total clicks: " +Simple10.count);
	}
}