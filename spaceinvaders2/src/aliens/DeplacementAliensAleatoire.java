package aliens;

import java.util.Random;

public class DeplacementAliensAleatoire extends DeplacementAliensDefault {

	private final int timeChange = 1000;
	private final int timeChangeRange = 500;
	private long nextTimeChange=0;
	private Random rd = new Random();
	
	private int speed = 125;
	private final int speedRange = 50;
	
	
	public DeplacementAliensAleatoire(UsineAlien ua) {
		super(ua);
		vy = 10;
	}

	@Override
	public void updateMoveDirection() {
		super.updateMoveDirection();
		if(System.currentTimeMillis()>nextTimeChange){
			this.nextTimeChange = System.currentTimeMillis() 
								+ rd.nextInt(timeChangeRange)-timeChangeRange/2 
								+ timeChange;
			
			vx = (rd.nextBoolean()?1:-1)*((rd.nextInt(speedRange)-speedRange/2)+speed);
		}
	}
	
	public void increaseSpeed() {
		speed *= 1.05;
	}

}
