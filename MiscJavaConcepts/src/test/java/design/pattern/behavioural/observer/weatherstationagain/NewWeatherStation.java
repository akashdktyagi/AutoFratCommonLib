package design.pattern.behavioural.observer.weatherstationagain;

import java.util.ArrayList;
import java.util.Observer;

class NewWeatherStation implements ISubject{
    private String temp;
    private String press;
    private String humid;
    private ArrayList<INewWeatherObserver> listObserver = new ArrayList<>();

    public void getState(){
        System.out.println("Current State is: " + "Temp: " + temp + ", Pressure: " + press +  ", Humidity:" + humid);
    }

    public void setState(String temp, String press, String humid){
        this.temp=temp;
        this.press=press;
        this.humid=humid;
        notifyAllObserver();
    }

    @Override
    public void registerObserver(INewWeatherObserver observer) {
        if (!(listObserver.contains(observer))){
            listObserver.add(observer);
            System.out.println("Observer added: " + observer.toString());
        }
    }

    @Override
    public void removeObserver(INewWeatherObserver observer) {
        if (listObserver.contains(observer)){
            listObserver.remove(observer);
            System.out.println("Observer removed: " + observer.toString());
        }
    }

    @Override
    public void notifyAllObserver() {
        for(INewWeatherObserver o: listObserver){
            o.updateState(temp,press,humid);
        }
    }
}
