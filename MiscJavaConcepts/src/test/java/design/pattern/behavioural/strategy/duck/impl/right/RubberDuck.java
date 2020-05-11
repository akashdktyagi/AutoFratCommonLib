package design.pattern.behavioural.strategy.duck.impl.right;

import design.pattern.behavioural.strategy.duck.impl.right.interfaces.*;

public class RubberDuck extends Duck{

	public RubberDuck() {
		setFlyBehaviour(new FlyingIsNotPossible());
		setSwimBehaviour(new SwimIsPossible());
		setSpeakBehaviour(new SpeakIsNotPossible());
	}
	
	public void appearance() {
		System.out.println("I am a Rubber Duck.");
	}

}
