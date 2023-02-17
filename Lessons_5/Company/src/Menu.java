import java.util.Scanner;

public class Menu {

    // ������ ������� ���� ������
    public static final String ANSI_GREEN = "\u001B[32m";
    // ������ ����������� ���� ������
    public static final String ANSI_RESET = "\u001B[0m";

    Company company = new Company();
    Employee operator = new EmployeeOperator();
    Employee manager = new EmployeeManager();
    Employee topManager = new EmployeeTopManager();

    int command;

    // ����
    public void getMenu() {
        System.out.println("���� ������: " + ANSI_GREEN + "\" \n\t 1. " + ANSI_RESET + "������ �����������." +
                ANSI_GREEN + "\" \n\t 2. " + ANSI_RESET + "������ � �������� ���������." +
                ANSI_GREEN + "\" \n\t 3. " + ANSI_RESET + "������ � �������� ���������." +
                ANSI_GREEN + "\" \n\t 4. " + ANSI_RESET + "������ � �������� ���-���������." +
                ANSI_GREEN + "\" \n\t 5. " + ANSI_RESET + "������ � �������� ����������" +
                ANSI_GREEN + "\" \n\t 6. " + ANSI_RESET + "������ � �������� ����������" +
                ANSI_GREEN + "\" \n\t 7. " + ANSI_RESET + "������ � �������� ���-����������" +
                ANSI_GREEN + "\" \n\t 8. " + ANSI_RESET + "���������� �����������." +
                ANSI_GREEN + "\" \n\t 9. " + ANSI_RESET + "������ ����� ������� �������." +
                ANSI_GREEN + "\" \n\t 10. " + ANSI_RESET + "������ ����� ������ �������." +
                ANSI_GREEN + "\" \n\t 11. " + ANSI_RESET + "����� �� ����������.");
        setCommand();
    }

    //���� � ������� ������ �������
    private void setCommand() {

        Scanner scanner = new Scanner(System.in);

        int command = 0;

        System.out.println("������� � �������: ");

        command = scanner.nextInt();

        switch (command) {
            case 1:
                company.printArrayList();
                getMenu();
            case 2:
                company.hire(operator, "���������");
                getMenu();
            case 3:
                company.hire(manager, "���������");
                getMenu();
            case 4:
                company.hire(topManager,"���-���������");
                getMenu();
            case 5:
                company.hireAll(operator, "���������");
                getMenu();
            case 6:
                Scanner scanerEmployee = new Scanner(System.in);
                System.out.println("������� ���-�� ����������� ��� �����: ");
                int countEmployee = scanerEmployee.nextInt();
                company.hireAll(manager, "���������", countEmployee);
                getMenu();
            case 7:
                company.hireAll(topManager, "���-���������");
                getMenu();
            case 8:
                company.fire();
                getMenu();
            case 9:
                Scanner scanerCount = new Scanner(System.in);
                System.out.println("������� ���-�� �����������: ");
                int count = scanerCount.nextInt();
                company.getTopSalaryStaff(count);
                getMenu();
            case 10:
                Scanner scanerCount2 = new Scanner(System.in);
                System.out.println("������� ���-�� �����������: ");
                count = scanerCount2.nextInt();
                company.getLowestSalaryStaff(count);
                getMenu();
            case 11:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("���������� ��������� ������.");
                System.out.println("-------------------------------------------------------------------");
                break;
            default:
                if (command < 1 || command > 11) {
                    System.out.println("������� �������� �������! ������� ������� ��������.");
                }
                getMenu();
        }
    }
}
