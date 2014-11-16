package aliens;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import missile.MissileManager;

import entities.AlienEntity;
import entities.ShotEntity;


import base.Game;

public class UsineAlien {
	protected Game game;
	protected ArrayList<AlienEntity> aliens;
	protected ArrayList<AlienEntity> aliensToRemove;
	protected DeplacementAliensContainer deplacement;
	protected MissileManager missiles;
	protected int etape=0;
	public UsineAlien(Game game,MissileManager missiles) {
		this.game = game;
		this.missiles = missiles;
		aliens=new ArrayList<>();
		aliensToRemove=new ArrayList<>();
		deplacement = new DeplacementAliensContainer();
	}

	public void init(){
		aliens.clear();
		aliensToRemove.clear();
		deplacement.setInstance(new DeplacementAliensDefault(this));
	}
	
	public void update(long delta){
		
		aliens.removeAll(aliensToRemove);
		aliensToRemove.clear();
		deplacement.updateMoveDirection();
		for(AlienEntity alien : aliens)
			alien.update(delta);
		
		if(count()==0)
			game.notifyWin();
		

		
	}
	
	public void draw(Graphics g){
		
		
		
		for(AlienEntity alien : aliens)
			alien.draw(g);
	}
	
	public int count(){
		return aliens.size();
	}
	
	public void destroyAlien(AlienEntity ae){
		aliensToRemove.add(ae);
		deplacement.increaseSpeed();
	}
	
	public void notifyWin(){
		game.notifyDeath();
	}
	
	public void collidsTest(ShotEntity shot){
		
		for(AlienEntity alien : aliens)
			if(alien.collidesWith(shot)){
				shot.collidWithAlien(alien);
				alien.collidedWith(shot);
			}
	}
	
	public void goBack(){
		for(AlienEntity alien : aliens)
			alien.moveFixe(0,40);
	}
	
}
