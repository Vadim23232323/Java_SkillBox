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

        // ��������� stream ��������������� �������� > 100000 � �������� �� � �������
//        stream.filter(employee -> employee.getSalary() >= 100000).forEach(System.out::println);

        Stream<Integer> number = Stream.of(1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10);
        number.filter(num -> num % 2 == 0 ).forEach(System.out::println);

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10};
        Arrays.stream(numbers).forEach(System.out::println);


        // ����� ���������� ��������� � ������� Comparator
//        Collections.sort(staff, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        // ����� ���������� ��������� � ������� Comparator � ������ ���������
        Collections.sort(staff, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        // ����� ���������� ��������� � ������� Comparator � ������ ��������� � ����������
        Collections.sort(staff, Comparator.comparing(Employee::getSalary));


        // ��������� stream ��������������� �������� > 100000 � �������� �� � �������, �������� ������
        staff.stream().filter(e -> e.getSalary() >=120000 ).forEach(System.out::println);

        // ��������� stream ������������� ��������� �� �������� � �������� �� � �������, �������� ������
        staff.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        // ��������� stream �������� ������������ �������� ���������, �������� ������
        // Optional<Employee> optional =  staff.stream().max(Comparator.comparing(Employee::getSalary));
        // Employee employee = optional.get();
        staff.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);


//        for (Employee staf: staff) {
//            System.out.println(staf);
//        }

        // ����� forEach ��� �������� ��������� � �������������� ������ ���������
//      staff.forEach(Employee -> System.out.println(Employee));

        // ����� forEach ��� �������� ��������� � �������������� ������ ��������� � ����������
//        System.out.println("������ �������� �����������: ");
//        staff.forEach(System.out::println);


//        System.out.println("����� �������� �����������:");
//        for (Employee staf: staff) {
//            int salary = staf.getSalary();
//            staf.setSalary(salary + 10000);
//            System.out.println(staf);
//        }

        // ����� forEach ��� �������� ��������� � �������������� ������ ��������� � ����������
//        staff.forEach(employee -> {
//            int salary = employee.getSalary();
//            employee.setSalary(salary + 1000);
//        });

        // ����� forEach ����������� ��� �������� ��������� � ���������� �������� �� 10000 � �������������� ������ ��������� � ����������
//        staff.forEach(employee -> employee.setSalary(employee.getSalary() + 1000));


        // ����������� stream �����
//        Stream.iterate(1, n->n+1).forEach(System.out::println);

        // ����������� stream ������ "aaa"
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