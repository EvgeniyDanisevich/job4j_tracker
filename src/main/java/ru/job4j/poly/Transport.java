package ru.job4j.poly;

public interface Transport {
    void go();

    void passengers(int passengersNumber);

    double refuel(double fuel);
}
