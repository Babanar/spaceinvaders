package aliens;

import java.util.Random;

public class DeplacementAliensAleatoire extends DeplacementAliensDefault {

	private long lastChangeDirectionTime=0;
	private final int timeChange = 1000;
	private final int timeChangeRange = 500;
	private long nextTimeChange =0;
	private Random rd = new Random();
	
	private final int speed = 125;
	private final int speedRange = 50;
	
	
	public DeplacementAliensAleatoire(UsineAlien ua) {
		super(ua);
		
	}

	@Override
	public void updateMoveDirection() {
		super.updateMoveDirection();
		if(System.currentTimeMillis()-lastChangeDirectionTime>nextTimeChange){
			lastChangeDirectionTime = System.currentTimeMillis();
			nextTimeChange = rd.nextInt(timeChangeRange)-timeChangeRange/2 + timeChange;
			vx = (rd.nextBoolean()?1:-1)*((rd.nextInt(speedRange)-speedRange/2)+speed);
		}
	}

}
