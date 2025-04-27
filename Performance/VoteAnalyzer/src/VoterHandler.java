import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class VoterHandler extends DefaultHandler {

    private HashMap<Voter, Integer> voterCounts = new HashMap<>();
    private SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("voter")) {
            String name = attributes.getValue("name");
            String birthDayStr = attributes.getValue("birthDay");
            try {
                Date birthDay = birthDayFormat.parse(birthDayStr);
                Voter voter = new Voter(name, birthDay);
                voterCounts.merge(voter, 1, Integer::sum);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public HashMap<Voter, Integer> getVoterCounts() {
        return voterCounts;
    }
}