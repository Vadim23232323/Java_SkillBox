import java.security.PublicKey;
import java.util.Scanner;
    // // Карточный счёт, при снятии денег с которого взимаеться комиссия 1%
public class CardAccount extends BankAccount{

    Scanner scannerWithdrawCard = new Scanner(System.in);


    // Снятия средств со счета
    public void withdrawCardAccount () {

        int withdrawMoney, commission;

        System.out.println("Введите сумму в белорусских рублях для снятия средств с карт счета: ");

        withdrawMoney = scannerwithdrawMoney.nextInt();

        commission = (withdrawMoney*1)/100;

        if (withdrawMoney > moneyAccount || withdrawMoney <= 0) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Недостаточно средств! Баланс вашего счета составляет: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        } else {

            moneyAccount = moneyAccount - withdrawMoney - commission;

            System.out.println("------------------------------------------------------------------------");
            System.out.println("Операция завершена успешно!");
            System.out.println("Сумма снятая со счета: " + ANSI_GREEN + withdrawMoney + " BLR" + ANSI_RESET);
            System.out.println("Баланс вашего счета составляет: " + ANSI_GREEN + moneyAccount + " BLR" + ANSI_RESET);
            System.out.println("Комиссия банка составила 1%: " + ANSI_GREEN + commission + " BLR" + ANSI_RESET);
            System.out.println("------------------------------------------------------------------------");
        }

    }

}

