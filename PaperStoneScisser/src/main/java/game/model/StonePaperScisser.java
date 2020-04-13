package game.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("stonePaperScisser")
public class StonePaperScisser {
	public enum Game {
		ROCK, SCISSORS, PAPER
	};

	private int totalPlayer = 4;
	private int[][] result = new int[this.totalPlayer][this.totalPlayer];
	private int[] guess = new int[this.totalPlayer];

	public int getTotalPlayer() {
		return this.totalPlayer;
	}

	public void setTotalPlayer(int totalPlayer) {
		this.totalPlayer = totalPlayer;
	}

	public int[][] getResult() {
		return this.result;
	}

	public void setResult(int[][] result) {
		this.result = result;
	}

	public int[] getGuess() {
		return this.guess;
	}

	public void setGuess(int[] guess) {
		this.guess = guess;
	}

}
