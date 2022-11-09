package HomeWorkThree;

public class Answer {
    private int number;
    private final String text;
    private boolean correct;

    public Answer(String text){
        this.text = text;
    }
    public Answer(int number, String text){
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return correct;
    }

}
