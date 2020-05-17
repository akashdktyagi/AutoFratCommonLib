package design.pattern.behavioural.observer.weather;

import java.util.ArrayList;

public class WeatherStation implements IWeatherStation{

	private int temperature;
	private int windSpeed;
	private int pressure;
	ArrayList<IWeatherObserver> list = new ArrayList<>();
	
	@Override
	public void register(IWeatherObserver o) {
		list.add(o);
	}

	@Override
	public void remove(IWeatherObserver o) {
		list.remove(o);
	}

	@Override
	public void notifyWeatherObservers() {
		for(IWeatherObserver o:list) {
			o.update(temperature,windSpeed,pressure);
		}
	}

	public void changeInState(int temp, int wind,int press) {
		this.temperature=temp;
		this.windSpeed=wind;
		this.pressure=press;
		notifyWeatherObservers();
	}
	
}
