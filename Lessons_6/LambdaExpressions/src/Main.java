import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args)
    {
        ArrayList<Employee> staff = loadStaffFromFile();

        Stream<Employee> stream = staff.stream();

        // Используя stream отфильтровываем зарплаты > 100000 и печатаем их в консоль
//        stream.filter(employee -> employee.getSalary() >= 100000).forEach(System.out::println);

        Stream<Integer> number = Stream.of(1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10);
        number.filter(num -> num % 2 == 0 ).forEach(System.out::println);

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10};
        Arrays.stream(numbers).forEach(System.out::println);


        // Метод Сортировки коллекции с помощью Comparator
//        Collections.sort(staff, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        // Метод Сортировки коллекции с помощью Comparator и лямбда выражений
        Collections.sort(staff, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        // Метод Сортировки коллекции с помощью Comparator и лямбда выражений и указателей
        Collections.sort(staff, Comparator.comparing(Employee::getSalary));


        // Используя stream отфильтровываем зарплаты > 100000 и печатаем их в консоль, короткий способ
        staff.stream().filter(e -> e.getSalary() >=120000 ).forEach(System.out::println);

        // Используя stream отсортировать коллекцию по зарплате и печатаем их в консоль, короткий способ
        staff.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        // Используя stream получаем максимальную зарплату коллекции, короткий способ
        // Optional<Employee> optional =  staff.stream().max(Comparator.comparing(Employee::getSalary));
        // Employee employee = optional.get();
        staff.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);


//        for (Employee staf: staff) {
//            System.out.println(staf);
//        }

        // Метод forEach для перебора коллекции с использованием лямбда выражений
//      staff.forEach(Employee -> System.out.println(Employee));

        // Метод forEach для перебора коллекции с использованием лямбда выражений и указателей
//        System.out.println("Старая зарплата сотрудников: ");
//        staff.forEach(System.out::println);


//        System.out.println("Новая зарплата сотрудников:");
//        for (Employee staf: staff) {
//            int salary = staf.getSalary();
//            staf.setSalary(salary + 10000);
//            System.out.println(staf);
//        }

        // Метод forEach для перебора коллекции с использованием лямбда выражений и указателей
//        staff.forEach(employee -> {
//            int salary = employee.getSalary();
//            employee.setSalary(salary + 1000);
//        });

        // Метод forEach сокращенный для перебора коллекции и увелечения зарплаты на 10000 с использованием лямбда выражений и указателей
//        staff.forEach(employee -> employee.setSalary(employee.getSalary() + 1000));


        // Бесконечный stream чисел
//        Stream.iterate(1, n->n+1).forEach(System.out::println);

        // Бесконечный stream строки "aaa"
//        Stream.generate(()->"aaa").forEach(System.out::print);

    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}