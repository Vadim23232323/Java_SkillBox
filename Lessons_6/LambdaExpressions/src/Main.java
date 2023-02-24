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



        // Заданине N7.2.1 Выведит в консоль с помощью Stream API сотрудника с максимальной зарплатой среди тех, кто пришёл в 2017 году.
        Date year = new SimpleDateFormat(dateFormat).parse("01.01.2017");
        System.out.println("Работники устроенные в 2017 году: ");
        staff.stream().filter(employee -> employee.getWorkStart().compareTo(year) == 1).
                sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

        // Заданине N7.2.1

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

        // Используя stream отфильтровываем зарплаты > 100000 и печатаем их в консоль
//        stream.filter(employee -> employee.getSalary() >= 100000).forEach(System.out::println);

//        Stream<Integer> number = Stream.of(1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10);
//        number.filter(num -> num % 2 == 0 ).forEach(System.out::println);

//        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8 ,9 ,10};
//        Arrays.stream(numbers).forEach(System.out::println);


        // Метод Сортировки коллекции с помощью Comparator
//        Collections.sort(staff, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        // Метод Сортировки коллекции с помощью Comparator и лямбда выражений
//        Collections.sort(staff, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        // Метод Сортировки коллекции с помощью Comparator и лямбда выражений и указателей
//        Collections.sort(staff, Comparator.comparing(Employee::getSalary));




        // Используя stream отфильтровываем зарплаты > 100000 и печатаем их в консоль, короткий способ
//        staff.stream().filter(e -> e.getSalary() >=100000 ).forEach(System.out::println);

        // Используя stream отсортировать коллекцию по зарплате и печатаем их в консоль, короткий способ
//        staff.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        // Используя stream получаем максимальную зарплату коллекции, короткий способ
        // Optional<Employee> optional =  staff.stream().max(Comparator.comparing(Employee::getSalary));
        // Employee employee = optional.get();
//        staff.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

        // Используя straem и его метод map отфильтровываем зарплаты > 100000, суммируем полученные зарплаты и печатаем их в консоль, короткий способ
//        staff.stream().map(e->e.getSalary()).filter(s-> s >= 100000).reduce((s1,s2) -> s1 + s2).ifPresent(System.out::println);



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