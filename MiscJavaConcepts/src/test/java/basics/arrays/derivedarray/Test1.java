package basics.arrays.derivedarray;
class A
{
}
public class Test1
{
	public static void main(String[] args)
	{
		
		A[] ref = new A[5];
		ref[0] = new A();
		ref[1] = new A();
		ref[2] = new A();
		ref[3] = new A();
		ref[4] = new A();
		
		System.out.println("length is " +ref.length);
		for(int i=0;i<ref.length;i++)
		{
			System.out.println(ref[i]);
		}
	}
}
/*
Output:
length is 5
derivedarray.A@15db9742
derivedarray.A@6d06d69c
derivedarray.A@7852e922
derivedarray.A@4e25154f
derivedarray.A@70dea4e
 */