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


    // ������ ������� �� �����
    public void withdrawAccount() {

        int withdrawMoney;

        System.out.println("������� ����� � ����������� ������ ��� ������ ������� �� �����: ");

        withdrawMoney = scannerWithdraw.nextInt();

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
    public void refillAccount() {

        System.out.println("������� ����� � ����������� ������ ��� ���������� �������:");

        moneyAccount = scannerRefill.nextInt() + moneyAccount;

        System.out.println("------------------------------------------------------------------------");
        System.out.println("������� �� ����� ����� ���������� �������: " + Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
        printDateOperation();
        System.out.println("------------------------------------------------------------------------");
    }

    // ������ ������� �� ������
    public void printAccountBalance(BankAccount nameAccount, String name) {
        System.out.println("------------------------------------------------------------------------");
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

    // ���� ���������� ��������
    public void printDateOperation () {
        dateOperatin.setTime(new Date());
        System.out.println("���� ��������: " + format.format(dateOperatin.getTime()));
    }

}
