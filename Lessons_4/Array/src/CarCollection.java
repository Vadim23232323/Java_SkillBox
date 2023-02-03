import java.time.LocalDateTime;
import java.util.Collections;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// ������� 5.7 ��������� ���������� ������������� ������� � ������� ������ ��������� � ����������
public class CarCollection {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";
    ArrayList<String> carList = new ArrayList<>();
    TreeSet<String> carSet = new TreeSet<>();
    int command = 0;
    String randomNumber;
    private Pattern pattern;
    private Matcher matcher;


    //����
    public void getMenu() {
        System.out.println("���� ������: " + ANSI_GREEN + "\" \n\t 1. LIST " + ANSI_RESET + "- ������� ������ ������������� �������." +
                ANSI_GREEN + "\" \n\t 2. ADD " + ANSI_RESET + "- ��������� � ������ 100 ��������������� ������������� �������" +
                ANSI_GREEN + "\" \n\t 3. SEARCH " + ANSI_RESET + "- ����� �������������� ������." +
                ANSI_GREEN + "\" \n\t 4. EXIT " + ANSI_RESET + "- ����� �� ����������.");
        setCommand();
    }

    //���� � ������� ������ �������
    public void setCommand() {

        Scanner scanner = new Scanner(System.in);

        command = 0;

        System.out.println("������� � �������: ");

        command = scanner.nextInt();

        switch (command) {
            case 1:
                printList();
                break;
            case 2:
                setAddArrayList();
                seAddHashSet();
                getMenu();
            case 3:
                getSearch();
                getMenu();
            case 4:
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


    // ��������� ���������� ������������� �������
    public String setRandomNumber() {
        int number, region;
        char chOne, chTwo;
        number = (int) ((Math.random() * 9999) + 0000);
        region = (int) ((Math.random() * 8) + 0);
        chOne = (char) ((Math.random() * 25) + 65);
        chTwo = (char) ((Math.random() * 25) + 65);
        randomNumber = Integer.toString(number) + " " + chOne + chTwo + "-" + Integer.toString(region);
        return randomNumber;
    }


    // ��������� 100 ��������������� ������������� ������� �
    public ArrayList<String> setAddArrayList() {
        for (int i = 0; i < 4; i++) {
            setRandomNumber();
            carList.add(randomNumber);
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println(ANSI_GREEN + "��������� 1000 ��������������� ��������������� ������������� �������!" + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        return carList;
    }


    public TreeSet<String> seAddHashSet() {
        carSet = new TreeSet<>(carList);
        return carSet;
    }

    public void printList() {

        System.out.println(ANSI_GREEN + "C����� ������������� ������� � LIST: " + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        if (carList.size() == 0) {
            System.out.println("������ ����!!! �������� ������ � ������.");
        } else {
            for (String car : carList) {
                System.out.println("��������������� ����� ����������: " + ANSI_GREEN + car + ANSI_RESET);
            }
        }
        System.out.println("-------------------------------------------------------------------");

        System.out.println(ANSI_GREEN + "C����� ������������� ������� � SET: " + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        if (carSet.size() == 0) {
            System.out.println("������ ����!!! �������� ������ � ������.");
        } else {
            for (String car : carSet) {
                System.out.println("��������������� ����� ����������: " + ANSI_GREEN + car + ANSI_RESET);
            }
        }
        System.out.println("-------------------------------------------------------------------");
        getMenu();
    }


    public void getSearch() {

        boolean list = false, listSort, set, setSort;

        String searchNumberCar = "";

        Scanner scannerNumberCar = new Scanner(System.in);

        System.out.println("������� ����� ���������� ������� ������ �����: ");

        searchNumberCar = scannerNumberCar.nextLine();

      //  int time = LocalDateTime.now();

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).equals(searchNumberCar)) {
                list = true;
            } else {
                list = false;
            }
        }

        System.out.println("����� ���������: ����� ������: " + list + " ����� �����: ");


    }



}
