package HomeWorkSeven.otus.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class GameTest {

  @Mock
  Dice dice;
  @Mock
  GameWinnerPrinter winnerPrinter;
  @InjectMocks
  Game game;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testPlayGame() {
    when(dice.roll()).thenReturn(0);
    Player player1 = new Player("name1");
    Player player2 = new Player("name2");

    game.playGame(player1, player2);
    assertEquals(player2, "name2");

  }
}