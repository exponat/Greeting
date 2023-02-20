package ProjectWork;

import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

public class ProjectWork {
  private static final String[] RUS_PLURAL_MONEY = {"Рубль", "Рубля", "Рублей"};
  private static final String[] US_PLURAL_MONEY = {"Dollar", "Dollars", "Dollars"};
  private static final String[] RU_US_PLURAL_MONEY = {"Доллар", "Доллара", "Долларов"};

  public static void main(String[] args) {
    System.out.println("Введите число: ");
    int moneyAmount = new Scanner(System.in).nextInt();
    System.out.println(moneyAmount + " " + pluralEnding(moneyAmount, RUS_PLURAL_MONEY));
    System.out.println(moneyAmount + " " + pluralEnding(moneyAmount, US_PLURAL_MONEY));
    System.out.println(moneyAmount + " " + pluralEnding(moneyAmount, RU_US_PLURAL_MONEY));
  }

  private static String pluralEnding(int moneyAmount, String[] pluralMoney) {
    String correctPluralMoney;
    moneyAmount = moneyAmount % 100;
    if (moneyAmount >= 11 && moneyAmount <= 19) {
      correctPluralMoney = pluralMoney[2];
    } else {
      correctPluralMoney = switch (moneyAmount % 10) {
        case (1) -> pluralMoney[0];
        case (2), (3), (4) -> pluralMoney[1];
        default -> pluralMoney[2];
      };
    }
    return correctPluralMoney;
  }

  @Test
  public void pluralEndingTest() {
    String rusOne = "Рубль";
    String usOne = "Dollar";
    String ruUsOne = "Доллар";

    String rusMany = "Рубля";
    String usMany = "Dollars";
    String ruUsMany = "Доллара";

    String rusManyNext = "Рублей";
    String usManyNext = "Dollars";
    String ruUsManyNext = "Долларов";

    Assert.assertEquals(rusOne, pluralEnding(1, RUS_PLURAL_MONEY));
    Assert.assertEquals(usOne, pluralEnding(1, US_PLURAL_MONEY));
    Assert.assertEquals(ruUsOne, pluralEnding(1, RU_US_PLURAL_MONEY));

    Assert.assertEquals(rusMany, pluralEnding(22, RUS_PLURAL_MONEY));
    Assert.assertEquals(usMany, pluralEnding(22, US_PLURAL_MONEY));
    Assert.assertEquals(ruUsMany, pluralEnding(22, RU_US_PLURAL_MONEY));

    Assert.assertEquals(rusManyNext, pluralEnding(356, RUS_PLURAL_MONEY));
    Assert.assertEquals(usManyNext, pluralEnding(356, US_PLURAL_MONEY));
    Assert.assertEquals(ruUsManyNext, pluralEnding(356, RU_US_PLURAL_MONEY));
  }
}
