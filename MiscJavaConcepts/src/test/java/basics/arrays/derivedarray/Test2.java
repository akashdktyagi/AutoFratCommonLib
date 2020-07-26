package basics.arrays.derivedarray;

class B
{
	public String toString()
	{
		return super.toString() + ": B class Object";
	}
}

public class Test2
{
	public static void main(String[] args)
	{
	
		
		B[] ref = new B[5];
		for(int i=0;i<ref.length;i++)
		{
			ref[i]=new B();
		}
		
		for(int i=0;i<ref.length;i++)
		{
			System.out.println(ref[i]);
		}
	}
}
/*
Output:
B class Object
B class Object
B class Object
B class Object
B class Object
 */