import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("회사명을 입력해주세요. ");
        String getCompany = sc.nextLine();
        System.out.print("이름을 입력해주세요. ");
        String getName = sc.nextLine();
        System.out.print("전화번호를 입력해주세요. ");
        String getNumber = sc.nextLine();

        NameCard nc = new NameCard(getCompany, getName, getNumber);
        System.out.println(nc.getInf());
    }
}
