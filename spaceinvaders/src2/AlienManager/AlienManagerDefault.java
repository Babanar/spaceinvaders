package AlienManager;

import java.util.ArrayList;

import base.Game;

import entities.AlienEntity;

public class AlienManagerDefault extends AlienManagerConcrete {
	public AlienManagerDefault(Game game){
		super(game);
		aliens=new ArrayList<>();
	}
	
	public void init(){
		aliens.clear();
		deplacement.setInstance(new DeplacementAlienDefault());
		for(int i=0;i<3;i++)
			for(int j=0;j<10;j++)
				aliens.add(new AlienEntity(this,"sprites/alien.gif",100+(j*50),(50)+i*30,deplacement));	
	}
	
	public void update(long delta){
		super.update(delta);
		if(count()<=5 && !(deplacement.getInstance() instanceof DeplacementAlienAleatoire)){
			deplacement.setInstance(new DeplacementAlienAleatoire(this));
			
		}
	}
}
