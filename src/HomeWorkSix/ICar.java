package HomeWorkSix;

public interface ICar {
  public void drive(int distance,int avgFuelConsumption, int speed);
  public int driveDistance(int fuelTankVolume, int avgFuelConsumption);

  public void speedUp() throws MaximumSpeedReached;
  public void speedDown() throws MinimumSpeedReached;

}
