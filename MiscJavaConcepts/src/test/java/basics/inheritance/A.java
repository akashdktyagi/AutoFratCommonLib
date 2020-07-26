package basics.inheritance;
class A extends Object
{
	int a=10;
	
	void test1()
	{
		System.out.println("Running test1");
	}
}
class B extends A
{
	/*
	int a=10;
	
	void test1()
	{
		System.out.println("Running test1");
	}*/
	
	double d=10.5;
	void demo1()
	{
		System.out.println("Running demo2");
	}
}
class SingleInheritance
{
	public static void main(String[] args)
	{
		B b = new B();
		
	}
}