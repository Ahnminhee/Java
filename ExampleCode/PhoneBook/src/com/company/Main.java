package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PhoneManager manager = new PhoneManager();
        int choice;

        while(true) {
            show.showMenu();
            choice = show.sc.nextInt();
            show.sc.nextLine();

            switch (choice) {
                case 1 :
                    manager.InputData();
                    break;
                case 2 :
                    manager.searchData();
                    break;
                case 3 :
                    manager.deleteData();
                    break;
                case 4 :
                    System.out.println("프로그램 종료");
                    return;

            }
        }
    }
}

class PhoneInfo {
    String name;
    String phoneNumber;
    String date;

    public PhoneInfo(String name, String phoneNumber, String date) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date = date;
    }

    public PhoneInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date = null;
    }

    public void showPhoneInfo() {
        System.out.println("이름 : " + name);
        System.out.println("전화번호 : " + phoneNumber);
        if(date != null) {
            System.out.println("생년월일 : " + date);
        }
    }
}

class PhoneManager {
    PhoneInfo[] info = new PhoneInfo[10];
    int count =0;

    public void InputData() {
        System.out.println("데이터 입력을 시작");

        System.out.print("이름 : ");
        String name = show.sc.nextLine();
        System.out.print("전화번호 : ");
        String phone = show.sc.nextLine();
        System.out.print("생년월일 : ");
        String date = show.sc.nextLine();

        info[count] = new PhoneInfo(name, phone, date);
        count++;

    }

    public void searchData() {
        System.out.println("데이터 검색 시작 ");

        System.out.print("이름 : ");
        String name = show.sc.nextLine();

        if(search(name) < 0) {
            System.out.println("데이터가 없습니다");
        } else {
            info[search(name)].showPhoneInfo();
            System.out.println("데이터가 있습니다");
        }

    }

    public void deleteData() {
        System.out.println("데이터 삭제 시작");

        System.out.print("이름 : ");
        String name = show.sc.nextLine();

        if(search(name) < 0 ){
            System.out.println("데이터가 없습니다");
        } else {
            for(int i = search(name); i < count-1 ; i++) {
                info[i] = info[i+1];

                count--;
                System.out.println("데이터 삭제 성공");
            }
        }
    }

    private int search(String name) {
        for (int i =0; i < count; i++) {
            PhoneInfo curInfo = info[i];
            if(name.compareTo(curInfo.name)==0)
                return i;
        }
        return -1;
    }

}

class show {
    public static Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("선택하세요");
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 검색");
        System.out.println("3. 데이터 삭제");
        System.out.println("4. 종료");
        System.out.println("선택 : ");
    }
}
