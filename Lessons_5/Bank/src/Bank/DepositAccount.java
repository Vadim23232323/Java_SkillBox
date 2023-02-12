package Bank;

import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

    // Депозитный счет с которого нельзя снимать деньги в течение месяца после последнего внесения.
public class DepositAccount extends BankAccount {

    String nameAccount = "ДЕПОЗИТНОМ CЧЕТЕ";
    Scanner scannerWithdrawDeposit = new Scanner(System.in);
    Calendar dateNext = Calendar.getInstance();
    Calendar calendar= Calendar.getInstance();

    // Снятия средств со счета
    void withdrawDepositAccount() {

        dateNext = super.dateOperatin;

        dateNext.add(dateNext.MONTH, +1);

        calendar.setTime(new Date());

        calendar.add(calendar.MONTH, +2);

        if (calendar.compareTo(dateNext) == 1) {
            super.withdrawMoneyAccount();
        } else {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Вы не можете снять средства! \nДля снятие средств необходимо что бы прошел месяц " +
                    "с момента операции пополнения счета. \nОперация по снятию средств будет доступна: "
                    + Menu.ANSI_GREEN + format.format(dateNext.getTime()) + Menu.ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        }
    }

    // Пополнение счета
    void refillDepositAccount () {
        super.refillAccount();
    }
}
