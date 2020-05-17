package design.pattern.behavioural.observer.weather;

public class Runner {

	public static void main(String[] args) {

		WeatherStation ws = new WeatherStation();
		
		LogObserver lo = new LogObserver();
		AlertObserver ao = new AlertObserver();
		UserInterfaceObserver uo = new UserInterfaceObserver();
		
		ws.register(lo);
		ws.register(ao);
		ws.register(uo);
		
		//Change the value in Weather Station object ws
		ws.changeInState(4, 5, 6);
		
		//Change the value in Weather Station object ws
		ws.changeInState(6, 7, 8);
		
		//Change the value in Weather Station object ws
		ws.changeInState(1, 2, 3);
		
		//With Every change above Observer objects values are automatically Updated
		//Output as below:
		/*
		 *  Log Info: Temp: 4, windSpeed: 5, , Pressure: 6
			Alert: Temp: 4, windSpeed: 5, , Pressure: 6
			UI : Temp: 4, windSpeed: 5, , Pressure: 6
			
			Log Info: Temp: 6, windSpeed: 7, , Pressure: 8
			Alert: Temp: 6, windSpeed: 7, , Pressure: 8
			UI : Temp: 6, windSpeed: 7, , Pressure: 8
			
			Log Info: Temp: 1, windSpeed: 2, , Pressure: 3
			Alert: Temp: 1, windSpeed: 2, , Pressure: 3
			UI : Temp: 1, windSpeed: 2, , Pressure: 3

		 * 
		 * 
		 */

	}

}
