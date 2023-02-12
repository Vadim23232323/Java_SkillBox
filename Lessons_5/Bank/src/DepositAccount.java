import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

    // ���������� ���� � �������� ������ ������� ������ � ������� ������ ����� ���������� ��������.
public class DepositAccount extends BankAccount {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";

    Scanner scannerWithdrawDeposit = new Scanner(System.in);

    DateFormat format = new SimpleDateFormat("HH:mm MM/dd/yyyy");

    Calendar dateOperatin = Calendar.getInstance();
    Calendar dateNext = Calendar.getInstance();
    Calendar calendar= Calendar.getInstance();
    Date aaa = new Date();



    // ������ ������� �� �����
    public void withdrawDepositAccount() {

        dateNext = dateOperatin;

        dateNext.add(dateNext.MONTH, +1);

        calendar.setTime(new Date());

        calendar.add(calendar.MONTH, +2);

        if (calendar.compareTo(dateNext) == 1) {
            super.withdrawMoneyAccount();
        } else {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("�� �� ������ ����� ��������! \n��� ������ ������� ���������� ��� �� ������ ����� " +
                    "� ������� �������� ���������� �����. \n�������� �� ������ ������� ����� ��������: "
                    + ANSI_GREEN + format.format(dateNext.getTime()) + ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        }
    }

    // ���������� �����
    public void refillDepositAccount () {
        super.refillAccount();
        dateOperatin.setTime(new Date());
        System.out.println("���� ��������: " + format.format(dateOperatin.getTime()));
    }
}
