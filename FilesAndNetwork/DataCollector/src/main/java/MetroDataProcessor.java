import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.List;

public class MetroDataProcessor {

    public static void main(String[] args) {
        try {
            // Парсинг HTML страницы
            MetroParser parser = new MetroParser();
            Document document = parser.getHtmlPage("https://skillbox-java.github.io/");

            // Парсинг линий метро
            List<MetroLine> lines = parser.parseLines(document);
            System.out.println("Линии метро:");
            for (MetroLine line : lines) {
                System.out.println(line);
            }

            // Парсинг станций метро
            List<MetroStation> stations = parser.parseStations(document, lines);
            System.out.println("\nСтанции метро:");
            for (MetroStation station : stations) {
                System.out.println(station);
            }

            // Поиск файлов
            FileSearcher fileSearcher = new FileSearcher();
            String directoryPath = "C:\\Users\\Андрей\\Downloads\\stations-data";
            fileSearcher.searchFiles(directoryPath);
            fileSearcher.printFoundFiles();

            // Парсинг JSON-файлов
            JsonParser jsonParser = new JsonParser();
            String filePath = "C:\\Users\\Андрей\\Downloads\\stations-data\\data\\2\\4\\depths-1.json";
            List<Station> jsonStations = jsonParser.parseStations(filePath);
            if (jsonStations != null) {
                for (Station station : jsonStations) {
                    System.out.println(station);
                }
            } else {
                System.out.println("Не удалось прочитать файл!");
            }

            // Парсинг CSV-файлов
            String csvFilePath = "C:\\Users\\Андрей\\Downloads\\stations-data\\data\\0\\5\\dates-2.csv";
            System.out.println("Парсинг CSV-файла...");
            List<StationInfoCsv> csvStations = CsvParser.parseCsv(csvFilePath);
            if (csvStations != null && !csvStations.isEmpty()) {
                csvStations.forEach(System.out::println);
            } else {
                System.out.println("Данные из CSV-файла не найдены или произошла ошибка.");
            }

            // Дополнительный парсинг и обработка
            processAdditionalData(fileSearcher, lines, stations);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processAdditionalData(FileSearcher fileSearcher, List<MetroLine> lines, List<MetroStation> stations) {


            // Обработка дополнительных данных: парсинг JSON и CSV
        JsonParser jsonParser = new JsonParser();
        List<Station> depthStations = jsonParser.parseStations(fileSearcher.getJsonFiles().get(0).getAbsolutePath());

        CsvParser csvParser = new CsvParser();
        List<StationInfoCsv> dateStations = csvParser.parseCsv(fileSearcher.getCsvFiles().get(0).getAbsolutePath());

        // Сборка данных и запись в JSON файлы
        DataCollector dataCollector = new DataCollector(lines, stations, depthStations, dateStations);
        dataCollector.writeJsonFiles("stations.json", "map.json");

    }
}

