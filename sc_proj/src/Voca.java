package lab;

import java.util.Arrays;

public class Voca implements Comparable<Voca>{
    private int IDnum;
    private String EnglishVoca;
    private String[] KoreanVoca;
    private int count = 0;

    public Voca(int iDnum, String englishVoca) {
        super();
        IDnum = iDnum;
        EnglishVoca = englishVoca;
        this.KoreanVoca = new String[0];
    }
    public int getIDnum() {
        return IDnum;
    }
    public void setIDnum(int iDnum) {
        IDnum = iDnum;
    }
    public String getEnglishVoca() {
        return EnglishVoca;
    }
    public void setEnglishVoca(String englishVoca) {
        EnglishVoca = englishVoca;
    }
    public String[] getKoreanVoca() {
        return KoreanVoca;
    }
    public void setKoreanVoca(String[] koreanVoca) {
        KoreanVoca = koreanVoca;
    }

    public void addKoreanVoca(String Korean) {
        String[] temp = new String[this.KoreanVoca.length];
        for(int i=0; i<this.KoreanVoca.length; i++) {
            temp[i]= this.KoreanVoca[i];
        }
        this.KoreanVoca = new String[this.KoreanVoca.length+1];
        for(int i=0; i<temp.length; i++) {
            this.KoreanVoca[i] = temp[i];
        }
        this.KoreanVoca[this.KoreanVoca.length-1] = Korean;

    }
    @Override
    public String toString() {
        return "Voca [IDnum=" + IDnum + ", EnglishVoca=" + EnglishVoca + ", KoreanVoca=" + Arrays.toString(KoreanVoca)
                + "]";
    }
    public int getCount() {
        return count;
    }
    public void addCount() {
        this.count++;
    }
    public int compareTo(Voca o) {
        // TODO Auto-generated method stub
        return o.count-count;
    }

}
