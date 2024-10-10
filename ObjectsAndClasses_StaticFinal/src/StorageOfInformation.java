public class StorageOfInformation {

    private final TypeOfStorage typeOfStorage;
    private final VolumeOfStorage volumeOfStorage;
    private final int weightOfStorage;

    public StorageOfInformation(TypeOfStorage typeOfStorage, VolumeOfStorage volumeOfStorage, int weightOfStorage) {
        this.typeOfStorage = typeOfStorage;
        this.volumeOfStorage = volumeOfStorage;
        this.weightOfStorage = weightOfStorage;
    }

    public TypeOfStorage getTypeOfStorage() {
        return typeOfStorage;
    }
    public VolumeOfStorage getVolumeOfStorage() {
        return volumeOfStorage;
    }
    public int getWeightOfStorage() {
        return weightOfStorage;
    }
}
