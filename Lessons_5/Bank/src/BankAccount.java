import java.util.Scanner;



public class BankAccount {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";

    protected int moneyAccount;

    Scanner scannerMoney = new Scanner(System.in);

    Scanner scannerwithdrawMoney = new Scanner(System.in);


    // ������ ������� �� �����
    public void withdrawMoneyAccount() {

        int withdrawMoney;

        System.out.println("������� ����� � ����������� ������ ��� ������ ������� �� �����: ");

        withdrawMoney = scannerwithdrawMoney.nextInt();

        if (withdrawMoney > moneyAccount || withdrawMoney <= 0) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("������������ �������! ������ ������ ����� ����������: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        } else {
            moneyAccount = moneyAccount - withdrawMoney;
            System.out.println("------------------------------------------------------------------------");
            System.out.println("�������� ��������� �������!");
            System.out.println("����� ������ �� �����: " + ANSI_GREEN + withdrawMoney + " BLR" + ANSI_RESET);
            System.out.println("������ ������ ����� ����������: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        }

    }

    // ���������� �����
    public void refillAccount() {

        System.out.println("������� ����� � ����������� ������ ��� ���������� �������:");

        moneyAccount = scannerMoney.nextInt();

        System.out.println("------------------------------------------------------------------------");
        System.out.println("������� �� ����� ����� ���������� �������: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
        System.out.println("------------------------------------------------------------------------");
    }

    // ������ ������� �� �����
    public void printAccountBalance() {
        System.out.println("�������: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
    }



}
