import java.util.Scanner;

public class FullName {
    String fullName = "Dubovskiy Vadim Alexandrovich";
    String surname, name, patronymic, clearSpaceText;
    int indexSpace = 0, indexSpaceN = 0, indexSpaceP;

    // ����� ����� � ���������� ���
    public String setFullName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ���");

        fullName = scanner.nextLine();

        return fullName;
    }


    // ����� ���������� � ������ � ������ �������, ���, ��������
    public void getFullName() {

        clearSpaceText = fullName.trim();

        indexSpace = clearSpaceText.indexOf(' ');

        surname = fullName.substring(0, indexSpace);

        indexSpaceP = fullName.lastIndexOf(' ');

        patronymic = fullName.substring(indexSpaceP + 1);

        name = fullName.substring(indexSpace, indexSpaceP);

        System.out.println("������� - " + surname);

        System.out.println("��� - " + name);

        System.out.println("�������� - " + patronymic);
    }

    public void getFullNameRegularExpressions() {
        String[] fio = fullName.split("\\s+", 3);

        for (int i = 0; i < fio.length; i++) {
            System.out.println(fio[i]);
        }

    }

}
