import java.util.Collections;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;


// Задание 5.7 Генератор «красивых» автомобильных номеров и методов поиска элементов в коллекциях
public class CarCollection {

    // Задает зеленый цвет текста
    public static final String ANSI_GREEN = "\u001B[32m";
    // Задает стандартный цвет текста
    public static final String ANSI_RESET = "\u001B[0m";
    ArrayList<String> carList = new ArrayList<>();
    TreeSet<String> carSet = new TreeSet<>();
    HashSet<String> carHashSet = new HashSet<>();
    int command = 0;
    String randomNumber;


    //Меню
    public void getMenu() {
        System.out.println("Меню команд: " + ANSI_GREEN + "\" \n\t 1. LIST " + ANSI_RESET + "- Выводит список автомобильных номеров." +
                ANSI_GREEN + "\" \n\t 2. ADD " + ANSI_RESET + "- Добавляет в список 1.000.000 сгенерированных автомобильных номеров" +
                ANSI_GREEN + "\" \n\t 3. SEARCH " + ANSI_RESET + "- Поиск автомобильного номера." +
                ANSI_GREEN + "\" \n\t 4. EXIT " + ANSI_RESET + "- Выход из приложения.");
        setCommand();
    }

    //Ввод с консоли номера команды
    public void setCommand() {

        Scanner scanner = new Scanner(System.in);

        command = 0;

        System.out.println("Введите № команды: ");

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
                System.out.println("Приложение завершило работу.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:

                getMenu();
        }
    }


    // Генератор «красивых» автомобильных номеров
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


    // Добавляем 100 сгенерированных автомобильных номеров в
    public ArrayList<String> setAddArrayList() {
        for (int i = 0; i < 1000000; i++) {
            setRandomNumber();
            carList.add(randomNumber);
        }
        seAddTreeSet();
        System.out.println("-------------------------------------------------------------------");
        System.out.println(ANSI_GREEN + "Добавлено 1.000.000 сгенерированных государственных автомобильных номеров!" + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        return carList;
    }

    public TreeSet<String> seAddTreeSet() {
        carSet = new TreeSet<>(carList);
        return carSet;
    }

    public void printList() {

        System.out.println(ANSI_GREEN + "Cписко автомобильных номеров в LIST: " + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        if (carList.size() == 0) {
            System.out.println("СПИСОК ПУСТ!!! Добавьте запись в список.");
        } else {
            for (String car : carList) {
                System.out.println("Государственный номер автомобиля: " + ANSI_GREEN + car + ANSI_RESET);
            }
        }
        System.out.println("-------------------------------------------------------------------");

//        System.out.println(ANSI_GREEN + "Cписко автомобильных номеров в SET: " + ANSI_RESET);
//        System.out.println("-------------------------------------------------------------------");
//        if (carSet.size() == 0) {
//            System.out.println("СПИСОК ПУСТ!!! Добавьте запись в список.");
//        } else {
//            for (String cars : carSet) {
//                System.out.println("Государственный номер автомобиля: " + ANSI_GREEN + cars + ANSI_RESET);
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

        System.out.println("Введите номер автомобиля который хотите найти: ");

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

        System.out.println("Поиск перебором: номер найден: " + list + " поиск занял - " + timeList + " нс");

        Collections.sort(carList);

        long timeStartListSort = System.currentTimeMillis() * 1000;

        if (Collections.binarySearch(carList, searchNumberCar) >= 0) {
            listSort = true;
        }

        long timeEndListSort = System.currentTimeMillis() * 1000;

        timeListSort = timeEndListSort - timeStartListSort;

        System.out.println("Бинарный поиск: номер найден: " + listSort + " поиск занял - " + timeListSort + " нс");


        long timeStartTreeSet = System.currentTimeMillis() * 1000;

        if (carSet.contains(searchNumberCar)) {
            setSort = true;
        } else {
            setSort = false;
        }

        long timeEndTreeSet = System.currentTimeMillis() * 1000;

        timeSetSort = timeEndTreeSet - timeStartTreeSet;

        System.out.println("Поиск в TreeSet: номер найден: " + setSort + " поиск занял - " + timeSetSort + " нс");


        long timeStartHashSet = System.currentTimeMillis() * 1000;

        if (carHashSet.contains(searchNumberCar)) {
            set = true;
        } else {
            set = false;
        }

        long timeEndHashSet = System.currentTimeMillis() * 1000;

        timeSet = timeEndHashSet - timeStartHashSet;

        System.out.println("Поиск в HashSet: номер найден: " + set + " поиск занял - " + timeSet + " нс");

        System.out.println("-------------------------------------------------------------------");

    }

}







