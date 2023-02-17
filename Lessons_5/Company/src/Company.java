import java.util.*;
import java.util.Scanner;

public class Company {
    private final List<Employee> employees = new ArrayList<Employee>();

    // Найм одного сотрудника
    public void hire(Employee employee, String nameJobTitle) {
        this.employees.add(employee);
        System.out.println("-------------------------------------------------------------------\n" +
                "Вы наняли сотрудника на должность " + nameJobTitle + " с зарплатой: " + employee.getMonthSalary() +
                "\n-------------------------------------------------------------------");
    }

    // Найм введенного количества сотрудников
    public void hireAll(Employee employee, String nameJobTitle) {
        int countEmployee;
        Scanner scanerEmployee = new Scanner(System.in);
        System.out.println("Введите кол-во сотрудников для найма: ");
        countEmployee = scanerEmployee.nextInt();
        for (int i = 0; i < countEmployee; i++) {
            this.employees.add(employee);
        }
        System.out.println("-------------------------------------------------------------------\n" +
                "Вы наняли " + countEmployee + " сотрудников на должность: " + nameJobTitle +
                "\n-------------------------------------------------------------------");

    }

    // Перегрузка метода найм введенного количества сотрудников
    public void hireAll(Employee employee, String nameJobTitle, int countEmployee) {
        for (int i = 0; i < countEmployee; i++) {
            employee = new EmployeeManager();
            this.employees.add(employee);
        }
        System.out.println("-------------------------------------------------------------------\n" +
                "Вы наняли " + countEmployee + " сотрудников на должность: " + nameJobTitle +
                "\n-------------------------------------------------------------------");

    }

    // Увольнение сотрудника
    public void fire() {
        int countEmployee;
        Scanner scanerEmployee = new Scanner(System.in);
        System.out.println("Введите кол-во сотрудников для увольнения: ");
        countEmployee = scanerEmployee.nextInt();
        if (countEmployee > employees.size()) {
            System.out.println("Вы хотите уволить количество сотрудников больше чем их работает в компании!!!" +
                    "\n\t В компании работает:" + employees.size());
        } else {
            for (int i = 0; i < countEmployee; i++) {
                int index = (int) (Math.random() * employees.size());
                Employee fired = employees.get(index);
                employees.remove(fired);
            }
            System.out.println("Уволено: " + countEmployee + " сотрудника компании");
        }

    }

    public static int getIncome() {
        return 700000000;
    }

    public void printArrayList() {
        System.out.println(Menu.ANSI_GREEN + " Список зарплат сотрудников: " + Menu.ANSI_RESET);
        System.out.println("-------------------------------------------------------------------");
        if (employees.size() == 0) {
            System.out.println("СПИСОК ПУСТ!!! Добавьте хотя бы одного сотрудника.");
        } else {
            for (Employee employee : employees) {
                System.out.println("Зарплата сотрудника: " + Menu.ANSI_GREEN + employee.getMonthSalary() + Menu.ANSI_RESET);
            }
        }
        System.out.println("-------------------------------------------------------------------");
    }

    //Сортировка по убыванию зарплат сотрудников
    List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o2.getMonthSalary() - o1.getMonthSalary();
            }

        });
        if (count > employees.size()) {
            System.out.println("Вы хотите вывести зарплаты сотрудников больше чем их работает в компании!!!" +
                    "\n\t В компании работает:" + employees.size());
        } else {
            System.out.println(count + " самых высоких зарплат: ");
            for (int i = 0; i < count; i++) {
                System.out.println("Зарплата сотрудника № " + (i + 1) + " : " + employees.get(i).getMonthSalary());
            }
        }
        return employees;
    }

    //Сортировка по возрастанию зарплат сотрудников
    List<Employee> getLowestSalaryStaff(int count) {

        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getMonthSalary() - o2.getMonthSalary();
            }

        });
        if (count > employees.size()) {
            System.out.println("Вы хотите вывести зарплаты сотрудников больше чем их работает в компании!!!" +
                    "\n\t В компании работает:" + employees.size());
        } else {
            System.out.println(count + " самых высоких зарплат: ");
            for (int i = 0; i < count; i++) {
                System.out.println("Зарплата сотрудника № " + (i + 1) + " : " + employees.get(i).getMonthSalary());
            }
        }
        return employees;
    }

}


