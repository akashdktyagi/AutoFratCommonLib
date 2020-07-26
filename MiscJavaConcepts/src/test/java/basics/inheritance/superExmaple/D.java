package basics.inheritance.superExmaple;
class D
{
	D()
	{
		System.out.println("From D Cosntructor");
	}
}
class E extends D
{
	E()
	{
		//super(); //->Deafult Super calling(Commented Delibrately)
		System.out.println("From E constructor");
	}
}
class SuperMain1
{
	public static void main(String[] args)
	{
		System.out.println("Main starts");
		E rv=new E();
		System.out.println("Main Ends");
	}
}

/*
Output:
Main starts
From D Cosntructor
From E constructor
Main Ends
 */