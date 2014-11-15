package AlienManager;

import java.awt.Graphics2D;

import entities.ShotEntity;

public interface AlienManager {
		public void update(long delta);
		public void draw(Graphics2D g);
		public void collidEdge();
		public int count();
		public void init();
		public void invadesWeWin();
		public void collidShot(ShotEntity se);
		public boolean isInEdge();
}
