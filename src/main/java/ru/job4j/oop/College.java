package ru.job4j.oop;

/** Такое приведение типов
 *  является повышающим
 */

public class College {
    Freshman freshman = new Freshman();
    Student student = freshman;
    Object ob = freshman;
}
