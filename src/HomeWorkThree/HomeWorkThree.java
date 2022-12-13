package HomeWorkThree;

public class HomeWorkThree {

    public static void main(String[] args) {
        QuizData quiz = new QuizData();
        quiz.start();
        System.out.println("!!!!!!!!!!!!!!!!!");
        System.out.println("Вторая реализация");
        System.out.println("!!!!!!!!!!!!!!!!!");
        QuizData quiz2 = new QuizData(true);
        quiz2.start();
    }
}
