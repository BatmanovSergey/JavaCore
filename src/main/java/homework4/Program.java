package homework4;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        DebitAccount debitAccount = null;
        CreditAccount creditAccount = null;

        System.out.println("1. Создайте счета:");

        while (true) {
            try {
                if ((debitAccount == null)) {
                    double money = prompt("Введите сумму для открытия дебетового счёта: \n");
                    debitAccount = DebitAccount.creater(money);
                    System.out.println("Дебетовый счёт открыт!\n" + debitAccount);
                }
                if ((creditAccount == null)) {
                    double money = prompt("Введите сумму для открытия кредитного счёта:\n");
                    creditAccount = CreditAccount.creater(money);
                    System.out.println("Кредитный счёт открыт!\n" + creditAccount);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода данных");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("2. Пополнить дебетовый счёт:");

        while (true) {
            try {
                double money = prompt("Введите сумму для пополнения дебетового счёта:\n");
                debitAccount.addAccount(money);
                System.out.printf("Дебетовый счёт пополнен на %.2f!\n Баланс составляет - %.2f\n",
                        money, debitAccount.getBalans());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода данных");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("3. Снятие с дебетового счёта:");

        while (true) {
            try {
                double money = prompt("Введите сумму снятия с дебетового счёта:\n");
                debitAccount.withdrawMoney(money);
                System.out.printf("Дебетовый счёт опустел на %.2f!\n Баланс составляет - %.2f\n",
                        money, debitAccount.getBalans());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода данных");
            } catch (InsufficientFundsException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("4. Перевод со счета на счёт:");
        System.out.println(debitAccount);
        System.out.println(creditAccount);
        while (true) {
            try {
                double money = prompt("Введите сумму перевода с дебетового счёта:\n");
                Transaction transaction = new Transaction(debitAccount,creditAccount,money);
                transaction.transferMoney();
                System.out.printf("Кредитный счёт пополнен на %.2f!\n " +
                                "Баланс составляет - %.2f\n " +
                                "Дебетовый счёт опустел на %.2f!\n " +
                                "Баланс составляет - %.2f\n",
                        money, creditAccount.getBalans(), money, debitAccount.getBalans());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода данных");
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }
}
