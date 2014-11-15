package AlienManager;

import entities.AlienEntity;

public class DeplacementAlienContainer implements DeplacementAlien {
	
	DeplacementAlien deplacement;
	
	@Override
	public void move(AlienEntity e, long delta) {
		if(deplacement!=null)
		deplacement.move(e, delta);
	}

	@Override
	public void change() {
		if(deplacement!=null)
		deplacement.change();
	}
	
	public void setInstance(DeplacementAlien da){
		deplacement = da;
	}

	public DeplacementAlien getInstance(){
		return deplacement;
	}

	@Override
	public void beforeNextUpdate() {
		if(deplacement!=null)
		deplacement.beforeNextUpdate();
	}
}
