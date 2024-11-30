import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
    private final List<File> jsonFiles = new ArrayList<>();
    private final List<File> csvFiles = new ArrayList<>();

    public void searchFiles(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            System.out.println("Указанный путь не является директорией: " + directoryPath);
            return;
        }
        searchFilesRecursive(directory);
    }

    private void searchFilesRecursive(File folder) {
        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                searchFilesRecursive(file);
            } else if (file.getName().endsWith(".json")) {
                jsonFiles.add(file);
            } else if (file.getName().endsWith(".csv")) {
                csvFiles.add(file);
            }
        }
    }

    public List<File> getJsonFiles() {
        return jsonFiles;
    }

    public List<File> getCsvFiles() {
        return csvFiles;
    }

    public void printFoundFiles() {
        System.out.println("Найденные JSON-файлы:");
        for (File file : jsonFiles) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("\nНайденные CSV-файлы:");
        for (File file : csvFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }
}

