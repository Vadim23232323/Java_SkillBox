import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionMap {

    // Задает зеленый цвет текста
    public static final String ANSI_GREEN = "\u001B[32m";
    // Задает стандартный цвет текста
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


    //Меню
    public void getMenu() {
        System.out.println("Меню команд: " + ANSI_GREEN + "\" \n\t 1. LIST " + ANSI_RESET + "- Выводит телефонную книгу." +
                ANSI_GREEN + "\" \n\t 2. ADD " + ANSI_RESET + "- Добавляет новый контакт в телефонную книгу " +
                ANSI_GREEN + "\" \n\t 3. EXIT " + ANSI_RESET + "- Выход из приложения.");

        setCommand();
    }

    //Ввод с консоли номера команды
    public void setCommand() {

        command = 0;

        System.out.println("Введите № команды: ");

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

    // Добавление записи в телефонную книгу из консоли
    public TreeMap<String, String> setAddTreeMap() {

        String name, numberPhone;
        System.out.println("Введите имя или номер телефона: ");
        line = scannerLine.nextLine();
        if (line == "") {
            System.out.println("Введены не корректные данные!!! повторите ввод данных. ");
        } else {
            setSearch(line);
            if (correctFormat) {
                name = line;
                System.out.println("Введите номер телефона: ");
                numberPhone = scannerNumberPhone.nextLine();
                phoneBook.put(numberPhone, name);
                System.out.println("-------------------------------------------------------------------");
                System.out.println("В телефонную книгу добавлен контакт: " + ANSI_GREEN + " Имя: " + name + " | " + "Телефон: "
                        + numberPhone + ANSI_RESET);
                System.out.println("-------------------------------------------------------------------");
            } else {
                numberPhone = line;
                System.out.println("Введите имя: ");
                name = scannerName.nextLine();
                phoneBook.put(numberPhone, name);
                System.out.println("-------------------------------------------------------------------");
                System.out.println("В телефонную книгу добавлен контакт: " + ANSI_GREEN + " Имя: " + name + " | " + "Телефон: "
                        + numberPhone + ANSI_RESET);
                System.out.println("-------------------------------------------------------------------");
            }
        }

        return phoneBook;
    }


    // Вывод телефонной книги в консоль
    public void printTreeMap() {

        System.out.println(ANSI_GREEN + "ТЕЛЕФОННАЯ КНИГА: " + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        if (phoneBook.size() == 0) {
            System.out.println("СПИСОК ПУСТ!!! Добавьте запись в список.");
        } else {
            for (String bookEntry : phoneBook.keySet()) {
                System.out.println("Имя: " + phoneBook.get(bookEntry) + " | " + "Телефон: " + bookEntry);
            }
        }
        System.out.println("-------------------------------------------------------------------");
        getMenu();
    }

    // Вывод в консоль контакта который уже имеется в телефонной книги
    public void PrintExistTreeMap() {

        if (phoneBook.containsKey(line)) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Такой контакт уже существует: Имя: " + phoneBook.get(line) + " | " + "Телефон: " + line);
        }
        if (phoneBook.containsValue(line)) {
            System.out.println("-------------------------------------------------------------------");
            for (String bookEntry : phoneBook.keySet()) {
                if (phoneBook.get(bookEntry).equals(line)) {
                    System.out.println("Такой контакт уже существует: Имя: " + phoneBook.get(bookEntry) + " | " + "Телефон: " + bookEntry);
                    break;
                }
            }
        }
        System.out.println("-------------------------------------------------------------------");
        getMenu();
    }

    // Проверка какие данные введены в консоль
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
