package basics.arrays.derivedarray;
public class Test3
{
	public static void main(String[] args)
	{
		Employee[] ref=new Employee[5];
		ref[0] = new Employee(10,100000);
		ref[1] = new Employee(20,200000);
		ref[2] = new Employee(30,300000);
		ref[3] = new Employee(40,400000);
		ref[4] = new Employee(50,500000);
		for(int i=0;i<ref.length;i++)
		{
			System.out.println(ref[i].empid + "::" + ref[i].salary);
		}
	}
}

/*
Output:
10::100000.0
20::200000.0
30::300000.0
40::400000.0
50::500000.0
 */