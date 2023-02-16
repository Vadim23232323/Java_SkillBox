package Clients;

import accounts.BankAccount;

   // Абстрактный класс и три обязательных метода для операций со счетами клиентов
public abstract class Client extends BankAccount {

   public abstract void refillClientAccount();
   public abstract void withdrawClientAccount();
   public abstract void printClientAccountBalance();


}
