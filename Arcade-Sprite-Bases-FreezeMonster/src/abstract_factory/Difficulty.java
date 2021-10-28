package abstract_factory;

import abstract_factory.Difficulty.FactoryMaker.DIFFICULTY;

public class Difficulty {

	int MONSTER_SPEED;
	int MONSTER_MOVEMENT_RANDOMNESS;
	int MONSTER_SHOT_CHANCE;
	int MONSTER_SHOT_SPEED;
	int PLAYER_SPEED;
	int RAY_SPEED;

	public Difficulty(DIFFICULTY difficultyType) {
		DifficultyFactory factory = Difficulty.FactoryMaker.makeFactory(difficultyType);
		this.setMONSTER_MOVEMENT_RANDOMNESS(factory.MONSTER_MOVEMENT_RANDOMNESS());
		this.setMONSTER_SHOT_CHANCE(factory.MONSTER_SHOT_CHANCE());
		this.setMONSTER_SHOT_SPEED(factory.MONSTER_SHOT_SPEED());
		this.setMONSTER_SPEED(factory.MONSTER_SPEED());
		this.setPLAYER_SPEED(factory.PLAYER_SPEED());
		this.setRAY_SPEED(factory.RAY_SPEED());
		
	}

	public void setMONSTER_SPEED(int mONSTER_SPEED) {
		MONSTER_SPEED = mONSTER_SPEED;
	}

	public void setMONSTER_MOVEMENT_RANDOMNESS(int mONSTER_MOVEMENT_RANDOMNESS) {
		MONSTER_MOVEMENT_RANDOMNESS = mONSTER_MOVEMENT_RANDOMNESS;
	}

	public void setMONSTER_SHOT_CHANCE(int mONSTER_SHOT_CHANCE) {
		MONSTER_SHOT_CHANCE = mONSTER_SHOT_CHANCE;
	}

	public void setMONSTER_SHOT_SPEED(int mONSTER_SHOT_SPEED) {
		MONSTER_SHOT_SPEED = mONSTER_SHOT_SPEED;
	}

	public void setPLAYER_SPEED(int pLAYER_SPEED) {
		PLAYER_SPEED = pLAYER_SPEED;
	}

	public void setRAY_SPEED(int rAY_SPEED) {
		RAY_SPEED = rAY_SPEED;
	}

	public int getMONSTER_SPEED() {
		return MONSTER_SPEED;
	}

	public int getMONSTER_MOVEMENT_RANDOMNESS() {
		return MONSTER_MOVEMENT_RANDOMNESS;
	}

	public int getMONSTER_SHOT_CHANCE() {
		return MONSTER_SHOT_CHANCE;
	}

	public int getMONSTER_SHOT_SPEED() {
		return MONSTER_SHOT_SPEED;
	}

	public int getPLAYER_SPEED() {
		return PLAYER_SPEED;
	}

	public int getRAY_SPEED() {
		return RAY_SPEED;
	}

	public static class FactoryMaker {

		public enum DIFFICULTY {
			EASY, MEDIUM, HARD
		}

		public static DifficultyFactory makeFactory(DIFFICULTY difficulty) {
			switch (difficulty) {
			case EASY:
				return new EasyDifficultyFactory();
			case MEDIUM:
				return new MediumDifficultyFactory();
			case HARD:
				return new HardDifficultyFactory();
			default:
				throw new IllegalArgumentException("KingdomType not supported.");
			}

		}
	}
}
