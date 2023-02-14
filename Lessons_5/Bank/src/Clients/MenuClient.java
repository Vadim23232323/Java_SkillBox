package Clients;

import java.util.Scanner;

public class MenuClient {

    // Задает зеленый цвет текста
    public static final String ANSI_GREEN = "\u001B[32m";
    // Задает стандартный цвет текста
    public static final String ANSI_RESET = "\u001B[0m";
    ClientIndividual clientIndividual = new ClientIndividual();
    ClientEntity clientEntity = new ClientEntity();
    ClientIndividualEntrepreneur clientIndividualEntrepreneur = new ClientIndividualEntrepreneur();

    // Меню
    public void getMenu() {
        System.out.println("Меню команд: " + ANSI_GREEN + "\" \n\t 1. " + ANSI_RESET + "Получить остаток на счетах." +
                ANSI_GREEN + "\" \n\t 2. " + ANSI_RESET + "пополнить счёт физического лица (без комиссии)." +
                ANSI_GREEN + "\" \n\t 3. " + ANSI_RESET + "снятие средств со счёта физического лица (без комиссии)." +
                ANSI_GREEN + "\" \n\t 4. " + ANSI_RESET + "пополнить счёт юридического лица (без комиссии)." +
                ANSI_GREEN + "\" \n\t 5. " + ANSI_RESET + "снятие средств со счёта юридического лица (комиссия 1%)." +
                ANSI_GREEN + "\" \n\t 6. " + ANSI_RESET + "пополнить счёт ИП (без комиссии)." +
                ANSI_GREEN + "\" \n\t 7. " + ANSI_RESET + "снятие средств со счёта ИП " +
                "(пополнение с комиссией 1%, если сумма меньше 1000 рублей. И с комиссией 0,5%, " +
                "если сумма больше либо равна 1000 рублей.)." +
                ANSI_GREEN + "\" \n\t 8. " + ANSI_RESET + "Выход из приложения.");
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
                System.out.println("########################################################################");
                clientIndividual.printClientAccountBalance();
                clientEntity.printClientAccountBalance();
                clientIndividualEntrepreneur.printClientAccountBalance();
                System.out.println("########################################################################");
                getMenu();
            case 2:
                clientIndividual.refillClientAccount();
                getMenu();
            case 3:
                clientIndividual.withdrawClientAccount();
                getMenu();
            case 4:
                clientEntity.refillClientAccount();
                getMenu();
            case 5:
                clientEntity.withdrawClientAccount();
                getMenu();
            case 6:
                clientIndividualEntrepreneur.refillClientAccount();
                getMenu();
            case 7:
                clientIndividualEntrepreneur.withdrawClientAccount();
                getMenu();
            case 8:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Приложение завершило работу.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:
                if (command < 1 || command > 8) {
                    System.out.println("Введена неверная команда! Введите команду повторно.");
                }
                getMenu();
        }
    }
}
