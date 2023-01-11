import java.util.Scanner;


public class Main {
    private static int minIncome = 200000;
    private static int maxIncome = 900000;

    private static int officeRentCharge = 140000;
    private static int telephonyCharge = 12000;
    private static int internetAccessCharge = 7200;

    private static int assistantSalary = 45000;
    private static int financeManagerSalary = 90000;

    private static double mainTaxPercent = 0.24;
    private static double managerPercent = 0.15;

    private static double minInvestmentsAmount = 100000;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите сумму доходов компании за месяц " +
                "(от 200 до 900 тысяч рублей): ");
            int income = (new Scanner(System.in)).nextInt();

            if (!checkIncomeRange(income)) {
                continue;
            }

            // Зарплата менеджера
            double managerSalary = income * managerPercent;
            
            // Чистый доход
            double pureIncome = income - managerSalary -
                calculateFixedCharges();

            if (pureIncome < 0 ) {
                double stopPoint = income + Math.abs(pureIncome);
                System.out.println("Доход компании должен составлять :" + stopPoint + " что бы быть неубыточной ");
                continue;
            }
            // Налог от чистого дохода
            double taxAmount = mainTaxPercent * pureIncome;

            // Чистый доход после налогообложения
            double pureIncomeAfterTax = pureIncome - taxAmount;

            // Может ли инвестировать компания
            boolean canMakeInvestments = pureIncomeAfterTax >=
                minInvestmentsAmount;

            System.out.println("Зарплата менеджера: " + managerSalary);
            System.out.println("Общая сумма налогов: " +
                (taxAmount > 0 ? taxAmount : 0));
            System.out.println("Компания может инвестировать: " +
                (canMakeInvestments ? "да" : "нет"));
            if (pureIncome < 0) {
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!");
            }
        }
    }

    // Метод проверки дохода компании на соответствие условию минимальной и максимальной границы дохода
    private static boolean checkIncomeRange(int income) {
        if (income < minIncome) {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if (income > maxIncome) {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true;
    }

    // Возвращает сумму коммунальных расходов
    private static int calculateFixedCharges() {
        return officeRentCharge +
            telephonyCharge +
            internetAccessCharge +
            assistantSalary +
            financeManagerSalary;
    }
}
