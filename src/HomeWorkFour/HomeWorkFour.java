package HomeWorkFour;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeWorkFour {

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            array.add((int) Math.round((Math.random() * 200000)));
        }

        bubbleSort(array);

        builtInSort(array);

        streamSort(array);

    }

    public static List<Integer> bubbleSort(List<Integer> integerList) {
        Instant start = Instant.now();
        boolean sorted = false;
        int tempValue;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < integerList.size() - 1; i++) {
                if (integerList.get(i) > integerList.get(i + 1)) {
                    tempValue = integerList.get(i);
                    integerList.set(i, integerList.get(i + 1));
                    integerList.set(i + 1, tempValue);
                    sorted = false;
                }
            }
        }
        Instant end = Instant.now();
        long elapsed = Duration.between(start, end).toMillis();
        System.out.println("Время сортировки пузырьзом - " + elapsed);
        return integerList;
    }

    public static List<Integer> builtInSort(List<Integer> integerList) {
        Instant start = Instant.now();
        Collections.sort(integerList);
        Instant end = Instant.now();
        long elapsed = Duration.between(start, end).toMillis();
        System.out.println("Время сортировки Collections.sort - " + elapsed);
        return integerList;
    }

    public static List<Integer> streamSort(List<Integer> integerList) {
        Instant start = Instant.now();
        integerList = integerList.stream().sorted().toList();
        Instant end = Instant.now();
        long elapsed = Duration.between(start, end).toMillis();
        System.out.println("Время сортировки stream().sorted() - " + elapsed);
        return integerList;
    }
}
