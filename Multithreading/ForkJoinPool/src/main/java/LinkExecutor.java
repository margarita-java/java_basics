import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveTask;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkExecutor extends RecursiveTask<String> {
    private final String url;
    private static final CopyOnWriteArrayList<String> WRITE_ARRAY_LIST = new CopyOnWriteArrayList<>();
    private static final String CSS_QUERY = "a[href]";
    private static final String ATTRIBUTE_KEY = "href";

    protected LinkExecutor(String url) {
        this.url = url.trim();
    }

    @Override
    protected String compute() {
        String stringUtils = StringUtils.repeat("\t",
                url.lastIndexOf("/") != url.length() - 1 ? StringUtils.countMatches(url, "/") - 2
                        : StringUtils.countMatches(url, "/") - 3);

        StringBuffer sb = new StringBuffer(String.format("%s%s%s", stringUtils, url, System.lineSeparator()));
        List<LinkExecutor> writeArrayList = new CopyOnWriteArrayList<>();
        Document document;
        Elements elements;

        try {
            Thread.sleep(150);
            document = Jsoup.connect(url).ignoreContentType(true).userAgent("Mozilla/5.0").get();
            elements = document.select(CSS_QUERY);

            System.out.println("Парсим URL: " + url);

            for (Element element : elements) {
                String attributeUrl = element.absUrl(ATTRIBUTE_KEY);
                if (!attributeUrl.isEmpty() && attributeUrl.startsWith(url) && !WRITE_ARRAY_LIST.contains(attributeUrl) && !attributeUrl.contains("#")) {
                    System.out.println("Найдена ссылка: " + attributeUrl);
                    LinkExecutor linkExecutor = new LinkExecutor(attributeUrl);
                    linkExecutor.fork();
                    writeArrayList.add(linkExecutor);
                    WRITE_ARRAY_LIST.add(attributeUrl);
                }
            }
        } catch (InterruptedException | IOException e) {
            Thread.currentThread().interrupt();
        }

        writeArrayList.sort(Comparator.comparing((LinkExecutor o) -> o.url));
        int i = 0, allTasksSize = writeArrayList.size();
        while (i < allTasksSize) {
            LinkExecutor link = writeArrayList.get(i);
            sb.append(link.join());
            i++;
        }

        // Диагностика:
        System.out.println("Текущая директория: " + System.getProperty("user.dir"));
        System.out.println("Начинаем запись в файл...");

        // Проверяем и создадаем директорию, если её нет
        File directory = new File("src/main/resources/map");
        if (!directory.exists()) {
            boolean dirsCreated = directory.mkdirs();
            if (dirsCreated) {
                System.out.println("Директория создана: " + directory.getPath());
            } else {
                System.out.println("Не удалось создать директорию.");
            }
        }

        // Записываем файл в директорию
        try (FileWriter writer = new FileWriter("src/main/resources/map/sendel_ru.txt")) {
            writer.write(sb.toString());
            System.out.println("Файл записан в src/main/resources/map/sendel_ru.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}