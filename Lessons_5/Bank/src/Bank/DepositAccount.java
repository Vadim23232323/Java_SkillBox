package Bank;

import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

    // ���������� ���� � �������� ������ ������� ������ � ������� ������ ����� ���������� ��������.
public class DepositAccount extends BankAccount {

    String nameAccount = "���������� C����";
    Scanner scannerWithdrawDeposit = new Scanner(System.in);
    Calendar dateNext = Calendar.getInstance();
    Calendar calendar= Calendar.getInstance();

    // ������ ������� �� �����
    void withdrawDepositAccount() {

        dateNext = super.dateOperatin;

        dateNext.add(dateNext.MONTH, +1);

        calendar.setTime(new Date());

        calendar.add(calendar.MONTH, +2);

        if (calendar.compareTo(dateNext) == 1) {
            super.withdrawMoneyAccount();
        } else {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("�� �� ������ ����� ��������! \n��� ������ ������� ���������� ��� �� ������ ����� " +
                    "� ������� �������� ���������� �����. \n�������� �� ������ ������� ����� ��������: "
                    + Menu.ANSI_GREEN + format.format(dateNext.getTime()) + Menu.ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        }
    }

    // ���������� �����
    void refillDepositAccount () {
        super.refillAccount();
    }
}
