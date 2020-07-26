package basics.arrays;

//Iteration of array
public class Test1
{
	int a=7;
	String a1 = "sdfds";
	int b =9;
	int c = 10;
	
	//int[] singleVariable = new int[6];
	
	public static void main(String[] args)
	{
		int[] rv = new int[5];
		//int[][] rv = new int[5][4]; //Creating an integer array with 5 slots
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
		
		for(int c:rv)
		{
			System.out.println(c);
		}
	}
	
	//not yet full functional
	public static void twoDArray() {
		int[][] rv = new int[2][3];
		rv[0][0] = 10;
		rv[2][1] = 30;
		
		for(int i=0;i<rv.length;i++) {
			for(int j=0;i<rv.length;j++) {
				
			}
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