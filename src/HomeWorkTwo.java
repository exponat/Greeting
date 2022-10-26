import java.util.Objects;
import java.util.Scanner;

public class HomeWorkTwo {
    private static final int MAXIMUM_ANSWERS = 4;
    private static final int RIGHT_ANSWER_COLUMN = 5;

    public static void main(String[] args) {

        int correctCount = 0, wrongCount = 0;

        Object[][] quizData = new Object[][]{
                {"В файл с каким расширением компилируется java-файл?", "1. cs", "2. java", "3. class", "4. exe", 3},
                {"С помощью какой команды git можно получить полную копию удаленного репозитория?", "1. commit", "2. push", "3. clone", "4. copy", 3},
                {"Какой применяется цикл, когда не известно количество итераций?", "1. while", "2. for", "3. loop", "", 1}
        };

        Scanner scanner = new Scanner(System.in);

        for (int question = 0; question < quizData.length; question++) {
            System.out.println("Вопрос №" + (question + 1));
            for (int answer = 0; answer <= MAXIMUM_ANSWERS; answer++) {
                System.out.println(quizData[question][answer]);
            }

            int answer = scanner.nextInt();

            if (Objects.equals(quizData[question][RIGHT_ANSWER_COLUMN], answer)) {
                System.out.println("Правильный ответ!");
                correctCount++;
            } else {
                System.out.println("Неправильный ответ!");
                wrongCount++;
            }
            System.out.println(">---------------------------------------------------<");
        }
        System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);
    }
}
