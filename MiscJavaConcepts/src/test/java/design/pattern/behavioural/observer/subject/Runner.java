package design.pattern.behavioural.observer.subject;

public class Runner {

	public static void main(String[] args) {

		SimpleSubject subject = new SimpleSubject();
		IObserver obs1 = new Observer1(subject);
		IObserver obs2 = new Observer2(subject);
		
		subject.changeValueOfI(9);
	}

}

/*
 * OUTPUT
 * Value in Observer 1 is: 9
 * Value in Observer 2 is: 9
 */
