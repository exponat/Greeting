package HomeWorkSix;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws MaximumSpeedReached, MinimumSpeedReached {
    List<Car> cars = new ArrayList<>();
    cars.add(new Car("ВАЗ 2101", "В", 120, 40, 20, 0, 4));
    cars.add(new Car("ВАЗ 2106", "В", 140, 50, 25, 0, 5));
    cars.add(new Car("ВАЗ 21099", "В", 160, 60, 30, 0, 6));
    cars.add(new Car("ВАЗ 210999", "Х", 90, 60, 30, 0, 0));
    cars.add(new Car("ВАЗ 210666", "Y", -70, -50, -25, -10, -6));

    Garage garage = new Garage(cars);

    cars.forEach(garage::refuel);

    for (Car c : cars) {
      System.out.println(
          "Топлива в автомобиле: " + c.getModel() + " - " + c.getCurrentFuelVolume());
      c.drive(100, c.getAvgFuelConsumption(), c.getMaximumSpeed());
      System.out.println(
          "Останется топлива после 100 км на максимальной скорости - " + c.getMaximumSpeed()
              + " останется - "
              + c.getCurrentFuelVolume());
      c.drive(100, c.getAvgFuelConsumption(), 90);
      System.out.println(
          "Останется топлива после ещё 100 км на скорости 90 км/ч - " + c.getMaximumSpeed()
              + " останется - "
              + c.getCurrentFuelVolume());
      System.out.println("На остаток топлива автомобиль сможет проехать ещё - " + c.driveDistance(
          c.getCurrentFuelVolume(), c.getAvgFuelConsumption()) + " км");
      System.out.println("---------------------------");
    }

    cars.get(1).setCurrentSpeed(120);
    cars.get(1).speedUp();
    System.out.println("Скорость автомобиля " + cars.get(1).getModel() + " = " + cars.get(1).getCurrentSpeed());
    cars.get(1).speedUp();
    System.out.println("Скорость автомобиля " + cars.get(1).getModel() + " = " + cars.get(1).getCurrentSpeed());
    cars.get(1).speedUp();
    System.out.println("Скорость автомобиля " + cars.get(1).getModel() + " = " + cars.get(1).getCurrentSpeed());
    cars.get(1).speedUp();
    System.out.println("Скорость автомобиля " + cars.get(1).getModel() + " = " + cars.get(1).getCurrentSpeed());
    cars.get(1).speedUp();
    System.out.println("Скорость автомобиля " + cars.get(1).getModel() + " = " + cars.get(1).getCurrentSpeed());

    cars.get(2).speedDown();
    System.out.println("Скорость автомобиля " + cars.get(2).getModel() + " = " + cars.get(2).getCurrentSpeed());

  }
}
