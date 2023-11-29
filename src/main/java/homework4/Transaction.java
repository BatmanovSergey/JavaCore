package homework4;

public class Transaction {
    private final Account account1;
    private final Account account2;
    private final double money;

    public Transaction(Account account1, Account account2, double money) {
        this.account1 = account1;
        this.account2 = account2;
        this.money = money;
    }

    public void transferMoney()
            throws InsufficientFundsException {
        if (money > account1.getBalans()) {
            throw new InsufficientFundsException(String.format("Сумма перевода превышает баланс счёта!!!\n " +
                    "Баланс равен: %.2f!\n",account1.getBalans()));
        }
        account1.withdrawMoney(money);
        account2.addAccount(money);

    }


}
