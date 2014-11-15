package entities;

import AlienManager.AlienManager;
import AlienManager.DeplacementAlien;

/**
 * An entity which represents one of our space invader aliens.
 * 
 * @author Kevin Glass
 */
public class AlienEntity extends Entity {
	/** The speed at which the alient moves horizontally */
	
	/** The game in which the entity exists */
	private DeplacementAlien deplacement;
	private AlienManager commandant;
	/**
	 * Create a new alien entity
	 * 
	 * @param game The game in which this entity is being created
	 * @param ref The sprite which should be displayed for this alien
	 * @param x The intial x location of this alien
	 * @param y The intial y location of this alient
	 */
	public AlienEntity(AlienManager am, String ref,int x,int y,DeplacementAlien d) {
		super(ref,x,y);
		this.commandant = am;
		this.deplacement = d;
	}

	/**
	 * Request that this alien moved based on time elapsed
	 * 
	 * @param delta The time that has elapsed since last move
	 */
	public void move(long delta) {
		// if we have reached the left hand side of the screen and
		// are moving left then request a logic update 
		if (x < 10) {
			commandant.collidEdge();
		}
		// and vice versa, if we have reached the right hand side of 
		// the screen and are moving right, request a logic update
		if (x > 750) {
			commandant.collidEdge();
		}
		
		if(y>540)
			commandant.invadesWeWin();
		
		// proceed with normal move
		deplacement.move(this, delta);
	}
	
	/**
	 * Update the game logic related to aliens
	 */

	public void doLogic() {

	}
	
	/**
	 * Notification that this alien has collided with another entity
	 * 
	 * @param other The other entity
	 */
	public void collidedWith(Entity other) {
		// collisions with aliens are handled elsewhere
	}
}