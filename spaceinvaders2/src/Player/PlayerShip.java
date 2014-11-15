package Player;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import base.Game;
import base.InputMonitor;
import entities.Entity;
import entities.ShipEntity;
import entities.ShotEntity;

public class PlayerShip {

	private ShipEntity ship;
	private long vitesse = 300;
	private Game game;
	
	private long lastFire = 0;
	private long firingInterval = 500;
	
	public PlayerShip(Game game) {
		
		ship = new ShipEntity(game,"sprites/ship.gif",370,550);
		this.game = game;
	}

	public void update(long delta){
		
		ship.move(delta);
		ship.setHorizontalMovement(0);
		
		if (!InputMonitor.isPressed(KeyEvent.VK_RIGHT) && 
			InputMonitor.isPressed(KeyEvent.VK_LEFT)) {
			ship.setHorizontalMovement(-vitesse);
		} else if ( InputMonitor.isPressed(KeyEvent.VK_RIGHT) && 
				   !InputMonitor.isPressed(KeyEvent.VK_LEFT)) {
			ship.setHorizontalMovement(vitesse);
		}
		
		// if we're pressing fire, attempt to fire
		if (InputMonitor.isPressed(KeyEvent.VK_SPACE)) {
			tryToFire();
		}
	}
	
	public void draw(Graphics g){
		ship.draw(g);
	}
	
	public void tryToFire() {
		// check that we have waiting long enough to fire
		if (System.currentTimeMillis() - lastFire < firingInterval) {
			return;
		}
		
		// if we waited long enough, create the shot entity, and record the time.
		lastFire = System.currentTimeMillis();
		ShotEntity shot = new ShotEntity(game,"sprites/shot.gif",ship.getX()+10,ship.getY()-30);
		game.addEntity(shot);
	}

}
