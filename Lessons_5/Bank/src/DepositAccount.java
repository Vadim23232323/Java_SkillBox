import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

public class DepositAccount extends BankAccount {

    Scanner scannerWithdrawDeposit = new Scanner(System.in);

    DateFormat format = new SimpleDateFormat("HH:mm MM/dd/yyyy");

    Calendar calendar = Calendar.getInstance();
    Calendar dateOperatin;

    public void withdrawDepositAccount() {

        System.out.println(format.format(dateOperatin.getTime()));

        if (calendar.add(Calendar.MONTH,))

//        int withdrawMoney, commission;
//
//        System.out.println("������� ����� � ����������� ������ ��� ������ ������� � ����������� �����: ");
//
//        withdrawMoney = scannerWithdrawDeposit.nextInt();
//
//        commission = (withdrawMoney*1)/100;
//
//        if (withdrawMoney > moneyAccount || withdrawMoney <= 0) {
//            System.out.println("------------------------------------------------------------------------");
//            System.out.println("������������ �������! ������ ������ ����� ����������: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
//            System.out.println("------------------------------------------------------------------------");
//        } else {
//
//            moneyAccount = moneyAccount - withdrawMoney - commission;
//
//            System.out.println("------------------------------------------------------------------------");
//            System.out.println("�������� ��������� �������!");
//            System.out.println("����� ������ �� �����: " + ANSI_GREEN + withdrawMoney + " BLR" + ANSI_RESET);
//            System.out.println("������ ������ ����� ����������: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
//            System.out.println("�������� ����� ��������� 1%: " + ANSI_GREEN + commission + " BLR" + ANSI_RESET);
//            System.out.println("------------------------------------------------------------------------");
//        }

    }


    public void refillDepositAccount () {
        super.refillAccount();
        dateOperatin = calendar;
        System.out.println("���� ��������: " + format.format(dateOperatin.getTime()));
    }
}
