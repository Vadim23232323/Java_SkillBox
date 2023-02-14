package accounts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BankAccount {

    public int moneyAccount;
    DateFormat format = new SimpleDateFormat("HH:mm MM/dd/yyyy");
    Calendar dateOperatin = Calendar.getInstance();
    public Scanner scannerRefill = new Scanner(System.in);
    public Scanner scannerWithdraw = new Scanner(System.in);


    // Снятия средств со счета
    public void withdrawAccount() {

        int withdrawMoney;

        System.out.println("Введите сумму в белорусских рублях для снятия средств со счета: ");

        withdrawMoney = scannerWithdraw.nextInt();

        if (withdrawMoney > moneyAccount || withdrawMoney <= 0) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Недостаточно средств! Баланс вашего счета составляет: " + Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        } else {
            moneyAccount = moneyAccount - withdrawMoney;
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Операция завершена успешно!");
            System.out.println("Сумма снятая со счета: " + Menu.ANSI_GREEN + withdrawMoney + " BLR" + Menu.ANSI_RESET);
            System.out.println("Баланс вашего счета составляет: " + Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        }

    }

    // Пополнение счета
    public void refillAccount() {

        System.out.println("Введите сумму в белорусских рублях для пополнения баланса:");

        moneyAccount = scannerRefill.nextInt() + moneyAccount;

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Остаток на счете после пополнение баланса: " + Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
        printDateOperation();
        System.out.println("------------------------------------------------------------------------");
    }

    // Печать остатка на счетах
    public void printAccountBalance(BankAccount nameAccount, String name) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("ОСТАТОК НА " + name + ": "+ Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
        System.out.println("------------------------------------------------------------------------");
    }

    // Перевод с депозитного счета на счет
    boolean send(BankAccount receiver, int amount) {
        receiver.moneyAccount = receiver.moneyAccount - amount;
        moneyAccount = moneyAccount + amount;
        System.out.println("Деньги успешно переведены!");
        return true;
    }

    // Дата проведения операции
    public void printDateOperation () {
        dateOperatin.setTime(new Date());
        System.out.println("Дата операции: " + format.format(dateOperatin.getTime()));
    }

}
