import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class main {


    public static void main(String[] args) {

        Bank bank = new Bank();
        // HashMap ���������� ������
        HashMap<String, Account> accounts = new HashMap<>();
        // List �������
        List<Thread> threadList = new ArrayList<>();
        Random random = new Random();



        // ������� 100 ������ � ���������� ���������
        for (int i = 0; i < 100; i++) {
            long amountAccount = ThreadLocalRandom.current().nextLong(10000, 900000);
            accounts.put("" + i, new Account("" + i, amountAccount));
        }

        // ������������� �����
        bank.setAccounts(accounts);


        // ������� ������� �� ������ ����� �� ����������
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("������� �� ����� � " + i + " ������: " + bank.getBalance(Integer.toString(i)));
        }


        // ������� 100 ���������� � ���������� ������
        for (int i = 0; i < 100; i++) {
            String fromAccNum = "" + random.nextInt(accounts.size());
            String toAccNum = "" + random.nextInt(accounts.size());
            long amountTransferred = ThreadLocalRandom.current().nextLong(30000, 52000);
            Thread thread = new Thread(() -> {
                bank.transfer(fromAccNum,toAccNum,amountTransferred);
            }," THEAD");
            thread.start();
            threadList.add(thread);
        }

        // ������� ������� �� ������ ����� ����� ����������
        System.out.println("--------------------------------------------------------------------------------");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("������� �� ����� � " + i + " ������: " + bank.getBalance(Integer.toString(i)));
        }
    }
}
