package basics.constructorOverloading;

public class Caller {

	public static void main(String[] args) {
		ClassA obj = new ClassA();
		
		ClassA obj1 = new ClassA("akash");
		
		ClassA obj2 = new ClassA(7);
		
	}
}
