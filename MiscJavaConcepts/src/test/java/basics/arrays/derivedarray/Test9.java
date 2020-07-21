package basics.arrays.derivedarray;
public class Test9
{
	public static void main(String[] args)
	{
		String rv = "Customer Relationship Management, Enterprise Relationship Planning";
		String[] ref = rv.split(" ");
		String a = " ";
		for(int i=0;i<ref.length;i++)
		{
			a=a+ref[i].charAt(0);
		}
		System.out.println(a);
	}
}
/*
Output:
CRMERP
 */