package overriding.canweoverridestaticmethod;

public class Runner {

	public static void main(String[] args) {

		ParentClass obj = new ParentClass();
		obj.method1(); // this will invoke parent method
		
		ParentClass obj1 = new ChildClass();
		obj1.method1(); // this will also invoke parent 'class method'
						// because it is invoked on the parent instance
		
		ChildClass obj3 = new ChildClass();
		obj3.method1();// this will invoke child 'class method'
		
		/*
		 * Static methods are class methods, and they will always be
		 * invoked if called on class objects
		 * 
		 * If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass hides the one in the superclass.

		The distinction between hiding a static method and overriding an instance method has important implications:
	
		The version of the overridden instance method that gets invoked is the one in the subclass.
		The version of the hidden static method that gets invoked depends on whether it is invoked from the superclass or the subclass.
		 */
		

	}

}
