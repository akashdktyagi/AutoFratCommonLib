package design.pattern.behavioural.strategy.duck.impl.wrong;

public abstract class Duck {

	public abstract void appearance();
	
	public void fly() {
		System.out.println("I am flying.");
	}
	public void swim() {
		System.out.println("I can swim.");
	}
	public void speak() {
		System.out.println("I can speak quack");
	}
	
}
