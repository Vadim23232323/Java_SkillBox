import java.time.LocalDateTime;
import java.util.Collections;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Задание 5.7 Генератор «красивых» автомобильных номеров и методов поиска элементов в коллекциях
public class CarCollection {

    // Задает зеленый цвет текста
    public static final String ANSI_GREEN = "\u001B[32m";
    // Задает стандартный цвет текста
    public static final String ANSI_RESET = "\u001B[0m";
    ArrayList<String> carList = new ArrayList<>();
    TreeSet<String> carSet = new TreeSet<>();
    int command = 0;
    String randomNumber;
    private Pattern pattern;
    private Matcher matcher;


    //Меню
    public void getMenu() {
        System.out.println("Меню команд: " + ANSI_GREEN + "\" \n\t 1. LIST " + ANSI_RESET + "- Выводит список автомобильных номеров." +
                ANSI_GREEN + "\" \n\t 2. ADD " + ANSI_RESET + "- Добавляет в список 100 сгенерированных автомобильных номеров" +
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
                seAddHashSet();
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
                if (command < 1 || command > 3) {
                    System.out.println("Введена неверная команда! Введите команду повторно.");
                }
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
        for (int i = 0; i < 4; i++) {
            setRandomNumber();
            carList.add(randomNumber);
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println(ANSI_GREEN + "Добавлено 1000 сгенерированных государственных автомобильных номеров!" + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        return carList;
    }


    public TreeSet<String> seAddHashSet() {
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

        System.out.println(ANSI_GREEN + "Cписко автомобильных номеров в SET: " + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        if (carSet.size() == 0) {
            System.out.println("СПИСОК ПУСТ!!! Добавьте запись в список.");
        } else {
            for (String car : carSet) {
                System.out.println("Государственный номер автомобиля: " + ANSI_GREEN + car + ANSI_RESET);
            }
        }
        System.out.println("-------------------------------------------------------------------");
        getMenu();
    }


    public void getSearch() {

        boolean list = false, listSort, set, setSort;

        String searchNumberCar = "";

        Scanner scannerNumberCar = new Scanner(System.in);

        System.out.println("Введите номер автомобиля который хотите найти: ");

        searchNumberCar = scannerNumberCar.nextLine();

      //  int time = LocalDateTime.now();

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).equals(searchNumberCar)) {
                list = true;
            } else {
                list = false;
            }
        }

        System.out.println("Поиск перебором: номер найден: " + list + " поиск занял: ");


    }



}
