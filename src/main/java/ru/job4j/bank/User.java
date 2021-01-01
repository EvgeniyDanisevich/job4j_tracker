package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных клиента банка
 * @version 1.0
 */
public class User {
    /**
     * Хранение номера паспорта и имени клиента банка
     * в переменных типа String
     */
    private String passport;
    private String username;

    /**
     * Конструктор класса, принимает две строки
     * @param passport номер паспорта клиента банка
     * @param username имя клиента банка
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Позволяет получить номер паспорта
     * @return номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Позволяет ввести номер паспорта
     * @param passport номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Позволяет получить имя клиента банка
     * @return имя клиента банка
     */
    public String getUsername() {
        return username;
    }

    /**
     * Позволяет ввести имя клиента банка
     * @param username имя клинта банка
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает клиентов банка по номеру паспорта
     * @param o объект класса User
     * @return значение сравнения клиентов банка
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Генерирует хэш-код на основе номера паспорта
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}