package accounts;

import java.util.Scanner;
    // // ��������� ����, ��� ������ ����� � �������� ���������� �������� 1%
public class CardAccount extends BankAccount{

    // ������ ������� �� �����
    public void withdrawCardAccount () {

        int withdrawMoney, commission;

        System.out.println("������� ����� � ����������� ������ ��� ������ ������� �� �����: ");

        withdrawMoney = super.scannerWithdraw.nextInt();

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

