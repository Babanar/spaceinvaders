package aliens;

import entities.AlienEntity;

public class DeplacementAliensContainer implements DeplacementAliens {
	
	private DeplacementAliens instance;
	
	public void setInstance(DeplacementAliens da){
		instance = da;
	}

	public void updateMoveDirection() {
		if(instance!=null)
			instance.updateMoveDirection();
	}

	public void setDirection(AlienEntity ae) {
		if(instance!=null)
			instance.setDirection(ae);
	}

}
