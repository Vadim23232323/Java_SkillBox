public class EmployeeManager implements Employee{
    private static final int FIX_SALARY = 1100;
    private final int earningsForCompany;

    // Количество заработанных денег для компании сгенерированных случайным образом от 115 000 до 140 000 рублей
    public EmployeeManager() {
        this.earningsForCompany = (int) (Math.random() * 25000) + 115000;
    }

    // Зарплата сотрудника
    @Override
    public int getMonthSalary() {
        return FIX_SALARY + earningsForCompany;
    }
}
