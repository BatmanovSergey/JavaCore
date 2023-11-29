package homework4;

public abstract class Account {
    private double balans;
    protected Account(double balans) {
        this.balans = balans;
    }

    protected void addAccount (double sum) {
        if (sum < 0) {
            throw new IllegalArgumentException("Вы ввели отрицательную сумму пополнения счёта");
        }
        balans += sum;
    }

    protected void withdrawMoney (double sum) throws InsufficientFundsException {
        if (sum < 0) {
            throw new InsufficientFundsException("Вы ввели не корректную сумму снятия");
        }
        if (sum > balans) {
            throw new InsufficientFundsException("Недостаточно средств для снятия на текущем счёте");
        }
        balans -= sum;
    }
    public double getBalans() {
        return balans;
    }

}
