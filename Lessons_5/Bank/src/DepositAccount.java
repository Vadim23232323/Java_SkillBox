import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

    // Депозитный счет с которого нельзя снимать деньги в течение месяца после последнего внесения.
public class DepositAccount extends BankAccount {

    // Задает зеленый цвет текста
    public static final String ANSI_GREEN = "\u001B[32m";
    // Задает стандартный цвет текста
    public static final String ANSI_RESET = "\u001B[0m";

    Scanner scannerWithdrawDeposit = new Scanner(System.in);

    DateFormat format = new SimpleDateFormat("HH:mm MM/dd/yyyy");

    Calendar dateOperatin = Calendar.getInstance();
    Calendar dateNext = Calendar.getInstance();
    Calendar calendar= Calendar.getInstance();
    Date aaa = new Date();



    // Снятия средств со счета
    public void withdrawDepositAccount() {

        dateNext = dateOperatin;

        dateNext.add(dateNext.MONTH, +1);

        calendar.setTime(new Date());

        calendar.add(calendar.MONTH, +2);

        if (calendar.compareTo(dateNext) == 1) {
            super.withdrawMoneyAccount();
        } else {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Вы не можете снять средства! \nДля снятие средств необходимо что бы прошел месяц " +
                    "с момента операции пополнения счета. \nОперация по снятию средств будет доступна: "
                    + ANSI_GREEN + format.format(dateNext.getTime()) + ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        }
    }

    // Пополнение счета
    public void refillDepositAccount () {
        super.refillAccount();
        dateOperatin.setTime(new Date());
        System.out.println("Дата операции: " + format.format(dateOperatin.getTime()));
    }
}
