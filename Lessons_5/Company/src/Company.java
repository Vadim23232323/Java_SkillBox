import java.util.*;
import java.util.Scanner;
public class Company {
    private final List<Employee> employees = new ArrayList<Employee>();

    public void hire(Employee employee, String nameJobTitle) {
        this.employees.add(employee);
        System.out.println("-------------------------------------------------------------------\n" +
                "Вы наняли сотрудника на должность " + nameJobTitle + " с зарплатой: " + employee.getMonthSalary() +
                "\n-------------------------------------------------------------------");
    }

    public void hireAll(Employee employee, String nameJobTitle) {
        int countEmployee;
        Scanner scanerEmployee = new Scanner(System.in);
        System.out.println("Введите кол-во сотрудников для найма: ");
        countEmployee = scanerEmployee.nextInt();
        for (int i = 0; i < countEmployee; i++) {
            this.employees.add(employee);
        }
        System.out.println("-------------------------------------------------------------------\n" +
                "Вы наняли " + countEmployee +" сотрудников на должность: " + nameJobTitle +
                "\n-------------------------------------------------------------------");

    }

    public void fire() {

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

   List<Employee> getTopSalaryStaff(int count) {
        for (int i =0; i < count; i++ ) {

        }
        return employees;
   }
//
//	List<Employee> getLowestSalaryStaff(int count){
//
//   }



}
