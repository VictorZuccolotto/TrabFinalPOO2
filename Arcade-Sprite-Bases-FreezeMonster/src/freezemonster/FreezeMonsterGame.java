package freezemonster;

import java.awt.EventQueue;

import abstract_factory.Difficulty.FactoryMaker;
import spriteframework.AbstractBoard;
import spriteframework.Commons;
import spriteframework.MainFrame;

public class FreezeMonsterGame extends MainFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final FactoryMaker.DIFFICULTY difficultyType = FactoryMaker.DIFFICULTY.
			//SELECT YOUR DIFFICULTY TYPE
			MEDIUM;
	//EASY, MEDIUM, HARD
	
	public FreezeMonsterGame(String t) {
		super(t,Commons.BOARD_WIDTH,Commons.BOARD_HEIGHT);
	}

	@Override
	protected AbstractBoard createBoard() {
		return new FreezeMonsterBoard();
	}

	
	
	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {

			new FreezeMonsterGame("FreezeMonster");
		});
	}
}
