package lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Vocabulary {
    private List<Voca> Vocas;
    private int TotalNum;
    private String Filename;
    private HashMap<String, String> wordMap;
    private Scanner sc = new Scanner(System.in);

    public int getTotalNum() {
        return TotalNum;
    }

    public Vocabulary(String FileName) {
        this.Filename = FileName;
        this.TotalNum = 0;
        File file = new File(FileName);
        Vocas = new ArrayList<Voca>();
        wordMap = new HashMap<>();
        Scanner sc = null;
        try {
            sc = new Scanner(file, "UTF-8");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int count = 1;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] tmp_list = str.split("\\s:\\s");
            wordMap.put(tmp_list[0], tmp_list[1]);
            Voca temp2 = new Voca(count, tmp_list[0]);
            String[] KRMean = tmp_list[1].split("/ ");
            for (int i = 0; i < KRMean.length; i++) {
                temp2.addKoreanVoca(KRMean[i]);
            }
            Vocas.add(temp2);
            TotalNum++;
            count++;
        }
    }

    public Voca[] getSubjectProblem() {
        Random rand = new Random();
        int[] intArr = new int[5];
        for (int i = 0; i < 5; i++) {
            int temp = rand.nextInt(TotalNum);
            boolean success = true;
            for (int j = 0; j < i; j++) {
                if (intArr[j] == temp) {
                    success = false;
                    break;
                }
            }
            if (success) {
                intArr[i] = temp;
            } else {
                i--;
            }
        }

        Voca[] result = new Voca[5];
        for (int i = 0; i < 5; i++) {
            result[i] = Vocas.get(intArr[i]);
            Vocas.get(intArr[i]).addCount();
        }
        return result;
    }

    public ObjectProblem[] getObjectProblem() {
        Random rand = new Random();
        int[] AnsArr = new int[5];
        ObjectProblem[] result = new ObjectProblem[5];
        for (int z = 0; z < 5; z++) {
            int[] intArr = new int[4];
            for (int i = 0; i < 4; i++) {
                int temp = rand.nextInt(TotalNum);
                boolean success = true;
                for (int j = 0; j <= i; j++) {
                    if (intArr[j] == temp) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    intArr[i] = temp;
                } else {
                    i--;
                }

            }
            int ddtemp = rand.nextInt(4);
            while (true) {

                boolean success = true;
                for (int i = 0; i < z; i++) {
                    if (AnsArr[i] == intArr[ddtemp]) {
                        success = false;
                        break;
                    }
                }
                if (success)
                    break;
                else
                    ddtemp = rand.nextInt(4);
            }
            AnsArr[z] = intArr[ddtemp];
            Vocas.get(intArr[ddtemp]).addCount();
            Voca[] d = new Voca[4];
            for (int i = 0; i < 4; i++) {
                d[i] = Vocas.get(intArr[i]);
            }

            result[z] = new ObjectProblem(Vocas.get(AnsArr[z]), d);
        }

        return result;
    }

    public boolean AddWord() {
        System.out.print("영어를 입력하세요 : ");
        String eng = sc.nextLine();
        System.out.print("한글 뜻을 입력하세요 : ");
        String kor = sc.nextLine();

        if (wordMap.containsKey(eng)) {
            System.out.println("중복 단어입니다.");
            return false;
        }

        else {
            Voca temp = new Voca(Vocas.size(), eng);
            String[] KRMean = kor.split("/ ");
            for (int i = 0; i < KRMean.length; i++) {
                temp.addKoreanVoca(KRMean[i]);
            }

            Vocas.add(temp);
            System.out.println("입력 하신 단어정보 // " + temp.toString());
            return true;
        }
    }

    public String printFrequancy(int sel) {
        switch (sel) {
            case 1:
                return printFrequancyUp();
            case 2:
            default:
                return printFrequancyDown();
        }
    }

    public String printFrequancyUp() {
        String res = "";
        Collections.sort(Vocas);
        List<Voca> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            temp.add(Vocas.get(i));
        }
        for (int i = 0; i < 10; i++) {
            System.out.print("[" + (i + 1) + "]");
            res += "[" + (i + 1) + "]";
            System.out.print(temp.get(i).getEnglishVoca() + ":");
            res += temp.get(i).getEnglishVoca() + ":";

            for (String c : temp.get(i).getKoreanVoca()) {
                System.out.print(c + "/");
                res += c + "/";
            }
            System.out.println(temp.get(i).getCount() + "회");
            res += temp.get(i).getCount() + "회\n";
        }
        return res;
    }

    public String printFrequancyDown() {
        String res = "";
        Collections.sort(Vocas);
        List<Voca> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            temp.add(Vocas.get(i));
        }
        Collections.reverse(temp);
        for (int i = 0; i < 10; i++) {
            System.out.print("[" + (i + 1) + "]");
            res += "[" + (i + 1) + "]";
            System.out.print(temp.get(i).getEnglishVoca() + ":");
            res += temp.get(i).getEnglishVoca() + ":";

            for (String c : temp.get(i).getKoreanVoca()) {
                System.out.print(c + "/");
                res += c + "/";
            }
            System.out.println(temp.get(i).getCount() + "회");
            res += temp.get(i).getCount() + "회\n";
        }
        return res;
    }
}
