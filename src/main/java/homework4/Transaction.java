package homework4;

public class Transaction {
    private final Account moneyFrom;
    private final Account moneyTo;
    private final double money;

    public Transaction(Account moneyFrom, Account moneyTo, double money) {
        this.moneyFrom = moneyFrom;
        this.moneyTo = moneyTo;
        this.money = money;
    }

    public void transferMoney()
            throws InsufficientFundsException {
        if (money > moneyFrom.getBalans()) {
            throw new InsufficientFundsException(String.format("Сумма перевода превышает баланс счёта!!!\n " +
                    "Баланс равен: %.2f!\n",moneyFrom.getBalans()));
        }
        moneyFrom.withdrawMoney(money);
        moneyTo.addAccount(money);

    }


}
