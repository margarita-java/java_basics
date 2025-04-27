import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class Loader {
    public static void main(String[] args) {
        String fileName = "res/data-1M.xml";

        long start = System.currentTimeMillis();

        try {
            prepareDatabase();
            parseFile(fileName); // Только парсинг
            DBConnection.printVoterCounts(); // Проверка результата
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }

        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + " ms");
    }

    private static void parseFile(String fileName) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        VoterHandler handler = new VoterHandler();
        parser.parse(new File(fileName), handler);

        saveToDb(handler.getVoterCounts()); // Сохраняем только после полного парсинга
    }

    private static void saveToDb(HashMap<Voter, Integer> voterCounts) throws Exception {
        Connection connection = DBConnection.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO voter_count(name, birthDate, count) VALUES ");

        int count = 0;
        for (Voter voter : voterCounts.keySet()) {
            if (voterCounts.get(voter) > 1) { // Сохраняем только повторяющихся
                if (count > 0) {
                    sql.append(",");
                }
                sql.append("('")
                        .append(voter.getName().replace("'", "''"))
                        .append("', '")
                        .append(new java.sql.Date(voter.getBirthDay().getTime()))
                        .append("', ")
                        .append(voterCounts.get(voter))
                        .append(")");
                count++;
            }
            if (count % 1000 == 0 && count != 0) {
                connection.createStatement().execute(sql.toString());
                sql = new StringBuilder();
                sql.append("INSERT INTO voter_count(name, birthDate, count) VALUES ");
                count = 0;
            }
        }
        if (count > 0) {
            connection.createStatement().execute(sql.toString());
        }
    }

    private static void prepareDatabase() throws SQLException {
        Connection connection = DBConnection.getConnection();
        connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
        connection.createStatement().execute(
                "CREATE TABLE voter_count (" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "count INT NOT NULL, " +
                        "PRIMARY KEY(id))"
        );
    }
}