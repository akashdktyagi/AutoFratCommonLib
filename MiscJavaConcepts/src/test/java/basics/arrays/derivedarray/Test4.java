package basics.arrays.derivedarray;
public class Test4
{
	public static void main(String[] args)
	{
		String[] ref = new String[5];
		ref[0] = new String("Akash");
		ref[1] = new String("Sarang");
		ref[2] = new String("Sachin");
		ref[3] = new String("Bhushan");
		ref[4] = new String("Iqbal");
		for(int i=0;i<ref.length;i++)
		{
			System.out.println(ref[i].toUpperCase());
		}
	}
}
/*
Output:
Akash
Sarang
Sachin
Bhushan
Iqbal
 */