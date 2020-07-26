package basics.inheritance.superExmaple;
class M
{
	M()
	{
		System.out.println("From M()");
	}
}
class N extends M
{
	N(int a)
	{
		System.out.println("From N()" +a);
	}
	N()
	{
		this(10); // call the same class object
		System.out.println("From N()");
	}
}
class O extends N
{
	O()
	{
		System.out.println("From O()");
	}
}

public class SuperMain3
{
	public static void main(String[] args)
	{
		O rv=new O();
	}
}

/*
 Output:
From M()
From N()10
From N()
From O()

 */
