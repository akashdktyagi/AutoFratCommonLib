package design.pattern.behavioural.observer.weather;

public class LogObserver implements IWeatherObserver {
	private int temperature;
	private int windSpeed;
	private int pressure;
	
	@Override
	public void update(int i,int j, int k) {
		temperature=i;
		windSpeed=j;
		pressure=k;
		log();
	}
	
	public void log() {
		System.out.println("Log Info: Temp: " + temperature + ", windSpeed: " + windSpeed + ", " + ", Pressure: " + pressure);
	}

}
