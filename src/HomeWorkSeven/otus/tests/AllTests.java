package HomeWorkSeven.otus.tests;


import HomeWorkSeven.otus.tests.unit.DiceImplTest;
import HomeWorkSeven.otus.tests.unit.GameTest;

public class AllTests {

  public static void main(String[] args) {
    new DiceImplTest().testRollFromOneToSix();
    new DiceImplTest().testRollPositiveNumber();
    new GameTest().testPlayGameDraw();
    new GameTest().testPlayGameWinnerNotNull();
  }
}
