package HomeWorkSix;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Car implements ICar {

  private String model;
  private String carClass;
  private int maximumSpeed;
  private int fuelTankVolume;
  private int currentFuelVolume;
  private int currentSpeed;
  private int avgFuelConsumption;

  @Override
  public void drive(int distance, int avgFuelConsumption, int speed) {
    try {
      if (distance >= 0 && avgFuelConsumption >= 0 && speed >= 0) {
        int fuelConsumption = distance / 100 * (avgFuelConsumption + ((speed - 90) * 10) / 100);
        setCurrentFuelVolume(getCurrentFuelVolume() - fuelConsumption);
      } else {
        throw new IllegalArgumentException(
            "Проверьте входные данные " + distance + " " + avgFuelConsumption + " " + speed);
      }
    } catch (Throwable e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public int driveDistance(int fuelTankVolume, int avgFuelConsumption) {
    int driveDistance = 0;
    try {
      driveDistance = 100 * fuelTankVolume / avgFuelConsumption;
    } catch (ArithmeticException e) {
      System.out.println("Деление на ноль " + e.getMessage());
    }
    return driveDistance;
  }

  @Override
  public void speedUp() throws MaximumSpeedReached {
    try {
      if (this.getCurrentSpeed() <= this.getMaximumSpeed() - 5) {
        this.currentSpeed += 5;
      } else {
        throw new MaximumSpeedReached("Достигнута максимальная скорость - ",
            this.getCurrentSpeed());
      }
    }catch(MaximumSpeedReached ex){
      System.out.println("Достигнута максимальная скорость - " + ex.getSpeed());
    }
  }

  @Override
  public void speedDown() throws MinimumSpeedReached {
    try {
      if (this.getCurrentSpeed() >= 5) {
        this.currentSpeed -= 5;
      } else {
        throw new MinimumSpeedReached("Достигнута минимальная скорость - ", this.getCurrentSpeed());
      }
    } catch (MinimumSpeedReached ex) {
      System.out.println("Достигнута минимальная скорость - " + ex.getSpeed());
    }
  }
}
