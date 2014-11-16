package aliens;


import entities.AlienEntity;

public class DeplacementAliensDefault implements DeplacementAliens {
	
	UsineAlien commandant;
	public boolean needChangementDirection;
	public double vx;
	public double vy;
	
	public DeplacementAliensDefault(UsineAlien ua) {
		commandant = ua;
		vx = 75;
	}
	
	public void updateMoveDirection(){
		if(needChangementDirection){
			vx = -vx;
			commandant.goBack();
			needChangementDirection=false;
		}
	}
	
	public void setDirection(AlienEntity ae){
		if(vx<0&&ae.getX()<0
		|| vx>0&&ae.getX()>800-ae.getWidth())
			needChangementDirection = true;
		ae.setHorizontalMovement(vx);
		ae.setVerticalMovement(vy);
	}

	public void increaseSpeed(){
		vx *=1.03;
	}


}
