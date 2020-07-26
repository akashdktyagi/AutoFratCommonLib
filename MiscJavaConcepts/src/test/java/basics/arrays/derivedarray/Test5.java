package basics.arrays.derivedarray;

import java.util.Arrays;

public class Test5
{
	public static void main(String[] args)
	{
		String[] ref = new String[5];
		ref[0] = "AB";
		ref[1] = "Cd";
		ref[2] = "EF";
		ref[3] = "GH";
		ref[4] = "IJ";
		
		for(int i=0;i<ref.length;i++)
		{
			ref[i]=ref[i].toUpperCase();
		}
		
		Arrays.sort(ref);
		
		for(String s:ref)
		{
			System.out.println(s);
		}
		System.out.println(Arrays.binarySearch(ref, "AB"));
		System.out.println(Arrays.binarySearch(ref, "AB"));
		System.out.println(Arrays.binarySearch(ref, "ABCD"));
	}
}

/*
AB
CD
EF
GH
IJ
0
0
-2
 */