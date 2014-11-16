package Niveau;

import entities.AlienEntity;
import missile.MissileManager;
import aliens.AlienShooter;
import aliens.DeplacementAliensAleatoire;
import aliens.UsineAlien;
import base.Game;

public class Niveau1 extends UsineAlien {

	public Niveau1(Game game, MissileManager missiles) {
		super(game, missiles);
		// TODO Stub du constructeur généré automatiquement
	}

	public void init(){
		super.init();
		for (int row=0;row<3;row++) {
			for (int x=0;x<10;x++) {
				aliens.add(new AlienEntity(this,"sprites/alien.gif",100+(x*50),(50)+row*30,deplacement));
			}
		}
	}
	
	public void update(long delta){
		super.update(delta);
		if(count()<=5&&etape==0){
			etape++;
			deplacement.setInstance(new DeplacementAliensAleatoire(this));
		}
	}

}
