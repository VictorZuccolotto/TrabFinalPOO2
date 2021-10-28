package freezemonster.sprite;

import java.awt.Image;

import javax.swing.ImageIcon;

import freezemonster.Commons;
import spriteframework.sprite.BadSprite;

public class Gosma extends BadSprite {
	private boolean destroyed;

	public Gosma(int x, int y) {
		initBomb(x, y);
	}


	private void initBomb(int x, int y) {

		setDestroyed(true);

		this.x = x;
		this.y = y;

		String bombImg = "images/gosma.png";
		ImageIcon ii = new ImageIcon(bombImg);
		Image scaledImage = ii.getImage().getScaledInstance(Commons.PROJECTILE_WIDTH, Commons.PROJECTILE_HEIGHT, Image.SCALE_SMOOTH);
		setImage(scaledImage);
		
		imageHeight = Commons.PROJECTILE_HEIGHT;
		imageWidth = Commons.PROJECTILE_WIDTH;
		
		this.setVisible(false);
	}

	public void setDestroyed(boolean destroyed) {

		this.destroyed = destroyed;
	}

	public boolean isDestroyed() {

		return destroyed;
	}
}
