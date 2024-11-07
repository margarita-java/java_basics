import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;


public class Company {

    private double income;
    private List<Employee> employees = new ArrayList<Employee>();

    // найм одного сотрудника
    public void hire(Employee employee) {
        employees.add(employee);
    }

    // найм списка сотрудников
    public void hireAll(Collection<Employee> employes) {
        this.employees.addAll(employes);
    }

    // увольнение сотрудника
    public void fire(Employee employee) {
        employees.remove(employee);
    }

    // получение значения дохода компании
    public double getIncome() {
        return income;
    }

    public void addIncome(double amount) {
        income += amount;
    }

    List<Employee> getTopSalaryStaff(int count) {
        employees.sort(Comparator.comparing(Employee::getMonthSalary).reversed());
        return employees.subList(0, Math.min(count, employees.size()));
    }

    List<Employee> getLowestSalaryStaff(int count) {
        employees.sort(Comparator.comparing(Employee::getMonthSalary));
        return employees.subList(0, Math.min(count, employees.size()));

    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
