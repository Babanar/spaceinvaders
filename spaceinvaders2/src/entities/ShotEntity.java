package entities;

import missile.MissileManager;
import base.Game;

/**
 * An entity representing a shot fired by the player's ship
 * 
 * @author Kevin Glass
 */
public abstract class ShotEntity extends Entity {
	/** The vertical speed at which the players shot moves */
	protected double moveSpeed;
	/** True if this shot has been "used", i.e. its hit something */
	protected boolean used = false;
	
	protected int degats=0;
	
	protected MissileManager manager;
	
	/**
	 * Create a new shot from the player
	 * 
	 * @param game The game in which the shot has been created
	 * @param sprite The sprite representing this shot
	 * @param x The initial x location of the shot
	 * @param y The initial y location of the shot
	 */
	public ShotEntity(MissileManager manager,String sprite,int x,int y) {
		super(sprite,x,y);
		this.manager = manager;
		dy = moveSpeed;
	}

	/**
	 * Request that this shot moved based on time elapsed
	 * 
	 * @param delta The time that has elapsed since last move
	 */
	public void move(long delta) {
		// proceed with normal move
		super.move(delta);
		
		// if we shot off the screen, remove ourselfs
		if (y+getHeight() < 0 
			|| y > 600 
			|| x+getWidth() < 0 
			|| x > 800) 
		manager.destroyMissile(this);
		
	}
	
	/**
	 * Notification that this shot has collided with another
	 * entity
	 * 
	 * @parma other The other entity with which we've collided
	 */

	public abstract void collidWithAlien(AlienEntity ae);
	public abstract void collidWithShip(ShipEntity ship);
	
    @Override
    public void doLogic() {
        // FIXME Auto-generated method stub
        
    }
}