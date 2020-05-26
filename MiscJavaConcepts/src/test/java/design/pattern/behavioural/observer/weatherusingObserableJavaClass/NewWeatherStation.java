package design.pattern.behavioural.observer.weatherusingObserableJavaClass;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

class NewWeatherStation extends Observable {
    private String temp;
    private String press;
    private String humid;

    public String getTemperature(){
        return temp;
    }

    public String getPressure(){
        return press;
    }

    public String getHumidity(){
        return humid;
    }
    public void setState(String temp, String press, String humid){
        this.temp=temp;
        this.press=press;
        this.humid=humid;
        setChanged(); // This has to be called only then data will be passed on
        notifyObservers();
    }
}
