package AlienManager;

import entities.AlienEntity;

public class DeplacementAlienDefault implements DeplacementAlien {
	
	protected double moveSpeed = 75;
	@Override
	public void move(AlienEntity e, long delta) {
		e.moveFixe((delta*moveSpeed)/1000,0);
	}

	@Override
	public void change() {
		
		moveSpeed = -moveSpeed;	
	}

	@Override
	public void beforeNextUpdate() {
		
	}

}
