package design.pattern.behavioural.observer.weatherusingObserableJavaClass;

class TestHarness {

    public static void main(String[] args){
        NewWeatherStation subject = new NewWeatherStation();
        Observer1 observer1 = new Observer1(subject);
        subject.setState("1","2","3");
    }
}
