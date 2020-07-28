package basics.abstractClassAndInterface;


//Boss Created- THings to be done
abstract class A
{
	abstract void test1();//only declaration
	abstract void test2();//only declaration
	
	public void test3() {
		//i am implemented
	}
}

//Worker
class B extends A//inheriting abstract class A
{
	@Override
	void test1()//Declaration
	{
		System.out.println("test1() is overridden in class B");//Definition
	}
	@Override
	void test2()//Declaration
	{
		System.out.println("test2() is overridden in class B");//Definition
	}
}
public class Test1
{
	public static void main(String[] args)
	{
		System.out.println("Main Starts");
		//A a=new A();//Class A is abstract and cannot be instantiated
		B b=new B();
		b.test1();
		b.test2();
	}
}

/*
Output:
Main Starts
test1() is overridden in class B
test2() is overridden in class B
*/