package missile;

import java.awt.Graphics;
import java.util.ArrayList;

import aliens.UsineAlien;

import Player.PlayerShip;

import entities.AlienEntity;
import entities.ShipEntity;
import entities.ShotEntity;

public class MissileManager {

	ArrayList<ShotEntity> missiles;
	ArrayList<ShotEntity> missilesToRemove;
	
	public MissileManager() {
		missiles = new ArrayList<>();
		missilesToRemove = new ArrayList<>();
	}
	
	public void update(long delta){
		missiles.removeAll(missilesToRemove);
		missilesToRemove.clear();
		for(ShotEntity s : missiles)
			s.move(delta);
	}
	
	public void destroyMissile(ShotEntity se){
		missilesToRemove.add(se);
	}
	
	public void draw(Graphics g){
		for(ShotEntity s : missiles)
			s.draw(g);
	}
	
	public void addShot(ShotEntity se){
		missiles.add(se);
	}
	
	public void collidsTest(PlayerShip player){
		ShipEntity ship = player.getEntity();
		for(ShotEntity s : missiles)
			if(s.collidesWith(ship)){
				s.collidedWith(ship);
				ship.collidedWith(s);
			}
	}
	
	public void collidsTest(UsineAlien aliens){
		for(ShotEntity s : missiles){
			aliens.collidsTest(s);
		}
	}


}
