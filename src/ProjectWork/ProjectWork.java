package ProjectWork;

import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

public class ProjectWork {
  private static final String[] RUS_PLURAL_MONEY = {"Рубль", "Рубля", "Рублей"};
  private static final String[] US_PLURAL_MONEY = {"Dollar", "Dollars", "Dollars"};
  private static final String[] RU_US_PLURAL_MONEY = {"Доллар", "Доллара", "Долларов"};
  private static final String[] RU_CH_PLURAL_MONEY = {"Юань", "Юаня", "Юаней"};
  private static final String[] RU_JP_PLURAL_MONEY = {"Йена", "Йены", "Йен"};

  public static void main(String[] args) {
    System.out.println("Введите число: ");
    int moneyAmount = new Scanner(System.in).nextInt();
    System.out.println(pluralPrice(moneyAmount, RUS_PLURAL_MONEY));
    System.out.println(pluralPrice(moneyAmount, US_PLURAL_MONEY));
    System.out.println(pluralPrice(moneyAmount, RU_US_PLURAL_MONEY));
    System.out.println(pluralPrice(moneyAmount, RU_CH_PLURAL_MONEY));
    System.out.println(pluralPrice(moneyAmount, RU_JP_PLURAL_MONEY));
  }

  private static String pluralPrice(int moneyAmount, String[] pluralMoney) {
    String correctPluralMoney;
    int money = moneyAmount % 100;
    if (money >= 11 && money <= 19) {
      correctPluralMoney = pluralMoney[2];
    } else {
      correctPluralMoney = switch (money % 10) {
        case (1) -> pluralMoney[0];
        case (2), (3), (4) -> pluralMoney[1];
        default -> pluralMoney[2];
      };
    }
    return moneyAmount + " " + correctPluralMoney;
  }

  @Test
  public void testPluralPrice() {
    Assert.assertEquals("1 Рубль", pluralPrice(1, RUS_PLURAL_MONEY));
    Assert.assertEquals("1 Dollar", pluralPrice(1, US_PLURAL_MONEY));
    Assert.assertEquals("1 Доллар", pluralPrice(1, RU_US_PLURAL_MONEY));
    Assert.assertEquals("1 Юань", pluralPrice(1, RU_CH_PLURAL_MONEY));
    Assert.assertEquals("1 Йена", pluralPrice(1, RU_JP_PLURAL_MONEY));

    Assert.assertEquals("22 Рубля", pluralPrice(22, RUS_PLURAL_MONEY));
    Assert.assertEquals("22 Dollars", pluralPrice(22, US_PLURAL_MONEY));
    Assert.assertEquals("22 Доллара", pluralPrice(22, RU_US_PLURAL_MONEY));
    Assert.assertEquals("22 Юаня", pluralPrice(22, RU_CH_PLURAL_MONEY));
    Assert.assertEquals("22 Йены", pluralPrice(22, RU_JP_PLURAL_MONEY));

    Assert.assertEquals("356 Рублей", pluralPrice(356, RUS_PLURAL_MONEY));
    Assert.assertEquals("356 Dollars", pluralPrice(356, US_PLURAL_MONEY));
    Assert.assertEquals("356 Долларов", pluralPrice(356, RU_US_PLURAL_MONEY));
    Assert.assertEquals("356 Юаней", pluralPrice(356, RU_CH_PLURAL_MONEY));
    Assert.assertEquals("356 Йен", pluralPrice(356, RU_JP_PLURAL_MONEY));
  }
}
