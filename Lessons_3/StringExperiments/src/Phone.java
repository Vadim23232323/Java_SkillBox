import java.util.Scanner;

public class Phone {

    String phone;

    public String setFullName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ���");

        phone = scanner.nextLine();

        return phone;
    }
}
