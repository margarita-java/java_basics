

public class Account {

    private long money;
    private String accNumber;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }


    public synchronized long getMoney() {
        return money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public synchronized void deposit(long amount) {
        money += amount;
    }

    public synchronized void withdraw(long amount) {
        money -= amount;
    }


}
