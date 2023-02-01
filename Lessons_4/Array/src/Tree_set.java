import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeSet;

public class Tree_set {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";
    TreeSet<String> emailingSet = new TreeSet<>();
    Scanner scanElement = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    String email;
    int  command = 0;

    //����
    public void getMenu() {
        System.out.println("���� ������: " + ANSI_GREEN + "\" \n\t 1. LIST " + ANSI_RESET + "- ������� ������ email ������� " +
                ANSI_GREEN + "\" \n\t 2. ADD " + ANSI_RESET + "- ��������� email ������� � ������ ��� " +
                ANSI_GREEN + "\" \n\t 3. EXIT " + ANSI_RESET + "- ����� �� ����������.");
        setCommand();
    }

    //���� � ������� ������ �������
    public void setCommand() {

        command = 0;

        System.out.println("������� � �������: ");

        command = scanner.nextInt();

        switch (command) {
            case 1:
                printTreeSet();
                break;
            case 2:
                setAddTreeSet();
                getMenu();
            case 3:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("���������� ��������� ������.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:
                if (command < 0 || command > 6) {
                    System.out.println("������� �������� �������! ������� ������� ��������.");
                }
                getMenu();
        }
    }

    // ���������� ������ � TreeSet �� �������
    public TreeSet<String> setAddTreeSet() {
        String emailFormat;
        System.out.println("������� email �����:");
        email = scanElement.nextLine();
        emailFormat = String.valueOf(email.split("@\\.?"));
        System.out.println("���������������" + emailFormat);
        emailingSet.add(email);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Email: " + ANSI_GREEN  + email + ANSI_RESET + " �������� � ������ ");
        System.out.println("-------------------------------------------------------------------");
        command = 0;
        return emailingSet;
    }


    // ����� ������ � �������
    public void printTreeSet() {
        System.out.println(ANSI_GREEN + " ������ email: " + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        if (emailingSet.size() == 0) {
            System.out.println("������ ����!!! �������� ������ � ������.");
        } else {
            for (String emailEl : emailingSet) {
                System.out.println(emailEl);
            }
        }
        System.out.println("-------------------------------------------------------------------");
        getMenu();
    }

}
