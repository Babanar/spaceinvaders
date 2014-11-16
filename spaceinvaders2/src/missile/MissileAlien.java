package missile;

import base.Game;
import entities.AlienEntity;
import entities.Entity;
import entities.ShipEntity;
import entities.ShotEntity;

public class MissileAlien extends ShotEntity {

	
	
	public MissileAlien(MissileManager manager, int x, int y) {
		super(manager, "sprites/shot.gif", x, y);
		 moveSpeed = 300;
		 degats = 10;
		 dy=moveSpeed;
	}



	public void collidedWith(Entity other) {
	}





	public void collidWithAlien(AlienEntity ae) {

	}





	@Override
	public void collidWithShip(ShipEntity ship) {
		if (used) 
			return;
		
		ship.takeDamage(degats);
		manager.destroyMissile(this);	
		used = true;
	}

}
