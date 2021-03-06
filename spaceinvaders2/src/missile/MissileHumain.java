package missile;

import base.Game;
import entities.AlienEntity;
import entities.Entity;
import entities.ShipEntity;
import entities.ShotEntity;

public class MissileHumain extends ShotEntity {

	
	
	public MissileHumain(MissileManager manager, int x, int y) {
		super(manager, "sprites/shot.gif", x, y);
		 moveSpeed = -300;
		 degats = 10;
		 dy=moveSpeed;
	}



	public void collidedWith(Entity other) {
	}





	public void collidWithAlien(AlienEntity ae) {
		if (used) 
			return;
		
		
			ae.takeDamage(degats);
			manager.destroyMissile(this);
			
			used = true;
	}





	@Override
	public void collidWithShip(ShipEntity ship) {
		return;
	}

}
