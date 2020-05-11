package design.pattern.behavioural.strategy.duck.impl.right;

import design.pattern.behavioural.strategy.duck.impl.right.interfaces.*;

public abstract class Duck {

	protected Flyable flyable;
	protected Speakable speakable;
	protected Swimable swimable;

	protected abstract void appearance();
	
	public void setFlyBehaviour(Flyable flyable) {
		this.flyable = flyable;
	}
	
	public void setSpeakBehaviour(Speakable speakable) {
		this.speakable = speakable;
	}
	
	public void setSwimBehaviour(Swimable swimable) {
		this.swimable = swimable;
	}
	
	public void performFly() {
		flyable.fly();
	}
	
	public void performSpeak() {
		speakable.speak();
	}
	
	public void performSwim() {
		swimable.swim();
	}
}
