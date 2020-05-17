package design.pattern.behavioural.observer.subject;

public class Observer1 implements IObserver {
	private int i;
	private ISubject subject;
	
	public Observer1(ISubject subject) {
		this.subject=subject;
		subject.registerObeserver(this);
	}
	
	@Override
	public void update(int i) {
		this.i = i;
		getI();
	}
	
	public void getI() {
		System.out.println("Value in Observer 1 is: " + i);
	}

}
