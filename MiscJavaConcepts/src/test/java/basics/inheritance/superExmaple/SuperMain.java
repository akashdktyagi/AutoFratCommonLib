package basics.inheritance.superExmaple;
class A
{
	A()
	{
		System.out.println("Constructor of A class");
	}
	
	A(int i){
		System.out.println("i: " + i);
	}
}
class B extends A
{
	B()
	{	
		//super();
		super(2);
		System.out.println("Constructor of B class");
	}
}
class C extends B
{
	C()
	{
		super();
		System.out.println("Constructor of C class");
	}
}
public class SuperMain
{
	public static void main(String[] args)
	{
		System.out.println("Main Starts");
		C rv=new C();
		System.out.println("Main Ends");
	}
}

//Main Starts
//Constructor of C class
//Main Ends



/*
Output:
Main Starts
Constructor of A class
Constructor of B class
Constructor of C class
Main Ends
*/