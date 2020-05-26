package design.pattern.behavioural.observer.weatherusingObserableJavaClass;

import java.util.Observable;
import java.util.Observer;

class Observer1 implements Observer, IDisplay {

    private String temp;
    private String press;
    private String humid;
    private Observable subject;

    public Observer1(Observable subject){
       this.subject=subject;
       subject.addObserver(this);
    }
    @Override
    public void display() {
        System.out.println("Observer 1 display method implemented here: " + temp + "," + press + ","+ humid );
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof NewWeatherStation){
            temp = ((NewWeatherStation) o).getTemperature();
            press = ((NewWeatherStation) o).getPressure();
            humid = ((NewWeatherStation) o).getHumidity();
        }
        display();
    }
}
