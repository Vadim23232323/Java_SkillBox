import Clients.MenuClient;
import accounts.Menu;

public class loader {
    public static void main(String[] args) {

        // ������� 6.1 ����� BankAccount, ������� ������������ ����� ��������� ����� � ����� � �������� � ����
//        Menu menu = new Menu();
//        menu.getMenu();
//
        // ������� 6.2 ������ �������������� �������� �����
        MenuClient menuClient = new MenuClient();
        menuClient.getMenu();

    }
}
