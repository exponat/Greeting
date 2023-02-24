package HomeWorkSeven.otus;

import HomeWorkSeven.otus.game.Dice;
import HomeWorkSeven.otus.game.DiceImpl;
import HomeWorkSeven.otus.game.Game;
import HomeWorkSeven.otus.game.GameWinnerConsolePrinter;
import HomeWorkSeven.otus.game.GameWinnerPrinter;
import HomeWorkSeven.otus.game.Player;

public class Demo {

  public static void main(String[] args) {
    Dice dice = new DiceImpl();
    GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
    Game game = new Game(dice, winnerPrinter);
    game.playGame(new Player("Вася"), new Player("Игорь"));
  }
}
