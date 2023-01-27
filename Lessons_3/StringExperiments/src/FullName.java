import java.util.Scanner;

public class FullName {
    String fullName = "Dubovskiy Vadim Alexandrovich";
    String surname, name, patronymic, clearSpaceText;
    int indexSpace = 0, indexSpaceN = 0, indexSpaceP;

    // Метод ввода с клавиатуры ФИО
    public String setFullName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ФИО");

        fullName = scanner.nextLine();

        return fullName;
    }


    // Метод нахождения в строке и вывода Фамилии, Имя, Отчества
    public void getFullName() {

        clearSpaceText = fullName.trim();

        indexSpace = clearSpaceText.indexOf(' ');

        surname = fullName.substring(0, indexSpace);

        indexSpaceP = fullName.lastIndexOf(' ');

        patronymic = fullName.substring(indexSpaceP + 1);

        name = fullName.substring(indexSpace, indexSpaceP);

        System.out.println("Фамилия - " + surname);

        System.out.println("Имя - " + name);

        System.out.println("Отчество - " + patronymic);
    }

    public void getFullNameRegularExpressions() {
        String[] fio = fullName.split("\\s+", 3);

        for (int i = 0; i < fio.length; i++) {
            System.out.println(fio[i]);
        }

    }

}
