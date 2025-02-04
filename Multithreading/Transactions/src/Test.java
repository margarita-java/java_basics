import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Account> accounts = new HashMap<>();
        accounts.put("111", new Account(100000L, "111"));
        accounts.put("222", new Account(100000L, "222"));
        accounts.put("333", new Account(100000L, "333"));

        Bank bank = new Bank(accounts);

        for (int i = 0; i < 10; i++) {
            String from = i % 2 == 0 ? "111" : "222";
            String to = i % 2 == 0 ? "222" : "333";
            long amount = (i + 1) * 10000;

            TransferTread tread = new TransferTread(bank, from, to, amount);
            tread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Баланс 111: " + bank.getBalance("111"));
        System.out.println("Баланс 222: " + bank.getBalance("222"));
        System.out.println("Баланс 333: " + bank.getBalance("333"));
        System.out.println("Общая сумма в банке: " + bank.getSumAllAccounts());

    }
}
