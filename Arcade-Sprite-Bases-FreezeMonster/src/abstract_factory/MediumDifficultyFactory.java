package abstract_factory;

public class MediumDifficultyFactory implements DifficultyFactory {

	@Override
	public int MONSTER_SPEED() {
		return 3;
	}

	@Override
	public int MONSTER_MOVEMENT_RANDOMNESS() {
		return 5;
	}

	@Override
	public int MONSTER_SHOT_CHANCE() {
		return 5;
	}

	@Override
	public int MONSTER_SHOT_SPEED() {
		return 6;
	}

	@Override
	public int PLAYER_SPEED() {
		return 2;
	}

	@Override
	public int RAY_SPEED() {
		return 4;
	}

}
