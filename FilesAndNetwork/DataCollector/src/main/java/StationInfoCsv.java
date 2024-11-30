public class StationInfoCsv {
    private String name;
    private String date;

    public StationInfoCsv(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "StationInfoCsv{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
