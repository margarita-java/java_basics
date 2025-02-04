public class TransferTread extends Thread {

    private final Bank bank;
    private final String fromAccount;
    private final String toAccount;
    private final long amount;

    public TransferTread(Bank bank, String fromAccount, String toAccount, long amount) {
        this.bank = bank;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        bank.transfer(fromAccount, toAccount, amount);
    }
}
