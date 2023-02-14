package Clients;

import java.util.Scanner;

public class MenuClient {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";
    ClientIndividual clientIndividual = new ClientIndividual();
    ClientEntity clientEntity = new ClientEntity();
    ClientIndividualEntrepreneur clientIndividualEntrepreneur = new ClientIndividualEntrepreneur();

    // ����
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
                ANSI_GREEN + "\" \n\t 8. " + ANSI_RESET + "����� �� ����������.");
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
                clientEntity.printClientAccountBalance();
                clientIndividualEntrepreneur.printClientAccountBalance();
                System.out.println("########################################################################");
                getMenu();
            case 2:
                clientIndividual.refillClientAccount();
                getMenu();
            case 3:
                clientIndividual.withdrawClientAccount();
                getMenu();
            case 4:
                clientEntity.refillClientAccount();
                getMenu();
            case 5:
                clientEntity.withdrawClientAccount();
                getMenu();
            case 6:
                clientIndividualEntrepreneur.refillClientAccount();
                getMenu();
            case 7:
                clientIndividualEntrepreneur.withdrawClientAccount();
                getMenu();
            case 8:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("���������� ��������� ������.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:
                if (command < 1 || command > 8) {
                    System.out.println("������� �������� �������! ������� ������� ��������.");
                }
                getMenu();
        }
    }
}
