package Clients;

import accounts.BankAccount;

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
        bankAccount.printAccountBalance(bankAccount, "—◊≈“≈ ‘»«»◊≈— Œ√Œ À»÷¿");
    }
}
