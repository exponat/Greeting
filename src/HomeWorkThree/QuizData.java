package HomeWorkThree;

import java.util.Objects;
import java.util.Scanner;

public class QuizData {
    private int correctCount = 0;
    private int wrongCount = 0;

    public void make() {
        Scanner scanner = new Scanner(System.in);

        Question question1 = new Question(1, "В файл с каким расширением компилируется java-файл?");
        question1.addAnswer(new Answer(1, "cs"));
        question1.addAnswer(new Answer(2, "java"));
        question1.addAnswer(new Answer(3, "class"));
        question1.addAnswer(new Answer(4, "exe"));
        question1.setCorrectAnswer(3);
        question1.printQuestion();
        checkAnswer(question1, scanner.nextInt());

        System.out.println(">---------------------------------------------------<");

        Question question2 = new Question(2, "С помощью какой команды git можно получить полную копию удаленного репозитория?");
        question2.addAnswer(new Answer(1, "commit"));
        question2.addAnswer(new Answer(2, "push"));
        question2.addAnswer(new Answer(3, "clone"));
        question2.addAnswer(new Answer(4, "copy"));
        question2.setCorrectAnswer(3);
        question2.printQuestion();
        checkAnswer(question2, scanner.nextInt());

        System.out.println(">---------------------------------------------------<");

        Question question3 = new Question(3, "Какой применяется цикл, когда не известно количество итераций?");
        question3.addAnswer(new Answer(1, "while"));
        question3.addAnswer(new Answer(2, "for"));
        question3.addAnswer(new Answer(3, "loop"));
        question3.setCorrectAnswer(1);
        question3.printQuestion();
        checkAnswer(question3, scanner.nextInt());

        System.out.println(">---------------------------------------------------<");
        System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);
    }

    private void checkAnswer(Question question, int answer){
        if(Objects.equals(question.getCorrectAnswer(), answer)){
            correctCount++;
            System.out.println("Правильно!");
            return;
        }
        wrongCount++;
        System.out.println("Не правильно!");
    }

}
