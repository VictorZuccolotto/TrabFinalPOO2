package freezemonster.sprite;

import java.awt.Image;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;

import freezemonster.Commons;
import spriteframework.sprite.BadSprite;
import spriteframework.sprite.BadnessBoxSprite;

public class Monster extends BadnessBoxSprite {

    private Gosma bomb = null;
    private String monsterImg = "images/monster";
    public String froozeImg = "images/monster";

    public Monster(int x, int y, int id) {
    	this.monsterImg = this.monsterImg + id + ".png";
    	this.froozeImg = this.froozeImg + id +"bg.png";
    	initBomber(x, y);
    }

    private void initBomber(int x, int y) {
    	Random random = new Random();
    	this.dx = (random.nextInt(Commons.MONSTER_SPEED*2 + 1) - Commons.MONSTER_SPEED); 
    	this.dy = (random.nextInt(Commons.MONSTER_SPEED*2 + 1) - Commons.MONSTER_SPEED);
    	if(dx+dy == 0)
    		dx++;
        this.x = x;
        this.y = y;

        bomb = new Gosma(x,y);

        
        ImageIcon ii = new ImageIcon(monsterImg);
        Image scaledImage = ii.getImage().getScaledInstance(Commons.MONSTER_WIDTH, Commons.MONSTER_HEIGHT, Image.SCALE_SMOOTH);
		setImage(scaledImage);
		
		imageHeight = Commons.MONSTER_HEIGHT;
		imageWidth = Commons.MONSTER_WIDTH;
        
        
    }



    public Gosma getBomb() {
        return bomb;
    }
    
    public void setBomb(Gosma bomb) {
    	this.bomb = bomb;
    }


	@Override
	public LinkedList<BadSprite> getBadnesses() {
		LinkedList<BadSprite> aBomb = new LinkedList<BadSprite>();
		aBomb.add(bomb);
		return aBomb;
	}
}
