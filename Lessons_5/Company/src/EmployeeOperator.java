public class EmployeeOperator implements Employee{

    // ������������� ����� ��������
    private static final int FIX_SALARY = 1100;

    // �������� ����������
    @Override
    public int getMonthSalary() {
        return FIX_SALARY;
    }
}
