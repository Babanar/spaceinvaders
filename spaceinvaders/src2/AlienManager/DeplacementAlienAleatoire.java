package AlienManager;

import java.util.Random;


import entities.AlienEntity;

public class DeplacementAlienAleatoire extends DeplacementAlienDefault {
	
	protected Random rand;
	protected long nextChange;
	protected AlienManager commandant;

	public DeplacementAlienAleatoire(AlienManager commandant){
		rand=new Random();
		newMovementSpeed();
		this.commandant = commandant;
	}
	
	public void move(AlienEntity e, long delta) {

		e.moveFixe((delta*moveSpeed)/1000,(10.0*delta)/1000); 
		/*J'ai décidé de les faires descendre légérement, leurs mouvements étant aléatoires
		 * ils ont tendance à toucher moins souvent les bords.
		 */		
		
	}

	@Override
	public void change() {
		moveSpeed = -moveSpeed;	
	}
	
	@Override
	public void beforeNextUpdate() {
		if(!commandant.isInEdge() && System.currentTimeMillis()>nextChange){
			newMovementSpeed();
		}
	}
	
	public void newMovementSpeed(){
		moveSpeed = rand.nextInt(100) + 70;
		moveSpeed = (rand.nextBoolean()?moveSpeed:-moveSpeed);
		nextChange=System.currentTimeMillis()+((rand.nextInt()%10)*100+500);
	
	}

}
