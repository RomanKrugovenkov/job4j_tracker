package ru.job4j.bank;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class BankServiceStreamTest {
    public BankServiceStreamTest() {
    }

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434")).isEqualTo(user);
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150.0D));
        assertThat(bank.findByRequisite("34", "5546")).isNull();
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150.0D));
        assertThat(bank.findByRequisite("3434", "5546").getBalance())
                .isEqualTo(150.0D);
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150.0D));
        bank.addAccount(user.getPassport(), new Account("113", 50.0D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150.0D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance())
                .isEqualTo(200.0D);
    }

}