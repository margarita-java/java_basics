public class StorageOfInformation {
    private final TypeOfStorage type;
    private final int amountOfRAM;
    private final double weight;

    public StorageOfInformation(TypeOfStorage type, int amountOfRAM, double weight) {
        this.type = type;
        this.amountOfRAM = amountOfRAM;
        this.weight = weight;
    }


    public TypeOfStorage getType() {
        return type;
    }
    public int getAmountOfRAM() {
        return amountOfRAM;
    }
    public double getWeight() {
        return weight;
    }



}
