package design.pattern.behavioural.observer.weatherstationagain;

class Observer1 implements INewWeatherObserver,IDisplay {

    private String temp;
    private String press;
    private String humid;
    private ISubject subject;

    public Observer1(ISubject subject){
       this.subject=subject;
       subject.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("Observer 1 display method implemented here: " + temp + "," + press + ","+ humid );
    }

    @Override
    public void updateState(String t, String p,String h) {
        this.humid=h;
        this.temp=t;
        this.press=p;
    }
}
