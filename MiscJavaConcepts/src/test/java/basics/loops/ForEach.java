package basics.loops;
class ForEach
{
	public static void main(String args[])
	{		
		/*
		//Simple for loop to iterate an array
		for(int i=0;i<nums.length;i++) {
			System.out.println("array value: " + nums[i]);
		}
		*/
		
		int nums[] = { 1, 2, 3, 4, 5, 6, 7};
		
		int sum = 0;
		// use for-each style for to display and sum the values
		for(int x : nums)  // enhanced for
		{
			System.out.println("Value is: " + x);
			sum += x; // sum = sum + x;
		}
		System.out.println("Summation: " + sum);
	}
}