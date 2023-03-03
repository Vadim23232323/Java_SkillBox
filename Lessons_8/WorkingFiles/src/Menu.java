import java.util.Scanner;

public class Menu {
    // Задает зеленый цвет текста
    public static final String ANSI_GREEN = "\u001B[32m";
    // Задает стандартный цвет текста
    public static final String ANSI_RESET = "\u001B[0m";

    WorkFolder folder = new WorkFolder();

    int command;

    // Меню
    public void getMenu() {
        System.out.println("Меню команд: " + ANSI_GREEN + "\" \n\t 1. " + ANSI_RESET + "Задайте каталог." +
                ANSI_GREEN + "\" \n\t 2. " + ANSI_RESET + "Дерево каталога и размер." +
                ANSI_GREEN + "\" \n\t 3. " + ANSI_RESET + "Выход.");
        setCommand();
    }

    //Ввод с консоли номера команды
    private void setCommand() {

        Scanner scanner = new Scanner(System.in);

        int command = 0;

        System.out.println("Введите № команды: ");

        command = scanner.nextInt();

        switch (command) {
            case 1:
                folder.loadingFolder();
                getMenu();
            case 2:
                folder.printFolders();
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
}
