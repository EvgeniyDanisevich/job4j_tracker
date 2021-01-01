package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery batteryOne = new Battery(10);
        Battery batteryTwo = new Battery(15);
        System.out.println("Before exchange: batteryOne "
                + batteryOne.load + ". " + "batteryTwo " + batteryTwo.load);
        batteryOne.exchange(batteryTwo);
        System.out.println("After exchange: batteryOne "
                + batteryOne.load + ". " + "batteryTwo " + batteryTwo.load);
    }
}
