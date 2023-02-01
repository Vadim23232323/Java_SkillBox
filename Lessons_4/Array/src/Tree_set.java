import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tree_set {

    // Задает зеленый цвет текста
    public static final String ANSI_GREEN = "\u001B[32m";
    // Задает стандартный цвет текста
    public static final String ANSI_RESET = "\u001B[0m";
    TreeSet<String> emailingSet = new TreeSet<>();
    Scanner scanElement = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    String email;
    boolean correctEmailFormat;
    int command = 0;
    private Pattern pattern;
    private Matcher matcher;

    //Меню
    public void getMenu() {
        System.out.println("Меню команд: " + ANSI_GREEN + "\" \n\t 1. LIST " + ANSI_RESET + "- Выводит список email адресов " +
                ANSI_GREEN + "\" \n\t 2. ADD " + ANSI_RESET + "- Добавляет email адресов в список дел " +
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
                printTreeSet();
                break;
            case 2:
                setAddTreeSet();
                getMenu();
            case 3:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Приложение завершило работу.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:
                if (command < 0 || command > 6) {
                    System.out.println("Введена неверная команда! Введите команду повторно.");
                }
                getMenu();
        }
    }

    // Добавление записи в TreeSet из консоли
    public TreeSet<String> setAddTreeSet() {

        System.out.println("Введите email адрес, " +
                "email адрес должен соответствовать маске примера [пример: google@gmail.com]: ");
        email = scanElement.nextLine();
        setSearch(email);
        if (correctEmailFormat) {
            emailingSet.add(email);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Email: " + ANSI_GREEN + email + ANSI_RESET + " добавлен в список ");
            System.out.println("-------------------------------------------------------------------");
        } else {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Email введе с ошибками!!! Проверьте правильность введеного email и повторите попытку. ");
            System.out.println("-------------------------------------------------------------------");
        }

        command = 0;
        return emailingSet;
    }

    // Вывод списка в консоль
    public void printTreeSet() {
        System.out.println(ANSI_GREEN + " Список email: " + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        if (emailingSet.size() == 0) {
            System.out.println("СПИСОК ПУСТ!!! Добавьте запись в список.");
        } else {
            for (String emailEl : emailingSet) {
                System.out.println(emailEl);
            }
        }
        System.out.println("-------------------------------------------------------------------");
        getMenu();
    }

    // Проверка email на соответсвие маски *@*.*
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
