package spriteframework.sprite;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import spriteframework.Commons;

public class XYPlayer extends Sprite{
	protected int width;
    protected int height;
    

    public XYPlayer() {
        loadImage();
//		getImageDimensions();
		resetState();
    }
	
    protected void loadImage () {
        ImageIcon ii = new ImageIcon("images/player.png");
        width = ii.getImage().getWidth(null);
        setImage(ii.getImage());
    }
    
    public void act() {

        x += dx;
        y += dy;

        if (x <= 2) {

            x = 2;
        }
        
        if (y <= 2) {

            y = 2;
        }

        if (x >= Commons.BOARD_WIDTH - imageWidth) {

            x = Commons.BOARD_WIDTH - imageWidth;
        }
        
        if (y >= Commons.BOARD_HEIGHT - imageHeight) {
        	
            y = Commons.BOARD_HEIGHT - imageHeight;
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        	super.lastDirection = 1;
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
        	super.lastDirection = 3;
            dx = 2;
        }
        
        if (key == KeyEvent.VK_UP) {
        	super.lastDirection = 2;
            dy = -2;
            
        }

        if (key == KeyEvent.VK_DOWN) {
        	super.lastDirection = 4;
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        	super.lastDirection = 1;
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
        	super.lastDirection = 3;
            dx = 0;
        }
        
        if (key == KeyEvent.VK_UP) {
        	super.lastDirection = 2;
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
        	super.lastDirection = 4;
            dy = 0;
        }
        
    }
    
    private void resetState() {

        setX(Commons.INIT_PLAYER_X-100);
        setY(Commons.INIT_PLAYER_Y);
    }
}
