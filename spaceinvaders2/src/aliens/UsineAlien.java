package aliens;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import entities.AlienEntity;


import base.Game;

public class UsineAlien {
	private Game game;
	private ArrayList<AlienEntity> aliens;
	private DeplacementAliensContainer deplacements;
	public UsineAlien(Game game) {
		this.game = game;
		aliens=new ArrayList<>();
		deplacements = new DeplacementAliensContainer();
	}

	public void init(){
		deplacements = new DeplacementAliensContainer();
		deplacements.setInstance(new DeplacementAliensDefault(this));
		for (int row=0;row<3;row++) {
			for (int x=0;x<10;x++) {
				aliens.add(new AlienEntity(game,"sprites/alien.gif",100+(x*50),(50)+row*30,deplacements));
			}
		}
	}
	
	public void update(long delta){
		for(AlienEntity alien : aliens)
			alien.move(delta);
		if(count()<=5)
			deplacements.setInstance(new DeplacementAliensAleatoire(this));
	}
	
	public void draw(Graphics g){
		
		deplacements.updateMoveDirection();
		
		for(AlienEntity alien : aliens)
			alien.draw(g);
	}
	
	public int count(){
		return aliens.size();
	}
	
}
