package design.pattern.behavioural.observer.subject;

import java.util.ArrayList;

public class SimpleSubject implements ISubject {

	private int i;
	private ArrayList<IObserver> observers = new ArrayList<>();
	
	@Override
	public void registerObeserver(IObserver o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {
		observers.add(o);
	}

	@Override
	public void notifyObservers() {
		for(IObserver o:observers) {
			o.update(i);
		}
	}
	
	public void changeValueOfI(int i) {
		this.i=i;
		notifyObservers();
	}

}
