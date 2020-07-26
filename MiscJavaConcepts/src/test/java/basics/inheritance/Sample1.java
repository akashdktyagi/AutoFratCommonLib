package basics.inheritance;
class Sample1
{
	void test1()
	{
		System.out.println("Running Test1");
	}
}
class Sample2 extends Sample1
{
	void test2()
	{
		System.out.println("Running Test2");
	}
}
class Sample3 extends Sample2
{
	void test3()
	{
		System.out.println("Running Test3");
	}
}
class MultiLevelInheritence
{
	public static void main(String[] args)
	{
		System.out.println("Main Starts");
		Sample3 rv1=new Sample3();
		rv1.test1();
		rv1.test2();
		rv1.test3();
		System.out.println();
		Sample2 rv2=new Sample2();
		rv2.test1();
		rv2.test2();
		//rv2.test3();
		System.out.println("Main Ends");
	}
}