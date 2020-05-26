package design.pattern.behavioural.observer.weatherstationagain;
interface ISubject {
    public void registerObserver(INewWeatherObserver observer);
    public void removeObserver(INewWeatherObserver observer);
    public void notifyAllObserver();
}
