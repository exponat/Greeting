package HomeWorkThree;

public class IncorrectAnswer extends Answer{

    public IncorrectAnswer(String text) {
        super(text);
    }
    private final static boolean CORRECT = false;

    public boolean isCorrect() {
        return CORRECT;
    }
}
