package Bank;

import java.util.Scanner;
    // // ��������� ����, ��� ������ ����� � �������� ���������� �������� 1%
public class CardAccount extends BankAccount{

    Scanner scannerWithdrawCard = new Scanner(System.in);
    String nameAccount = "���� C����";
    // ������ ������� �� �����
    void withdrawCardAccount () {

        int withdrawMoney, commission;

        System.out.println("������� ����� � ����������� ������ ��� ������ ������� � ���� �����: ");

        withdrawMoney = scannerwithdrawMoney.nextInt();

        commission = (withdrawMoney*1)/100;

        if (withdrawMoney > moneyAccount || withdrawMoney <= 0) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("������������ �������! ������ ������ ����� ����������: " + Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        } else {

            moneyAccount = moneyAccount - withdrawMoney - commission;

            System.out.println("------------------------------------------------------------------------");
            System.out.println("�������� ��������� �������!");
            System.out.println("����� ������ �� �����: " + Menu.ANSI_GREEN + withdrawMoney + " BLR" + Menu.ANSI_RESET);
            System.out.println("������ ������ ����� ����������: " + Menu.ANSI_GREEN + moneyAccount + " BLR" + Menu.ANSI_RESET);
            System.out.println("�������� ����� ��������� 1%: " + Menu.ANSI_GREEN + commission + " BLR" + Menu.ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        }

    }

}

