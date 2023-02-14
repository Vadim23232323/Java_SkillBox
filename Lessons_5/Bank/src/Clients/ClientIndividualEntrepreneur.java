package Clients;

import accounts.BankAccount;
import accounts.Menu;

import java.util.Date;

    // ������ �������������� ���������������
public class ClientIndividualEntrepreneur extends Client{

    BankAccount bankAccount = new BankAccount();

    @Override
    public void refillClientAccount() {

        double commission;

        System.out.println("������� ����� � ����������� ������ ��� ���������� �������:");

         bankAccount.moneyAccount = bankAccount.scannerRefill.nextInt() + bankAccount.moneyAccount;

         if (bankAccount.moneyAccount < 1000) {
             commission = (bankAccount.moneyAccount*1)/100;
             bankAccount.moneyAccount = (int) (bankAccount.moneyAccount - commission);
             System.out.println("------------------------------------------------------------------------");
             System.out.println("������� �� ����� ����� ���������� �������: " + Menu.ANSI_GREEN + bankAccount.moneyAccount + " BLR" + Menu.ANSI_RESET);
             System.out.println("�������� ����� ��������� 1%: " + Menu.ANSI_GREEN + commission + " BLR" + Menu.ANSI_RESET);
             bankAccount.printDateOperation();
             System.out.println("------------------------------------------------------------------------");
         } if (bankAccount.moneyAccount >= 1000) {
            commission = (bankAccount.moneyAccount*0.5)/100;
            bankAccount.moneyAccount = (int) (bankAccount.moneyAccount - commission);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("������� �� ����� ����� ���������� �������: " + Menu.ANSI_GREEN + bankAccount.moneyAccount + " BLR" + Menu.ANSI_RESET);
            System.out.println("�������� ����� ��������� 0.5%: " + Menu.ANSI_GREEN + commission + " BLR" + Menu.ANSI_RESET);
            bankAccount.printDateOperation();
            System.out.println("------------------------------------------------------------------------");
        }
    }

    @Override
    public void withdrawClientAccount() {
        bankAccount.withdrawAccount();
    }

    @Override
    public void printClientAccountBalance() {
        bankAccount.printAccountBalance(bankAccount, "����� ��������������� ���������������");
    }
}
