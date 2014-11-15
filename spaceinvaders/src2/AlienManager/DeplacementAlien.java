package AlienManager;

import entities.AlienEntity;

public interface DeplacementAlien {
	public void move(AlienEntity e,long delta);
	public void change();
	public void beforeNextUpdate();
}
