package design.pattern.behavioural.strategy.duck.impl.right.interfaces;

public class SwimIsNotPossible implements Swimable{

	@Override
	public void swim() {
		System.out.println("Swim is not possible");
		
	}

}
