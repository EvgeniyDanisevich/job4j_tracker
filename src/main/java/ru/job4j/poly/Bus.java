package ru.job4j.poly;

public class Bus implements Transport {
    int passengers;
    int fuelPrice = 10;

    @Override
    public void go() {
    }

    @Override
    public void passengers(int passengersNumber) {
        passengers = passengersNumber;
    }

    @Override
    public double refuel(double fuelQuantity) {
        return fuelQuantity * fuelPrice;
    }
}
