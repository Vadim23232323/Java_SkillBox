public class EmployeeOperator implements Employee{

    // Фиксированной часть зарплаты
    private static final int FIX_SALARY = 1100;

    // Зарплата сотрудника
    @Override
    public int getMonthSalary() {
        return FIX_SALARY;
    }
}
