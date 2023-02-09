import java.util.Scanner;

public class Menu {

    // Задает зеленый цвет текста
    public static final String ANSI_GREEN = "\u001B[32m";
    // Задает стандартный цвет текста
    public static final String ANSI_RESET = "\u001B[0m";

    private int command = 0;

    BankAccount bankAccount = new BankAccount();

    CardAccount cardAccount = new CardAccount();


    public void getMenu() {
        System.out.println("Меню команд: " + ANSI_GREEN + "\" \n\t 1. " + ANSI_RESET + "Получить остаток на счете." +
                ANSI_GREEN + "\" \n\t 2. " + ANSI_RESET + "пополнить счёт (без комиссии)." +
                ANSI_GREEN + "\" \n\t 3. " + ANSI_RESET + "снятие средств со счёта (без комиссии)." +
                ANSI_GREEN + "\" \n\t 4. " + ANSI_RESET + "снятие средств с карт счёта (комиссия 1%)." +
                ANSI_GREEN + "\" \n\t 5. " + ANSI_RESET + "снятие средств со счёта (без комиссии)." +
                ANSI_GREEN + "\" \n\t 6. " + ANSI_RESET + "Выход из приложения.");
        setCommand();
    }

    //Ввод с консоли номера команды
    private void setCommand() {

        Scanner scanner = new Scanner(System.in);

        command = 0;

        System.out.println("Введите № команды: ");

        command = scanner.nextInt();

        switch (command) {
            case 1:
                bankAccount.printAccountBalance();
                getMenu();
            case 2:
                bankAccount.topUpCashAccount();
                getMenu();
            case 3:
                bankAccount.withdrawMoneyAccount();
                getMenu();
            case 4:
                cardAccount.withdrawCardAccount();
                getMenu();
            case 6:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Приложение завершило работу.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:
                if (command < 1 || command > 6) {
                    System.out.println("Введена неверная команда! Введите команду повторно.");
                }
                getMenu();
        }
    }

}
