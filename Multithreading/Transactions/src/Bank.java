import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {

        if (!accounts.containsKey(fromAccountNum) || !accounts.containsKey(toAccountNum)) {
            System.out.println("Аккаунт не найден!");
            return;
        }

        Account from = accounts.get(fromAccountNum);
        Account to = accounts.get(toAccountNum);

        Account first = from.getAccNumber().compareTo(to.getAccNumber()) < 0 ? from : to;
        Account second = first == from ? to : from;

        synchronized (first) {
            synchronized (second) {
                if (from.getMoney() < amount) {
                    System.out.println("Недостаточно средств!");
                    return;
                }

                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Перевод" + amount + " с " + fromAccountNum + " на " + toAccountNum);

                if (amount > 50000) {
                    try {
                        if (isFraud(fromAccountNum, toAccountNum, amount)) {
                            System.out.println("Мошенническая операция! Блокировка счёта!");
                            return;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public synchronized long getBalance(String accountNum) {
        return accounts.getOrDefault(accountNum, new Account(0, accountNum)).getMoney();
    }

    public synchronized long getSumAllAccounts() {
        return accounts.values().stream().mapToLong(Account::getMoney).sum();
    }
}
