package HomeWorkSix;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MaximumSpeedReached extends Exception {
  private String message;
  private int speed;
}
