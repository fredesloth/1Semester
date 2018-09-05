package opgave2multiplechoice;

public class MultipleChoiceApp {

    public static void main(String[] args) {
        MultipleChoice mc = new MultipleChoice(3);
        mc.printCorrectAnswers();
        System.out.println();
        mc.printStudentAnswers();
        mc.printCorrectAnswersPrStudent();
    }

}
