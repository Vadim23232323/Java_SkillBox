import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {

    String phone ;

    public String setPhoneNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер мобильного телефона: ");

        phone = scanner.nextLine();

        return phone;
    }


    public void formatPhone() {

        String numberPhone = phone.replaceAll("[^0-9]", "");

        StringBuilder sb = new StringBuilder(numberPhone);

        if (numberPhone.length() == 12 & numberPhone.charAt(0) == '8') {

            sb.setCharAt(0, '3');
            numberPhone = sb.toString();
            System.out.println("Номер мобильного телефона Беларуси: " + numberPhone);
        }

        else {
            System.out.println("Неверный формат номера: " + numberPhone);
        }
    }


}
