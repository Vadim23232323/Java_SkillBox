import java.security.PublicKey;
import java.util.Scanner;
    // // ��������� ����, ��� ������ ����� � �������� ���������� �������� 1%
public class CardAccount extends BankAccount{

    Scanner scannerWithdrawCard = new Scanner(System.in);


    // ������ ������� �� �����
    public void withdrawCardAccount () {

        int withdrawMoney, commission;

        System.out.println("������� ����� � ����������� ������ ��� ������ ������� � ���� �����: ");

        withdrawMoney = scannerwithdrawMoney.nextInt();

        commission = (withdrawMoney*1)/100;

        if (withdrawMoney > moneyAccount || withdrawMoney <= 0) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("������������ �������! ������ ������ ����� ����������: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        } else {

            moneyAccount = moneyAccount - withdrawMoney - commission;

            System.out.println("------------------------------------------------------------------------");
            System.out.println("�������� ��������� �������!");
            System.out.println("����� ������ �� �����: " + ANSI_GREEN + withdrawMoney + " BLR" + ANSI_RESET);
            System.out.println("������ ������ ����� ����������: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
            System.out.println("�������� ����� ��������� 1%: " + ANSI_GREEN + commission + " BLR" + ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        }

    }

}

