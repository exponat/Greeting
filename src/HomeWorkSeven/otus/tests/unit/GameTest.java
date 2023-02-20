package HomeWorkSeven.otus.tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import HomeWorkSeven.otus.game.GameWinnerConsolePrinter;
import HomeWorkSeven.otus.game.GameWinnerPrinter;
import HomeWorkSeven.otus.game.Player;


public class GameTest {

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

  public void testPlayGameWinnerNotNull() {
    String scenario = "Тест наличия победителя";
    try {
      GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
      Player player1 = new Player("Вася");
      Player player2 = new Player("Игорь");

      Player winner = (2 > 3) ? player1 : player2;
      assertNotNull(winner);

      System.out.printf("\"%s\" passed %n", scenario);
    } catch (Throwable e) {
      System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
    }
  }

}
