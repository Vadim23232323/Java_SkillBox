import java.util.Scanner;

public class Menu {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";

    private int command = 0;

    BankAccount bankAccount = new BankAccount();

    CardAccount cardAccount = new CardAccount();


    public void getMenu() {
        System.out.println("���� ������: " + ANSI_GREEN + "\" \n\t 1. " + ANSI_RESET + "�������� ������� �� �����." +
                ANSI_GREEN + "\" \n\t 2. " + ANSI_RESET + "��������� ���� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 3. " + ANSI_RESET + "������ ������� �� ����� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 4. " + ANSI_RESET + "������ ������� � ���� ����� (�������� 1%)." +
                ANSI_GREEN + "\" \n\t 5. " + ANSI_RESET + "������ ������� �� ����� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 6. " + ANSI_RESET + "����� �� ����������.");
        setCommand();
    }

    //���� � ������� ������ �������
    private void setCommand() {

        Scanner scanner = new Scanner(System.in);

        command = 0;

        System.out.println("������� � �������: ");

        command = scanner.nextInt();

        switch (command) {
            case 1:
                bankAccount.printAccountBalance();
                getMenu();
            case 2:
                bankAccount.topUpCashAccount();
                getMenu();
            case 3:
                bankAccount.withdrawMoneyAccount();
                getMenu();
            case 4:
                cardAccount.withdrawCardAccount();
                getMenu();
            case 6:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("���������� ��������� ������.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:
                if (command < 1 || command > 6) {
                    System.out.println("������� �������� �������! ������� ������� ��������.");
                }
                getMenu();
        }
    }

}
