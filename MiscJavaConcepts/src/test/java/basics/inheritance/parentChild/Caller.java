package basics.inheritance.parentChild;

public class Caller {

	public static void main(String[] args) {

		ParentClass obj  = new ChildClass();
		
		((ParentClass) obj).methodParent();
		
	}

}
