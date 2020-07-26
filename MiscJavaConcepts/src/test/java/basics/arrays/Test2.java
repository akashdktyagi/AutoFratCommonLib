package basics.arrays;

//data in array, iterting ==> Give us a Sum and average
public class Test2
{
	public static void main(String[] args)
	{
		int[] arr = new int[6];
		arr[0]=99;
		arr[1]=99;
		arr[2]=99;
		arr[3]=99;
		arr[4]=99;
		arr[5]=99;
		int total = 0;
		
		//total = arr[0] + arr[1] +arr[2] + arr[3] + arr[4] +arr[5];
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println("marks in subject number " +(i+1)+ "::" +arr[i]);
			
			total = total + arr[i];
		}
		System.out.println("----------------");
		System.out.println("total marks secured ::" +total);
		int avg = total/arr.length;
		System.out.println("------------------");
		System.out.println("Average marks is ::" +avg);
	}
}
/*

Output:
marks in subject number 1::99
marks in subject number 2::99
marks in subject number 3::99
marks in subject number 4::99
marks in subject number 5::99
marks in subject number 6::99
---------------- total marks secured ::594
------------------ Average marks is ::99

 */