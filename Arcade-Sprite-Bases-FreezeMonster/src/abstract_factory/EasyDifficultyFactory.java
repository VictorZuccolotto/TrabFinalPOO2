package abstract_factory;

public class EasyDifficultyFactory implements DifficultyFactory {

	@Override
	public int MONSTER_SPEED() {
		return 2;
	}

	@Override
	public int MONSTER_MOVEMENT_RANDOMNESS() {
		return 1;
	}

	@Override
	public int MONSTER_SHOT_CHANCE() {
		return 2;
	}

	@Override
	public int MONSTER_SHOT_SPEED() {
		return 3;
	}

	@Override
	public int PLAYER_SPEED() {
		return 4;
	}

	@Override
	public int RAY_SPEED() {
		return 8;
	}

}
