import java.util.*;
import java.util.Scanner;

public class Company {
    private final List<Employee> employees = new ArrayList<Employee>();

    // ���� ������ ����������
    public void hire(Employee employee, String nameJobTitle) {
        this.employees.add(employee);
        System.out.println("-------------------------------------------------------------------\n" +
                "�� ������ ���������� �� ��������� " + nameJobTitle + " � ���������: " + employee.getMonthSalary() +
                "\n-------------------------------------------------------------------");
    }

    // ���� ���������� ���������� �����������
    public void hireAll(Employee employee, String nameJobTitle) {
        int countEmployee;
        Scanner scanerEmployee = new Scanner(System.in);
        System.out.println("������� ���-�� ����������� ��� �����: ");
        countEmployee = scanerEmployee.nextInt();
        for (int i = 0; i < countEmployee; i++) {
            this.employees.add(employee);
        }
        System.out.println("-------------------------------------------------------------------\n" +
                "�� ������ " + countEmployee + " ����������� �� ���������: " + nameJobTitle +
                "\n-------------------------------------------------------------------");

    }

    // ���������� ������ ���� ���������� ���������� �����������
    public void hireAll(Employee employee, String nameJobTitle, int countEmployee) {
        for (int i = 0; i < countEmployee; i++) {
            employee = new EmployeeManager();
            this.employees.add(employee);
        }
        System.out.println("-------------------------------------------------------------------\n" +
                "�� ������ " + countEmployee + " ����������� �� ���������: " + nameJobTitle +
                "\n-------------------------------------------------------------------");

    }

    // ���������� ����������
    public void fire() {
        int countEmployee;
        Scanner scanerEmployee = new Scanner(System.in);
        System.out.println("������� ���-�� ����������� ��� ����������: ");
        countEmployee = scanerEmployee.nextInt();
        if (countEmployee > employees.size()) {
            System.out.println("�� ������ ������� ���������� ����������� ������ ��� �� �������� � ��������!!!" +
                    "\n\t � �������� ��������:" + employees.size());
        } else {
            for (int i = 0; i < countEmployee; i++) {
                int index = (int) (Math.random() * employees.size());
                Employee fired = employees.get(index);
                employees.remove(fired);
            }
            System.out.println("�������: " + countEmployee + " ���������� ��������");
        }

    }

    public static int getIncome() {
        return 700000000;
    }

    public void printArrayList() {
        System.out.println(Menu.ANSI_GREEN + " ������ ������� �����������: " + Menu.ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        if (employees.size() == 0) {
            System.out.println("������ ����!!! �������� ���� �� ������ ����������.");
        } else {
            for (Employee employee : employees) {
                System.out.println("�������� ����������: " + Menu.ANSI_GREEN + employee.getMonthSalary() + Menu.ANSI_RESET);
            }
        }
        System.out.println("-------------------------------------------------------------------");
    }

    //���������� �� �������� ������� �����������
    List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o2.getMonthSalary() - o1.getMonthSalary();
            }

        });
        if (count > employees.size()) {
            System.out.println("�� ������ ������� �������� ����������� ������ ��� �� �������� � ��������!!!" +
                    "\n\t � �������� ��������:" + employees.size());
        } else {
            System.out.println(count + " ����� ������� �������: ");
            for (int i = 0; i < count; i++) {
                System.out.println("�������� ���������� � " + (i + 1) + " : " + employees.get(i).getMonthSalary());
            }
        }
        return employees;
    }

    //���������� �� ����������� ������� �����������
    List<Employee> getLowestSalaryStaff(int count) {

        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getMonthSalary() - o2.getMonthSalary();
            }

        });
        if (count > employees.size()) {
            System.out.println("�� ������ ������� �������� ����������� ������ ��� �� �������� � ��������!!!" +
                    "\n\t � �������� ��������:" + employees.size());
        } else {
            System.out.println(count + " ����� ������� �������: ");
            for (int i = 0; i < count; i++) {
                System.out.println("�������� ���������� � " + (i + 1) + " : " + employees.get(i).getMonthSalary());
            }
        }
        return employees;
    }

}


