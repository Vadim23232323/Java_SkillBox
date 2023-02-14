package Clients;

import accounts.BankAccount;

    // Êëèåíò ôèçè÷åñêîå ëèöî
public class ClientIndividual extends Client {
    BankAccount bankAccount = new BankAccount();


    @Override
    public void refillClientAccount() {
        bankAccount.refillAccount();
    }

    @Override
    public void withdrawClientAccount() {
        bankAccount.withdrawAccount();
    }

    @Override
    public void printClientAccountBalance() {
        bankAccount.printAccountBalance(bankAccount, "Ñ×ÅÒÅ ÔÈÇÈ×ÅÑÊÎÃÎ ËÈÖÀ");
    }
}
