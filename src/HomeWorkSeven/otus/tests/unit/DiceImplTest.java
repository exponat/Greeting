package HomeWorkSeven.otus.tests.unit;

import static org.junit.Assert.assertTrue;

import HomeWorkSeven.otus.game.DiceImpl;
import java.util.ArrayList;
import java.util.List;

public class DiceImplTest {

  public void testRollFromOneToSix() {
    String scenario = "Тест выпадения значений от 1 до 6";
    try {
      List<Integer> numbers = new ArrayList<>();
      for (int i = 1; i <= 100; i++) {
        numbers.add(new DiceImpl().roll());
      }

      for (int n : numbers) {
        assertTrue("Значение вне диапазона 1 - 6: " + n, n >= 1 && n <= 6);
      }

      System.out.printf("\"%s\" passed %n", scenario);
    } catch (Throwable e) {
      System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
    }
  }

  public void testRollPositiveNumber() {
    String scenario = "Тест выпадения значений больше 0";
    try {
      List<Integer> numbers = new ArrayList<>();
      for (int i = 1; i <= 100; i++) {
        numbers.add(new DiceImpl().roll());
      }

      for (int n : numbers) {
        assertTrue("Отрицательное или равное 0 значение: " + n, n >= 1);
      }

      System.out.printf("\"%s\" passed %n", scenario);
    } catch (Throwable e) {
      System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
    }

  }
}
