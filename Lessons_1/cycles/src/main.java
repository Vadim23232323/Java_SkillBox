public class main {
    public static void main(String[] args) {

        // cycle for
        for (int age = 15; age<40; age++) {
            System.out.print(age + " ���; �� ������: ");
            if (age >=16 && age < 18) {
                System.out.print("����� ����������� �����, ");
            }
            else if (age >= 18) {
                System.out.print("����� ������� ����� ");
            }
            else {
                System.out.print("������ ����");
            }
            if (age >= 35) {
                System.out.print(", �� ������ ���������������");
            }
            System.out.println();
        }

        /*// cycle while
        int age = 15;

        while (age < 40) {
            System.out.print(age + " ���; �� ������: ");
            if (age >=16 && age < 18) {
                System.out.print("����� ����������� �����, ");
            }
            else if (age >= 18) {
                System.out.print("����� ������� ����� ");
            }
            else {
                System.out.print("������ ����");
            }
            if (age >= 35) {
                System.out.print(", �� ������ ���������������");
            }
            System.out.println();
        }*/
    }
}
