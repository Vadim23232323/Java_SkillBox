package Clients;

import accounts.BankAccount;

public abstract class Client extends BankAccount {

   public abstract void refillClientAccount();
   public abstract void withdrawClientAccount();
   public abstract void printClientAccountBalance();

}
