package Bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BankAccount {

    String nameAccount = "CЧЕТЕ";
    int moneyAccount;
    DateFormat format = new SimpleDateFormat("HH:mm MM/dd/yyyy");
    Calendar dateOperatin = Calendar.getInstance();
    Scanner scannerMoney = new Scanner(System.in);
    Scanner scannerwithdrawMoney = new Scanner(System.in);


    // Снятия средств со счета с условием
    void withdrawMoneyAccount() {

        int withdrawMoney;

        System.out.println("Введите сумму в белорусских рублях для снятия средств со счета: ");

        withdrawMoney = scannerwithdrawMoney.nextInt();

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
    void refillAccount() {

        System.out.println("Введите сумму в белорусских рублях для пополнения баланса:");

        moneyAccount = scannerMoney.nextInt();

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Остаток на счете после пополнение баланса: " + Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
        dateOperatin.setTime(new Date());
        System.out.println("Дата операции: " + format.format(dateOperatin.getTime()));
        System.out.println("------------------------------------------------------------------------");
    }

    // Печать остатка на счетах
    void printAccountBalance(BankAccount nameAccount, String name) {
        System.out.println("Остаток на " + name + ": "+ Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
        System.out.println("------------------------------------------------------------------------");
    }

    // Перевод с депозитного счета на счет
    boolean send(BankAccount receiver, int amount) {
        receiver.moneyAccount = receiver.moneyAccount - amount;
        moneyAccount = moneyAccount + amount;
        System.out.println("Деньги успешно переведены!");
        return true;
    }


}
