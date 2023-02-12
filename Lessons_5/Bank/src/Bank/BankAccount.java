package Bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BankAccount {

    String nameAccount = "C����";
    int moneyAccount;
    DateFormat format = new SimpleDateFormat("HH:mm MM/dd/yyyy");
    Calendar dateOperatin = Calendar.getInstance();
    Scanner scannerMoney = new Scanner(System.in);
    Scanner scannerwithdrawMoney = new Scanner(System.in);


    // ������ ������� �� ����� � ��������
    void withdrawMoneyAccount() {

        int withdrawMoney;

        System.out.println("������� ����� � ����������� ������ ��� ������ ������� �� �����: ");

        withdrawMoney = scannerwithdrawMoney.nextInt();

        if (withdrawMoney > moneyAccount || withdrawMoney <= 0) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("������������ �������! ������ ������ ����� ����������: " + Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        } else {
            moneyAccount = moneyAccount - withdrawMoney;
            System.out.println("------------------------------------------------------------------------");
            System.out.println("�������� ��������� �������!");
            System.out.println("����� ������ �� �����: " + Menu.ANSI_GREEN + withdrawMoney + " BLR" + Menu.ANSI_RESET);
            System.out.println("������ ������ ����� ����������: " + Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        }

    }

    // ���������� �����
    void refillAccount() {

        System.out.println("������� ����� � ����������� ������ ��� ���������� �������:");

        moneyAccount = scannerMoney.nextInt();

        System.out.println("------------------------------------------------------------------------");
        System.out.println("������� �� ����� ����� ���������� �������: " + Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
        dateOperatin.setTime(new Date());
        System.out.println("���� ��������: " + format.format(dateOperatin.getTime()));
        System.out.println("------------------------------------------------------------------------");
    }

    // ������ ������� �� ������
    void printAccountBalance(BankAccount nameAccount, String name) {
        System.out.println("������� �� " + name + ": "+ Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
        System.out.println("------------------------------------------------------------------------");
    }

    // ������� � ����������� ����� �� ����
    boolean send(BankAccount receiver, int amount) {
        receiver.moneyAccount = receiver.moneyAccount - amount;
        moneyAccount = moneyAccount + amount;
        System.out.println("������ ������� ����������!");
        return true;
    }


}
