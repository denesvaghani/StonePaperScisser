package game.controller;

import java.util.Random;

import game.model.StonePaperScisser.Game;

public class GameLogic {
	private static int iteration = 1;
	private static int totalLimit = 50;

	public static int getTotalLimit() {
		return totalLimit;
	}

	public static int getIteration() {
		return iteration;
	}

	public static void setIteration(int iteration) {
		GameLogic.iteration = iteration;
	}

	public static int[] guess(int totalPlayer) {
		Random rm = new Random();
		int guess[] = new int[totalPlayer];
		for (int i = 0; i < totalPlayer; i++)
			guess[i] = rm.nextInt(1000) % 3;
		return guess;
	}

	public static Game[] assignSymboll(int[] random, int totalPlayer) {

		Game[] iterationGuess = new Game[totalPlayer];

		for (int i = 0; i < random.length; i++) {
			if (random[i] == 0)
				iterationGuess[i] = Game.ROCK;
			else if (random[i] == 1)
				iterationGuess[i] = Game.SCISSORS;
			else
				iterationGuess[i] = Game.PAPER;
		}

		return iterationGuess;
	}

	public static Game desideWinner(Game playerGuess) {
		Game winner;

		if (playerGuess == Game.SCISSORS)
			winner = Game.ROCK;
		else if (playerGuess == Game.PAPER)
			winner = Game.SCISSORS;
		else
			winner = Game.PAPER;

		return winner;
	}

	public static int[][] calculateResult(Game[] iterationGuess, int[][] result, int totalPlayer) {
		for (int resultOfPlayer = 0; resultOfPlayer < totalPlayer; resultOfPlayer++) {
			Game winner = desideWinner(iterationGuess[resultOfPlayer]);
			for (int otherPlayer = 0; otherPlayer < totalPlayer; otherPlayer++) {
				if (resultOfPlayer != otherPlayer && iterationGuess[resultOfPlayer] != iterationGuess[otherPlayer]) {
					if (winner == iterationGuess[otherPlayer])
						result[resultOfPlayer][otherPlayer] += 1;
				}
			}
		}

		return result;
	}

}
