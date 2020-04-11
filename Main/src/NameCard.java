public class NameCard {
    String company;
    String name;
    String phoneNumber;

    public NameCard(String company, String name, String phoneNumber)
    {
        this.company = company;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setCompany(String com)
    {
        company = com;
    }

    public void setName(String na)
    {
        name = na;
    }

    public void setPhoneNumber(String pn)
    {
        phoneNumber = pn;
    }

    public int getInf()
    {
        System.out.println("회사명 : "+company);
        System.out.println("이름 : "+name);
        System.out.println("전화번호 : "+phoneNumber);
        System.out.println("--------------------------------");

        return 0;
    }
}
