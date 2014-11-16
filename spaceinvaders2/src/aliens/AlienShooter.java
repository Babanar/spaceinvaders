package aliens;

import java.util.Random;

import missile.MissileManager;
import missile.MissileAlien;
import entities.AlienEntity;

public class AlienShooter extends AlienEntity {
	protected 	MissileManager missiles;
	protected 	Random rd=new Random();;
	protected 	long fireRate=10000;
	protected 	long fireRateRange = 5000;
	protected 	long nextFire= System.currentTimeMillis()+rd.nextInt(10000);
	
	public AlienShooter(UsineAlien ua, String ref, int x, int y,
			DeplacementAliens da, MissileManager missiles) {
		super(ua, ref, x, y, da);
		this.missiles = missiles;
	}
	
	public void update(long delta){
		if(nextFire<System.currentTimeMillis()){
		nextFire= System.currentTimeMillis()+rd.nextInt((int)fireRateRange)+fireRate-fireRateRange/2;
		
		missiles.addShot(new MissileAlien(missiles,(int)x,(int)y));
		
		
		}
		super.update(delta);
	}


}
