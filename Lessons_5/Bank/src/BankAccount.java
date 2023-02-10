import java.util.Scanner;



public class BankAccount {

    // Задает зеленый цвет текста
    public static final String ANSI_GREEN = "\u001B[32m";
    // Задает стандартный цвет текста
    public static final String ANSI_RESET = "\u001B[0m";

    protected int moneyAccount;

    Scanner scannerMoney = new Scanner(System.in);

    Scanner scannerwithdrawMoney = new Scanner(System.in);


    // Снятия средств со счета
    public void withdrawMoneyAccount() {

        int withdrawMoney;

        System.out.println("Введите сумму в белорусских рублях для снятия средств со счета: ");

        withdrawMoney = scannerwithdrawMoney.nextInt();

        if (withdrawMoney > moneyAccount || withdrawMoney <= 0) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Недостаточно средств! Баланс вашего счета составляет: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        } else {
            moneyAccount = moneyAccount - withdrawMoney;
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Операция завершена успешно!");
            System.out.println("Сумма снятая со счета: " + ANSI_GREEN + withdrawMoney + " BLR" + ANSI_RESET);
            System.out.println("Баланс вашего счета составляет: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        }

    }

    // Пополнение счета
    public void refillAccount() {

        System.out.println("Введите сумму в белорусских рублях для пополнения баланса:");

        moneyAccount = scannerMoney.nextInt();

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Остаток на счете после пополнение баланса: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
        System.out.println("------------------------------------------------------------------------");
    }

    // Печать остатка на счете
    public void printAccountBalance() {
        System.out.println("Остаток: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
    }



}
