package HomeWorkSix;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Garage implements IRefuel{
  private List<Car> cars;

  @Override
  public void refuel(Car car) {
    car.setCurrentFuelVolume(car.getFuelTankVolume());
  }

  @Override
  public void addFuel(Car car) {
    car.setCurrentFuelVolume(car.getCurrentFuelVolume() + 10);
  }
}
