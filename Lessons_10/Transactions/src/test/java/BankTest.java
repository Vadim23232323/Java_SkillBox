import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.when;

public class BankTest extends TestCase {

    private static final String NOT_EXPECTED_MAP_ACC_MESSAGE = "Карта счетов не соответствует ожидаемой";
    private static final String NOT_EXPECTED_BALANCE_ACC_MESSAGE = "Баланс счета не соответствует ожидаемому";
    private static final String NOT_EXPECTED_IS_FRAG_MESSAGE = "Флаг проверки СБ не соответствует ожидаемому";
    private Bank bank = new Bank();
    // HashMap Банковских счетов
    private HashMap<String, Account> accounts = new HashMap<>();
    // List потоков
    private List<Thread> threadList = new ArrayList<>();

    @Override
    protected void setUp() throws Exception {
        accounts.put("1", new Account("1", 70000));
        accounts.put("2", new Account("2", 3000));
        accounts.put("3", new Account("3", 5000));
        bank.setAccounts(accounts);
        bank.transfer("1","2", 50000);
        bank.transfer("2","3", 100);

    }

    @DisplayName("Метод transfer")
    public void testTransfer() {
        long accountAmount = bank.getBalance(Integer.toString(1));
        long accountAmount2 = bank.getBalance(Integer.toString(2));
        long accountAmount3 = bank.getBalance(Integer.toString(3));

        assertEquals(20000, accountAmount);
        assertEquals(52900, accountAmount2);
        assertEquals(5100, accountAmount3);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
