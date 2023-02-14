package accounts;

import java.util.Scanner;

public class Menu {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";
    BankAccount bankAccount = new BankAccount();
    CardAccount cardAccount = new CardAccount();
    DepositAccount depositAccount = new DepositAccount();

    // ����
    public void getMenu() {
        System.out.println("���� ������: " + ANSI_GREEN + "\" \n\t 1. " + ANSI_RESET + "�������� ������� �� ������." +
                ANSI_GREEN + "\" \n\t 2. " + ANSI_RESET + "��������� ���� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 3. " + ANSI_RESET + "������ ������� �� ����� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 4. " + ANSI_RESET + "��������� ���� ���� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 5. " + ANSI_RESET + "������ ������� � ���� ����� (�������� 1%)." +
                ANSI_GREEN + "\" \n\t 6. " + ANSI_RESET + "��������� ���������� ���� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 7. " + ANSI_RESET + "������ ������� � ����������� ����� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 8. " + ANSI_RESET + "������� � ����������� ����� �� ���� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 9. " + ANSI_RESET + "����� �� ����������.");
        setCommand();
    }

    //���� � ������� ������ �������
    private void setCommand() {

        Scanner scanner = new Scanner(System.in);

        int command = 0;

        System.out.println("������� � �������: ");

        command = scanner.nextInt();

        switch (command) {
            case 1:
                System.out.println("########################################################################");
                bankAccount.printAccountBalance(bankAccount, "C����");
                cardAccount.printAccountBalance(cardAccount, "���� C����");
                depositAccount.printAccountBalance(depositAccount, "���������� C����");
                System.out.println("########################################################################");
                getMenu();
            case 2:
                bankAccount.refillAccount();
                getMenu();
            case 3:
                bankAccount.withdrawAccount();
                getMenu();
            case 4:
                cardAccount.refillAccount();
                getMenu();
            case 5:
                cardAccount.withdrawCardAccount();
                getMenu();
            case 6:
                depositAccount.refillAccount();
                getMenu();
            case 7:
                depositAccount.withdrawDepositAccount();
                getMenu();
            case 8:
                bankAccount.send(depositAccount, depositAccount.moneyAccount);
                getMenu();
            case 9:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("���������� ��������� ������.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:
                if (command < 1 || command > 9) {
                    System.out.println("������� �������� �������! ������� ������� ��������.");
                }
                getMenu();
        }
    }

}
