public class main {

    public static void main(String[] args) {
        int vasyAge = 25;
        int katyAge = 36;
        int mishaAge = 30;


        int min = 1;
        int middle = 1;
        int max = 1;

        // max
        if ((vasyAge > katyAge) & (vasyAge > mishaAge)) {
            max = vasyAge;
        }
        if ((mishaAge > katyAge) & (mishaAge > vasyAge)) {
            max = mishaAge;
        }
        if ((katyAge > mishaAge) & (katyAge > vasyAge)) {
            max = katyAge;
        }

        // middle
        if ((vasyAge > katyAge) & (vasyAge < mishaAge) || ((vasyAge < katyAge) & (vasyAge > mishaAge))) {
            middle = vasyAge;
        }
        if (((mishaAge > katyAge) & (mishaAge < vasyAge)) || ((mishaAge < katyAge) & (mishaAge > vasyAge))) {
            middle = mishaAge;
        }
        if ((katyAge > mishaAge) & (katyAge < vasyAge) || ((katyAge < mishaAge) & (katyAge > vasyAge))) {
            middle = katyAge;
        }

        // min
        if ((vasyAge < katyAge) & (vasyAge < mishaAge)) {
            min = vasyAge;
        }
        if ((mishaAge < katyAge) & (mishaAge < vasyAge)) {
            min = mishaAge;
        }
        if ((katyAge < mishaAge) & (katyAge < vasyAge)) {
            min = katyAge;
        }


        System.out.println("Min age: " + min);
        System.out.println("Max age: " + max);
        System.out.println("Middle age: " + middle);

    }
}
