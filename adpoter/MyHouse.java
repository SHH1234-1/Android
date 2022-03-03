package com.example.myfragment.adapter;

public class MyHouse {

    public static void main(String[] args) {

        AirConditioner airConditioner = new AirConditioner();
        connect(airConditioner);

        HairDryer hairDryer = new HairDryer();
        ElectronicAdapter electronicAdapter1 = new ElectronicAdapter(hairDryer);
        connect(electronicAdapter1);

        Cleaner cleaner = new Cleaner();
        ElectronicAdapter electronicAdapter2 = new ElectronicAdapter(cleaner);
        connect(electronicAdapter2);
        //connect(cleaner);
//        connect(hairDryer);
    }

    // 전기 콘센트
    public static void connect(Electronic220v electronic220v) {
        electronic220v.connect();
    }
}