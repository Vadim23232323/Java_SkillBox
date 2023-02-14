import Clients.MenuClient;
import accounts.Menu;

public class loader {
    public static void main(String[] args) {

        // Задание 6.1 Класс BankAccount, который представляет собой расчётные счёта в банке и операции с ними
//        Menu menu = new Menu();
//        menu.getMenu();
//
        // Задание 6.2 Классы представляющие клиентов банка
        MenuClient menuClient = new MenuClient();
        menuClient.getMenu();

    }
}
