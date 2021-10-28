package freezemonster;

import java.awt.Color;

import abstract_factory.Difficulty;

public interface Commons extends spriteframework.Commons{

//	Difficulty difficulty = new Difficulty(FactoryMaker.DIFFICULTY.MEDIUM);
	Difficulty difficulty = new Difficulty(FreezeMonsterGame.difficultyType);
	
    int BOARD_WIDTH = 800;//;
    int BOARD_HEIGHT = 600;//600;
    Color BOARD_COLOR = new Color(83, 186, 139);

    int MONSTER_WIDTH = 30;
    int MONSTER_HEIGHT = 50;
    int MONSTER_INIT_X = 150;
    int MONSTER_INIT_Y = 5;
    int NUMBER_OF_MONSTERS_TO_DESTROY = 9;
    int MONSTER_SPEED = difficulty.getMONSTER_SPEED();
    int MONSTER_MOVEMENT_RANDOMNESS = difficulty.getMONSTER_MOVEMENT_RANDOMNESS();  // %
    int MONSTER_SHOT_CHANCE = difficulty.getMONSTER_SHOT_CHANCE(); // %
    int MONSTER_SHOT_SPEED = difficulty.getMONSTER_SHOT_SPEED(); 

    int PLAYER_WIDTH = 35;
    int PLAYER_HEIGHT = 55;
    int PLAYER_SPEED = difficulty.getPLAYER_SPEED();
    int RAY_SPEED = difficulty.getRAY_SPEED();
    
    int PROJECTILE_HEIGHT = 25;
    int PROJECTILE_WIDTH = 25;

//    int MONSTER_WIDTH = 30;
//    int MONSTER_HEIGHT = 50;
//    int MONSTER_INIT_X = 150;
//    int MONSTER_INIT_Y = 5;
//    int NUMBER_OF_MONSTERS_TO_DESTROY = 9;
//    int MONSTER_SPEED = 3;
//    int MONSTER_MOVEMENT_RANDOMNESS = 3;  // %
//    int MONSTER_SHOT_CHANCE = 8; // %
//    int MONSTER_SHOT_SPEED = 6; 
//
//    int PLAYER_WIDTH = 35;
//    int PLAYER_HEIGHT = 55;
//    int PLAYER_SPEED = 2;
//    int RAY_SPEED = 4;
//    
//    int PROJECTILE_HEIGHT = 25;
//    int PROJECTILE_WIDTH = 25;
    
}
