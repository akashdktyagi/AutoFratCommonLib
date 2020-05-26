package design.pattern.behavioural.observer.weather;

interface IWeatherStation {
	public void register(IWeatherObserver o);
	public void remove(IWeatherObserver o);
	public void notifyWeatherObservers();	
}
