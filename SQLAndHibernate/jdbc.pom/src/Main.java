
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "ycC-Byy-JBN-9zN";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT course_name, COUNT(*) AS total_sales," +
                            "(MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date)) + 1) " +
                            "AS month_range FROM PurchaseList " +
                            "WHERE YEAR(subscription_date) = 2018 GROUP BY course_name");

            System.out.println("Среднее количество продаж в месяц для каждого курса:");

            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                int totalSales = resultSet.getInt("total_sales");
                int monthRange = resultSet.getInt("month_range");

                double avgSales = (double) totalSales / monthRange;

                System.out.printf("Курс: %s, Среднее количество продаж: %.2f%n", courseName, avgSales);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}