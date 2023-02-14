package HomeWorkFive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Client {
    private int id;
    private String name;
    private int age;
    private List<Account> accounts;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", accounts=" + accounts +
                '}';
    }

    public boolean isServed() {
        if (this.age >= 18) {
            return true;
        }
        return false;
    }

}
