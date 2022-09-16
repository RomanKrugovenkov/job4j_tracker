package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс
 */
public class BankServiceStream {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает параметры пользователя и добавляет их в список users,
     * если такого пользователя нет в списке
     *
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает паспортные данные и данные аккаунта
     * Если пользователь с таким паспортом существует, а такого аккаунта у него еще нет,
     * то добавляет новый аккаунт для этого пользователя
     *
     * @param passport паспортные данные пользователя
     * @param account  данные аккаунта
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод принимает паспортные данные и ищет совпадение в списке пользователей
     * Если находит совпадение, то возвращает пользователя user
     * Если не находит - null
     *
     * @param passport паспортные данные пользователя
     * @return возвращает пользователя при совпадении или null если совпадения нет
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод принимает паспортные данные и реквизиты
     * Ищет совпадение паспорта в списке пользователей
     * Если находит совпадение, то начинает поиск по аккаунтам на совпадения реквизитов
     * Если находит, то возвращает данные аккаунта
     *
     * @param passport  паспортные данные пользователя
     * @param requisite реквизиты аккаунта пользователя
     * @return возвращает данные аккаунта пользователя или null если реквизиты не совпали
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(acc -> requisite.equals(acc.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод принимает паспортные данные отправителя и получателя
     * + реквизиты их аккаунтов и сумму перевода
     * Если пользователи и аккаунты существуют,
     * то сумма перевода списывается с балланса отправителя и добавляется к баллансу получателя
     *
     * @param srcPassport   паспортные данные отправителя
     * @param srcRequisite  реквизиты отправителя
     * @param destPassport  паспортные данные получателя
     * @param destRequisite реквизиты получателя
     * @param amount        сумма перевода
     * @return возвращает true если перевод произошел успешно
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
