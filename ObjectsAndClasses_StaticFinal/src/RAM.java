public class RAM {

    private final TypeOfRAM typeOfRAM;
    private final VolumeOfRAM volumeOfRAM;
    private final int weightOfRAM;


    public RAM(TypeOfRAM typeOfRAM, VolumeOfRAM volumeOfRAM,
               int weightOfRAM) {
        this.typeOfRAM = typeOfRAM;
        this.volumeOfRAM = volumeOfRAM;
        this.weightOfRAM = weightOfRAM;
    }

    public TypeOfRAM getTypeOfRAM() {
        return typeOfRAM;
    }
    public VolumeOfRAM getVolumeOfRAM() {
        return volumeOfRAM;
    }
    public int getWeightOfRAM() {
        return weightOfRAM;
    }

    public String toString() {
        return "Оперативная память: " + "\n" +
                "Тип: " + typeOfRAM + "\n" +
                "Объём: " + volumeOfRAM + "\n" +
                "Вес оперативной памяти: " + "\n";
    }
}
