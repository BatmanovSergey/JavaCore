package homework4;

public class CreditAccount extends Account {
    private CreditAccount(double balans) {
        super(balans);
    }

    public static CreditAccount creater(double balans) {
        if (balans < 0) {
            throw new IllegalArgumentException("Вы ввели отрицательный баланс счёта");
        }
        return new CreditAccount(balans);
    }

    @Override
    public String toString() {
        return "Баланс средств кредитного счёта составляет: " + getBalans() + "\n";
    }


}
