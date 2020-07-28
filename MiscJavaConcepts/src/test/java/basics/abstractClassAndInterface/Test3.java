package basics.abstractClassAndInterface;

abstract class college
{
	abstract void gridview();
}


class faculty extends college
{
	String name;
	int yoe;
	faculty(String name, int yoe)// abstract class can have a constructor
	{
		this.name = name;
		this.yoe = yoe;
	}
	@Override
	void gridview()
	{
		System.out.println("the name is " +name);
		System.out.println("the total exp is " +yoe);
	}
	
	
}

public class Test3
{
	public static void main(String[] args)
	{
		faculty f=new faculty("JSM", 2);
		f.gridview();
	}

}

/*
Output:
the name is JSM
the total exp is 2
 */