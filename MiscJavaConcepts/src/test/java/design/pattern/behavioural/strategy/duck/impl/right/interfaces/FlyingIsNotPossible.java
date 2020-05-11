package design.pattern.behavioural.strategy.duck.impl.right.interfaces;

public class FlyingIsNotPossible implements Flyable {

	@Override
	public void fly() {
		System.out.println("I can't Fly");
		
	}

}
