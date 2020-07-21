package basics.arrays.derivedarray;
public class Test8
{
	public static void main(String[] args)
	{
		String rv="Customer Relationship Management";
		String[] ref=rv.split(" ");
		String a = " ";
		a = a+ref[0].charAt(0)+ref[1].charAt(0)+ref[2].charAt(0);
		System.out.println(a);
	}
}
/*
Output:
CRM
 */