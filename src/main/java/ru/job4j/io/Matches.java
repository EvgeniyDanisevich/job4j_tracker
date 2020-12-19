package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        while (matches > 0) {
            System.out.println("Первый игрок забирает спички...");
            int select = Integer.valueOf(input.nextLine());
            while (select > 3 || select < 1) {
                System.out.println("Неверное значение. Введите целое число от 1 до 3");
                select = Integer.valueOf(input.nextLine());
            }
            if (matches - select > 0) {
                matches = matches - select;
                System.out.println("На столе осталось спичек: " + matches);
            } else {
                System.out.println("На столе не осталось спичек. Первый игрок победил.");
                break;
            }
            System.out.println("Второй игрок забирает спички...");
            select = Integer.valueOf(input.nextLine());
            while (select > 3 || select < 1) {
                System.out.println("Неверное значение. Введите целое число от 1 до 3");
                select = Integer.valueOf(input.nextLine());
            }
            if (matches - select > 0) {
                matches = matches - select;
                System.out.println("На столе осталось спичек: " + (matches));
            } else {
                System.out.println("На столе не осталось спичек. Второй игрок победил.");
                break;
            }
        }
    }
}
