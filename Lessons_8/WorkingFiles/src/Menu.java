import java.util.Scanner;

public class Menu {
    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";

    WorkFolder folder = new WorkFolder();

    int command;

    // ����
    public void getMenu() {
        System.out.println("���� ������: " + ANSI_GREEN + "\" \n\t 1. " + ANSI_RESET + "������� �������." +
                ANSI_GREEN + "\" \n\t 2. " + ANSI_RESET + "������ �������� � ������." +
                ANSI_GREEN + "\" \n\t 3. " + ANSI_RESET + "�����.");
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
                folder.loadingFolder();
                getMenu();
            case 2:
                folder.printFolders();
                getMenu();
            case 3:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("���������� ��������� ������.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:
                if (command < 1 || command > 3) {
                    System.out.println("������� �������� �������! ������� ������� ��������.");
                }
                getMenu();
        }
    }
}
