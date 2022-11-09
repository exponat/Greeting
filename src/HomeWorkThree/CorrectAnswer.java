package HomeWorkThree;

public class CorrectAnswer extends Answer{

    public  CorrectAnswer(String text) {
        super(text);
    }
    private final static boolean CORRECT = true;

    public boolean isCorrect() {
        return CORRECT;
    }

}
