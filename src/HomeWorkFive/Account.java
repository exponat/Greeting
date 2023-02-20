package HomeWorkFive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Account {
    private int id;
    private int clientId;
    private int moneyAmount;

    @Override
    public String toString() {
        return "Счёт № - " + id +
                ", Сумма на счёте - " + moneyAmount;
    }
}
