import java.util.Collections;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;


// ������� 5.7 ��������� ���������� ������������� ������� � ������� ������ ��������� � ����������
public class CarCollection {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";
    ArrayList<String> carList = new ArrayList<>();
    TreeSet<String> carSet = new TreeSet<>();
    HashSet<String> carHashSet = new HashSet<>();
    int command = 0;
    String randomNumber;


    //����
    public void getMenu() {
        System.out.println("���� ������: " + ANSI_GREEN + "\" \n\t 1. LIST " + ANSI_RESET + "- ������� ������ ������������� �������." +
                ANSI_GREEN + "\" \n\t 2. ADD " + ANSI_RESET + "- ��������� � ������ 1.000.000 ��������������� ������������� �������" +
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
//                seAddTreeSet();
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
        for (int i = 0; i < 1000000; i++) {
            setRandomNumber();
            carList.add(randomNumber);
        }
        seAddTreeSet();
        System.out.println("-------------------------------------------------------------------");
        System.out.println(ANSI_GREEN + "��������� 1.000.000 ��������������� ��������������� ������������� �������!" + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        return carList;
    }

    public TreeSet<String> seAddTreeSet() {
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

//        System.out.println(ANSI_GREEN + "C����� ������������� ������� � SET: " + ANSI_RESET);
//        System.out.println("-------------------------------------------------------------------");
//        if (carSet.size() == 0) {
//            System.out.println("������ ����!!! �������� ������ � ������.");
//        } else {
//            for (String cars : carSet) {
//                System.out.println("��������������� ����� ����������: " + ANSI_GREEN + cars + ANSI_RESET);
//            }
//        }
//        System.out.println("-------------------------------------------------------------------");
        getMenu();
    }


    public void getSearch() {

        boolean list = false, listSort = false, set = false, setSort = false;

        long timeList, timeListSort, timeSet, timeSetSort;

        carHashSet = new HashSet<>(carSet);

        String searchNumberCar = "";

        Scanner scannerNumberCar = new Scanner(System.in);

        System.out.println("������� ����� ���������� ������� ������ �����: ");

        searchNumberCar = scannerNumberCar.nextLine();

        long timeStartList = System.currentTimeMillis() * 1000;

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).equals(searchNumberCar)) {
                list = true;
            }
        }
        long timeEndList = System.currentTimeMillis() * 1000;

        timeList = timeEndList - timeStartList;

        System.out.println("-------------------------------------------------------------------");

        System.out.println("����� ���������: ����� ������: " + list + " ����� ����� - " + timeList + " ��");

        Collections.sort(carList);

        long timeStartListSort = System.currentTimeMillis() * 1000;

        if (Collections.binarySearch(carList, searchNumberCar) >= 0) {
            listSort = true;
        }

        long timeEndListSort = System.currentTimeMillis() * 1000;

        timeListSort = timeEndListSort - timeStartListSort;

        System.out.println("�������� �����: ����� ������: " + listSort + " ����� ����� - " + timeListSort + " ��");


        long timeStartTreeSet = System.currentTimeMillis() * 1000;

        if (carSet.contains(searchNumberCar)) {
            setSort = true;
        } else {
            setSort = false;
        }

        long timeEndTreeSet = System.currentTimeMillis() * 1000;

        timeSetSort = timeEndTreeSet - timeStartTreeSet;

        System.out.println("����� � TreeSet: ����� ������: " + setSort + " ����� ����� - " + timeSetSort + " ��");


        long timeStartHashSet = System.currentTimeMillis() * 1000;

        if (carHashSet.contains(searchNumberCar)) {
            set = true;
        } else {
            set = false;
        }

        long timeEndHashSet = System.currentTimeMillis() * 1000;

        timeSet = timeEndHashSet - timeStartHashSet;

        System.out.println("����� � HashSet: ����� ������: " + set + " ����� ����� - " + timeSet + " ��");

        System.out.println("-------------------------------------------------------------------");

    }

}







