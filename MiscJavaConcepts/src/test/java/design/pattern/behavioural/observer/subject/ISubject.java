package design.pattern.behavioural.observer.subject;

public interface ISubject {
	public void registerObeserver(IObserver o);
	public void removeObserver(IObserver o);
	public void notifyObservers();
}
