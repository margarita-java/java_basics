import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();

        for (int i = 0; i < 180; i++) {
            company.hire(new Operator(50_000));
        }
        for (int i = 0; i < 80; i++) {
            company.hire(new Manager(70_000, company));
        }
        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager(100_000, company));
        }

        List<Employee> topSalaries = company.getTopSalaryStaff(15);
        System.out.println("Список самых высоких зарплат в компании: ");
        for (Employee employee : topSalaries) {
            System.out.printf("%.2f руб.%n", employee.getMonthSalary());
        }


        List<Employee> lowSalaries = company.getLowestSalaryStaff(30);
        for (Employee employee : lowSalaries) {
            System.out.printf("%.2f руб.%n", employee.getMonthSalary());
        }

        int half = company.getEmployees().size() / 2;
        for (int i = 0; i < half; i++) {
            company.fire(company.getEmployees().get(0));
        }

        System.out.println("Список самых высоких зарплат после увольнения:");
        topSalaries = company.getTopSalaryStaff(15);
        for (Employee employee : topSalaries) {
            System.out.printf("%.2f руб.%n", employee.getMonthSalary());
        }

        System.out.println("Список самых низких зарплат после увольнения:");
        lowSalaries = company.getLowestSalaryStaff(30);
        for (Employee employee : lowSalaries) {
            System.out.printf("%.2f руб.%n", employee.getMonthSalary());
        }
    }
}