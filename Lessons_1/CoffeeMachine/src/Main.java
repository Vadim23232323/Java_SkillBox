import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        // ��������� ����������
        int moneyAmout = 200;
        int cappucinoPrice = 180;
        int latePrice = 120;
        int espressoPrice = 80;
        int waterPrice = 20;
        boolean isMilkEnought = true   ;
        boolean canBuyAnything = false;
        boolean moneyEnoughtForCappucino = moneyAmout >=cappucinoPrice;


        System.out.println("Enter the amout of money in the wallet");

        //����� ����� � ��������
        moneyAmout = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());

        System.out.println("--------------------------------------------------------------------------");

        if (moneyEnoughtForCappucino && isMilkEnought) {
            System.out.println("You can buy : cappucino | ��������");
            canBuyAnything = true;
        }
        if (moneyAmout >=latePrice && isMilkEnought == true) {
            System.out.println("You can buy : late | ��������");
            canBuyAnything = true;
        }
        if (moneyAmout >=espressoPrice) {
            System.out.println("You can buy : espresso | �������");
            canBuyAnything = true;
        }
        if (moneyAmout >=waterPrice) {
            System.out.println("You can buy : water | ����");
            canBuyAnything = true;
        }

        if (!canBuyAnything) {
            System.out.println("Insufficient funds | ������������ �������");
        }
    }
}
