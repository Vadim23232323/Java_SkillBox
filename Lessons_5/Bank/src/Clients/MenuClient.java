package Clients;

import accounts.BankAccount;
import accounts.CardAccount;
import accounts.DepositAccount;

import java.util.Scanner;

public class MenuClient {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";

    ClientIndividual clientIndividual = new ClientIndividual();

    public void getMenu() {
        System.out.println("���� ������: " + ANSI_GREEN + "\" \n\t 1. " + ANSI_RESET + "�������� ������� �� ������." +
                ANSI_GREEN + "\" \n\t 2. " + ANSI_RESET + "��������� ���� ����������� ���� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 3. " + ANSI_RESET + "������ ������� �� ����� ����������� ���� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 4. " + ANSI_RESET + "��������� ���� ������������ ���� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 5. " + ANSI_RESET + "������ ������� �� ����� ������������ ���� (�������� 1%)." +
                ANSI_GREEN + "\" \n\t 6. " + ANSI_RESET + "��������� ���� �� (��� ��������)." +
                ANSI_GREEN + "\" \n\t 7. " + ANSI_RESET + "������ ������� �� ����� �� " +
                "(���������� � ��������� 1%, ���� ����� ������ 1000 ������. � � ��������� 0,5%, " +
                "���� ����� ������ ���� ����� 1000 ������.)." +
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
                clientIndividual.printClientAccountBalance();
                System.out.println("########################################################################");
                getMenu();
            case 2:
                clientIndividual.refillClientAccount();
                getMenu();
            case 3:
                clientIndividual.withdrawClientAccount();
                getMenu();
            case 4:

                getMenu();
            case 5:

                getMenu();
            case 6:

                getMenu();
            case 7:

                getMenu();
            case 8:

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
