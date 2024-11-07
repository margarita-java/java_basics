public class Manager implements Employee {

    private final double fixedSalary;
    private Company company;

    public Manager(double fixedSalary, Company company) {
        this.fixedSalary = fixedSalary;
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        double earnedForCompany = 115000 + Math.random() * (140000 - 115000);
        company.addIncome(earnedForCompany);
        return fixedSalary + earnedForCompany * 0.05;
    }
}
