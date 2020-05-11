package design.pattern.behavioural.strategy.duck.impl.wrong;

public class RubberDuck extends Duck{

	public void appearance() {
		System.out.println("I am a Rubber Duck.");
	}
	
	@Override
	public void fly() {
		System.out.println("But I can't fly because I am Rubber Duck.");
	}

	@Override
	public void speak() {
		System.out.println("But I can't speak because I am Rubber Duck.");
	}
	

	
}
