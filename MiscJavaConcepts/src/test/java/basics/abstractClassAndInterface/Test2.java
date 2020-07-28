package basics.abstractClassAndInterface;

//Step 1- What (Templateing- Abstract Class and Interface)

//Step 2: How

//God created Class- Template-Blue Print-Basic strucute
abstract class Animal
{
	abstract void move();
	abstract void sound();
}

//Concrete class 1
class dog extends Animal
{
	
	@Override
	void move()
	{
		System.out.println("dog moves");
	}
	@Override
	void sound()
	{
		System.out.println("bow bow");
	}
}

//Concreate Class 2
class cat extends Animal
{

	void move()
	{
		System.out.println("cat moves");
	}

	@Override
	void sound() {
		System.out.println("mow mow");
		
	}

}
public class Test2
{
	public static void main(String[] args)
	{
		//Animal a=new Animal();//Animal class is abtract and cannot be instantiated
		dog d1=new dog();
		d1.move();
		d1.sound();
		cat c1=new cat();
		c1.move();
		c1.sound();
	}
}

/*
Output:
dog moves
bow bow
cat moves
meow meow
*/