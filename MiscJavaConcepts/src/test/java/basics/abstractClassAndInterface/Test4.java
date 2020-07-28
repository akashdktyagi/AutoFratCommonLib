package basics.abstractClassAndInterface;



abstract class Sample
{
	abstract void test1();
	abstract void test2();
}
class Demo extends Sample// sub class Demo should implement all the methods of abstract methods
{
	void test1()
	{
		System.out.println("Test1() overridden in demo class");
	}
}
//void test2() is not inherited and implemented, so CTE. 
public class Test4
{
	public static void main(String[] args)
	{
		Demo d1=new Demo();
		d1.test1();
		d1.test2();
	}
}

/*
Output:
Abstract_Class.Demo is not abstract and does not override abstract method test2() in
Abstract_Class.Sample
*/