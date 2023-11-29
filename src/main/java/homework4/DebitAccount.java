package homework4;

public class DebitAccount extends Account {
    private DebitAccount(double balans) {
        super(balans);
    }

    public static DebitAccount creater(double balans) {
        if (balans < 0) {
            throw new IllegalArgumentException("Вы ввели отрицательный баланс счёта");
        }
        return new DebitAccount(balans);
    }
    @Override
    public String toString() {
        return "Баланс средств дебетового счёта составляет: " + getBalans() + "\n";
    }
}
