package lab;

import java.util.Random;

public class ObjectProblem {
    private Voca Answer;
    private Voca[] Exemple = new Voca[4];
    Random rand = new Random();
    private String[] Korean;

    public ObjectProblem(Voca Answer, Voca[] Exemple) {
        this.Answer = Answer;
        for (int i = 0; i < 4; i++) {
            this.Exemple[i] = Exemple[i];
        }
    }

    public Voca getAnswer() {
        return Answer;
    }

    public String getAnswerEnglish() {
        return Answer.getEnglishVoca();
    }

    public String getAnswerKorean() {
        return Answer.getKoreanVoca()[0];
    }

    public void setAnswer(Voca answer) {
        Answer = answer;
    }

    public Voca[] getExemple() {
        return Exemple;
    }

    public String getExempleKorean(int index) {
        Korean = new String[Exemple[index].getKoreanVoca().length];
        for (int i = 0; i < Exemple[index].getKoreanVoca().length; i++) {
            Korean[i] = Exemple[index].getKoreanVoca()[i];
        }
        return Korean[0];
    }

    public void setExemple(Voca[] exemple) {
        Exemple = exemple;
    }

}