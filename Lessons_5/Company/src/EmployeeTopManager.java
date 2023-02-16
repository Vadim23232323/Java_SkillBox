import java.util.*;

public class EmployeeTopManager implements Employee{

    // Фиксированной часть зарплаты
    private static final int FIX_SALARY = 1500;

    // Зарплата сотрудника
    @Override
    public int getMonthSalary() {
        return FIX_SALARY + Company.getIncome() > 10000000 ? (int) (FIX_SALARY * 1.5) : 0;
    }
}
