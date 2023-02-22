package HomeWorkSeven.otus.tests.unit;

import static org.junit.Assert.assertEquals;

import HomeWorkSeven.otus.game.Dice;
import HomeWorkSeven.otus.game.GameWinnerConsolePrinter;
import HomeWorkSeven.otus.game.GameWinnerPrinter;
import HomeWorkSeven.otus.game.Player;


public class GameTest implements Dice {

  private boolean isFirstRoll = true;

  public void testPlayGameDraw() {
    String scenario = "Тест результата \"Ничья\"";
    try {
      GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
      Player player1 = new Player("Вася");
      Player player2 = new Player("Игорь");

      Player winner = (2 > 2) ? player1 : player2;
      assertEquals(winner.getName(), "Ничья");

      System.out.printf("\"%s\" passed %n", scenario);
    } catch (Throwable e) {
      System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
    }
  }

  public void testPlayGame() {
    String scenario = "Тест выбора победителя";
    try {
      GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
      Player player1 = new Player("Первый игрок");
      Player player2 = new Player("Второй игрок");

      int player1Result = roll();
      int player2Result = roll();

      Player winner = (player1Result > player2Result) ? player1 : player2;
      assertEquals(winner.getName(), "Второй игрок");

      System.out.printf("\"%s\" passed %n", scenario);
    } catch (Throwable e) {
      System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
    }
  }

  @Override
  public int roll() {
    int result = (isFirstRoll) ? 1 : 2;
    isFirstRoll = !isFirstRoll;
    return result;
  }
}
