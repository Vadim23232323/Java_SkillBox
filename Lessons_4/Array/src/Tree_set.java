import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tree_set {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";
    TreeSet<String> emailingSet = new TreeSet<>();
    Scanner scanElement = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    String email;
    boolean correctEmailFormat;
    int command = 0;
    private Pattern pattern;
    private Matcher matcher;

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

        System.out.println("������� email �����, " +
                "email ����� ������ ��������������� ����� ������� [������: google@gmail.com]: ");
        email = scanElement.nextLine();
        setSearch(email);
        if (correctEmailFormat) {
            emailingSet.add(email);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Email: " + ANSI_GREEN + email + ANSI_RESET + " �������� � ������ ");
            System.out.println("-------------------------------------------------------------------");
        } else {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Email ����� � ��������!!! ��������� ������������ ��������� email � ��������� �������. ");
            System.out.println("-------------------------------------------------------------------");
        }

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

    // �������� email �� ����������� ����� *@*.*
    public boolean setSearch(String email) {

        this.email = email;

        pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        matcher = pattern.matcher(email);

        if (matcher.matches())
            correctEmailFormat = true;
        else correctEmailFormat = false;

        return correctEmailFormat;
    }

}
