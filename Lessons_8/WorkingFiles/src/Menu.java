import java.util.Scanner;

public class Menu {
    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";

    WorkFolder folder = new WorkFolder();

    WorkFile file = new WorkFile();

    int command;

    // ����
    public void getMenu() {
        System.out.println("���� ������ ������ � ������: " + ANSI_GREEN + "\" \n\t 1. " + ANSI_RESET + "������� �������." +
                ANSI_GREEN + "\" \n\t 2. " + ANSI_RESET + "������ ��������." +
                ANSI_GREEN + "\" \n\t 3. " + ANSI_RESET + "������ ��������." +
                ANSI_GREEN + "\" \n\t 4. " + ANSI_RESET + "����������� ���������." +
                ANSI_GREEN + "\" \n\t 5. " + ANSI_RESET + "��������� ���������� �������." +
                ANSI_GREEN + "\" \n\t 6. " + ANSI_RESET + "������� ���������� �� ���������� �������." +
                ANSI_GREEN + "\" \n\t 9. " + ANSI_RESET + "�����.");
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
                folder.getFoldersSize(folder.folder);
                getMenu();
            case 3:
                folder.printSizeFolder();
                getMenu();
            case 4:
                folder.copyFolder(folder.folder, folder.loadingFolderToCopy());
                folder.resultCopy();
                getMenu();
            case 5:
                file.loadStaffFromFile();
                getMenu();
            case 6:
                file.getPrintBankStatement();
                getMenu();
            case 9:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("���������� ��������� ������.");
                System.out.println("-------------------------------------------------------------------");
                System.exit(0);
                break;
            default:
                if (command < 1 || command > 9) {
                    System.out.println("������� �������� �������! ������� ������� ��������.");
                }
                getMenu();
        }
    }
}
