package HomeWorkThree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class QuizData {
    private int correctCount = 0;
    private int wrongCount = 0;
    private boolean alternativeVersion = false;
    private final ArrayList<Question> quizQuestions = new ArrayList<>();

    public QuizData(){
        Question question1 = new Question(1, "В файл с каким расширением компилируется java-файл?");
        question1.addAnswer(new Answer(1, "cs"));
        question1.addAnswer(new Answer(2, "java"));
        question1.addAnswer(new Answer(3, "class"));
        question1.addAnswer(new Answer(4, "exe"));
        question1.setCorrectAnswer(3);
        quizQuestions.add(question1);

        Question question2 = new Question(2, "С помощью какой команды git можно получить полную копию удаленного репозитория?");
        question2.addAnswer(new Answer(1, "commit"));
        question2.addAnswer(new Answer(2, "push"));
        question2.addAnswer(new Answer(3, "clone"));
        question2.addAnswer(new Answer(4, "copy"));
        question2.setCorrectAnswer(3);
        quizQuestions.add(question2);

        Question question3 = new Question(3, "Какой применяется цикл, когда не известно количество итераций?");
        question3.addAnswer(new Answer(1, "while"));
        question3.addAnswer(new Answer(2, "for"));
        question3.addAnswer(new Answer(3, "loop"));
        question3.setCorrectAnswer(1);
        quizQuestions.add(question3);

    }

    public QuizData(boolean alternativeVersion){
        Question question1 = new Question(2, "В файл с каким расширением компилируется java-файл?");
        question1.addAnswer(new IncorrectAnswer("cs"));
        question1.addAnswer(new IncorrectAnswer( "java"));
        question1.addAnswer(new CorrectAnswer("class"));
        question1.addAnswer(new IncorrectAnswer("exe"));
        quizQuestions.add(question1);

        Question question2 = new Question(1, "С помощью какой команды git можно получить полную копию удаленного репозитория?");
        question2.addAnswer(new IncorrectAnswer("commit"));
        question2.addAnswer(new IncorrectAnswer("push"));
        question2.addAnswer(new CorrectAnswer( "clone"));
        question2.addAnswer(new IncorrectAnswer("copy"));
        quizQuestions.add(question2);

        Question question3 = new Question(3, "Какой применяется цикл, когда не известно количество итераций?");
        question3.addAnswer(new CorrectAnswer("while"));
        question3.addAnswer(new IncorrectAnswer("for"));
        question3.addAnswer(new IncorrectAnswer("loop"));
        quizQuestions.add(question3);

        this.alternativeVersion = alternativeVersion;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        if(alternativeVersion) {
            quizQuestions.sort(Comparator.comparing(Question::getNumber));
            for(Question question : quizQuestions){
                question.print();
                try {
                    checkAnswer(question.getAnswers().get(scanner.nextInt() - 1));
                }
                catch(Exception e){
                    System.out.println("Ответа с таким номером нет! Засчитано как не правильный ответ!");
                    wrongCount++;
                }
                System.out.println(">---------------------------------------------------<");
            }
        }
        else{
            for(Question question : quizQuestions) {
                question.printQuestion();
                checkAnswer(question, scanner.nextInt());
                System.out.println(">---------------------------------------------------<");
            }
        }
        System.out.println("Результат: правильно " + correctCount + ", не правильно " + wrongCount);
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
    private void checkAnswer(Answer answer){
        if(answer.isCorrect()){
            correctCount++;
            System.out.println("Правильно!");
            return;
        }
        wrongCount++;
        System.out.println("Не правильно!");
    }

}
