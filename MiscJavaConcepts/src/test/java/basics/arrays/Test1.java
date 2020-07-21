package basics.arrays;
public class Test1
{
	public static void main(String[] args)
	{
		int[] rv = new int[5]; //Creating an integer array with 5 slots
		rv[0] = 10;
		rv[1] = 20;
		rv[2] = 30;
		rv[3] = 40;
		rv[4] = 50;
		System.out.println("length is:: " +rv.length);
		for(int i=0;i<rv.length;i++)
		{
			System.out.println(i);
		}
	}
}
/*
Output:
length is:: 5
0
1
2
3
4
 */