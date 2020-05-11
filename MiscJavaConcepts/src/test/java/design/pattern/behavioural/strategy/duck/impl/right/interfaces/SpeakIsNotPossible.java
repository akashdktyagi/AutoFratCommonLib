package design.pattern.behavioural.strategy.duck.impl.right.interfaces;

public class SpeakIsNotPossible implements Speakable{

	@Override
	public void speak() {
		System.out.println("I speak nothing");
	}

}
