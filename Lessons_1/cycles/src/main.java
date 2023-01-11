public class main {
    public static void main(String[] args) {

        // cycle for
        for (int age = 15; age<40; age++) {
            System.out.print(age + " Лет; вы можете: ");
            if (age >=16 && age < 18) {
                System.out.print("Иметь ученические права, ");
            }
            else if (age >= 18) {
                System.out.print("Иметь обычные права ");
            }
            else {
                System.out.print("Просто жить");
            }
            if (age >= 35) {
                System.out.print(", вы можете баллотироваться");
            }
            System.out.println();
        }

        /*// cycle while
        int age = 15;

        while (age < 40) {
            System.out.print(age + " Лет; вы можете: ");
            if (age >=16 && age < 18) {
                System.out.print("Иметь ученические права, ");
            }
            else if (age >= 18) {
                System.out.print("Иметь обычные права ");
            }
            else {
                System.out.print("Просто жить");
            }
            if (age >= 35) {
                System.out.print(", вы можете баллотироваться");
            }
            System.out.println();
        }*/
    }
}
