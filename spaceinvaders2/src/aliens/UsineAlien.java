package aliens;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import entities.AlienEntity;
import entities.ShotEntity;


import base.Game;

public class UsineAlien {
	private Game game;
	private ArrayList<AlienEntity> aliens;
	private ArrayList<AlienEntity> aliensToRemove;
	private DeplacementAliensContainer deplacement;
	int etape=0;
	public UsineAlien(Game game) {
		this.game = game;
		aliens=new ArrayList<>();
		aliensToRemove=new ArrayList<>();
		deplacement = new DeplacementAliensContainer();
	}

	public void init(){
		aliens.clear();
		aliensToRemove.clear();
		deplacement.setInstance(new DeplacementAliensDefault(this));
		for (int row=0;row<3;row++) {
			for (int x=0;x<10;x++) {
				aliens.add(new AlienEntity(this,"sprites/alien.gif",100+(x*50),(50)+row*30,deplacement));
			}
		}
	}
	
	public void update(long delta){
		
		aliens.removeAll(aliensToRemove);
		aliensToRemove.clear();
		deplacement.updateMoveDirection();
		for(AlienEntity alien : aliens)
			alien.move(delta);
		if(count()<=5&&etape==0){
			etape++;
			deplacement.setInstance(new DeplacementAliensAleatoire(this));
		}
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
