package entities;

import missile.MissileAlien;
import missile.MissileManager;
import aliens.DeplacementAliens;
import aliens.UsineAlien;
import base.Game;

/**
 * An entity which represents one of our space invader aliens.
 * 
 * @author Kevin Glass
 */
public class AlienEntity extends Entity {
	/** The speed at which the alient moves horizontally */
	private double moveSpeed = 75;
	
	private DeplacementAliens deplacement;
	private UsineAlien commandant;

	
	/**
	 * Create a new alien entity
	 * 
	 * @param game The game in which this entity is being created
	 * @param ref The sprite which should be displayed for this alien
	 * @param x The intial x location of this alien
	 * @param y The intial y location of this alient
	 */
	public AlienEntity(UsineAlien ua,String ref,int x,int y,DeplacementAliens da) {
		super(ref,x,y);

		this.commandant = ua;
		dx = -moveSpeed;
		this.deplacement = da;
	}

	/**
	 * Request that this alien moved based on time elapsed
	 * 
	 * @param delta The time that has elapsed since last move
	 */
	public void move(long delta) {
		deplacement.setDirection(this);
		super.move(delta);
		if (y > 570) {
			commandant.notifyWin();
		}
	}
	
	public void update(long delta){
		move(delta);
	}
	
	
	
	/**
	 * Notification that this alien has collided with another entity
	 * 
	 * @param other The other entity
	 */
	public void collidedWith(Entity other) {
		// collisions with aliens are handled elsewhere
	}
	
	public void takeDamage(int degats){
		commandant.destroyAlien(this);
	}

	@Override
	public void doLogic() {
		// TODO Stub de la méthode généré automatiquement
		
	}
}