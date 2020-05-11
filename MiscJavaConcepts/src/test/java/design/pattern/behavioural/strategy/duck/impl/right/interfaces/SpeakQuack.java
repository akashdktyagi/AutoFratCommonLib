package design.pattern.behavioural.strategy.duck.impl.right.interfaces;

public class SpeakQuack implements Speakable{

	@Override
	public void speak() {
		System.out.println("I speak quack");
	}

}
