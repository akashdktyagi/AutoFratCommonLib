package design.pattern.behavioural.observer.weather;

public class AlertObserver implements IWeatherObserver {
	private int temperature;
	private int windSpeed;
	private int pressure;
	
	@Override
	public void update(int i,int j, int k) {
		temperature=i;
		windSpeed=j;
		pressure=k;
		alert();
	}
	
	public void alert() {
		System.out.println("Alert: Temp: " + temperature + ", windSpeed: " + windSpeed + ", " + ", Pressure: " + pressure);
	}

}
