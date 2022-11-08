package HomeWorkThree;

import java.util.ArrayList;

public class Question {
    private final int number;
    private final String text;
    private final ArrayList<Answer> answers = new ArrayList<>();
    private int correctAnswer;

    public Question(int number, String text){
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void addAnswer(Answer answer){
        this.answers.add(answer);
    }

    public void printQuestion(){
        System.out.println("Вопрос № " + getNumber());
        System.out.println(getText());
        for (Answer answer : answers) {
            System.out.println(answer.getNumber() + " " + answer.getText());
        }
    }

}
