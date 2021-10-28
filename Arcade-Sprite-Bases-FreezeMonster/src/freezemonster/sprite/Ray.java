package freezemonster.sprite;

import java.awt.Image;

import javax.swing.ImageIcon;

import freezemonster.Commons;
import spriteframework.sprite.BadSprite;

public class Ray extends BadSprite {

	
	
	public Ray() {
		this.setVisible(false);
	}
	
	public Ray(int x, int y, int lastDirection) {
		initShot(x, y);
		
		switch (lastDirection) {
		  case 1:
			  setDx(-Commons.RAY_SPEED);
		    break;
		  case 2:
			  setDy(-Commons.RAY_SPEED);
		    break;
		  case 3:
			  setDx(Commons.RAY_SPEED);
		    break;
		  case 4:
			  setDy(Commons.RAY_SPEED);
			    break;
		  default:
			  setDx(-Commons.RAY_SPEED);
		}
	}

	private void initShot(int x, int y) {
			ImageIcon ii = new ImageIcon("images/ray.png");
			Image scaledImage = ii.getImage().getScaledInstance(Commons.PROJECTILE_WIDTH, Commons.PROJECTILE_HEIGHT, Image.SCALE_SMOOTH); 
			setImage(scaledImage);

			super.imageWidth = Commons.PROJECTILE_WIDTH;
			super.imageHeight = Commons.PROJECTILE_HEIGHT;
		int H_SPACE = 6;
		setX(x + H_SPACE);

		int V_SPACE = 1;
		setY(y - V_SPACE);
	}
}
