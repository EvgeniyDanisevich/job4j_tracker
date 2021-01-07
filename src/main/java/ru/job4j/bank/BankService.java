package ru.job4j.bank;

import java.util.*;

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
        Optional<User> opUser = findByPassport(passport);
        if (opUser.isPresent()) {
            if (!users.get(opUser.get()).contains(account)) {
                users.get(opUser.get()).add(account);
            }
        }
    }

    /**
     * Позволяет найти клиента банка в базе
     * по номеру паспорта, возвращает null если
     * клиент не найден
     * @param passport номер паспорта
     * @return клиент банка или null
     */
//    public User findByPassport(String passport) {
//
////        for (User user : users.keySet()) {
////            if (user.getPassport().equals(passport)) {
////                return user;
////            }
////        }
////        return null;
//
//        return users.keySet()
//                .stream()
//                .filter(user -> user.getPassport().equals(passport))
//                .findFirst()
//                .orElse(null);
//    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    /**
     * Позволяет найти банковский счет по номеру паспорта и
     * по номеру счета, возвращает null если счет не найден
     * @param passport номер паспорта
     * @param requisite номер банковского счета
     * @return банковский счет или null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = Optional.of(account);
                    break;
                }
            }
        }
        return rsl;
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            if (srcAccount.get().getBalance() >= amount) {
                srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
