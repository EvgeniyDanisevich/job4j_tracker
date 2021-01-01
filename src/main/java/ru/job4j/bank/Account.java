package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных банковского счета
 * @version 1.0
 */
public class Account {
    /**
     * Хранение номера счета в переменной типа String
     * и хранение баланса в переменной типа double
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор банковского счета
     * @param requisite номер счета
     * @param balance баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Позволяет получить номер банковского счета
     * @return номер банковского счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Позволяет ввести номер банковского счета
     * @param requisite номер банковского счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Позволяет получить баланс банковского счета
     * @return баланс банковского счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Позволяет ввести баланс банковского счета
     * @param balance баланс банковского счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает банковские счета по номеру счета
     * @param o объект класса Account
     * @return результат сравнения банковских счетов
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Генерирует хэш-код на основе номера счета
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}