import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;


public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";


    public static void main(String[] args) throws ParseException {

        ArrayList<Employee> staff = loadStaffFromFile();
//        Stream<Employee> stream = staff.stream();



        // �������� N7.2.1 ������� � ������� � ������� Stream API ���������� � ������������ ��������� ����� ���, ��� ������ � 2017 ����.
        Date year = new SimpleDateFormat(dateFormat).parse("01.01.2017");
        System.out.println("��������� ���������� � 2017 ����: ");
        staff.stream().filter(employee -> employee.getWorkStart().compareTo(year) == 1).
                sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

        // �������� N7.2.1

        Airport airport = Airport.getInstance();

        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime twoHoursLater = nowDate.plusHours(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");

        System.out.println();
        System.out.println("Local time: " + nowDate.getHour() + ":" + nowDate.getMinute());

        airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)

                // Stream<Flight>
                .filter(flight -> {
                    LocalDateTime dt = toLocalDateTime(flight.getDate());
                    return flight.getType().equals(Flight.Type.DEPARTURE)
                            && dt.isAfter(nowDate)
                            && dt.isBefore(twoHoursLater);
                })

                .forEach(flight -> {
                    LocalDateTime dt = toLocalDateTime(flight.getDate());
                    System.out.println(
                            dt.format(formatter)
                                    + "\t"
                                    + flight.getAircraft().getModel()
                    );
                });


        Integer[] digits = {1,2,3,4,5,6,7,8,9};
        Arrays.stream(digits).map(String::valueOf).reduce((s1,s2) -> s1+s2).ifPresent(System.out::println);

        // ��������� stream ��������������� �������� > 100000 � �������� �� � �������
//        stream.filter(employee -> employee.getSalary() >= 100000).forEach(System.out::println);

//        Stream<Integer> number = Stream.of(1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10);
//        number.filter(num -> num % 2 == 0 ).forEach(System.out::println);

//        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10};
//        Arrays.stream(numbers).forEach(System.out::println);


        // ����� ���������� ��������� � ������� Comparator
//        Collections.sort(staff, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        // ����� ���������� ��������� � ������� Comparator � ������ ���������
//        Collections.sort(staff, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        // ����� ���������� ��������� � ������� Comparator � ������ ��������� � ����������
//        Collections.sort(staff, Comparator.comparing(Employee::getSalary));




        // ��������� stream ��������������� �������� > 100000 � �������� �� � �������, �������� ������
//        staff.stream().filter(e -> e.getSalary() >=100000 ).forEach(System.out::println);

        // ��������� stream ������������� ��������� �� �������� � �������� �� � �������, �������� ������
//        staff.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        // ��������� stream �������� ������������ �������� ���������, �������� ������
        // Optional<Employee> optional =  staff.stream().max(Comparator.comparing(Employee::getSalary));
        // Employee employee = optional.get();
//        staff.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

        // ��������� straem � ��� ����� map ��������������� �������� > 100000, ��������� ���������� �������� � �������� �� � �������, �������� ������
//        staff.stream().map(e->e.getSalary()).filter(s-> s >= 100000).reduce((s1,s2) -> s1 + s2).ifPresent(System.out::println);



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

    private static LocalDateTime toLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
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