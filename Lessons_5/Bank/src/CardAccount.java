import java.security.PublicKey;
import java.util.Scanner;

public class CardAccount extends BankAccount{

    Scanner scannerWithdrawCard = new Scanner(System.in);

    public newCardAccount(int money) {
        super(money);
    }

    public void withdrawCardAccount () {

        System.out.println("Введите сумму в белорусских рублях для снятия средств со счета: ");
        moneyAccount = scannerWithdrawCard.nextInt();
        moneyAccount= moneyAccount - ((moneyAccount*1)/100);


    }

}

