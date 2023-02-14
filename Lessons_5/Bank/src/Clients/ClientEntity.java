package Clients;

import accounts.CardAccount;

    // ������ ����������� ����
public class ClientEntity extends Client {

    CardAccount cardAccount = new CardAccount();

    @Override
    public void refillClientAccount() {
        cardAccount.refillAccount();
    }

    @Override
    public void withdrawClientAccount() {
        cardAccount.withdrawCardAccount();
    }

    @Override
    public void printClientAccountBalance() {
        cardAccount.printAccountBalance(cardAccount, "����� ������������ ����");
    }
}
