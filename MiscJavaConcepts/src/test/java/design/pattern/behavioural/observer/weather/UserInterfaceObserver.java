package design.pattern.behavioural.observer.weather;

class UserInterfaceObserver implements IWeatherObserver {
	private int temperature;
	private int windSpeed;
	private int pressure;
	
	@Override
	public void update(int i,int j, int k) {
		temperature=i;
		windSpeed=j;
		pressure=k;
		displayUI();
	}
	
	public void displayUI() {
		System.out.println("UI : Temp: " + temperature + ", windSpeed: " + windSpeed + ", " + ", Pressure: "  + pressure);
	}

}
