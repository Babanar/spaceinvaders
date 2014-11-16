package Niveau;

import entities.AlienEntity;
import missile.MissileManager;
import aliens.AlienShooter;
import aliens.DeplacementAliensAleatoire;
import aliens.UsineAlien;
import base.Game;

public class Niveau3 extends UsineAlien {

	public Niveau3(Game game, MissileManager missiles) {
		super(game, missiles);
		// TODO Stub du constructeur généré automatiquement
	}

	public void init(){
		super.init();
		int [][] niveau = {	{0,0,0,0,0,0,0,0,0,0},
							{0,2,0,0,0,0,0,0,2,0},
							{0,0,2,1,1,1,1,2,0,0},
							{0,0,0,2,2,2,2,0,0,0}
							};
		for (int y = 0;y<niveau.length;y++) {
			for (int x=0;x<niveau[y].length;x++) {
				switch(niveau[y][x]){
					case 1:
					aliens.add(new AlienShooter(this,"sprites/alien.gif",100+(x*50),(50)+y*30,deplacement,missiles));
					break;
					case 2:
					aliens.add(new AlienEntity(this,"sprites/alien.gif",100+(x*50),(50)+y*30,deplacement));
					break;
					default:
					break;
				}
				
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
