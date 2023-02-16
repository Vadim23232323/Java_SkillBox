import java.util.*;

public class EmployeeTopManager implements Employee{

    // ������������� ����� ��������
    private static final int FIX_SALARY = 1500;

    // �������� ����������
    @Override
    public int getMonthSalary() {
        return FIX_SALARY + Company.getIncome() > 10000000 ? (int) (FIX_SALARY * 1.5) : 0;
    }
}
