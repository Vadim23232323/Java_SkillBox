public class main {
    public static void main(String[] args) {

      /*  // FOR
        for (int numberTicket = 200000; numberTicket <= 210000 ; numberTicket++) {
            System.out.println("Номер билета: " + numberTicket);
        }
        for (int numberTicket = 220000; numberTicket <= 235000 ; numberTicket++) {
            System.out.println("Номер билета: " + numberTicket);
        }
*/

        // WHILE

        int numberTicket = 200000;

        while (numberTicket < 220000) {
            ++numberTicket;
            System.out.println("Номер билета: " + numberTicket);
        }

        numberTicket = 220000;

        while (numberTicket < 235000) {
            ++numberTicket;
            System.out.println("Номер билета: " + numberTicket);
        }

    }
}
