package AlienManager;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import base.Game;

import entities.AlienEntity;
import entities.Entity;
import entities.ShotEntity;

public abstract class AlienManagerConcrete implements AlienManager {
	protected List<AlienEntity> aliens;
	protected DeplacementAlienContainer deplacement;
	protected Game game;
	protected boolean needDeplacementChange;
	protected boolean inEdge;
	
	public AlienManagerConcrete(Game game) {
		this.game = game;
		this.needDeplacementChange = false;
		this.inEdge = false;
		this.deplacement = new DeplacementAlienContainer();
	}

	@Override
	public void invadesWeWin() {
		game.notifyDeath();		
	}

	@Override
	public int count() {
		return aliens.size();		
	}
	
	public void init(){
		
	}

	@Override
	public void update(long delta) {
		deplacement.beforeNextUpdate();
		if(needDeplacementChange){
			deplacement.change();
			for(AlienEntity ae : aliens)
				ae.moveFixe(0, 50);
			needDeplacementChange=false;
			inEdge = true;
		}
			
			
			
		for(AlienEntity ae : aliens)
			ae.move(delta);
		
		if(inEdge){
			inEdge=needDeplacementChange;
			needDeplacementChange=false;
		}

		
	}

	public boolean isInEdge() {
		return inEdge;
	}

	@Override
	public void collidShot(ShotEntity se) {
		for(AlienEntity ae: aliens)		
			if(se.collidesWith(ae)){
				se.collidedWith(ae);
				aliens.remove(ae);
				if(count()==0)
					game.notifyWin();
				return;
			}
	}

	@Override
	public void collidEdge() {
		needDeplacementChange = true;		
	}

	@Override
	public void draw(Graphics2D g) {
		for(AlienEntity e:aliens)
			e.draw(g);
	}
	
}
