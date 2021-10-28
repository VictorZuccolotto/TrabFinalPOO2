package spriteframework.sprite;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import spriteframework.Commons;

public class XPlayer extends XYPlayer {

    protected int width;
    protected int height;


    @Override
    protected void loadImage () {
        ImageIcon ii = new ImageIcon("images/player.png");
        width = ii.getImage().getWidth(null);
        setImage(ii.getImage());
    }
    
    @Override
    public void act() {

        x += dx;

        if (x <= 2) {

            x = 2;
        }

        if (x >= Commons.BOARD_WIDTH - 2 * width) {

            x = Commons.BOARD_WIDTH - 2 * width;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        	
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {

            dx = 0;
        }
    }

}
