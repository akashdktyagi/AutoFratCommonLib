package design.pattern.behavioural.strategy.duck.impl.right;

import design.pattern.behavioural.strategy.duck.impl.right.interfaces.*;

public class JellyDuck extends Duck{

	public JellyDuck() {
		setFlyBehaviour(new FlyingIsNotPossible());
		setSwimBehaviour(new SwimIsNotPossible());
		setSpeakBehaviour(new SpeakIsNotPossible());
	}
	public void appearance() {
		System.out.println("I am a Jelly Duck.");
	}


}
