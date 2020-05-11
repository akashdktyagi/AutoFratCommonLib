package design.pattern.behavioural.strategy.duck.impl.right;

public class DuckRunProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Duck duck_id = new IndianDuck();
		Duck duck_rd = new RubberDuck();
		Duck duck_jd = new JellyDuck();
		
		duck_id.appearance();
		duck_id.performFly();
		duck_id.performSpeak();
		duck_id.performSwim();
		
		duck_rd.appearance();
		duck_rd.performFly();
		duck_rd.performSpeak();
		duck_rd.performSwim();
		
		duck_jd.appearance();
		duck_jd.performFly();
		duck_jd.performSpeak();
		duck_jd.performSwim();
	
	}

}
