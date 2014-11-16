package missile;

import base.Game;
import entities.AlienEntity;
import entities.Entity;
import entities.ShipEntity;
import entities.ShotEntity;

public class MissileHumain extends ShotEntity {

	
	
	public MissileHumain(MissileManager manager, String sprite, int x, int y) {
		super(manager, sprite, x, y);
	}



	public void collidedWith(Entity other) {
		System.out.println("HERE2");
		if(other instanceof AlienEntity)
			System.out.println("Pourtant..");
		//Sinon, rien à faire		
	}





	public void collidWithAlien(AlienEntity ae) {
		if (used) {
			return;
		}
		
			ae.takeDamage(degats);
			manager.destroyMissile(this);
			
			//NEED TO SAY WIN OR NOT
			used = true;
	}





	@Override
	public void collidWithShip(ShipEntity ship) {
		return;
	}

}
