package game.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import game.model.StonePaperScisser;
import game.model.StonePaperScisser.Game;

@Controller
@RequestMapping(value = "/")
@ComponentScan("game.model.StonePaperScisser")
public class GameController {
	

	@Autowired
	StonePaperScisser stonePaperScisser;

	@RequestMapping(value = "/iterate",method = RequestMethod.POST)
	public String playGame(HttpServletResponse response,Model model) throws IOException {
		int iteration =  GameLogic.getIteration();
		if (iteration <= GameLogic.getTotalLimit()) {
			int totalPlayer = this.stonePaperScisser.getTotalPlayer();
		
			int[] guess = GameLogic.guess(totalPlayer);
			Game[] playerGuess = GameLogic.assignSymboll(guess, totalPlayer);
			int[][] result = GameLogic.calculateResult(playerGuess, this.stonePaperScisser.getResult(), totalPlayer);
			model.addAttribute("guess", playerGuess);
			model.addAttribute("result", result);
			model.addAttribute("iteration", iteration);
			
			GameLogic.setIteration(++iteration);
		} else {
			return "GameFinish";
		}
		return "result";
	}
}
