import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MetroParser {

    public Document getHtmlPage(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public List<MetroLine> parseLines(Document document) {
        List<MetroLine> lines = new ArrayList<>();
        Elements elements = document.select("span[data-line]");
        for (Element element : elements) {
            String lineNumber = element.attr("data-line");
            String lineName = element.text();
            lines.add(new MetroLine(lineNumber, lineName));
        }
        return lines;
    }

    public List<MetroStation> parseStations(Document document, List<MetroLine> lines) {
        List<MetroStation> stations = new ArrayList<>();

        for (MetroLine line : lines) {
            Elements stationElements = document.select("p.single-station");
            for (Element element : stationElements) {
                Element nameElement = element.selectFirst("span.name");
                if (nameElement != null) {
                    String stationName = nameElement.text();
                    stations.add(new MetroStation(stationName, line.getNumber()));
                }
            }
        }

        return stations;
    }
}
