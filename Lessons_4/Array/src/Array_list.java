import java.util.Scanner;
import java.util.ArrayList;

// ������� 5.4 ������� ������ ���, ������� ����������� ��������� � �������. �������: LIST, ADD, EDIT, DELETE.
public class Array_list {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";
    ArrayList<String> todoList = new ArrayList<>();
    Scanner scanIndex = new Scanner(System.in);
    Scanner scanElement = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    String todoElement;
    int todoIndex = 0, command = 0;

    //����
    public void getMenu() {
        System.out.println("���� ������: " + ANSI_GREEN + "\" \n\t 1. LIST " + ANSI_RESET + "- ������� ������ ��� " +
                ANSI_GREEN + "\" \n\t 2. ADD " + ANSI_RESET + "- ��������� ������ � ������ ��� " +
                ANSI_GREEN + "\" \n\t 3. EDIT " + ANSI_RESET + "- �������� ������ � ������ ��� " +
                ANSI_GREEN + "\" \n\t 4. DELETE " + ANSI_RESET + "- ������� ������ ������ " +
                ANSI_GREEN + "\" \n\t 5. DELETE-ALL " + ANSI_RESET + "- ������� ��� ������ � ������ ���" +
                ANSI_GREEN + "\" \n\t 6. EXIT " + ANSI_RESET + "- ����� �� ����������.");
        setCommand();
    }

    //���� � ������� ������ �������
    public void setCommand() {

        command = 0;

        System.out.println("������� � �������: ");

        command = scanner.nextInt();

        switch (command) {
            case 1:
                printArrayList();
                break;
            case 2:
                setAddArrayList();
                getMenu();
            case 3:
                setEditArrayList();
                getMenu();
            case 4:
                setDeleteArrayList();
                getMenu();
            case 5:
                setDeleteAllArrayList();
                getMenu();
            case 6:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("���������� ��������� ������.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:
                if (command < 0 || command > 6) {
                    System.out.println("������� �������� �������! ������� ������� ��������.");
                }
                getMenu();
        }
    }

    // ���������� ������ � ArrayList �� �������
    public ArrayList<String> setAddArrayList() {
        System.out.println("������� � ������");
        todoIndex = scanIndex.nextInt();
        System.out.println("������� �������� ������: ");
        todoElement = scanElement.nextLine();
        todoList.add(todoIndex, todoElement);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("������ " + ANSI_GREEN + "� " + todoIndex + " : " + todoElement + ANSI_RESET + " ��������� � ������ ");
        System.out.println("-------------------------------------------------------------------");
        command = 0;
        return todoList;
    }

    // ��������� ������ � ArrayList �� �������
    public ArrayList<String> setEditArrayList() {

        System.out.println("������� � ������ ������� ������ ��������:");
        todoIndex = scanIndex.nextInt();
        System.out.println("������� ����� �������� ������: ");
        todoElement = scanElement.nextLine();
        todoList.set(todoIndex, todoElement);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("������ " + ANSI_GREEN + todoElement + ANSI_RESET + " �������� � ������ ");
        System.out.println("-------------------------------------------------------------------");
        getMenu();
        return todoList;
    }

    // �������� ������ �� ArrayList
    public ArrayList<String> setDeleteArrayList() {
        System.out.println("������� � ������ ������� ������ �������:");
        todoIndex = scanIndex.nextInt();
        todoList.remove(todoIndex);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("������ " + ANSI_GREEN + todoElement + ANSI_RESET + " ������� �� ������ ");
        System.out.println("-------------------------------------------------------------------");
        return todoList;
    }

    // �������� ���� ������� �� ArrayList
    public ArrayList<String> setDeleteAllArrayList() {
        todoList.removeAll(todoList);
        System.out.println("������ ������ ");
        return todoList;
    }

    // ����� ������ � �������
    public void printArrayList() {

        System.out.println(ANSI_GREEN + " ������ ���: " + ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        if (todoList.size() == 0) {
            System.out.println("������ ����!!! �������� ������ � ������.");
        } else {
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println("������ �" + i + ": " + todoList.get(i));
            }
        }
        System.out.println("-------------------------------------------------------------------");
        getMenu();
    }

}
