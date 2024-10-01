public class RAM {

    private final String type;
    private final double volume;
    private final int weight;


    public RAM(String type, double volume, int weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }


    public String getType() {
        return type;
    }
    public double getVolume() {
        return volume;
    }
    public int getWeight() {
        return weight;
    }
}
