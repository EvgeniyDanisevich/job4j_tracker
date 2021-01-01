package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банка, позволяя добавлять клиентов,
 * добавлять клиентам счета, искать клиентов в базе, делать
 * денежные переводы со счета на счет
 * @author CHUCK NORRIS
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение базы клиентов банко в переменной типа HashMap.
     * Ключ - клиент банка,
     * Значение - список банковских счетов клиента
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет в базу нового клиента банка,
     * если такой клиент отсутствует в базе
     * @param user клиент банка
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавляет клиенту банка, найденному по номеру паспорта,
     * новый банковский счет, если такого счета у клиента нет
     * @param passport номер паспорта клиента
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Позволяет найти клиента банка в базе
     * по номеру паспорта, возвращает null если
     * клиент не найден
     * @param passport номер паспорта
     * @return клиент банка или null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Позволяет найти банковский счет по номеру паспорта и
     * по номеру счета, возвращает null если счет не найден
     * @param passport номер паспорта
     * @param requisite номер банковского счета
     * @return банковский счет или null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (accounts != null) {
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Позволяет произвести денежный перевод конкретной суммы с одного банковского счета
     * на другой по номерам паспортов клиентов и номерам счетов.
     * В случае отсутствия номеров паспортов или
     * номеров счетов, а также нехватки денежных средств на балансе счета, с которого идет
     * списание средств, возвращает false
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite номер счета отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite номер счета получателя
     * @param amount сумма
     * @return успешность операции
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (!(srcAccount == null || destAccount == null || srcAccount.getBalance() < amount)) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
