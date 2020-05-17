package design.pattern.behavioural.observer.subject;

public class Observer2 implements IObserver {
	private int i;
	private ISubject subject;
	
	public Observer2(ISubject subject) {
		this.subject=subject;
		subject.registerObeserver(this);
	}
	
	@Override
	public void update(int i) {
		this.i = i;
		getI();
	}
	
	public void getI() {
		System.out.println("Value in Observer 2 is: " + i);
	}

}
