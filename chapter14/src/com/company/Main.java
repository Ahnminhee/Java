package com.company;

import java.nio.file.FileSystemNotFoundException;

public class Main {

    public static void main(String[] args) {
	    HybridWaterCar car1 = new HybridWaterCar(4,2,3);
	    System.out.println("--- 첫번째 차 ---");
	    car1.showCurrentGauge();

	    System.out.println(" ");

	    HybridWaterCar car2 = new HybridWaterCar(7,6,8);
        System.out.println("--- 두번째 차 ---");
	    car2.showCurrentGauge();
    }
}

class Car {
    int gasolineGauge;

    public Car (int gasolineGauge) {
        this.gasolineGauge = gasolineGauge;
    }
}

class HybridCar extends Car {
    int electricGauge;

    public HybridCar(int gasolineGauge, int electricGauge) {
        super(gasolineGauge);
        this.electricGauge = electricGauge;
    }
}

class HybridWaterCar extends HybridCar {
    int waterGauge;

    public HybridWaterCar(int gasolineGauge, int electricGauge, int waterGauge) {
        super(gasolineGauge, electricGauge);
        this.waterGauge = waterGauge;
    }
    public void showCurrentGauge() {
        System.out.println("잔여 가솔린 : " + gasolineGauge);
        System.out.println("잔여 전기량 : " + electricGauge);
        System.out.println("잔여 워터량 : " + waterGauge);
    }
}