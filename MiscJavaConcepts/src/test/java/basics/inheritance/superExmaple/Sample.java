package basics.inheritance.superExmaple;
class Sample//Sample is Super class
{
	int empid;
	Sample(int empid)//Constructor
	{
		this.empid=empid;
	}
}
class Demo extends Sample// Demo is Sub class
{
	Demo(int empid)//Constructor
	{
		super(empid);
	}
}
class SuperMain4
{
	public static void main(String[] args)
	{
		Demo rv1=new Demo(1);
		System.out.println("The value of Empid is: " +rv1.empid);
		Demo rv2=new Demo(2);
		System.out.println("The value of Empid is: " +rv2.empid);
	}
}

/*
Output:
The value of Empid is: 1
The value of Empid is: 2
*/