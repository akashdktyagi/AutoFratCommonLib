package design.pattern.behavioural.observer.weatherstationagain;

class TestHarness {

    public static void main(String[] args){
        NewWeatherStation subject = new NewWeatherStation();
        Observer1 observer1 = new Observer1(subject);
        Observer2 observer2 = new Observer2(subject);

        subject.setState("1","2","3");
        observer1.display();
        observer2.display();
    }
}
