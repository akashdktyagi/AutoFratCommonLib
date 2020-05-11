package design.pattern.behavioural.strategy.duck.impl.right;

import design.pattern.behavioural.strategy.duck.impl.right.interfaces.*;

public class IndianDuck extends Duck {

	public IndianDuck() {
		setFlyBehaviour(new FlyingIsPossible());
		setSwimBehaviour(new SwimIsPossible());
		setSpeakBehaviour(new SpeakQuack());
	}
	
	public void appearance() {
		// TODO Auto-generated method stub
		System.out.println("I am an Indian Duck");
	}

}
