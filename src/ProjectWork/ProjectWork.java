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
    String rusOne = "1 Рубль";
    String usOne = "1 Dollar";
    String ruUsOne = "1 Доллар";
    String ruChOne = "1 Юань";
    String ruJpOne = "1 Йена";

    String rusMany = "22 Рубля";
    String usMany = "22 Dollars";
    String ruUsMany = "22 Доллара";
    String ruChMany = "22 Юаня";
    String ruJpMany = "22 Йены";

    String rusManyNext = "356 Рублей";
    String usManyNext = "356 Dollars";
    String ruUsManyNext = "356 Долларов";
    String ruChManyNext = "356 Юаней";
    String ruJpManyNext = "356 Йен";

    Assert.assertEquals(rusOne, pluralPrice(1, RUS_PLURAL_MONEY));
    Assert.assertEquals(usOne, pluralPrice(1, US_PLURAL_MONEY));
    Assert.assertEquals(ruUsOne, pluralPrice(1, RU_US_PLURAL_MONEY));
    Assert.assertEquals(ruChOne, pluralPrice(1, RU_CH_PLURAL_MONEY));
    Assert.assertEquals(ruJpOne, pluralPrice(1, RU_JP_PLURAL_MONEY));

    Assert.assertEquals(rusMany, pluralPrice(22, RUS_PLURAL_MONEY));
    Assert.assertEquals(usMany, pluralPrice(22, US_PLURAL_MONEY));
    Assert.assertEquals(ruUsMany, pluralPrice(22, RU_US_PLURAL_MONEY));
    Assert.assertEquals(ruChMany, pluralPrice(22, RU_CH_PLURAL_MONEY));
    Assert.assertEquals(ruJpMany, pluralPrice(22, RU_JP_PLURAL_MONEY));

    Assert.assertEquals(rusManyNext, pluralPrice(356, RUS_PLURAL_MONEY));
    Assert.assertEquals(usManyNext, pluralPrice(356, US_PLURAL_MONEY));
    Assert.assertEquals(ruUsManyNext, pluralPrice(356, RU_US_PLURAL_MONEY));
    Assert.assertEquals(ruChManyNext, pluralPrice(356, RU_CH_PLURAL_MONEY));
    Assert.assertEquals(ruJpManyNext, pluralPrice(356, RU_JP_PLURAL_MONEY));
  }
}
