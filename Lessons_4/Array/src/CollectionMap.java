import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionMap {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";
    TreeMap<String, String> phoneBook = new TreeMap<>();
    Scanner scanner = new Scanner(System.in);
    Scanner scannerLine = new Scanner(System.in);
    Scanner scannerNumberPhone = new Scanner(System.in);
    Scanner scannerName = new Scanner(System.in);
    int command = 0;
    String line;
    boolean correctFormat;
    private Pattern pattern;
    private Matcher matcher;


    //����
    public void getMenu() {
        System.out.println("���� ������: " + ANSI_GREEN + "\" \n\t 1. LIST " + ANSI_RESET + "- ������� ���������� �����." +
                ANSI_GREEN + "\" \n\t 2. ADD " + ANSI_RESET + "- ��������� ����� ������� � ���������� ����� " +
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
                printTreeMap();
                break;
            case 2:
                setAddTreeMap();
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

    // ���������� ������ � ���������� ����� �� �������
    public TreeMap<String, String> setAddTreeMap() {

        String name, numberPhone;
        System.out.println("������� ��� ��� ����� ��������: ");
        line = scannerLine.nextLine();
        if (line == "") {
            System.out.println("������� �� ���������� ������!!! ��������� ���� ������. ");
        } else {
            setSearch(line);
            if (correctFormat) {
                name = line;
                System.out.println("������� ����� ��������: ");
                numberPhone = scannerNumberPhone.nextLine();
                phoneBook.put(numberPhone, name);
                System.out.println("-------------------------------------------------------------------");
                System.out.println("� ���������� ����� �������� �������: " + ANSI_GREEN + " ���: " + name + " | " + "�������: "
                        + numberPhone + ANSI_RESET);
                System.out.println("-------------------------------------------------------------------");
            } else {
                numberPhone = line;
                System.out.println("������� ���: ");
                name = scannerName.nextLine();
                phoneBook.put(numberPhone, name);
                System.out.println("-------------------------------------------------------------------");
                System.out.println("� ���������� ����� �������� �������: " + ANSI_GREEN + " ���: " + name + " | " + "�������: "
                        + numberPhone + ANSI_RESET);
                System.out.println("-------------------------------------------------------------------");
            }
        }

        return phoneBook;
    }


    // ����� ���������� ����� � �������
    public void printTreeMap() {

        System.out.println(ANSI_GREEN + "���������� �����: " + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        if (phoneBook.size() == 0) {
            System.out.println("������ ����!!! �������� ������ � ������.");
        } else {
            for (String bookEntry : phoneBook.keySet()) {
                System.out.println("���: " + phoneBook.get(bookEntry) + " | " + "�������: " + bookEntry);
            }
        }
        System.out.println("-------------------------------------------------------------------");
        getMenu();
    }

    // ����� � ������� �������� ������� ��� ������� � ���������� �����
    public void PrintExistTreeMap() {

        if (phoneBook.containsKey(line)) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("����� ������� ��� ����������: ���: " + phoneBook.get(line) + " | " + "�������: " + line);
        }
        if (phoneBook.containsValue(line)) {
            System.out.println("-------------------------------------------------------------------");
            for (String bookEntry : phoneBook.keySet()) {
                if (phoneBook.get(bookEntry).equals(line)) {
                    System.out.println("����� ������� ��� ����������: ���: " + phoneBook.get(bookEntry) + " | " + "�������: " + bookEntry);
                    break;
                }
            }
        }
        System.out.println("-------------------------------------------------------------------");
        getMenu();
    }

    // �������� ����� ������ ������� � �������
    public boolean setSearch(String line) {

        this.line = line;

        if (phoneBook.containsKey(line) || phoneBook.containsValue(line)) {
            PrintExistTreeMap();
        } else {

            pattern = Pattern.compile("\\+?\\d+");

            matcher = pattern.matcher(line);

            if (matcher.matches())
                correctFormat = false;
            else correctFormat = true;
        }

        return correctFormat;
    }

}
