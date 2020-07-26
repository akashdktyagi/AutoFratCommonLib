package basics.finalAndStatic.staticexample;
public class Simple5
{
	static int a=10; //static varibale
	int b=20; //non-static varibale
	
	static void test()//static method
	{
		System.out.println("Running test method");
	}
	void test2()//non-static method
	{
		System.out.println("Running test2 method");
	}
	public static void main(String[] args)
	{
		Simple5.test();//Directly access the static method
		System.out.println("Value of a is " +Simple5.a);//Directly access the static varibale
		
		Simple5 s5=new Simple5(); //first create new address space and create a reference
		s5.test2(); //reference varibale used to access the non-static method which is in heap memory
		System.out.println("Value of b is " +s5.b);
	}
}
