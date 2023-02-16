public class EmployeeManager implements Employee{
    private static final int FIX_SALARY = 1100;
    private final int earningsForCompany;

    // ���������� ������������ ����� ��� �������� ��������������� ��������� ������� �� 115 000 �� 140 000 ������
    public EmployeeManager() {
        this.earningsForCompany = (int) (Math.random() * 25000) + 115000;
    }

    // �������� ����������
    @Override
    public int getMonthSalary() {
        return FIX_SALARY + earningsForCompany;
    }
}
