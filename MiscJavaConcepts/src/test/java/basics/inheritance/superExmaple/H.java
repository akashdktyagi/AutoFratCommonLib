package basics.inheritance.superExmaple;
//Super(parameter): This will call the immediate super class constructor with the matching arguments. Example:
class H
{
	H(int a)
	{
		System.out.println(" from H(int a) constructor");
	}
}
class I extends H
{
	I()
	{
		super(90);// will not work when double/flaot vlue is used
		System.out.println(" from I(int a) constructor");
	}
}
class Supermain2
{
	public static void main(String[] args)
	{
		I rv=new I();
	}
}

/*
 * Output:
from H(int a) constructor
from I(int 
*/
