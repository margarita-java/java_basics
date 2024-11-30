public class Station {
    private String station_name;
    private String depth;

    public Station(String name, String depth) {
        this.station_name = station_name;
        this.depth = depth;
    }
    public String getName() {
        return station_name;
    }

    public void setName(String name) {
        this.station_name = name;
    }
    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "StationDepth{" +
                "name='" + station_name + '\'' +
                ", depth=" + depth +
                '}';
    }
}


