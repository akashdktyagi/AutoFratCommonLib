package basics.exceptionHandling;
public class A
{
	
	public static void main(String[] args)
	{
		/*
		String str = "akash";
		int parseInt = Integer.parseInt(str);
		int b = 4;
		int c = parseInt + 4;
		*/
		
		//Abruptly
		//int a1 = Integer.parseInt("wow"); // dishani- program
		
		try
		{
			
			int a1 = Integer.parseInt("wow");
			int a=Integer.parseInt("hey");//program stop here-approva
			System.out.println("1");
		}
		catch (NumberFormatException e)//NumberFormatException
		{
			System.out.println("2");
			
		}catch(NullPointerException npe) {
			
			System.out.println("3");
		}catch (Exception e) {
			
		}
		
		System.out.println("4");
	}
}
//Arpit: nothing will be printed, exception
//Apporva/Sujit/Yadensh/Preeti: last line 

//
/*
Output:
caught
 */