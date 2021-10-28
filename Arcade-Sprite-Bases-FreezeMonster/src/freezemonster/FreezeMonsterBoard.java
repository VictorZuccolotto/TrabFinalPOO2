package freezemonster;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;

import freezemonster.sprite.Cowboy;
import freezemonster.sprite.Gosma;
import freezemonster.sprite.Monster;
import freezemonster.sprite.Ray;
import spriteframework.AbstractBoard;
import spriteframework.sprite.BadSprite;
import spriteframework.sprite.Sprite;
import spriteframework.sprite.XYPlayer;

public class FreezeMonsterBoard extends AbstractBoard {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Ray shot;

	private int deaths = 0;
	Random random = new Random();

	public FreezeMonsterBoard() {
		super(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
	}

	protected void createBadSprites() { // create monsters
		for (int i = 1; i <= 9; i++) {
			Monster monstro = new Monster(Commons.MONSTER_INIT_X + 18 * i, Commons.MONSTER_INIT_Y + 30 * i, i);
			badSprites.add(monstro);
		}
	}

	@Override
	protected void setBoardColor(Graphics g) {
		g.setColor(Commons.BOARD_COLOR);
		g.fillRect(0, 0, d.width, d.height);
	}

	@Override
	protected XYPlayer player() {
		return new Cowboy();
	}

	protected void createOtherSprites() {
		shot = new Ray();
	}

	private void drawShot(Graphics g) {

		if (shot.isVisible()) {

			g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
		}
	}

	@Override
	protected void drawOtherSprites(Graphics g) {
		drawShot(g);
	}

	protected void processOtherSprites(XYPlayer player, KeyEvent e) {
		int x = player.getX();
		int y = player.getY();

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {

			if (inGame) {

				if (!shot.isVisible()) {

					shot = new Ray(x, y, player.lastDirection);
				}
			}
		}
	}

	protected void update() {
		//verify games is over
		if (deaths == Commons.NUMBER_OF_MONSTERS_TO_DESTROY) {
			inGame = false;
			timer.stop();
			message = "Game won!";
		}

		// player
		for (XYPlayer player : players)
			player.act();
		
		//avoid null pointerException
		if (badSprites == null)
			badSprites = new LinkedList<BadSprite>();
		if (shot == null)
			shot = new Ray();
		
		// shot
		if (shot.isVisible()) {
			
			for (BadSprite monster : badSprites) {
				if (!monster.isFreezing() && shot.isVisible()) {
					if (checkSpriteCollision(shot, monster)) {
						Monster monsterGetImage = (Monster) monster;
						String frozenImage = monsterGetImage.froozeImg;
						ImageIcon ii = new ImageIcon(frozenImage);
						Image scaledImage = ii.getImage().getScaledInstance(Commons.MONSTER_WIDTH, Commons.MONSTER_HEIGHT, Image.SCALE_SMOOTH);
						monster.setImage(scaledImage);
						monster.setFreezing(true);
						deaths++;
						shot.die();
					}
				}
			}
			if (leakedFromScreen(shot)) {
				shot.die();
			} else {
				shot.setX(shot.getX() + shot.getDx());
				shot.setY(shot.getY() + shot.getDy());
			}
		}

		
		for (BadSprite monster : badSprites) {
			if (!monster.isFreezing()) {
				if (Commons.MONSTER_MOVEMENT_RANDOMNESS >= random.nextInt(100)) {
					int Dx;
					int Dy;
					do {
						Dx = (random.nextInt(Commons.MONSTER_SPEED*2 + 1) - Commons.MONSTER_SPEED);
						Dy = (random.nextInt(Commons.MONSTER_SPEED*2 + 1) - Commons.MONSTER_SPEED);
					}while (Dx + Dy == 0);

					monster.setDx(Dx);
					monster.setDy(Dy);
				}

				if (monster.getY() + monster.getDy() + monster.getImageHeight() >= d.getHeight()
						|| monster.getY() + monster.getDy() <= 0) {
					monster.setDy(monster.getDy() * -1);
				}

				if (monster.getX() + monster.getDx() + monster.getImageWidth() >= d.getWidth()
						|| monster.getX() + monster.getDx() <= 0) {
					monster.setDx(monster.getDx() * -1);
				}

				monster.setX(monster.getX() + monster.getDx());
				monster.setY(monster.getY() + monster.getDy());
				for (XYPlayer player : players) {
					if (checkSpriteCollision(monster, player)) {
						player.setDying(true);
					}
				}
			}
		}

		// gosmas
		updateOtherSprites();

	}

	private void updateOtherSprites() {

		for (BadSprite monster : badSprites) {

			Gosma gosma = ((Monster) monster).getBomb();

			if (random.nextInt(100) <= Commons.MONSTER_SHOT_CHANCE && !monster.isFreezing() && gosma.isDestroyed()) {
				gosma.setVisible(true);
				gosma.setDestroyed(false);
				gosma.setX(monster.getX());
				gosma.setY(monster.getY());
				gosma.setDx(monster.getDx() >= 0 ? -Commons.MONSTER_SHOT_SPEED : Commons.MONSTER_SHOT_SPEED);
				gosma.setDy(monster.getDy() >= 0 ? -Commons.MONSTER_SHOT_SPEED : Commons.MONSTER_SHOT_SPEED);
			}

			if (!gosma.isDestroyed()) {
				for (XYPlayer player : players) {
					if (player.isVisible()) {
						if (checkSpriteCollision(gosma, player)) {
							player.setDying(true);
							gosma.setDestroyed(true);
						}
					}

				}

				gosma.setX(gosma.getX() + gosma.getDx());
				gosma.setY(gosma.getY() + gosma.getDy());

				if (leakedFromScreen(gosma)) 
					gosma.setDestroyed(true);
			}
		}
	}
	
	private boolean leakedFromScreen(Sprite a1) {
		if(a1.getY() < (0 - a1.getImageHeight()) || a1.getY() > d.getHeight()
				|| a1.getX() < (0 - a1.getImageWidth()) || a1.getX() > d.getWidth())
			return true;
		return false;
	}

	private boolean checkSpriteCollision(Sprite a1, Sprite a2) {
		if (a1.getX() >= a2.getX() && a1.getX() <= a2.getX() + a2.getImageWidth() 
			&& a1.getY() >= a2.getY() && a1.getY() <= a2.getY() + a2.getImageHeight())
			return true;
		if (a1.getX() + a1.getImageWidth() >= a2.getX() && a1.getX() + a1.getImageWidth() <= a2.getX() + a2.getImageWidth()
			&& a1.getY() >= a2.getY() && a1.getY() <= a2.getY() + a2.getImageHeight())
			return true;
		if (a1.getY() + a1.getImageHeight() >= a2.getY() && a1.getY() + a1.getImageHeight() <= a2.getY() + a2.getImageHeight()
			&& a1.getX() >= a2.getX() && a1.getX() <= a2.getX() + a2.getImageWidth())
			return true;
		if (a1.getY() + a1.getImageHeight() >= a2.getY() && a1.getY() + a1.getImageHeight() <= a2.getY() + a2.getImageHeight()
			&& a1.getX() + a1.getImageWidth() >= a2.getX() && a1.getX() + a1.getImageWidth() <= a2.getX() + a2.getImageWidth())
			return true;
		return false;
	}

}
