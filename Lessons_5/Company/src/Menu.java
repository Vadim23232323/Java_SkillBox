import java.util.Scanner;

public class Menu {

    // Задает зеленый цвет текста
    public static final String ANSI_GREEN = "\u001B[32m";
    // Задает стандартный цвет текста
    public static final String ANSI_RESET = "\u001B[0m";

    Company company = new Company();
    Employee operator = new EmployeeOperator();
    Employee manager = new EmployeeManager();
    Employee topManager = new EmployeeTopManager();





    // Меню
    public void getMenu() {
        System.out.println("Меню команд: " + ANSI_GREEN + "\" \n\t 1. " + ANSI_RESET + "Список сотрудников." +
                ANSI_GREEN + "\" \n\t 2. " + ANSI_RESET + "Нанять в компанию оператора." +
                ANSI_GREEN + "\" \n\t 3. " + ANSI_RESET + "Нанять в компанию менеджера." +
                ANSI_GREEN + "\" \n\t 4. " + ANSI_RESET + "Нанять в компанию топ-менеджера." +
                ANSI_GREEN + "\" \n\t 5. " + ANSI_RESET + "Нанять в компанию операторов" +
                ANSI_GREEN + "\" \n\t 6. " + ANSI_RESET + "Нанять в компанию менеджеров" +
                ANSI_GREEN + "\" \n\t 7. " + ANSI_RESET + "Нанять в компанию топ-менеджеров" +
                ANSI_GREEN + "\" \n\t 4. " + ANSI_RESET + "Список сотрудников." +
                ANSI_GREEN + "\" \n\t 9. " + ANSI_RESET + "Выход из приложения.");
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
                company.printArrayList();
                getMenu();
            case 2:
                company.hire(operator, "оператора");
                getMenu();
            case 3:
                company.hire(manager, "менеджера");
                getMenu();
            case 4:
                company.hire(topManager,"топ-менеджера");
                getMenu();
            case 5:
                company.hireAll(operator, "оператора");
                getMenu();
            case 6:
                company.hireAll(manager, "менеджера");
                getMenu();
            case 7:
                company.hireAll(topManager, "топ-менеджера");
                getMenu();
            case 9:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Приложение завершило работу.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:
                if (command < 1 || command > 9) {
                    System.out.println("Введена неверная команда! Введите команду повторно.");
                }
                getMenu();
        }
    }
}
