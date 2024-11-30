import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataCollector {
    private List<MetroLine> lines;
    private List<MetroStation> stations;
    private List<Station> depthStations;
    private List<StationInfoCsv> dateStations;

    public DataCollector(List<MetroLine> lines, List<MetroStation> stations,
                         List<Station> depthStations, List<StationInfoCsv> dateStations) {
        this.lines = lines;
        this.stations = stations;
        this.depthStations = depthStations;
        this.dateStations = dateStations;
    }

    public void writeJsonFiles(String stationsFilePath, String mapFilePath) {
        try {
            writeStationsJson(stationsFilePath);
            writeMapJson(mapFilePath);
            System.out.println("JSON-файлы успешно созданы!");
        } catch (IOException e) {
            System.err.println("Ошибка при записи JSON-файлов: " + e.getMessage());
        }
    }

    private void writeStationsJson(String filePath) throws IOException {
        JsonArray stationsArray = new JsonArray();

        for (MetroStation station : stations) {
            JsonObject stationObject = new JsonObject();
            stationObject.addProperty("name", station.getName());
            stationObject.addProperty("line", getLineNameByNumber(station.getLineNumber()));

            // Добавляем дополнительные свойства, если они доступны
            depthStations.stream()
                    .filter(s -> s.getName().equalsIgnoreCase(station.getName()))
                    .findFirst()
                    .ifPresent(s -> stationObject.addProperty("depth", s.getDepth()));

            dateStations.stream()
                    .filter(s -> s.getName().equalsIgnoreCase(station.getName()))
                    .findFirst()
                    .ifPresent(s -> stationObject.addProperty("date", s.getDate()));

            boolean hasConnection = stations.stream()
                    .filter(s -> s.getName().equalsIgnoreCase(station.getName()))
                    .count() > 1;
            if (hasConnection) {
                stationObject.addProperty("hasConnection", true);
            }

            stationsArray.add(stationObject);
        }

        JsonObject result = new JsonObject();
        result.add("stations", stationsArray);

        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(result, writer);
        }
    }

    private void writeMapJson(String filePath) throws IOException {
        JsonObject result = new JsonObject();

        JsonArray linesArray = new JsonArray();
        for (MetroLine line : lines) {
            JsonObject lineObject = new JsonObject();
            lineObject.addProperty("number", line.getNumber());
            lineObject.addProperty("name", line.getName());
            linesArray.add(lineObject);
        }

        JsonObject stationsByLine = new JsonObject();
        Map<String, List<MetroStation>> stationsGroupedByLine = stations.stream()
                .collect(Collectors.groupingBy(MetroStation::getLineNumber));

        for (Map.Entry<String, List<MetroStation>> entry : stationsGroupedByLine.entrySet()) {
            JsonArray stationNames = new JsonArray();
            for (MetroStation station : entry.getValue()) {
                stationNames.add(station.getName());
            }
            stationsByLine.add(entry.getKey(), stationNames);
        }

        result.add("lines", linesArray);
        result.add("stations", stationsByLine);

        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(result, writer);
        }
    }

    private String getLineNameByNumber(String lineNumber) {
        return lines.stream()
                .filter(line -> line.getNumber().equals(lineNumber))
                .map(MetroLine::getName)
                .findFirst()
                .orElse("Unknown");
    }
}

