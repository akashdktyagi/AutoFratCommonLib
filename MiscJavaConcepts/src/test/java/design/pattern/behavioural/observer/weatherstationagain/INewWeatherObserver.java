package design.pattern.behavioural.observer.weatherstationagain;

interface INewWeatherObserver {
    public void updateState(String temp, String press, String humid);
}
